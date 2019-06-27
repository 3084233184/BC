package pers.lasting.management.database.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import pers.lasting.management.database.SetDatabase;
/**
 * @author 
 * Lasting
 * */
public class SubjectInformationOperation {
	
	private static Connection con;//用来链接的
	private static String url;//jdbc驱动  mysql数据库   3306端口    clse2数据库名字
	private static String user;
	private static String password;
	

	
	protected static String addSubject(String [] values) throws SQLException{
		con = SetDatabase.getConection();
	    	int i=0;
			String sql = "INSERT INTO SubjectInformation (sid,sname) VALUES('"+values[i++]+"','"+values[i++]+"')";
			PreparedStatement pstmt;
		    try {
				pstmt = (PreparedStatement) con.prepareStatement(sql);
				i = pstmt.executeUpdate();
		        pstmt.close();
		        return "Success!";
		    }
		    catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(new Date());
				System.err.println(e.getMessage());
				return "false";
			}
	    } 
	    
	protected static String updateSubject(String []values) throws SQLException{
		con = SetDatabase.getConection();
    	int i = 0;
	    String sql = "UPDATE SubjectInformation SET sid='"+values[i++]+"',sname='"+values[i++]+"' WHERE sid='"+values[i++]+"'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) con.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        return "success!";
	    } catch (SQLException e) {
			System.err.println(new Date());
			System.err.println(e.getMessage());
		    return "false!";
	    }

    }

    protected static String deleteSubject(String sid) throws SQLException{
		con = SetDatabase.getConection();
		PreparedStatement pstmt;
		int i = 0;
		try {
			String sql="DELETE FROM SubjectInformation WHERE sid='"+sid+"'";
			pstmt = con.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        if(i>0)
			return "SUCCESS!";
	        else return "FALSE!";
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
			return "FALSE!";
		}
    }
    @SuppressWarnings("finally")
	protected static Vector<String> getAllSubject() throws SQLException{
    	con = SetDatabase.getConection();
    	String sql = "SELECT sname FROM SubjectInformation";
    	Vector<String> datas = new Vector<String>();
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);//execute表示查询语句  只有才能返回ResultSet  保存结果的
			while(rs.next()){
				datas.add(rs.getString("sname"));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}
		finally {
			return datas;
		}
    }
    protected static String querySubject(String sid , String []columnNames) throws SQLException {
		con = SetDatabase.getConection();
    	String sql = "SELECT * FROM SubjectInformation WHERE sid='"+sid+"';";
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);//execute表示查询语句  只有才能返回ResultSet  保存结果的
			String dataBuffer = "";
			if(rs.next()){
				for(String columnName:columnNames) {
					dataBuffer += rs.getString(columnName);
					dataBuffer = dataBuffer.concat(" ");    
					}
				return dataBuffer;
			}
			else {
				return "未找到!";
//				System.err.println(rs.getString(3));//rs.getString(columnIndex)columnIndex是写列数
			//每一次使用完都得关闭状态，链接。
		}
			}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
			return "SubjectQueryERROR";
		}
    }
    @SuppressWarnings("finally")
	protected static Vector<String> getAllSubjectVector() throws SQLException{
    	con = SetDatabase.getConection();
    	String sql = "SELECT sname FROM SubjectInformation";
    	Vector<String> datas = new Vector<String>();
    	try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);//execute表示查询语句  只有才能返回ResultSet  保存结果的
			
			while(rs.next()){
				datas.add(rs.getString("sname"));
			}
		//每一次使用完都得关闭状态，链接。
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}
    	finally {
    		return datas;
    	}
    }
}
