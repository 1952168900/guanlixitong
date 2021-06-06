package VIEW.SEPVIEW;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.SepDao;


public class DeleteSchView {
	JFrame jFrame=new JFrame("删除时间安排表");
    JPanel jPanel=new JPanel(null);
    JLabel scid=new JLabel("时间安排表编号:");
    JTextField scidtext=new JTextField(20);
    JButton ensure=new JButton("确定");
    public void init(){
    	jFrame.setLocationRelativeTo(null);
        jFrame.setSize(300,200);
        scid.setBounds(10,10,80,25);
        scidtext.setBounds(100,10,160,25);
        ensure.setBounds(30,90,80,25);
        jPanel.add(scid);
        jPanel.add(scidtext);
        jPanel.add(ensure);
        ActionListener ensureListener=e -> {
            try {
                if (new SepDao().deleteSch(scidtext.getText())){
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
