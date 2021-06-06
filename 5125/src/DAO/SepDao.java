package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SepDao {
	/*
	 * 服务提供者登录
	 */
	public boolean loginFrame(String user,String password) throws Exception{
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    try (
	    		Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
	                        "5125zl","123456");
	            PreparedStatement pstmt=conn.prepareStatement(
	                    "select * from Sep where SID=? and PAS=? ")
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
	 * 增加合同
	 */
	public boolean addSic(String CID,String SID,String CON,String CNAME,String SNAME) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "insert into Sic(CID,SID,CON,CNAME,SNAME)values (?,?,?,?,?)")
        ) {
            pstmt.setString(1,CID);
            pstmt.setString(2,SID);
            pstmt.setString(3,CON);
            pstmt.setString(4,CNAME);
            pstmt.setString(5,SNAME);
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
	 * 增加时间安排表
	 */
	public boolean addSch(String SCID,String SID,String CON) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "insert into Sch(SCID,SID,CON)values (?,?,?)")
        ) {
            pstmt.setString(1,SCID);
            pstmt.setString(2,SID);
            pstmt.setString(3,CON);
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
	 * 删除时间安排表
	 */
    public boolean deleteSch(String SCID) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
        		Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "delete from Sch where SCID=?")
        ) {
            pstmt.setString(1,SCID);
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
	 * 删除合同
	 */
    public boolean deleteSic(String CID,String SID) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
        		Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "delete from Sic where CID=? and SID=?")
        ) {
            pstmt.setString(1,CID);
            pstmt.setString(2,SID);
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
	 * 修改个人信息
	 */
	public boolean updatePer(String SID,String PAS,String SNAME,String TYPE) throws Exception{
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
	 * 修改时间表信息
	 */
	public boolean updateSch(String SCID,String CON) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "update Sch set CON=? where SCID=?")
        ){
            pstmt.setString(1,CON);
            pstmt.setString(2,SCID);
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
