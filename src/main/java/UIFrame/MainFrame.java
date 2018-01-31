package UIFrame;

import Activity.MainActivity;
import Const.ConstValues;
import InfoLoad.LoadDramaInfo;
import InfoStore.StoreDramaInfo;
import Util.CheckOperationSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 主窗体
 */
public class MainFrame extends JFrame implements ConstValues {
    private Container container;
    private ListPanel listPanel;
    private LoadedContentPanel loadedContentPanel;
    private VacantContentPanel vacantContentPanel;
    private LoadDramaInfo loadDramaInfo;
    private StoreDramaInfo storeDramaInfo;
    private List<String> dramaInfo = new ArrayList<String>();


    /**
     * 构造方法
     */
    public MainFrame() {
        container = this.getContentPane();
        container.setBackground(Color.yellow);
        try {
            loadDramaInfo = LoadDramaInfo.getInstance();
            loadDramaInfo.loadDramaInfo();
            dramaInfo = loadDramaInfo.getDramaInfo();
            storeDramaInfo = StoreDramaInfo.getInstance(dramaInfo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this.getComponent(0), e.getMessage(), "error喵！", JOptionPane.ERROR_MESSAGE);
        }
        frameConfig();
        buildListPanel(dramaInfo);
        addStoreDramaInfo();
    }

