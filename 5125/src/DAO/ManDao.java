package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManDao {
	/*
	 * 管理员登录
	 */
	public boolean loginFrame(String user,String password) throws Exception{
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    try (
	    		Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
	                        "5125zl","123456");
	            PreparedStatement pstmt=conn.prepareStatement(
	                    "select * from Man where MID=? and PAS=? ")
	    ){
	        pstmt.setString(1,user);
	        pstmt.setString(2,password);
	        try (
	                ResultSet rs=pstmt.executeQuery()
	                ){
	            if (rs.next()){
	                //System.out.println("成功");
	                return true;
	            }
	        }
	    }
	    return false;
	}
	/*
	 * 增加客户
	 */
	public boolean addCus(String CID,String PAS,String CNAME,String CINF) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "insert into Cus(CID,PAS,CNAME,CINF)values (?,?,?,?)")
        ) {
            pstmt.setString(1,CID);
            pstmt.setString(2,PAS);
            pstmt.setString(3,CNAME);
            pstmt.setString(4,CINF);
            pstmt.executeUpdate();
            int i=pstmt.getUpdateCount();
            if (i>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
	/*
	 * 增加服务提供者
	 */
	public boolean addSep(String SID,String PAS,String SNAME,String TYPE) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "insert into Sep(SID,PAS,SNAME,TYPE)values (?,?,?,?)")
        ) {
            pstmt.setString(1,SID);
            pstmt.setString(2,PAS);
            pstmt.setString(3,SNAME);
            pstmt.setString(4,TYPE);
            pstmt.executeUpdate();
            int i=pstmt.getUpdateCount();
            if (i>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
	/*
	 * 删除客户
	 */
	public boolean deleteCus(String CID) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
        		Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "delete from Cus where CID=?")
        ) {
            pstmt.setString(1,CID);
            pstmt.executeUpdate();
            int i=pstmt.getUpdateCount();
            if (i>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
	/*
	 * 删除服务提供者
	 */
	public boolean deleteSep(String SID) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
        		Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "delete from Sep where SID=?")
        ) {
            pstmt.setString(1,SID);
            pstmt.executeUpdate();
            int i=pstmt.getUpdateCount();
            if (i>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
	/*
	 * 修改客户信息
	 */
    public boolean updateCus(String CID,String PAS,String CNAME,String CINF) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "update Cus set PAS=?,CNAME=?,CINF=? where CID=?")
        ){
            pstmt.setString(1,PAS);
            pstmt.setString(2,CNAME);
            pstmt.setString(3,CINF);
            pstmt.setString(4,CID);
            pstmt.executeUpdate();
            int i=pstmt.getUpdateCount();
            if (i>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    /*
	 * 修改服务提供者信息
	 */
    public boolean updateSep(String SID,String PAS,String SNAME,String TYPE) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "update Sep set PAS=?,SNAME=?,TYPE=? where SID=?")
        ){
            pstmt.setString(1,PAS);
            pstmt.setString(2,SNAME);
            pstmt.setString(3,TYPE);
            pstmt.setString(4,SID);
            pstmt.executeUpdate();
            int i=pstmt.getUpdateCount();
            if (i>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    /*
	 * 修改合同信息
	 */
    public boolean updateSic(String CID,String SID,String CON,String CNAME,String SNAME) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "update Sep set CON=?,CNAME=?,SNAME=? where SID=? and SID=?")
        ){
            pstmt.setString(1,CON);
            pstmt.setString(2,CNAME);
            pstmt.setString(3,SNAME);
            pstmt.setString(4,CID);
            pstmt.setString(5,SID);
            pstmt.executeUpdate();
            int i=pstmt.getUpdateCount();
            if (i>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    
}
