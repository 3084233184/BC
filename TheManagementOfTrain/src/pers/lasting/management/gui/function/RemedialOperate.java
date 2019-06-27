package pers.lasting.management.gui.function;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import pers.lasting.management.database.operation.RemedialOperation;

public class RemedialOperate extends RemedialOperation{
	public static boolean isAdd(String[] values) throws SQLException {
		// TODO Auto-generated method stub
		if(add(values)>0)
			return true;
		return false;
	}
	public static boolean isDelete(String[] values) throws SQLException {
		if(delete(values)>0)
			return true;
		return false;
	}
	public static Vector<Vector<String>> getRemedial(String uid,String cid) throws SQLException{
		
		return getInformation(uid, cid);
		
	}
	
	/***
	 * 
	 * @param uid
	 * @throws SQLException
	 */
	public static Vector<Vector<String>> getRemedial(String uid) throws SQLException{
		
		String[] cids = CourseOperate.getAllCourseName();
		Vector<Vector<String>> rowDatas = new Vector<Vector<String>>();
		if(cids!=null)
		for (String cid : cids) {
			rowDatas.addAll(getInformation(uid, cid));
		}
		return rowDatas;
	}
}
