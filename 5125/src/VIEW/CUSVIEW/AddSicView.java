package VIEW.CUSVIEW;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.CusDao;

public class AddSicView {
	JFrame jFrame=new JFrame("增加签订合同界面");
    JPanel jp=new JPanel(null);
    JLabel cid=new JLabel("客户号:");
    JLabel sid=new JLabel("服务提供者号:");
    JLabel con=new JLabel("内容:");
    JLabel cname=new JLabel("客户名字:");
    JLabel sname=new JLabel("服务提供者名字:");
    JButton add=new JButton("添加");

    JTextField cidtext=new JTextField(20);
    JTextField sidtext=new JTextField(20);
    JTextField context=new JTextField(20);
    JTextField cnametext=new JTextField(20);
    JTextField snametext=new JTextField(20);

    public void init(){
    	jFrame.setLocationRelativeTo(null);
        jFrame.setSize(600,400);
        cid.setBounds(10,20,160,25);
        cidtext.setBounds(200,20,165,25);
        sid.setBounds(10,60,240,25);
        sidtext.setBounds(200,60,165,25);
        con.setBounds(10,100,165,25);
        context.setBounds(200,100,165,25);
        cname.setBounds(10,140,165,25);
        cnametext.setBounds(200,140,165,25);
        sname.setBounds(10,180,165,25);
        snametext.setBounds(200,180,165,25);
        add.setBounds(10,220,80,25);

        ActionListener addListener=e -> {
        	try {
        	 String s1=cidtext.getText();
             String s2=sidtext.getText();
             String s3=context.getText();
             String s4=cnametext.getText();
             String s5=snametext.getText();
             if (new CusDao().addSic(s1,s2,s3,s4,s5)) {
                 JOptionPane.showMessageDialog(jp,"成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
                 jFrame.dispose();
             }
         } catch (ClassNotFoundException classNotFoundException) {
             classNotFoundException.printStackTrace();
         }
        };
        add.addActionListener(addListener);
        jp.add(cid);
        jp.add(sid);
        jp.add(con);
        jp.add(cname);
        jp.add(sname);
        jp.add(cidtext);
        jp.add(sidtext);
        jp.add(context);
        jp.add(cnametext);
        jp.add(snametext);
        jp.add(add);
        jFrame.add(jp);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
