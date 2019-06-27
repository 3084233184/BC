package pers.lasting.management.gui.function;

import java.sql.SQLException;
import java.util.Vector;

import pers.lasting.management.database.operation.CourseInformationOperation;
import pers.lasting.management.database.operation.ScheduleOperation;
import pers.lasting.management.gui.page.UserOpreatePage;

public class ScheduleOperate extends ScheduleOperation{
	
	public static int queryStudyTime(String[] values) throws SQLException {
		
		return queryAttribute(values, "SUM(willtime)");
		
	}
	public static Vector<Vector<String>> getRowDatas() throws SQLException {
		return queryAllLeason();
	}
	
	public static Vector<Vector<String>> getRowDatas(String uid) throws SQLException {
		 return getUserSchedule(uid);
	}
	
	public static Vector<Vector<String>> getRowDatas(String uid,String sc_date) throws SQLException {
		 return getUserSchedule(uid,sc_date);
	}
	public static Vector<Vector<String>> getRowData(String[] values) throws SQLException {
		return queryLeason(values);
	}
	
	public static boolean isAdd(String[] values) throws SQLException {
		if(addLeason(values)<0) {
			return false;
		}
		return true;
	}
	
	/***
	 * values = {upost, cid, sc_date};
	 * @param values
	 * @return
	 * @throws SQLException
	 */
	
	public static boolean isDelete(String[]values) throws SQLException{
		
		if(deleteLeason(values)>0) {
			return true;
		}
			return false;
	}

//	Vector<Vector<String>>
	public static Vector<Vector<String>> getStudyRowDatas(String uid) throws SQLException{
		return getStudyByUid(uid);
	}
}
