package UIFrame;

import Activity.MainActivity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 有内容时，单个番剧的面板
 */
public class LoadedContentPanel extends ContentPanel {

    public Button getButton_DStart() {
        return button_DStart;
    }

    public Button getButton_DDelete() {
        return button_DDelete;
    }

    public Button getButton_AllProgressAdd() {
        return button_AllProgressAdd;
    }

    public Button getButton_AllProgressMinus() {
        return button_AllProgressMinus;
    }

    public Button getButton_NowProgressAdd() {
        return button_NowProgressAdd;
    }

    public Button getButton_NowProgressMinus() {
        return button_NowProgressMinus;
    }

    public String getDUrl() {
        return DUrl;
    }

    public String getSingleDramaInfoRegister() {
        return singleDramaInfoRegister;
    }

    public JProgressBar getProgressBar_NowProgress() {
        return progressBar_NowProgress;
    }

    private Button button_DStart = new Button("开始追番喵");
    private Button button_DDelete = new Button("删\n除");
    private Button button_AllProgressAdd = new Button("+1s");
    private Button button_AllProgressMinus = new Button("-1s");
    private Button button_NowProgressAdd = new Button("+1s");
    private Button button_NowProgressMinus = new Button("-1s");
    private String DUrl = null;

    private String singleDramaInfoRegister; //单个整条番剧信息暂存器

    private JProgressBar progressBar_NowProgress = new JProgressBar();

    /**
     * 构造方法
     */
    public LoadedContentPanel() {
        super(true);
        this.setTxtEditable(false);
        this.setLayout(null);

        setComponentsBounds();
        addComponents();
        setComponetsFonts();
    }

    /**
     * 设置所有控件位置和大小
     */
    private void setComponentsBounds() {
        this.button_DStart.setBounds(34, 163, 255, 24);
        this.button_DDelete.setBounds(580, -1, 24, 378);
        this.button_AllProgressAdd.setBounds(203, 95, 31, 31);
        this.button_AllProgressMinus.setBounds(260, 95, 31, 31);
        this.button_NowProgressAdd.setBounds(314, 317, 31, 31);
        this.button_NowProgressMinus.setBounds(374, 317, 31, 31);
        this.progressBar_NowProgress.setBounds(34, 292, 371, 19);
    }

    /**
     * 添加所有控件到该容器中
     */
    private void addComponents() {
        this.add(button_DStart);
        this.add(button_DDelete);
        this.add(button_AllProgressAdd);
        this.add(button_AllProgressMinus);
        this.add(button_NowProgressAdd);
        this.add(button_NowProgressMinus);
        this.add(progressBar_NowProgress);
    }

    /**
     * 设置所有控件的字体
     */
    private void setComponetsFonts() {
        Font font = new Font("宋体", 0, 12);
        this.button_AllProgressAdd.setFont(font);
        this.button_AllProgressMinus.setFont(font);
        this.button_NowProgressAdd.setFont(font);
        this.button_NowProgressMinus.setFont(font);
        this.button_DStart.setFont(font);
        this.button_DDelete.setFont(new Font("宋体", 0, 9));
    }

    /**
     * 初始化进度条
     */
    private void setProgressBarInitial() {
        this.progressBar_NowProgress.setMaximum(Integer.parseInt(this.txtF_DProgressAll.getText()));
        this.progressBar_NowProgress.setMinimum(1);
        this.progressBar_NowProgress.setValue(Integer.parseInt(this.txtF_DProgressNow.getText()));
        this.progressBar_NowProgress.setString(this.txtF_DName.getText());
    }

    /**
     * 番剧总进度加/减1的方法
     */
    public void addAllProgress() {
        Integer i = Integer.parseInt(txtF_DProgressAll.getText());
        i++;
        txtF_DProgressAll.setText(i.toString());
        progressBar_NowProgress.setMaximum(i);
        MainActivity.loggerRun.getLogger().info(txtF_DName.getText() + " 总进度+1");
    }

    public void minusAllProgress() {
        Integer i = Integer.parseInt(txtF_DProgressAll.getText());
        if (i > 0) {
            i--;
            txtF_DProgressAll.setText(i.toString());
            progressBar_NowProgress.setMaximum(i);
            MainActivity.loggerRun.getLogger().info(txtF_DName.getText() + " 总进度-1");
        }
    }

    /**
     * 番剧当前进度加/减1的方法
     */
    public void addNowProgress() {
        Integer i = Integer.parseInt(txtF_DProgressNow.getText());
        if (i < Integer.parseInt(txtF_DProgressAll.getText())) {
            i++;
            txtF_DProgressNow.setText(i.toString());
            progressBar_NowProgress.setValue(i);
            MainActivity.loggerRun.getLogger().info(txtF_DName.getText() + " 观看进度+1");
        }
    }

    public void minusNowProgress() {
        Integer i = Integer.parseInt(txtF_DProgressNow.getText());
        if (i > 0) {
            i--;
            txtF_DProgressNow.setText(i.toString());
            progressBar_NowProgress.setValue(i);
            MainActivity.loggerRun.getLogger().info(txtF_DName.getText() + " 观看进度-1");
        }
    }

    public void updateSingleDramaInfoRegisterAfterChange() {
        singleDramaInfoRegister = this.txtF_DName.getText() + "#"
                + this.txtF_DProgressAll.getText() + "#"
                + this.txtF_DProgressNow.getText() + "#"
                + this.panel_DPicture.getPicFile().getPath() + "#"
                + this.DUrl + "#"
        ;
    }

    /**
     * 装载番剧信息的方法
     *
     * @param singleDramaInfo 单个番剧信息，以"#"分割，共5项
     */
    public void loadDramaInfoIntoPanel(String singleDramaInfo) {
        singleDramaInfoRegister = singleDramaInfo;
        String temp[] = new String[5];
        for (int i = 0; i < temp.length; i++) {
            if (i < singleDramaInfo.split("#").length) {
                temp[i] = singleDramaInfo.split("#")[i];
            } else {
                temp[i] = " ";
            }
        }

        this.txtF_DName.setText(temp[0]);
        this.txtF_DProgressAll.setText(temp[1]);
        this.txtF_DProgressNow.setText(temp[2]);
        this.panel_DPicture.setPicFile(new File(temp[3]));
        this.DUrl = temp[4];

        this.panel_DPicture.repaint();

        setProgressBarInitial();        //初始化进度条
    }

    @Override
    public void print(Graphics g) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(CONTENT_BACKGROUND_PIC_PATH));
            g.drawImage(bufferedImage, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
