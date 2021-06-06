package VIEW.SEPVIEW;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.SepDao;
import MODEL.Sch;

public class UpdateSchView {
	JFrame jFrame=new JFrame("修改时间安排表信息");
    JPanel jPanel=new JPanel(null);
    JLabel SCID=new JLabel("时间安排表编号:");
    JLabel CON=new JLabel("内容:");
    
    JTextField SCIDtext=new JTextField();
    JTextField CONtext=new JTextField();
    JButton update=new JButton("更新");

    public void init(){
    	jFrame.setLocationRelativeTo(null);
        jFrame.setSize(400,400);
        SCID.setBounds(10,60,160,25);
        SCIDtext.setBounds(200,60,165,25);
        CON.setBounds(10,100,160,25);
        CONtext.setBounds(200,100,165,25);
        update.setBounds(10,250,80,25);
        Sch sch= Sch.getInstance();
        SCIDtext.setText(sch.getSCID());
        //EMP_IDtext.setEditable(false);
        CONtext.setText(sch.getCON());
        ActionListener updateListener=e -> {
            try {
            		new SepDao().updateSch(SCIDtext.getText(),CONtext.getText());
                    jFrame.dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
             
            };
           
        update.addActionListener(updateListener);
        jPanel.add(SCID);
        jPanel.add(SCIDtext);
        jPanel.add(CON);
        jPanel.add(CONtext);
        jPanel.add(update);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
