package VIEW.SEPVIEW;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SelectSicView {
	JFrame jFrame=new JFrame("查找已签订合同表的信息");
    JPanel jPanel=new JPanel();
   JLabel SID=new JLabel("服务提供者编号:");
    JTextField SIDtext=new JTextField(20);
    JButton button=new JButton("确认");
    public void init(){
    	jFrame.setLocationRelativeTo(null);
    	jFrame.setSize(300,200);
        jPanel.add(SID);
        jPanel.add(SIDtext);
       jPanel.add(button);
        ActionListener buttonListener=e -> {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                try (
                		Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                                "5125zl","123456");
                        PreparedStatement pstmt=conn.prepareStatement(
                                "select * from Sic where SID=?")
                ){
                    String id=SIDtext.getText();
                    pstmt.setString(1,id);
                    ResultSet rs=pstmt.executeQuery();
                    ResultSetMetaData rsmd= rs.getMetaData();
                    Vector<String> columnNames=new Vector<>();
                    Vector<Vector<String>> data=new Vector<>();
                    for (int i=0;i<rsmd.getColumnCount();i++){
                        columnNames.add(rsmd.getColumnName(i+1));
                    }
                    while (rs.next()){
                        Vector<String> v=new Vector<>();
                        for (int i=0;i<rsmd.getColumnCount();i++){
                            v.add(rs.getString(i+1));
                        }
                        data.add(v);
                    }
                    JTable table=new JTable(data,columnNames);
                    JScrollPane scrollPane=new JScrollPane(table);
                    JFrame jFrame=new JFrame("查找已签订合同表的信息");
                    jFrame.setLocationRelativeTo(null);
                    jFrame.setSize(680,480);
                    jFrame.add(scrollPane);
                    jFrame.setVisible(true);
                }catch (Exception exception){
                    exception.printStackTrace();
                }  
            }catch (Exception exception){
                exception.printStackTrace();
            }
};
	button.addActionListener(buttonListener);
	jPanel.add(SID);
    jPanel.add(SIDtext);
    jFrame.add(jPanel);
    jFrame.setVisible(true);
    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
}
