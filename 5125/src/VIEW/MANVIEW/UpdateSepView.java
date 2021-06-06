package VIEW.MANVIEW;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.ManDao;
import MODEL.Sep;

public class UpdateSepView {
	JFrame jFrame=new JFrame("修改服务提供者信息");
    JPanel jPanel=new JPanel(null);
    JLabel SID=new JLabel("服务提供者编号:");
    JLabel PAS=new JLabel("密码:");
    JLabel SNAME=new JLabel("服务提供者名字:");
    JLabel TYPE=new JLabel("类别:");
    
    JTextField SIDtext=new JTextField();
    JTextField PAStext=new JTextField();
    JTextField SNAMEtext=new JTextField();
    JTextField TYPEtext=new JTextField();
    JButton update=new JButton("更新");

    public void init(){
    	jFrame.setLocationRelativeTo(null);
        jFrame.setSize(400,400);
        SID.setBounds(10,20,160,25);
        SIDtext.setBounds(200,20,165,25);
        PAS.setBounds(10,100,160,25);
        PAStext.setBounds(200,100,165,25);
        SNAME.setBounds(10,140,160,25);
        SNAMEtext.setBounds(200,140,165,25);
        TYPE.setBounds(10,180,160,25);
        TYPEtext.setBounds(200,180,165,25);
        update.setBounds(10,250,80,25);
        Sep sep= Sep.getInstance();
        SIDtext.setText(sep.getSID());
        //EMP_IDtext.setEditable(false);
        PAStext.setText(sep.getPAS());
        SNAMEtext.setText(sep.getSNAME());
        TYPEtext.setText(sep.getTYPE());
        ActionListener updateListener=e -> {
            try {
            		new ManDao().updateSep(SIDtext.getText(),PAStext.getText(),SNAMEtext.getText(),TYPEtext.getText());
                    jFrame.dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
             
            };
           
        update.addActionListener(updateListener);
        jPanel.add(SID);
        jPanel.add(SIDtext);
        jPanel.add(PAS);
        jPanel.add(PAStext);
        jPanel.add(SNAME);
        jPanel.add(SNAMEtext);
        jPanel.add(TYPE);
        jPanel.add(TYPEtext);
        jPanel.add(update);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
