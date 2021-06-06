package VIEW.MANVIEW;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.ManDao;

public class AddCusView {
	JFrame jFrame=new JFrame("增加客户界面");
    JPanel jp=new JPanel(null);
    JLabel cid=new JLabel("客户号:");
    JLabel pas=new JLabel("密码:");
    JLabel cname=new JLabel("客户名字:");
    JLabel cinf=new JLabel("信息:");
    JButton add=new JButton("添加");

    JTextField cidtext=new JTextField(20);
    JTextField pastext=new JTextField(20);
    JTextField cnametext=new JTextField(20);
    JTextField cinftext=new JTextField(20);

    public void init(){
    	jFrame.setLocationRelativeTo(null);
        jFrame.setSize(600,400);
        cid.setBounds(10,20,160,25);
        cidtext.setBounds(200,20,165,25);
        pas.setBounds(10,80,240,25);
        pastext.setBounds(200,80,165,25);
        cname.setBounds(10,140,165,25);
        cnametext.setBounds(200,140,165,25);
        cinf.setBounds(10,180,165,25);
        cinftext.setBounds(200,180,165,25);
        add.setBounds(10,240,80,25);

        ActionListener addListener=e -> {
        	try {
        	 String s1=cidtext.getText();
             String s2=pastext.getText();
             String s3=cnametext.getText();
             String s4=cinftext.getText();
             if (new ManDao().addCus(s1,s2,s3,s4)) {
                 JOptionPane.showMessageDialog(jp,"成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
                 jFrame.dispose();
             }
         } catch (ClassNotFoundException classNotFoundException) {
             classNotFoundException.printStackTrace();
         }
        };
        add.addActionListener(addListener);
        jp.add(cid);
        jp.add(pas);
        jp.add(cname);
        jp.add(cinf);
        jp.add(cidtext);
        jp.add(pastext);
        jp.add(cnametext);
        jp.add(cinftext);
        jp.add(add);
        jFrame.add(jp);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
