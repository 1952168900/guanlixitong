package VIEW.CUSVIEW;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.CusDao;


public class DeletePrjView {
	JFrame jFrame=new JFrame("删除项目信息");
    JPanel jPanel=new JPanel(null);
    JLabel prid=new JLabel("项目号:");
    JTextField pridtext=new JTextField(20);
    JButton ensure=new JButton("确定");
    public void init(){
    	jFrame.setLocationRelativeTo(null);
        jFrame.setSize(300,150);
        prid.setBounds(10,10,80,25);
        pridtext.setBounds(100,10,160,25);
        ensure.setBounds(30,40,80,25);
        jPanel.add(prid);
        jPanel.add(pridtext);
        jPanel.add(ensure);
        ActionListener ensureListener=e -> {
            try {
                if (new CusDao().deletePrj(pridtext.getText())){
                    JOptionPane.showMessageDialog(jPanel,"成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
                    jFrame.dispose();
                }
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        };
        ensure.addActionListener(ensureListener);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
