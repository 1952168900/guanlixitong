package VIEW.CUSVIEW;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.CusDao;
import MODEL.Prj;

public class UpdatePrjView {
	JFrame jFrame=new JFrame("修改项目信息");
    JPanel jPanel=new JPanel(null);
    JLabel PRID=new JLabel("项目号:");
    JLabel CID=new JLabel("客户号:");
    JLabel CON=new JLabel("项目内容:");
    JLabel STARTTIME=new JLabel("开始时间:");
    JLabel ENDTIME=new JLabel("结束时间:");
    JLabel TYPE=new JLabel("类别:");
    
    JTextField PRIDtext=new JTextField();
    JTextField CIDtext=new JTextField();
    JTextField CONtext=new JTextField();
    JTextField STARTTIMEtext=new JTextField();
    JTextField ENDTIMEtext=new JTextField();
    JTextField TYPEtext=new JTextField();
    JButton update=new JButton("更新");

    public void init(){
    	jFrame.setLocationRelativeTo(null);
        jFrame.setSize(400,400);
        PRID.setBounds(10,20,160,25);
        PRIDtext.setBounds(200,20,165,25);
        CID.setBounds(10,60,160,25);
        CIDtext.setBounds(200,60,165,25);
        CON.setBounds(10,100,160,25);
        CONtext.setBounds(200,100,165,25);
        STARTTIME.setBounds(10,140,160,25);
        STARTTIMEtext.setBounds(200,140,165,25);
        ENDTIME.setBounds(10,180,160,25);
        ENDTIMEtext.setBounds(200,180,165,25);
        TYPE.setBounds(10,220,160,25);
        TYPEtext.setBounds(200,220,165,25);
        update.setBounds(10,260,80,25);
        Prj prj= Prj.getInstance();
        PRIDtext.setText(prj.getPRID());
        //EMP_IDtext.setEditable(false);
        
        CIDtext.setText(prj.getCID());
        CONtext.setText(prj.getCON());
        STARTTIMEtext.setText(prj.getSTARTTIME());
        ENDTIMEtext.setText(prj.getENDTIME());
        TYPEtext.setText(prj.getTYPE());
        ActionListener updateListener=e -> {
            try {
            		new CusDao().updatePrj(PRIDtext.getText(),CIDtext.getText(),CONtext.getText(),STARTTIMEtext.getText(),ENDTIMEtext.getText(),TYPEtext.getText());
                    jFrame.dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
             
            };
           
        update.addActionListener(updateListener);
        jPanel.add(PRID);
        jPanel.add(PRIDtext);
        jPanel.add(CID);
        jPanel.add(CIDtext);
        jPanel.add(CON);
        jPanel.add(CONtext);
        jPanel.add(STARTTIME);
        jPanel.add(STARTTIMEtext);
        jPanel.add(ENDTIME);
        jPanel.add(ENDTIMEtext);
        jPanel.add(TYPE);
        jPanel.add(TYPEtext);
        jPanel.add(update);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
