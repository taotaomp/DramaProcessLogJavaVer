package UIFrame;

import Const.ConstValues;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ListPanel extends JScrollPane implements ConstValues{
    private List<String> dramaInfo;

    public JLabel_withInfo[] getjLabel() {
        return jLabel_withInfo;
    }

    private JLabel_withInfo[] jLabel_withInfo ;

    public JLabel getLabel_AddD() {
        return label_AddD;
    }

    JLabel label_AddD = new JLabel("点我添加新东西喵");

    ListPanel(List<String> dramaInfo){
        this.dramaInfo = dramaInfo;

        this.setLayout(null);
        loadItems();
    }

    private void loadItems(){
        label_AddD.setFont(new Font("仿宋",1,16));
        label_AddD.setOpaque(false);
        label_AddD.setBounds(0,0,210,20);
        this.add(label_AddD);

        jLabel_withInfo = new JLabel_withInfo[dramaInfo.size()];
        Iterator<String> iterator = dramaInfo.iterator();
        for (int i = 0,y =20 ;iterator.hasNext();i++,y=y+20){
            String temp = iterator.next();
            jLabel_withInfo[i] = new JLabel_withInfo();
            jLabel_withInfo[i].setOpaque(false);
            jLabel_withInfo[i].setBounds(0,y,210,20);
            jLabel_withInfo[i].setVisible(true);
            jLabel_withInfo[i].setSingleDramaInfo(temp);
            jLabel_withInfo[i].setText(temp.split("#")[0]);
            this.add(jLabel_withInfo[i]);
        }
    }

    @Override
    public void print(Graphics g) {
        super.print(g);
        try{
            BufferedImage bufferedImage = ImageIO.read(new File(LIST_BACKGROUND_PIC_PATH));
            g.drawImage(bufferedImage, 0,0,this.getWidth(),this.getHeight(),null );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class JLabel_withInfo extends JLabel{

    public void setSingleDramaInfo(String singleDramaInfo) {
        this.singleDramaInfo = singleDramaInfo;
    }

    public String getSingleDramaInfo() {
        return singleDramaInfo;
    }

    private String singleDramaInfo;

}
