package UIFrame;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class LoadedContentPanel extends ContentPanel {

    private JButton button_DStart = new JButton("开始追番喵");
    private JButton button_DDelete = new JButton("删除");
    private JButton button_AllProgressAdd = new JButton("+1s");
    private JButton button_AllProgressMinus = new JButton("-1s");
    private JButton button_NowProgressAdd = new JButton("+1s");
    private JButton button_NowProgressMinus = new JButton("-1s");
    private String DUrl;

    public LoadedContentPanel() {
        super(true);
        this.setTxtEditable(false);
        this.setLayout(null);

        setComponentsBounds();
        addComponents();
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

    public void loadDramaInfoIntoPanel(String singleDramaInfo){
        String temp[] = singleDramaInfo.split("#");
        this.txtF_DName.setText(temp[0]);
        this.txtF_DProgressAll.setText(temp[1]);
        this.txtF_DProgressNow.setText(temp[2]);
        this.panel_DPicture.setPicFile(new File(temp[3]));
        this.DUrl = temp[4];
    }

    @Override
    public void print(Graphics g) {
        super.print(g);
    }
}
