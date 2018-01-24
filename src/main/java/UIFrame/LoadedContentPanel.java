package UIFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

    private Button button_DStart = new Button("开始追番喵");
    private Button button_DDelete = new Button("删除");
    private Button button_AllProgressAdd = new Button("+1s");
    private Button button_AllProgressMinus = new Button("-1s");
    private Button button_NowProgressAdd = new Button("+1s");
    private Button button_NowProgressMinus = new Button("-1s");
    private String DUrl = null;

    public LoadedContentPanel() {
        super(true);
        this.setTxtEditable(false);
        this.setLayout(null);

        setComponentsBounds();
        addComponents();
        setComponetsFonts();
    }

    private void setComponentsBounds(){
        this.button_DStart.setBounds(34,163,255,24);
        this.button_DDelete.setBounds(580,-1,24,378);
        this.button_AllProgressAdd.setBounds(203,95,31,31);
        this.button_AllProgressMinus.setBounds(260,95,31,31);
        this.button_NowProgressAdd.setBounds(314,317,31,31);
        this.button_NowProgressMinus.setBounds(374,317,31,31);
    }

    private void addComponents(){
        this.add(button_DStart);
        this.add(button_DDelete);
        this.add(button_AllProgressAdd);
        this.add(button_AllProgressMinus);
        this.add(button_NowProgressAdd);
        this.add(button_NowProgressMinus);
    }

    private void setComponetsFonts(){
        Font font = new Font("宋体",0,12);
        this.button_AllProgressAdd.setFont(font);
        this.button_AllProgressMinus.setFont(font);
        this.button_NowProgressAdd.setFont(font);
        this.button_NowProgressMinus.setFont(font);
        this.button_DStart.setFont(font);
        this.button_DDelete.setFont(font);
    }

    public void loadDramaInfoIntoPanel(String singleDramaInfo){
        String temp[] = new String[5];
        for(int i = 0 ;i<temp.length ;i++){
            if(i<singleDramaInfo.split("#").length){
                temp[i] = singleDramaInfo.split("#")[i];
            }
            else {
                temp[i] = " ";
            }
        }

        this.txtF_DName.setText(temp[0]);
        this.txtF_DProgressAll.setText(temp[1]);
        this.txtF_DProgressNow.setText(temp[2]);
        this.panel_DPicture.setPicFile(new File(temp[3]));
        this.DUrl = temp[4];

        this.panel_DPicture.repaint();
    }

    @Override
    public void print(Graphics g) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(CONTENT_BACKGROUND_PIC_PATH));
            g.drawImage(bufferedImage,0,0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
