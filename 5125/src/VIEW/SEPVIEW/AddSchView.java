package VIEW.SEPVIEW;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.SepDao;

public class AddSchView {
	JFrame jFrame=new JFrame("增加时间安排表界面");
    JPanel jp=new JPanel(null);
    JLabel scid=new JLabel("时间安排表编号:");
    JLabel sid=new JLabel("服务提供者号:");
    JLabel con=new JLabel("内容:");
    JButton add=new JButton("添加");

    JTextField scidtext=new JTextField(20);
    JTextField sidtext=new JTextField(20);
    JTextField context=new JTextField(20);

    public void init(){
    	jFrame.setLocationRelativeTo(null);
        jFrame.setSize(600,400);
        scid.setBounds(10,20,160,25);
        scidtext.setBounds(200,20,165,25);
        sid.setBounds(10,60,240,25);
        sidtext.setBounds(200,60,165,25);
        con.setBounds(10,100,165,25);
        context.setBounds(200,100,165,25);
        add.setBounds(10,220,80,25);

        ActionListener addListener=e -> {
        	try {
        	 String s1=scidtext.getText();
             String s2=sidtext.getText();
             String s3=context.getText();
             if (new SepDao().addSch(s1,s2,s3)) {
                 JOptionPane.showMessageDialog(jp,"成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
                 jFrame.dispose();
             }
         } catch (ClassNotFoundException classNotFoundException) {
             classNotFoundException.printStackTrace();
         }
        };
        add.addActionListener(addListener);
        jp.add(scid);
        jp.add(sid);
        jp.add(con);
        jp.add(scidtext);
        jp.add(sidtext);
        jp.add(context);
        jp.add(add);
        jFrame.add(jp);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
