package pers.lasting.management.gui.function;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import pers.lasting.management.database.operation.CourseInformationOperation;

public class CourseOperate extends CourseInformationOperation{

	/**
	 * @param
	 * cid, cname,ctime,sid.
	 * @throws SQLException 
	 * */
	public static boolean isAdd(String[] values) throws SQLException {
		if(addCourse(values).equals("Success!"))
			return true;
		return false;
	}
	/**
	 * @param cid
	 * @return
	 * @throws SQLException 
	 */
	public static String[] selectValues(String cid) throws SQLException {
		String[] columnNames = {"cid","cname","ctime","sid"};
		String value = queryCourse(cid, columnNames);
		String[] values = value.split(" ");
		return values;
	}
	public static boolean isUpdate(String[] values,String cid) throws SQLException {
		if(updateCourse(values, cid).equals("success!"))
			return true;
		return false;
	}
	
	public static boolean isDelete(String cid) throws SQLException {
		if(deleteCourse(cid).equals("SUCCESS!"))
			return true;
		return false;
	}
	/***
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static String[] getAllCourseNameBySname(String sna) throws SQLException {
		Vector<String> datas = getAllCourse(sna);
		String buffer = null;
		Iterator<String> it = datas.iterator();
		if(!it.hasNext()) {
			return null;
		}
		while(it.hasNext()) {
			if(buffer==null)
			buffer = it.next() + " ";
			else buffer+=it.next() +" ";
		}
		String []buffers = buffer.split(" ");
		return buffers;
	}
	
	public static String[] getAllCourseName() throws SQLException {
		String[] snames = SubjectOperate.getAllSubjectName();
		if(snames==null) return null;
		ArrayList<String> cnameList = new ArrayList<String>();
		for (String sname : snames) {
			String[] cnames = CourseOperate.getAllCourseNameBySname(sname);	
			if (cnames==null) continue;
			for (String cname : cnames) {
				cnameList.add(CourseOperate.getCourseID(cname));
			}
		}
		Object[] cids =  cnameList.toArray();
		String[] cidsString = new String[cids.length];
		
		for (int i = 0; i < cidsString.length; i++) {
			cidsString[i] = cids[i].toString();
		}
		return cidsString;
	}
	
	public static String getCourseTime(String cname) throws SQLException {
		return getCourseAttributeByName(cname, "ctime").trim();
	}
	
	public static String getCourseID(String cname) throws SQLException {
		return getCourseAttributeByName(cname, "cid").trim();
	}
}
