package pers.lasting.management.gui.function;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import pers.lasting.management.database.operation.SubjectInformationOperation;

public class SubjectOperate extends SubjectInformationOperation{
	
	public static boolean isAdd(String []values) throws SQLException {
		if(addSubject(values).equals("Success!"))
			return true;
		else return false;	
	}
	
	public static String[] selectValues(String sid) throws SQLException {
		String[] columnNames = {"sid","sname","stime"};
		String value = querySubject(sid, columnNames);
		String [] values = value.split(" ");
		return values;
	}
	
	public static boolean isUpdate(String[] values) throws SQLException {
		if(updateSubject(values).equals("success!"))
			return true;
		return false;
	}
	
	public static boolean isDelete(String sid) throws SQLException {
		if(deleteSubject(sid).equals("SUCCESS!"))
			return true;
		return false;
	}
	public static String[] getAllSubjectName() throws SQLException{
		Vector<String> datas = getAllSubjectVector();
		String s = null;
		Iterator<String> it = datas.iterator();
		if(!it.hasNext())
			return null;
		while(it.hasNext()) {
			if(s==null) {
				s = it.next() + " ";
				continue;
			}
			s+=it.next()+" ";
		}
		String [] values = s.trim().split(" ");
		return values;
	}
}
