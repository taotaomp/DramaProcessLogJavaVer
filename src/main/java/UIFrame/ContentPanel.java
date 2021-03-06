package UIFrame;

import Const.ConstValues;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 内容容器，定制化
 * 包含两种内容容器中都有的基本内容
 */
public abstract class ContentPanel extends JPanel implements ConstValues{
    protected JLabel label_DName = new JLabel("番剧名称");
    protected JLabel label_DProgressAll = new JLabel("番剧总进度");
    protected JLabel label_DProgressNow = new JLabel("番剧当前进度");

    protected JTextArea txtF_DName = new JTextArea();
    protected JTextArea txtF_DProgressAll = new JTextArea();
    protected JTextArea txtF_DProgressNow = new JTextArea();

    protected Image image = (Image)new ImageIcon(CONTENT_BACKGROUND_PIC_PATH).getImage();

    protected PicPanel panel_DPicture;

    /**
     * 构造方法,若窗口为有内容窗口,传true,反之为false
     * @param b 指示是否为有内容窗口
     */
    public ContentPanel(boolean b){
        panel_DPicture = new PicPanel(b);
        setComponentsBounds();
        addComponents();
        this.setLayout(null);
    }

//    /**
//     * 覆盖print方法，以绘制背景图片
//     * @param g
//     */
//    @Override
//    public void print(Graphics g) {
//        try {
//            BufferedImage bufferedImage = ImageIO.read(new File(CONTENT_BACKGROUND_PIC_PATH));
//            g.drawImage(bufferedImage,0,0, null);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    @Override
    protected void printComponent(Graphics g) {
        g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
    }

    /**
     * 设置文本控件（TextArea）是否可更改
     * @param b true为可更改，false为不可更改
     */
    protected void setTxtEditable(boolean b){
        this.txtF_DName.setEditable(b);
        this.txtF_DProgressAll.setEditable(b);
        this.txtF_DProgressNow.setEditable(b);
    }

    /**
     * 设置各个控件的位置和大小
     */
    private void setComponentsBounds(){
        this.label_DName.setBounds(32,62,70,21);
        this.label_DProgressAll.setBounds(33,100,93,18);
        this.label_DProgressNow.setBounds(33,266,110,18);

        this.txtF_DName.setBounds(108,62,183,26);
        this.txtF_DProgressAll.setBounds(132,97,55,26);
        this.txtF_DProgressNow.setBounds(149,263,60,26);

        this.panel_DPicture.setBounds(380,21,135,161);
    }

    /**
     * 将各个控件添加到容器中
     */
    private void addComponents(){
        this.add(label_DName);
        this.add(label_DProgressAll);
        this.add(label_DProgressNow);
        this.add(txtF_DName);
        this.add(txtF_DProgressAll);
        this.add(txtF_DProgressNow);
        this.add(panel_DPicture);
    }
}
