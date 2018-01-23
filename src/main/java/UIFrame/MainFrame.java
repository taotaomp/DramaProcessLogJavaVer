package UIFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private Container container;
    private ListPanel listPanel;
    private LoadedContentPanel loadedContentPanel;
    private VacantContentPanel vacantContentPanel;

    public MainFrame(){
        container = this.getContentPane();
        frameConfig();
        buildVacantContentPanel();
        buildListPanel(new ArrayList<String>());
    }

    private void frameConfig(){
        this.setVisible(true);
        this.setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(screenSize.width/2-410,screenSize.height/2-193,820,386);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void buildLoadedContentPanel(){
        loadedContentPanel = new LoadedContentPanel();
        loadedContentPanel.setBounds(211,0,610,386);
        loadedContentPanel.setVisible(true);
        container.add(loadedContentPanel);
    }

    public void buildVacantContentPanel(){
        vacantContentPanel = new VacantContentPanel();
        vacantContentPanel.setBounds(211,0,610,386);
        vacantContentPanel.setVisible(true);
        container.add(vacantContentPanel);
    }

    public void buildListPanel(List<String> dramaInfo){
        listPanel = new ListPanel(dramaInfo);
        listPanel.setBounds(0,0,210,386);
        listPanel.setVisible(true);
        container.add(listPanel);
    }

}
