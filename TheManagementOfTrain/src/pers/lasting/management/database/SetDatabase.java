package pers.lasting.management.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class SetDatabase {
	private static Connection con;//�������ӵ�
	private static String url ;//jdbc����  mysql���ݿ�   3306�˿�    clse2���ݿ�����
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
			Object[] options = { "ȷ��", "ȡ��" }; 
			JOptionPane.showOptionDialog(null, "���ӷ�����ʧ�ܣ�", "����", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
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
				ResultSet rs = state.executeQuery(sql);//execute��ʾ��ѯ���  ֻ�в��ܷ���ResultSet  ��������
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
				e.printStackTrace();//�����쳣��ӡ�쳣
			}
	}
	public static void main(String[] args) {
	}
}
