package pers.lasting.management.gui.function;

import java.sql.SQLException;

import pers.lasting.management.database.operation.UserInformationOperation;

public class Authentication extends UserInformationOperation{
	
	public static boolean isCorrespond(String uid , String pwd) throws SQLException {
		return userCheck(uid).equals(pwd);
	}
	
	public static String userModel(String uid) throws SQLException {
		return modelCheck(uid);
	}
	
	public static boolean isAdd(String[] values) throws SQLException {
		
		if(userAdd(values).equals("Success!"))
			return true;
		return false;
	}
	public static boolean isDelete(String uid) throws SQLException {
		if (userDelete(uid)>0) 
			return true;
		return false;
	}
	public static boolean isUser(String uid) throws SQLException {
		String str = getUserInformation(uid);
		if(!str.equals("")&&!str.equals("ERROR!"))
			return true;
		else return false;
	}
	
	public static boolean isUpdate(String[] values,String uid) throws SQLException{
		if(userUpdate(values, uid)>0)
			return true;
		else return false;
	}
	
	public static String[] getUserInformationArray(String uid) throws SQLException {
		if(isUser(uid))
			return getUserInformation(uid).split(" ");
		else return null;
	}
	
	public static String getUserIDByName(String uname) throws SQLException {
		String buffer = getUserAttributeByName(uname, "uid");
		if(buffer.equals("NOT FOUND!")||buffer.equals("ERROR!"))
			return null;
		return buffer;
	}
	public static String getUserNameByID(String uid) throws SQLException {
		String buffer = getUserAttributeByUid(uid, "uname");
		if(buffer.equals("NOT FOUND!")||buffer.equals("ERROR!"))
			return null;
		return buffer;
	}
}