    /**
     * 窗体配置
     */
    private void frameConfig() {
        this.setVisible(true);
        this.setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(screenSize.width / 2 - 410, screenSize.height / 2 - 193, 820, 386);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * 创建带内容的内容窗口
     *
     * @param singleDInfo 单个番剧内容以"#"分割，共五项
     */
    public void buildLoadedContentPanel(String singleDInfo) {
        loadedContentPanel = new LoadedContentPanel();
        //loadedContentPanel.setBackground(Color.cyan);
        loadedContentPanel.setBounds(211, 0, 610, 386);
        loadedContentPanel.setVisible(true);
        loadedContentPanel.loadDramaInfoIntoPanel(singleDInfo);
        container.add(loadedContentPanel);
        loadedContentPanel.repaint();
        loadedContentPanel.getButton_DStart().addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                try {
                    if (loadedContentPanel.getDUrl().contains("http")) {
                        Runtime.getRuntime().exec(BROWSER_NAME + " " + loadedContentPanel.getDUrl());
                    } else {
                        if (CheckOperationSystem.getSystem().toLowerCase().contains("win")) {
                            Runtime.getRuntime().exec("explorer.exe" + " " + loadedContentPanel.getDUrl());
                        }
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                loadedContentPanel.getButton_DStart().setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                loadedContentPanel.getButton_DStart().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        loadedContentPanel.getButton_DDelete().addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                MainActivity.loggerRun.getLogger().info("删除了番剧：" + loadedContentPanel.txtF_DName.getText());
                dramaInfo.remove(loadedContentPanel.getSingleDramaInfoRegister());
                reloadListPanel();
                repaintAllComponent();
                //这两个必须在最后，否则其他语句不起作用
                container.remove(loadedContentPanel);
                loadedContentPanel = null;
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
        loadedContentPanel.getButton_AllProgressAdd().addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                loadedContentPanel.addAllProgress();

                dramaInfo.remove(loadedContentPanel.getSingleDramaInfoRegister());
                loadedContentPanel.updateSingleDramaInfoRegisterAfterChange();
                dramaInfo.add(loadedContentPanel.getSingleDramaInfoRegister());
                reloadListPanel();
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                loadedContentPanel.getButton_AllProgressAdd().setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                loadedContentPanel.getButton_AllProgressAdd().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        loadedContentPanel.getButton_AllProgressMinus().addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                loadedContentPanel.minusAllProgress();

                dramaInfo.remove(loadedContentPanel.getSingleDramaInfoRegister());
                loadedContentPanel.updateSingleDramaInfoRegisterAfterChange();
                dramaInfo.add(loadedContentPanel.getSingleDramaInfoRegister());
                reloadListPanel();
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                loadedContentPanel.getButton_AllProgressMinus().setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                loadedContentPanel.getButton_AllProgressMinus().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        loadedContentPanel.getButton_NowProgressAdd().addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                loadedContentPanel.addNowProgress();

                dramaInfo.remove(loadedContentPanel.getSingleDramaInfoRegister());
                loadedContentPanel.updateSingleDramaInfoRegisterAfterChange();
                dramaInfo.add(loadedContentPanel.getSingleDramaInfoRegister());
                reloadListPanel();
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                loadedContentPanel.getButton_NowProgressAdd().setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                loadedContentPanel.getButton_NowProgressAdd().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        loadedContentPanel.getButton_NowProgressMinus().addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                loadedContentPanel.minusNowProgress();

                dramaInfo.remove(loadedContentPanel.getSingleDramaInfoRegister());
                loadedContentPanel.updateSingleDramaInfoRegisterAfterChange();
                dramaInfo.add(loadedContentPanel.getSingleDramaInfoRegister());
                reloadListPanel();
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                loadedContentPanel.getButton_NowProgressMinus().setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                loadedContentPanel.getButton_NowProgressMinus().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    /**
     * 构建空内容窗口
     */
    public void buildVacantContentPanel() {
        vacantContentPanel = new VacantContentPanel();
        vacantContentPanel.setBackground(Color.red);
        vacantContentPanel.setBounds(211, 0, 610, 386);
        vacantContentPanel.setVisible(true);
        container.add(vacantContentPanel);
        vacantContentPanel.repaint();
        vacantContentPanel.getButton_Confirm().addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                dramaInfo.add(
                        vacantContentPanel.getTxtF_DName().getText() + "#"
                                + vacantContentPanel.getTxtF_DProgressAll().getText() + "#"
                                + vacantContentPanel.getTxtF_DProgressNow().getText() + "#"
                                + vacantContentPanel.getPicPanel().getPicFile().getPath() + "#"
                                + vacantContentPanel.getTxt_DURL().getText()
                );

                reloadListPanel();
                MainActivity.loggerRun.getLogger().info("添加了番剧：" + vacantContentPanel.txtF_DName.getText());
                //这两个必须在最后，否则其他语句不起作用
                container.remove(vacantContentPanel);
                vacantContentPanel = null;
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                vacantContentPanel.getButton_Confirm().setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                vacantContentPanel.getButton_Confirm().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        vacantContentPanel.getButton_Cancel().addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                container.remove(vacantContentPanel);
                vacantContentPanel = null;
                repaintAllComponent();
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                vacantContentPanel.getButton_Cancel().setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                vacantContentPanel.getButton_Cancel().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    /**
     * 构建侧边条目窗口
     *
     * @param dramaInfo List<String>番剧信息集合
     */
    public void buildListPanel(List<String> dramaInfo) {
        listPanel = new ListPanel(dramaInfo);
        listPanel.setBackground(Color.green);
        listPanel.setBounds(0, 0, 210, 386);
        listPanel.setVisible(true);
        container.add(listPanel);
        listPanel.repaint();
        listPanel.getLabel_AddD().addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (loadedContentPanel == null) {
                    if (vacantContentPanel == null) {
                        buildVacantContentPanel();
                    }
                } else {
                    container.remove(loadedContentPanel);
                    loadedContentPanel = null;
                    if (vacantContentPanel == null) {
                        buildVacantContentPanel();
                    }
                }
                repaintAllComponent();
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
        for (int i = 0; i < dramaInfo.size(); i++) {
            listPanel.getjLabel()[i].addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                    JLabel_withInfo jLabel_withInfo = (JLabel_withInfo) e.getSource();
                    if (vacantContentPanel == null) {
                        if (loadedContentPanel == null) {
                            buildLoadedContentPanel(jLabel_withInfo.getSingleDramaInfo());
                        } else {
                            loadedContentPanel.loadDramaInfoIntoPanel(jLabel_withInfo.getSingleDramaInfo());
                        }
                        repaintAllComponent();
                    }
                }

                public void mousePressed(MouseEvent e) {

                }

                public void mouseReleased(MouseEvent e) {

                }

                public void mouseEntered(MouseEvent e) {
                    ((JLabel_withInfo) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                public void mouseExited(MouseEvent e) {
                    ((JLabel_withInfo) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            });
        }
    }

    /**
     * 添加将番剧信息存储到本地的方法
     */
    private void addStoreDramaInfo() {
        this.addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent e) {

            }

            public void windowClosing(WindowEvent e) {
                try {
                    storeDramaInfo = StoreDramaInfo.getInstance(dramaInfo);
                    storeDramaInfo.storeDramaInfo();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            public void windowClosed(WindowEvent e) {

            }

            public void windowIconified(WindowEvent e) {

            }

            public void windowDeiconified(WindowEvent e) {

            }

            public void windowActivated(WindowEvent e) {

            }

            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    /**
     * dramaInfo有更新时，重新装载ListPanel的方法
     */
    private void reloadListPanel() {
        container.remove(listPanel);
        repaintAllComponent();
        buildListPanel(dramaInfo);
    }

    /**
     * 重新绘制全部控件的方法
     */
    private void repaintAllComponent() {
        container.repaint();
        if (listPanel != null) {
            listPanel.repaint();
        }
        if (loadedContentPanel != null) {
            loadedContentPanel.repaint();
        }
        if (vacantContentPanel != null) {
            vacantContentPanel.repaint();
        }
    }
}
