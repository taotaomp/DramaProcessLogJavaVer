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

public class PicPanel extends JPanel {

    private File picFile;
    public void setPicFile(File picFile) {
        this.picFile = picFile;
    }

    public File getPicFile() {
        return picFile;
    }

    /**
     * 构造方法
     * @param b 指示是否为有内容窗口
     */
    public PicPanel(boolean b){
        if(!b) {
            this.setBackground(Color.white);
        }
    }

    @Override
    public void print(Graphics g) {
        try {
            BufferedImage bufferedImage = ImageIO.read(picFile);
            g.drawImage(bufferedImage,0,0, this.getWidth(),this.getHeight(),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
