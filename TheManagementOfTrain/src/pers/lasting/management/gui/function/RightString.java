package pers.lasting.management.gui.function;
public class RightString {
	public static String rightTel(String str) {		
		if(!CheckString.isOnlyNumber(str))
		str = (str.substring(0, str.length()-1)); 
		str = CheckString.filterChinese(str);
		str = CheckString.filterChinese(str);
		str = str.replace(" ","");
		return str;
	}
	/**
	public static String rightUserID(String str0){
		str0.trim();
	}
	
	public static String rightUserName(String str0){
		
	}
	public static String rightPassWord(String str0){
		
	}
	public static String righrOnlyNumber(String str0) {
		
	}
	public static String rightOnlyChinese(String str0) {
		
	}
	public static String rightOnlyChar(String str0) {
		
	}
	*/
}
