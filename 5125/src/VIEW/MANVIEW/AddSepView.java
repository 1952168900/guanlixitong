package VIEW.MANVIEW;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.ManDao;

public class AddSepView {
	JFrame jFrame=new JFrame("增加服务提供者界面");
    JPanel jp=new JPanel(null);
    JLabel sid=new JLabel("服务提供者号:");
    JLabel pas=new JLabel("密码:");
    JLabel sname=new JLabel("服务提供者名字:");
    JLabel type=new JLabel("类型:");
    JButton add=new JButton("添加");

    JTextField sidtext=new JTextField(20);
    JTextField pastext=new JTextField(20);
    JTextField snametext=new JTextField(20);
    JTextField typetext=new JTextField(20);

    public void init(){
    	jFrame.setLocationRelativeTo(null);
        jFrame.setSize(600,400);
        sid.setBounds(10,20,160,25);
        sidtext.setBounds(200,20,165,25);
        pas.setBounds(10,80,240,25);
        pastext.setBounds(200,80,165,25);
        sname.setBounds(10,140,165,25);
        snametext.setBounds(200,140,165,25);
        type.setBounds(10,180,165,25);
        typetext.setBounds(200,180,165,25);
        add.setBounds(10,240,80,25);

        ActionListener addListener=e -> {
        	try {
        	 String s1=sidtext.getText();
             String s2=pastext.getText();
             String s3=snametext.getText();
             String s4=typetext.getText();
             if (new ManDao().addSep(s1,s2,s3,s4)) {
                 JOptionPane.showMessageDialog(jp,"成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
                 jFrame.dispose();
             }
         } catch (ClassNotFoundException classNotFoundException) {
             classNotFoundException.printStackTrace();
         }
        };
        add.addActionListener(addListener);
        jp.add(sid);
        jp.add(pas);
        jp.add(sname);
        jp.add(type);
        jp.add(sidtext);
        jp.add(pastext);
        jp.add(snametext);
        jp.add(typetext);
        jp.add(add);
        jFrame.add(jp);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
