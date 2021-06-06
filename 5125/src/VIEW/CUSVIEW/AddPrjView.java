package VIEW.CUSVIEW;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.CusDao;

public class AddPrjView {
	JFrame jFrame=new JFrame("增加项目界面");
    JPanel jp=new JPanel(null);
    JLabel prid=new JLabel("项目号:");
    JLabel cid=new JLabel("客户:");
    JLabel con=new JLabel("内容:");
    JLabel starttime=new JLabel("开始时间:");
    JLabel endtime=new JLabel("结束时间:");
    JLabel type=new JLabel("类型:");    
    JButton add=new JButton("添加");

    JTextField pridtext=new JTextField(20);
    JTextField cidtext=new JTextField(20);
    JTextField context=new JTextField(20);
    JTextField starttimetext=new JTextField(20);
    JTextField endtimetext=new JTextField(20);
    JTextField typetext=new JTextField(20);

    public void init(){
    	jFrame.setLocationRelativeTo(null);
        jFrame.setSize(600,400);
        prid.setBounds(10,20,160,25);
        pridtext.setBounds(200,20,165,25);
        cid.setBounds(10,60,240,25);
        cidtext.setBounds(200,60,165,25);
        con.setBounds(10,100,165,25);
        context.setBounds(200,100,165,25);
        starttime.setBounds(10,140,165,25);
        starttimetext.setBounds(200,140,165,25);
        endtime.setBounds(10,180,165,25);
        endtimetext.setBounds(200,180,165,25);
        type.setBounds(10,220,165,25);
        typetext.setBounds(200,220,165,25);
        add.setBounds(10,260,80,25);

        ActionListener addListener=e -> {
        	try {
        	 String s1=pridtext.getText();
             String s2=cidtext.getText();
             String s3=context.getText();
             String s4=starttimetext.getText();
             String s5=endtimetext.getText();
             String s6=typetext.getText();
             if (new CusDao().addPrj(s1,s2,s3,s4,s5,s6)) {
                 JOptionPane.showMessageDialog(jp,"成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
                 jFrame.dispose();
             }
         } catch (ClassNotFoundException classNotFoundException) {
             classNotFoundException.printStackTrace();
         }
        };
        add.addActionListener(addListener);
        jp.add(prid);
        jp.add(cid);
        jp.add(con);
        jp.add(starttime);
        jp.add(endtime);
        jp.add(type);
        jp.add(pridtext);
        jp.add(cidtext);
        jp.add(context);
        jp.add(starttimetext);
        jp.add(endtimetext);
        jp.add(typetext);
        jp.add(add);
        jFrame.add(jp);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
