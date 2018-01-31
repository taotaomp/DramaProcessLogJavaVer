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
        picFile=new File("");
        if(!b) {
            this.setBackground(Color.white);
            addMouseAction();
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

    private void addMouseAction(){
        this.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                PicPanel temp = (PicPanel)e.getSource();
                JFileChooser jFileChooser = new JFileChooser();
                if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    temp.setPicFile(jFileChooser.getSelectedFile());
                    temp.repaint();
                }
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }
        });
    }

}
