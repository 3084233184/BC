package pers.lasting.management.database.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import com.mysql.cj.xdevapi.ColumnDefinition.StaticColumnDefinition;

import pers.lasting.management.database.SetDatabase;
import pers.lasting.management.gui.function.CourseOperate;

public class ScheduleOperation {
	
	private static Connection con;//用来链接的
	/***
	 * values = {uid, cid, sc_date, time};
	 * @param values
	 * @throws SQLException
	 */
	@SuppressWarnings("finally")
	
	protected static Vector<Vector<String>> getStudyByUid(String uid) throws SQLException{
		String upost = UserInformationOperation.getUserAttributeByUid(uid, "upost");
		String[] columnNames = {"upost","cid","studytime"};
		Vector<String> cids =  getUserLeason(uid);
		Vector<Vector<String>> rowDatas = new Vector<Vector<String>>();
		Iterator<String> it =  cids.iterator();
		while(it.hasNext()) {
			String cid = it.next();
		   	Vector<String> ue = new Vector<String>();
			String sql = "SELECT DISTINCT upost,cid,sum_studytime('"+uid+"','"+upost+"','"+cid+"') AS studytime FROM schedule WHERE upost='"+upost+"' AND cid='"+cid+"'";
		   	try {
				Statement state = con.createStatement();
				ResultSet rs = state.executeQuery(sql);
				while(rs.next()) {
					for (String columnName : columnNames) {
						if(columnName.equals("cid")) {
							ue.add(CourseOperate.getCourseAttributeByID(cid, "cname"));
							continue;
						}
						ue.add(rs.getString(columnName));
					}
					ue.add(CourseOperate.getCourseAttributeByID(cid, "ctime"));
				}
			rowDatas.add(ue);
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println(new Date());
				System.err.println(e.getMessage());
			}
		}
		return rowDatas;
	}
	
