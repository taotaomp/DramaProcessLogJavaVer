package UIFrame;

import InfoLoad.LoadDramaInfo;
import InfoStore.StoreDramaInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private Container container;
    private ListPanel listPanel;
    private LoadedContentPanel loadedContentPanel;
    private VacantContentPanel vacantContentPanel;
    private LoadDramaInfo loadDramaInfo;
    private StoreDramaInfo storeDramaInfo;
    private List<String> dramaInfo = new ArrayList<String>();


    public MainFrame(){
        container = this.getContentPane();
        try {
            loadDramaInfo = LoadDramaInfo.getInstance();
            loadDramaInfo.loadDramaInfo();
            dramaInfo = loadDramaInfo.getDramaInfo();
            storeDramaInfo = StoreDramaInfo.getInstance(dramaInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        frameConfig();
        buildListPanel(dramaInfo);
    }

    private void frameConfig(){
        this.setVisible(true);
        this.setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(screenSize.width/2-410,screenSize.height/2-193,820,386);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void buildLoadedContentPanel(String singleDInfo){
        loadedContentPanel = new LoadedContentPanel();
        loadedContentPanel.setBounds(211,0,610,386);
        loadedContentPanel.setVisible(true);
        loadedContentPanel.loadDramaInfoIntoPanel(singleDInfo);
        container.add(loadedContentPanel);
        loadedContentPanel.repaint();
        loadedContentPanel.getButton_DStart().addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                try {
                    Runtime.getRuntime().exec("google-chrome "+loadedContentPanel.getDUrl());
                } catch (IOException e1) {
                    e1.printStackTrace();
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

    public void buildVacantContentPanel(){
        vacantContentPanel = new VacantContentPanel();
        vacantContentPanel.setBounds(211,0,610,386);
        vacantContentPanel.setVisible(true);
        container.add(vacantContentPanel);
        vacantContentPanel.repaint();
        vacantContentPanel.getButton_Confirm().addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                dramaInfo.add(
                        vacantContentPanel.getTxtF_DName().getText()+"#"
                        +vacantContentPanel.getTxtF_DProgressAll().getText()+"#"
                        +vacantContentPanel.getTxtF_DProgressNow().getText()+"#"
                        +vacantContentPanel.getPicPanel().getPicFile().getPath()+"#"
                        +vacantContentPanel.getTxt_DURL().getText()
                );
                container.remove(vacantContentPanel);
                container.remove(listPanel);
                container.repaint();
                buildListPanel(dramaInfo);
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
        vacantContentPanel.getButton_Cancel().addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                container.remove(vacantContentPanel);
                container.repaint();
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

    public void buildListPanel(List<String> dramaInfo){
        listPanel = new ListPanel(dramaInfo);
        listPanel.setBounds(0,0,210,386);
        listPanel.setVisible(true);
        container.add(listPanel);
        listPanel.repaint();
        listPanel.getLabel_AddD().addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                buildVacantContentPanel();
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                listPanel.label_AddD.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                listPanel.label_AddD.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        for (int i = 0 ; i<dramaInfo.size();i++){
            listPanel.getjLabel()[i].addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                    JLabel_withInfo jLabel_withInfo = (JLabel_withInfo) e.getSource();
                    buildLoadedContentPanel(jLabel_withInfo.getSingleDramaInfo());
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

}
