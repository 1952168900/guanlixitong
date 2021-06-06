package VIEW.MANVIEW;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.ManDao;
import MODEL.Cus;

public class UpdateCusView {
	JFrame jFrame=new JFrame("修改客户信息");
    JPanel jPanel=new JPanel(null);
    JLabel CID=new JLabel("客户编号:");
    JLabel PAS=new JLabel("密码:");
    JLabel CNAME=new JLabel("客户名字:");
    JLabel CINF=new JLabel("信息:");
    
    JTextField CIDtext=new JTextField();
    JTextField PAStext=new JTextField();
    JTextField CNAMEtext=new JTextField();
    JTextField CINFtext=new JTextField();
    JButton update=new JButton("更新");

    public void init(){
    	jFrame.setLocationRelativeTo(null);
        jFrame.setSize(400,400);
        CID.setBounds(10,20,160,25);
        CIDtext.setBounds(200,20,165,25);
        PAS.setBounds(10,100,160,25);
        PAStext.setBounds(200,100,165,25);
        CNAME.setBounds(10,140,160,25);
        CNAMEtext.setBounds(200,140,165,25);
        CINF.setBounds(10,180,160,25);
        CINFtext.setBounds(200,180,165,25);
        update.setBounds(10,250,80,25);
        Cus cus= Cus.getInstance();
        CIDtext.setText(cus.getCID());
        //EMP_IDtext.setEditable(false);
        PAStext.setText(cus.getPAS());
        CNAMEtext.setText(cus.getCNAME());
        CINFtext.setText(cus.getCINF());
        ActionListener updateListener=e -> {
            try {
            		new ManDao().updateCus(CIDtext.getText(),PAStext.getText(),CNAMEtext.getText(),CINFtext.getText());
                    jFrame.dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
             
            };
           
        update.addActionListener(updateListener);
        jPanel.add(CID);
        jPanel.add(CIDtext);
        jPanel.add(PAS);
        jPanel.add(PAStext);
        jPanel.add(CNAME);
        jPanel.add(CNAMEtext);
        jPanel.add(CINF);
        jPanel.add(CINFtext);
        jPanel.add(update);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
