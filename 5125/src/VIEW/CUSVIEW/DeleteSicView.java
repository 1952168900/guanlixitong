package VIEW.CUSVIEW;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.CusDao;


public class DeleteSicView {
	JFrame jFrame=new JFrame("删除合同信息");
    JPanel jPanel=new JPanel(null);
    JLabel cid=new JLabel("客户号:");
    JTextField cidtext=new JTextField(20);
    JLabel sid=new JLabel("服务提供者编号:");
    JTextField sidtext=new JTextField(20);
    JButton ensure=new JButton("确定");
    public void init(){
    	jFrame.setLocationRelativeTo(null);
        jFrame.setSize(300,200);
        cid.setBounds(10,10,80,25);
        cidtext.setBounds(100,10,160,25);
        sid.setBounds(10,50,80,25);
        sidtext.setBounds(100,50,160,25);
        ensure.setBounds(30,90,80,25);
        jPanel.add(cid);
        jPanel.add(cidtext);
        jPanel.add(sid);
        jPanel.add(sidtext);
        jPanel.add(ensure);
        ActionListener ensureListener=e -> {
            try {
                if (new CusDao().deleteSic(cidtext.getText(),sidtext.getText())){
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
