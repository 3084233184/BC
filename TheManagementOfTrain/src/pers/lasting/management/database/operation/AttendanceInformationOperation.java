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

public class AttendanceInformationOperation {

	private static Connection con;//用来链接的
	
	/***
	 * 
	 * @param upost
	 * @return rowData
	 * @throws SQLException 
	 */
	protected static Vector<Vector<String>> queryAllSchedule(String upost) throws SQLException{
		con = SetDatabase.getConection();
		Vector<Vector<String>> rowData = new Vector<Vector<String>>();
		String [] columnNames = {"cid","sc_date","willtime"};
		String sql = "SELECT * FROM schedule WHERE upost='"+upost+"'";
		con = SetDatabase.getConection();
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);//execute表示查询语句  只有才能返回ResultSet  保存结果的
			boolean flag = true ;
			if(rs.next()){
				do {
				Vector<String> data = new Vector<String>();
				for(String columnName:columnNames) {
					data.add(rs.getString(columnName));
					}
				rowData.add(data);
				}while(rs.next());
				return rowData;
				}
			else {
				return null;
//				System.err.println(rs.getString(3));//rs.getString(columnIndex)columnIndex是写列数
			//每一次使用完都得关闭状态，链接。
		}
			}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
			return null;
		}
	}
	/***
	 * values = {upost, cid, date,willtime}
	 * @param values
	 * @return i if success >1  if false =0
	 * @throws SQLException 
	 */
	protected static int addSchedule(String[] values) throws SQLException {
		con = SetDatabase.getConection();
    	int i=0;
		String sql = "INSERT INTO schedule VALUES('"+values[i++]+"','"+values[i++]+"','"+values[i++]+"','"+values[i++]+"')";
		PreparedStatement pstmt;
	    try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			i = pstmt.executeUpdate();
	        pstmt.close();
	        return i;
	    }
	    catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(new Date());
			System.err.println(e.getMessage());
			return i;
		}
	}
	
	/***
	 * values = {uid, cid, remedialdate,remedialtimem,remedialtime}(remedialtime can be null)
	 * @param values
	 * @return
	 * @throws SQLException 
	 */
	protected static int addRemedial(String[] values) throws SQLException {
		con = SetDatabase.getConection();
		int i=0;
		String sql = "INSERT INTO remedial VALUES('"+values[i++]+"','"+values[i++]+"','"+values[i++]+"','"+values[i++]+"',"+values[i++]+")";
		PreparedStatement pstmt;
	    try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			i = pstmt.executeUpdate();
	        pstmt.close();
	        return i;
	    }
	    catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(new Date());
			System.err.println(e.getMessage());
			return i;
		}
	}
	
	/***
	 * 
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	protected static Vector<Vector<String>> queryRemedial(String uid) throws SQLException {
		con = SetDatabase.getConection();
		String sql = "SELECT * FROM remedial WHERE uid='"+uid+"' AND remedialflag=false";
		Vector<Vector<String>> rowData = new Vector<Vector<String>>();
		String [] columnNames = {"cid","remedialdate","remedialtime","remedialflag"};
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);//execute表示查询语句  只有才能返回ResultSet  保存结果的
			boolean flag = true ;
			if(rs.next()){
				do {
				Vector<String> data = new Vector<String>();
				for(String columnName:columnNames) {
					data.add(rs.getString(columnName));
					}
				rowData.add(data);
				}while(rs.next());
				return rowData;
				}
			else {
				return null;
//				System.err.println(rs.getString(3));//rs.getString(columnIndex)columnIndex是写列数
			//每一次使用完都得关闭状态，链接。
		}
			}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	/***
	 * 
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	protected static Vector<Vector<String>> queryAllRemedial(String uid) throws SQLException {
		con = SetDatabase.getConection();
		String sql = "SELECT * FROM remedial WHERE uid='"+uid+"'";
		Vector<Vector<String>> rowData = new Vector<Vector<String>>();
		String [] columnNames = {"cid","remedialdate","remedialtime","remedialflag"};
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);//execute表示查询语句  只有才能返回ResultSet  保存结果的
			boolean flag = true ;
			if(rs.next()){
				do {
				Vector<String> data = new Vector<String>();
				for(String columnName:columnNames) {
					data.add(rs.getString(columnName));
					}
				rowData.add(data);
				}while(rs.next());
				return rowData;
				}
			else {
				return null;
//				System.err.println(rs.getString(3));//rs.getString(columnIndex)columnIndex是写列数
			//每一次使用完都得关闭状态，链接。
		}
			}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
			return null;
		}
	}
}
