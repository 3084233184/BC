package pers.lasting.management.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class SetDatabase {
	private static Connection con;//用来链接的
	private static String url ;//jdbc驱动  mysql数据库   3306端口    clse2数据库名字
	private static String user;
	private static String password ;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConection() throws SQLException {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "123456");
			
		} 
		catch(NullPointerException e) {
			Object[] options = { "确认", "取消" }; 
			JOptionPane.showOptionDialog(null, "连接服务器失败！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		if(con==null){
//			con = DriverManager.getConnection(url, user, password);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management", "root", "123456");
		}
		return con;
	}

	private static void updateDatabaseInformation(String [] values) {
		int i = 0;
		String sql = "UPDATE DatabaseInformation SET url='"+values[i++]+"',user='"+values[i++]+"',password='"+values[i++]+"' WHERE dno='1';";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) con.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	private static void InitDatabaseInformation(){
		String sql = "SELECT * FROM databaseInformation WHERE dno='1'";
		String [] colName = {"url","user","password"};
			try {
				Statement state = con.createStatement();
				ResultSet rs = state.executeQuery(sql);//execute表示查询语句  只有才能返回ResultSet  保存结果的
				if(rs.next())
				{
					int i = 0 ;
					url = rs.getString(colName[i++]);
					user = rs.getString(colName[i++]);
					password = rs.getString(colName[i++]);
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();//捕获异常打印异常
			}
	}
	public static void main(String[] args) {
	}
}
