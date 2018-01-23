package UIFrame;

import Const.ConstValues;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Style;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListPanel extends JScrollPane implements ConstValues{
    List<String> dramaInfo = new ArrayList<String>();

    /**
     * 构造方法
     * @param dramaInfo 全部信息的集合
     */
    public ListPanel(List<String> dramaInfo){
        this.dramaInfo = dramaInfo;
        this.setViewportView(generateJListByDefaultListModel());
    }

    /**
     * 设置ListModel(也就是添加条目)
     * @return
     */
    private DefaultListModel loadAllInfoItem(){
        DefaultListModel defaultListModel = new DefaultListModel();
        defaultListModel.addElement("点我添加新番喵");
        Iterator<String> iterator = dramaInfo.iterator();
        while (iterator.hasNext()){
            String temp = iterator.next().split("#")[0];
            defaultListModel.addElement(temp);
        }
        return defaultListModel;
    }

    /**
     * 生成JList
     * @return
     */
    private JList generateJListByDefaultListModel(){
        JList jList = new JList(loadAllInfoItem());
        jList.setFont(new Font("宋体",0,15));
        jList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

            }
        });
        return jList;
    }

    @Override
    public void paint(Graphics g) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(LIST_BACKGROUND_PIC_PATH));
            g.drawImage(bufferedImage,0,0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
