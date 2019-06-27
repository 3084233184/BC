package pers.lasting.management.database.operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;

import pers.lasting.management.database.SetDatabase;

public class RemedialOperation {
	private static Connection con;//用来链接的
	
	/***
	 * values = {uid,cid,sc_date,time,flag};
	 * @param values
	 * @return effectRows
	 * @throws SQLException
	 */
	@SuppressWarnings("finally")
	protected static int add(String[] values) throws SQLException {
		con = SetDatabase.getConection();
    	int i=0;
		String sql = "INSERT INTO remedial VALUES('"+values[i++]+"','"+values[i++]+"','"+values[i++]+"00','"+values[i++]+"',0)";
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
	/***
	 * 
	 * @param values
	 * @return i
	 * @throws SQLException
	 */
	@SuppressWarnings("finally")
	protected static int delete(String[] values) throws SQLException{
		con = SetDatabase.getConection();
    	int i=0;
		String sql = "DELETE FROM remedial WHERE uid='"+
						values[i++]+"' AND cid='"+values[i++]+
						"' AND remedialsc_date='"+values[i++]+
						"00' AND remedialtime='"+values[i++]+"'";
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
	
	/***
	 * Vector<Vector<String>> datas =  uid , cid , date , time , flag ;
	 * @param uid
	 * @param cid
	 * @return datas
	 * @throws SQLException
	 */
	@SuppressWarnings("finally")
	protected static Vector<Vector<String>> getInformation(String uid,String cid) throws SQLException{
		con = SetDatabase.getConection();
    	ResultSet rs ;
		String sql = "SELECT * FROM remedial WHERE uid='"+uid+"' AND cid='"+cid+"'";
		PreparedStatement pstmt;
		Vector<Vector<String>> datas = new Vector<Vector<String>>();
	    try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("uid"));
				data.add(rs.getString("cid"));
				data.add(rs.getString("remedialsc_date"));
				data.add(rs.getString("remedialtime"));
				data.add(rs.getString("remedialflag"));
				datas.add(data);
			}
			pstmt.close();
	    }
	    catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}
	    finally {
	    	return datas;
	    }
	}
}
