package UIFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 空数据内容，内容容器
 */
public class VacantContentPanel extends ContentPanel {

    private JLabel label_DURL = new JLabel("番剧地址喵");
    private JTextArea txt_DURL = new JTextArea();
    private JButton button_Confirm = new JButton("好了");
    private JButton button_Cancel = new JButton("溜了");

    public JTextArea getTxt_DURL() {
        return txt_DURL;
    }

    public JTextArea getTxtF_DName(){
        return txtF_DName;
    }

    public JTextArea getTxtF_DProgressAll(){
        return txtF_DProgressAll;
    }

    public JTextArea getTxtF_DProgressNow(){
        return txtF_DProgressNow;
    }

    public PicPanel getPicPanel(){
        return this.panel_DPicture;
    }

    public JButton getButton_Confirm() {
        return button_Confirm;
    }

    public JButton getButton_Cancel() {
        return button_Cancel;
    }

    public void setTxt_DURL(JTextArea txt_DURL) {
        this.txt_DURL = txt_DURL;
    }

    public VacantContentPanel(){
        super(false);
        this.setTxtEditable(true);
        this.setLayout(null);

        setComponentsBounds();
        addComponents();
    }

    private void setComponentsBounds(){
        this.label_DURL.setBounds(34,170,93,18);
        this.txt_DURL.setBounds(150,170,200,18);
        this.button_Confirm.setBounds(469,265,70,20);
        this.button_Cancel.setBounds(469,295,70,20);
    }

    private void addComponents(){
        this.add(label_DURL);
        this.add(txt_DURL);
        this.add(button_Confirm);
        this.add(button_Cancel);
    }

    @Override
    public void print(Graphics g) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(CONTENT_BACKGROUND_PIC_PATH));
            g.drawImage(bufferedImage,0,0,this.getWidth(),this.getHeight(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
