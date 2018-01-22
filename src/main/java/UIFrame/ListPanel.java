package UIFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListPanel extends JScrollPane {
    List<String> dramaInfo = new ArrayList<String>();

    public ListPanel(List<String> dramaInfo){
        this.dramaInfo = dramaInfo;
        this.setViewportView(generateJListByDefaultListModel());
    }

    private DefaultListModel loadAllInfoItem(){
        DefaultListModel defaultListModel = new DefaultListModel();
        Iterator<String> iterator = dramaInfo.iterator();
        while (iterator.hasNext()){
            defaultListModel.addElement(iterator.next());
        }
        return defaultListModel;
    }

    private JList generateJListByDefaultListModel(){
        return new JList(loadAllInfoItem());
    }

}
