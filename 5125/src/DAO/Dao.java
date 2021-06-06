package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao {
	/**
	 * 增加员工
	 * @param EID
	 * @param ENAME
	 * @param SEX
	 * @param DID
	 * @return
	 * @throws ClassNotFoundException
	 */
	public boolean addEmp(String EID,String ENAME,String SEX,String DID) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "insert into Emp_5125(EID,ENAME,SEX,DID)values (?,?,?,?)")
        ) {
            pstmt.setString(1,EID);
            pstmt.setString(2,ENAME);
            pstmt.setString(3,SEX);
            pstmt.setString(4,DID);
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
	/**
	 * 增加部门
	 * @param DID
	 * @param DNAME
	 * @param DINF
	 * @return
	 * @throws ClassNotFoundException
	 */
	public boolean addDept(String DID,String DNAME,String DINF) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "insert into Dept_5125(DID,DNAME,DINF)values (?,?,?)")
        ) {
            pstmt.setString(1,DID);
            pstmt.setString(2,DNAME);
            pstmt.setString(3,DINF);
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
	/**
	 * 增加参与
	 * @param EID
	 * @param PID
	 * @param DATE
	 * @return
	 * @throws ClassNotFoundException
	 */
	public boolean addJoin(String EID,String PID) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "insert into Join_5125(EID,PID)values (?,?)")
        ) {
            pstmt.setString(1,EID);
            pstmt.setString(2,PID);
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
	/**
	 * 增加项目
	 * @param PID
	 * @param PNAME
	 * @param CON
	 * @param CID
	 * @return
	 * @throws ClassNotFoundException
	 */
	public boolean addPro(String PID,String PNAME,String CON,String CID) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "insert into Pro_5125(PID,PNAME,CON,CID)values (?,?,?,?)")
        ) {
            pstmt.setString(1,PID);
            pstmt.setString(2,PNAME);
            pstmt.setString(3,CON);
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
	/**
	 * 增加外包公司
	 * @param CID
	 * @param CNAME
	 * @param CINF
	 * @return
	 * @throws ClassNotFoundException
	 */
	public boolean addCom(String CID,String CNAME,String CINF) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "insert into Com_5125(CID,CNAME,CINF)values (?,?,?)")
        ) {
            pstmt.setString(1,CID);
            pstmt.setString(2,CNAME);
            pstmt.setString(3,CINF);
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
	/**
	 * 删除员工
	 * @param EID
	 * @return
	 * @throws ClassNotFoundException
	 */
    public boolean deleteEmp(String EID) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
        		Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "delete from Emp_5125 where EID=?")
        ) {
            pstmt.setString(1,EID);
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
    /**
     * 删除部门
     * @param DID
     * @return
     * @throws ClassNotFoundException
     */
    public boolean deleteDept(String DID) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
        		Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "delete from Dept_5125 where DID=?")
        ) {
            pstmt.setString(1,DID);
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
    /**
     * 删除参与
     * @param EID
     * @param PID
     * @return
     * @throws ClassNotFoundException
     */
    public boolean deleteJoin(String EID,String PID) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
        		Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "delete from Join_5125 where EID=? and PID=?")
        ) {
            pstmt.setString(1,EID);
            pstmt.setString(2,PID);
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
    /**
     * 删除项目
     * @param PID
     * @return
     * @throws ClassNotFoundException
     */
    public boolean deletePro(String PID) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
        		Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "delete from Pro_5125 where PID=?")
        ) {
            pstmt.setString(1,PID);
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
    /**
     * 删除外包公司
     * @param CID
     * @return
     * @throws ClassNotFoundException
     */
    public boolean deleteCom(String CID) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
        		Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "delete from Com_5125 where CID=?")
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
    /**
     * 修改员工信息
     * @param EID
     * @param ENAME
     * @param SEX
     * @param DID
     * @return
     * @throws Exception
     */
    public boolean updateEmp(String EID,String ENAME,String SEX,String DID) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "update Emp_5125 set ENAME=?,SEX=?,DID=? where EID=?")
        ){
            pstmt.setString(1,ENAME);
            pstmt.setString(2,SEX);
            pstmt.setString(3,DID);
            pstmt.setString(4,EID);
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
    /**
     * 修改部门信息
     * @param DID
     * @param DNAME
     * @param DINF
     * @return
     * @throws Exception
     */
    public boolean updateDept(String DID,String DNAME,String DINF) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "update Dept_5125 set DNAME=?,DINF=? where DID=?")
        ){
            pstmt.setString(1,DNAME);
            pstmt.setString(2,DINF);
            pstmt.setString(3,DID);
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
    /**
     * 修改参与信息
     * @param EID
     * @param PID
     * @param DATE
     * @return
     * @throws Exception
     */
    public boolean updateJoin(String EID,String PID) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
        		PreparedStatement pstmt1=conn.prepareStatement(
                        "delete from Join_5125 where EID=?");
                PreparedStatement pstmt2=conn.prepareStatement(
                        "insert into Join_5125(EID,PID)values (?,?)")
        ){
        	pstmt1.setString(1,EID);
        	pstmt1.executeUpdate();
            pstmt2.setString(1,EID);
            pstmt2.setString(2,PID);
            pstmt2.executeUpdate();
            int i=pstmt2.getUpdateCount();
            if (i>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    /**
     * 修改项目信息
     * @param PID
     * @param PNAME
     * @param CON
     * @param CID
     * @return
     * @throws Exception
     */
    public boolean updatePro(String PID,String PNAME,String CON,String CID) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "update Pro_5125 set PNAME=?,CON=?,CID=? where PID=?")
        ){
            pstmt.setString(1,PNAME);
            pstmt.setString(2,CON);
            pstmt.setString(3,CID);
            pstmt.setString(4,PID);
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
    /**
     * 修改外包公司信息
     * @param CID
     * @param CNAME
     * @param CINF
     * @return
     * @throws Exception
     */
    public boolean updateCom(String CID,String CNAME,String CINF) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zl5125",
                        "5125zl","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "update Com_5125 set CNAME=?,CINF=? where CID=?")
        ){
            pstmt.setString(1,CNAME);
            pstmt.setString(2,CINF);
            pstmt.setString(3,CID);
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
