package VIEW;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import VIEW.MANVIEW.AddCusView;
import VIEW.MANVIEW.AddSepView;
import VIEW.MANVIEW.DeleteCusView;
import VIEW.MANVIEW.DeleteSepView;
import VIEW.MANVIEW.UpdateCusView;
import VIEW.MANVIEW.UpdateSepView;
//import VIEW.MANVIEW.UpdateSicView;

public class ManMainView {
	JFrame jFrame=new JFrame("出租服务管理系统(管理员)");    
    JPanel jPanel=new JPanel(null);
    JMenuBar mb=new JMenuBar();
    JMenu cus=new JMenu("客户信息管理");
    JMenu sep=new JMenu("服务提供者信息管理");
    JMenu sic=new JMenu("签订合同信息管理");
    
    JMenuItem cus_add=new JMenuItem("增加客户");
    JMenuItem cus_delete=new JMenuItem("删除客户");
    JMenuItem cus_update=new JMenuItem("修改客户信息");
    JMenuItem cus_show=new JMenuItem("查看所有客户信息");
    JMenuItem sep_add=new JMenuItem("增加服务提供者");
    JMenuItem sep_delete=new JMenuItem("删除服务提供者");
    JMenuItem sep_update=new JMenuItem("修改服务提供者信息");  
    JMenuItem sep_show=new JMenuItem("查看所有服务提供者信息");
    //JMenuItem sic_update=new JMenuItem("修改合同的信息");
    JMenuItem sic_show=new JMenuItem("审计合同即查看所有合同的信息");

    public void init(){
    	jFrame.setLocationRelativeTo(null);
        cus.add(cus_add);
        cus.add(cus_delete);
        cus.add(cus_update);
        cus.add(cus_show);
        sep.add(sep_add);
        sep.add(sep_delete);
        sep.add(sep_update);
        sep.add(sep_show);
        //sic.add(sic_update);
        sic.add(sic_show);
        mb.add(cus);
        mb.add(sep);
        mb.add(sic);
        jFrame.setJMenuBar(mb);
        /**
         * 增加
         */
        ActionListener cus_addListener=e -> {
            try {
                new AddCusView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        
        ActionListener sep_addListener=e -> {
            try {
                new AddSepView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        /**
         * 删除
         */
        ActionListener cus_deleteListener=e -> {
            try {
                new DeleteCusView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        ActionListener sep_deleteListener=e -> {
            try {
                new DeleteSepView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        /**
         * 修改
         */
        ActionListener cus_updateListener=e -> {
            try {
                new UpdateCusView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        ActionListener sep_updateListener=e -> {
            try {
                new UpdateSepView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
//        ActionListener sic_updateListener=e -> {
//            try {
//                new UpdateSicView().init();
//            } catch (Exception exception) {
//                exception.printStackTrace();
//            }
//        };
        
        
        /**
         * 查看
         */
        ActionListener cus_showListener=e -> {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                try (
                		Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                                "5125zl","123456");
                        PreparedStatement pstmt=conn.prepareStatement(
                                "select * from Cus")
                ){
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
                        JFrame jFrame=new JFrame("查看客户信息");
                        jFrame.setLocationRelativeTo(null);
                        jFrame.setSize(680,480);
                        jFrame.add(scrollPane);
                        jFrame.setVisible(true);
                        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                }
            }catch (Exception exception){
                exception.printStackTrace();
            }
        };
        ActionListener sep_showListener=e -> {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                try (
                		Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                                "5125zl","123456");
                        PreparedStatement pstmt=conn.prepareStatement(
                                "select * from Sep")
                ){
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
                        JFrame jFrame=new JFrame("查看服务提供者信息");
                        jFrame.setLocationRelativeTo(null);
                        jFrame.setSize(680,480);
                        jFrame.add(scrollPane);
                        jFrame.setVisible(true);
                        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                }
            }catch (Exception exception){
                exception.printStackTrace();
            }
        };
        ActionListener sic_showListener=e -> {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                try (
                		Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                                "5125zl","123456");
                        PreparedStatement pstmt=conn.prepareStatement(
                                "select * from Sic")
                ){
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
                        JFrame jFrame=new JFrame("审计合同");
                        jFrame.setLocationRelativeTo(null);
                        jFrame.setSize(680,480);
                        jFrame.add(scrollPane);
                        jFrame.setVisible(true);
                        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                }
            }catch (Exception exception){
                exception.printStackTrace();
            }
        };
       
        
        cus_add.addActionListener(cus_addListener);
        sep_add.addActionListener(sep_addListener);
        cus_delete.addActionListener(cus_deleteListener);
        sep_delete.addActionListener(sep_deleteListener);
        cus_update.addActionListener(cus_updateListener);
        sep_update.addActionListener(sep_updateListener);
        //sic_update.addActionListener(sic_updateListener);
        cus_show.addActionListener(cus_showListener);
        sep_show.addActionListener(sep_showListener);
        sic_show.addActionListener(sic_showListener);

        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.pack();
    }
}
