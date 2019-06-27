package pers.lasting.management.database.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import pers.lasting.management.database.SetDatabase;

public class CourseInformationOperation {
	
	private static Connection con;//用来链接的

	
	
	protected static String addCourse(String[] values) throws SQLException {
		con = SetDatabase.getConection();
    	int i=0;
		String sql = "INSERT INTO CourseInformation VALUES('"+values[i++]+"','"+values[i++]+"','"+values[i++]+"','"+values[i++]+"')";
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

	/**
	 * @param values
	 * @param cid
	 * @return
	 * @throws SQLException 
	 */
	protected static String updateCourse(String []values,String cid) throws SQLException {
		con = SetDatabase.getConection();
		// TODO Auto-generated method stub
		int i = 0;
	    String sql = "UPDATE CourseInformation SET cid='"+values[i++]+"',cname='"+values[i++]+"',ctime='"+values[i++]+"',sid='"+values[i++]+"' WHERE cid='" + cid + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) con.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        if(i>0)
	        return "success!";
	        return "false!";
	    } catch (SQLException e) {
	        e.printStackTrace();

		    return "false!";
	    }
	}

	protected static String deleteCourse(String cid) throws SQLException {
		con = SetDatabase.getConection();
		// TODO Auto-generated method stub
		PreparedStatement pstmt;
		int i = 0;
		try {
			String sql="DELETE FROM CourseInformation WHERE cid='"+cid+"';";
			pstmt = con.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        pstmt.close();
			return "SUCCESS!";
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
			return "FALSE!";
		}
	}

	protected static String queryCourse(String cid,String[] columnNames) throws SQLException {
		con = SetDatabase.getConection();
		// TODO Auto-generated method stub
    	int i = 0;
    	String sql = "SELECT * FROM CourseInformation WHERE cid='"+cid+"'";
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);//execute表示查询语句  只有才能返回ResultSet  保存结果的
			String dataBuffer = "";
			if(rs.next())
			{
				for(String columnName: columnNames) {
				dataBuffer += rs.getString(columnNames[i++]);
				dataBuffer = dataBuffer.concat(" ");
				}
				return dataBuffer;
			}
			else {
				return "未找到!";
//			System.err.println(rs.getString(3));//rs.getString(columnIndex)columnIndex是写列数
			//每一次使用完都得关闭状态，链接。
		}
			}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
			return "CourseQueryERROR";
		}

	}
	@SuppressWarnings("finally")
	protected static Vector<String> getAllCourse(String sname) throws SQLException {
		con = SetDatabase.getConection();
		// TODO Auto-generated method stub
    	String sql = "SELECT cname FROM CourseInformation WHERE sid=(SELECT sid FROM SubjectInformation WHERE sname='"+sname+"')";
    	Vector<String> datas = new Vector<String>();
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);//execute表示查询语句  只有才能返回ResultSet  保存结果的
			while(rs.next())
			{
				datas.add(rs.getString("cname"));
			}
//			System.err.println(rs.getString(3));//rs.getString(columnIndex)columnIndex是写列数
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
	
	@SuppressWarnings("finally")
	protected static String getCourseAttributeByID(String cid,String attribute) throws SQLException {
		con = SetDatabase.getConection();
		// TODO Auto-generated method stub
		int i = 0 ; 
    	String sql = "SELECT "+ attribute + " FROM CourseInformation WHERE cid='"+ cid + "'";
    	String datas ="";
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);//execute表示查询语句  只有才能返回ResultSet  保存结果的
			while(rs.next())
			{
				datas =datas +  rs.getString(attribute) + " ";
			}
//			System.err.println(rs.getString(3));//rs.getString(columnIndex)columnIndex是写列数
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
	
	@SuppressWarnings("finally")
	protected static String getCourseAttributeByName(String cname,String attribute) throws SQLException {
		con = SetDatabase.getConection();
		// TODO Auto-generated method stub 
    	String sql = "SELECT "+ attribute + " FROM CourseInformation WHERE cname='"+ cname + "'";
    	String datas ="";
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);//execute表示查询语句  只有才能返回ResultSet  保存结果的
			while(rs.next())
			{
				datas =datas +  rs.getString(attribute) + " ";
			}
//			System.err.println(rs.getString(3));//rs.getString(columnIndex)columnIndex是写列数
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