	@SuppressWarnings("finally")
	protected static Vector<String> getUserLeason(String uid) throws SQLException {
		con=SetDatabase.getConection();
		String upost = UserInformationOperation.getUserAttributeByUid(uid, "upost");
		int i = 0;
    	String sql = "SELECT DISTINCT cid FROM schedule WHERE upost='"+upost+"'";
    	Vector<String> ue = new Vector<String>();
    	try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);//execute表示查询语句  只有才能返回ResultSet  保存结果的
			while(rs.next())
			{
				ue.add(rs.getString("cid"));;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}finally{
			return ue;
		}
	}
	
	@SuppressWarnings("finally")
	protected static int addLeason(String[] values) throws SQLException {
		con = SetDatabase.getConection();
    	int i=0;
		String sql = "INSERT INTO schedule VALUES('"+values[i++]+"','"+CourseOperate.getCourseID(values[i++]).trim()+"','"+values[i++]+"00','"+values[i++]+"')";
		i=-1;
		PreparedStatement pstmt;
	    try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			i = pstmt.executeUpdate();
	        pstmt.close();
	    }
	    catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}
	    finally {
	    	return i;
	    }
	}

	
	/**
	 * values = {upost, cid, sc_date, willtime};
	 * @param values
	 * @param cid
	 * @return
	 * @throws SQLException 
	 */
	@SuppressWarnings("finally")
	protected static int updateLeason(String []values) throws SQLException {
		con = SetDatabase.getConection();
		// TODO Auto-generated method stub
		int i = 0;
		int j = 0;
	    String sql = "UPDATE shcedule SET upost='"+values[i++]+"',cid='"+values[i++]+"',sc_date='"+values[i++]+"',willtime='"+values[i++]+"' WHERE upost='"+values[j++]+"' AND cid='"+values[j++]+"' AND sc_date='"+values[j++]+"'";
	    i=-1;
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) con.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	    } catch (SQLException e) {
			System.err.println(new Date());
			System.err.println(e.getMessage());
	    }
	    finally {
			return i;
		}
	}
	/***
	 * values = {upost, cid, sc_date};
	 * @param cid
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("finally")
	protected static int deleteLeason(String[] values) throws SQLException {
		con = SetDatabase.getConection();
		// TODO Auto-generated method stub
		PreparedStatement pstmt;
		int i = 0;
		try {
			String sql="DELETE FROM schedule WHERE upost='"+values[i++]+"' AND cid='"+values[i++]+"' AND sc_date='"+values[i++]+"00' ";
			i=-1;
			pstmt = con.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}
		finally {
			return i;
		}
	}
	
	/***
	 * 
	 * @param values
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("finally")
	protected static Vector<Vector<String>> queryLeason(String[] values) throws SQLException {
		con = SetDatabase.getConection();
		String[] columnNames = {"upost", "cid", "sc_date", "willtime"};
    	int i = 0;
    	Vector<Vector<String>> rowData = new Vector<Vector<String>>();
    	String sql = "SELECT * FROM schedule WHERE upost='"+values[i++]+"' AND cid='"+values[i++]+"' AND sc_date='"+values[i++]+"00'";
    	try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);//execute表示查询语句  只有才能返回ResultSet  保存结果的
			while(rs.next())
			{
				Vector<String> ue = new Vector<String>();
				for(String columnName: columnNames) {
					ue.add(rs.getString(columnName));
				}
				rowData.add(ue);
			}
//			System.err.println(rs.getString(3));//rs.getString(columnIndex)columnIndex是写列数
			//每一次使用完都得关闭状态，链接。
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}finally{
			return rowData;
		}

	}
	/***
	 * 
	 * @param upost
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("finally")
	protected static Vector<Vector<String>> queryAllLeason() throws SQLException {
		con = SetDatabase.getConection();
		String[] columnNames = {"upost", "cid", "sc_date", "willtime"};
    	Vector<Vector<String>> rowData = new Vector<Vector<String>>();
    	int i = 0;
//    	String sql = "SELECT * FROM schedule WHERE upost='"+values[i++]+"',cid=(SELECT cid FROM CourseInformation WHERE cname='"+values[i++]+"')'";
    	String sql = "SELECT * FROM schedule";
    	try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);//execute表示查询语句  只有才能返回ResultSet  保存结果的
			while(rs.next())
			{
				Vector<String> ue = new Vector<String>();
				String cname = "";
				for(String columnName: columnNames) {
					if(columnName.equals("cid")) {				
						cname = CourseOperate.getCourseAttributeByID(rs.getString(columnName),"cname");
						ue.add(cname);
						continue;
					}
					ue.add(rs.getString(columnName));
				}
				rowData.add(ue);
			}
//			System.err.println(rs.getString(3));//rs.getString(columnIndex)columnIndex是写列数
			//每一次使用完都得关闭状态，链接。
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}finally{
			return rowData;
		}

	}
	/***
	 * "upost"
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("finally")
	protected static Vector<Vector<String>> getUserSchedule(String uid) throws SQLException{
		String upost = UserInformationOperation.getUserAttributeByUid(uid, "upost");
		con = SetDatabase.getConection();
		String[] columnNames = { "cid", "sc_date", "willtime"};
    	Vector<Vector<String>> rowData = new Vector<Vector<String>>();
//    	String sql = "SELECT * FROM schedule WHERE upost='"+values[i++]+"',cid=(SELECT cid FROM CourseInformation WHERE cname='"+values[i++]+"')'";
    	String sql = "SELECT * FROM schedule WHERE upost='"+upost+"'";
    	try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);//execute表示查询语句  只有才能返回ResultSet  保存结果的
			while(rs.next())
			{
				Vector<String> ue = new Vector<String>();
				String cname = "";
				for(String columnName: columnNames) {
					if(columnName.equals("cid")) {				
						cname = CourseOperate.getCourseAttributeByID(rs.getString(columnName),"cname");
						ue.add(cname);
						continue;
					}
					ue.add(rs.getString(columnName));
				}
				rowData.add(ue);
			}
//			System.err.println(rs.getString(3));//rs.getString(columnIndex)columnIndex是写列数
			//每一次使用完都得关闭状态，链接。
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}finally{
			return rowData;
		}
	}
	
	/***
	 * values = {upost,cname}
	 * @param values
	 * @return
	 * @throws SQLException 
	 */
	@SuppressWarnings("finally")
	protected static int queryAttribute(String[] values,String attribute) throws SQLException {
		con = SetDatabase.getConection();
    	int i = 0 ;
    	String sql = "SELECT "+attribute+" FROM schedule WHERE upost='"+values[i++]+"' AND cid=(SELECT cid FROM CourseInformation WHERE cname='"+values[i]+"')";
    	int time = 0 ;
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);//execute表示查询语句  只有才能返回ResultSet  保存结果的
			if(rs.next())
				time = rs.getInt(attribute);
//			System.err.println(rs.getString(3));//rs.getString(columnIndex)columnIndex是写列数
			//每一次使用完都得关闭状态，链接。
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}finally{
			return time;
		}
	}
	
	@SuppressWarnings("finally")
	protected static Vector<Vector<String>> getUserSchedule(String uid,String sc_Date) throws SQLException{
		String upost = UserInformationOperation.getUserAttributeByUid(uid, "upost");
		con = SetDatabase.getConection();
		String[] columnNames = { "cid", "sc_date", "willtime"};
    	Vector<Vector<String>> rowData = new Vector<Vector<String>>();
//    	String sql = "SELECT * FROM schedule WHERE upost='"+values[i++]+"',cid=(SELECT cid FROM CourseInformation WHERE cname='"+values[i++]+"')'";
    	String sql = "SELECT * FROM schedule WHERE upost='"+upost+"' AND sc_Date>'"+sc_Date+"'";
    	try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);//execute表示查询语句  只有才能返回ResultSet  保存结果的
			while(rs.next())
			{
				Vector<String> ue = new Vector<String>();
				String cname = "";
				for(String columnName: columnNames) {
					if(columnName.equals("cid")) {				
						cname = CourseOperate.getCourseAttributeByID(rs.getString(columnName),"cname");
						ue.add(cname);
						continue;
					}
					ue.add(rs.getString(columnName));
				}
				rowData.add(ue);
			}
//			System.err.println(rs.getString(3));//rs.getString(columnIndex)columnIndex是写列数
			//每一次使用完都得关闭状态，链接。
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}finally{
			return rowData;
		}
	}

}
