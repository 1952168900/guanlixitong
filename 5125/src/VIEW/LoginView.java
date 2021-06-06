package VIEW;

import javax.swing.*;

import DAO.CusDao;
import DAO.ManDao;
import DAO.SepDao;
import MODEL.Cus;
import MODEL.Man;
import MODEL.Sep;

import java.awt.event.ActionListener;

public class LoginView {

    public void init(){
        JFrame jf=new JFrame("登录界面");
        jf.setLocationRelativeTo(null);
        jf.setSize(400,300);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel jPanel=new JPanel();
        jf.add(jPanel);
        jPanel.setLayout(null);
        JLabel user=new JLabel("User:");
        user.setBounds(10,20,80,25);
        jPanel.add(user);
        JTextField userText=new JTextField(20);
        userText.setBounds(100,20,165,25);
        jPanel.add(userText);
        JLabel password=new JLabel("Password:");
        password.setBounds(10,50,80,25);
        jPanel.add(password);
        JPasswordField passwordText=new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        jPanel.add(passwordText);
        JButton login=new JButton("login");
        login.setBounds(10,80,80,25);
        jPanel.add(login);


        JRadioButton cus=new JRadioButton("客户",true);
        cus.setBounds(100,80,100,25);
        JRadioButton sep=new JRadioButton("服务提供者");
        sep.setBounds(200,80,100,25);
        JRadioButton man=new JRadioButton("管理员");
        man.setBounds(300,80,100,25);
        ButtonGroup bg=new ButtonGroup();
        bg.add(cus);
        bg.add(sep);
        bg.add(man);
        jPanel.add(cus);
        jPanel.add(sep);
        jPanel.add(man);
        ActionListener loginListener=e -> {
            try {
                String s1=userText.getText();
                @SuppressWarnings("deprecation")
				String s2=passwordText.getText();
                //Cus登录成功
                if (new CusDao().loginFrame(s1,s2)&&cus.isSelected()){
                    JOptionPane.showMessageDialog(jPanel,"成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
                    jf.dispose();
                    Cus cus1=Cus.getInstance();
                    cus1.setCID(s1);
                    //System.out.println(r1.getId());
                    new CusMainView().init();
                }
                //Sep登录成功
                else if (new SepDao().loginFrame(s1,s2)&&sep.isSelected()){
                    JOptionPane.showMessageDialog(jPanel,"成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
                    jf.dispose();
                    Sep sep1 =Sep.getInstance();
                    sep1.setSID(s1);
                    //System.out.println(r1.getId());
                    new SepMainView().init();
                }
                //Man登录成功
                else if (new ManDao().loginFrame(s1,s2)&&man.isSelected()){
                    JOptionPane.showMessageDialog(jPanel,"成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
                    jf.dispose();
                    Man man1 =Man.getInstance();
                    man1.setMID(s1);
                    //System.out.println(r1.getId());
                    new ManMainView().init();
                }
                //登录失败
                else {
                    JOptionPane.showMessageDialog(jPanel,"失败！","提示信息",JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        login.addActionListener(loginListener);

        jf.setVisible(true);
        
    }
    public static void main(String[] args){
        new LoginView().init();
    }
}
