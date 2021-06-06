package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CusDao {
	/*
	 * 客户登录
	 */
	public boolean loginFrame(String user,String password) throws Exception{
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    try (
	    		Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
	                        "5125zl","123456");
	            PreparedStatement pstmt=conn.prepareStatement(
	                    "select * from Cus where CID=? and PAS=? ")
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
	 * 增加项目
	 */
	public boolean addPrj(String PRID,String CID,String CON,String STARTTIME,String ENDTIME,String TYPE) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "insert into Prj(PRID,CID,CON,STARTTIME,ENDTIME,TYPE)values (?,?,?,?,?,?)")
        ) {
            pstmt.setString(1,PRID);
            pstmt.setString(2,CID);
            pstmt.setString(3,CON);
            pstmt.setString(4,STARTTIME);
            pstmt.setString(5,ENDTIME);
            pstmt.setString(6,TYPE);
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
	 * 删除项目
	 */
    public boolean deletePrj(String PRID) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
        		Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "delete from Prj where PRID=?")
        ) {
            pstmt.setString(1,PRID);
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
    public boolean updatePer(String CID,String PAS,String CNAME,String CINF) throws Exception{
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
	 * 修改项目信息
	 */
    public boolean updatePrj(String PRID,String CID,String CON,String STARTTIME,String ENDTIME,String TYPE) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "update Prj set CID=?,CON=?,STARTTIME=?,ENDTIME=?,TYPE=?  where PRID=?")
        ){
            pstmt.setString(1,CID);
            pstmt.setString(2,CON);
            pstmt.setString(3,STARTTIME);
            pstmt.setString(4,ENDTIME);
            pstmt.setString(5,TYPE);
            pstmt.setString(6,PRID);
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
