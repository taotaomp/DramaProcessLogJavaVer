package UIFrame;

import javax.swing.*;
import java.awt.*;

public class VacantContentPanel extends ContentPanel {

    private JLabel label_DURL = new JLabel("番剧地址喵");
    private JTextArea txt_DURL = new JTextArea();
    private JButton button_Confirm = new JButton("好了");
    private JButton button_Cancel = new JButton("溜了");

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
        super.print(g);
    }
}
