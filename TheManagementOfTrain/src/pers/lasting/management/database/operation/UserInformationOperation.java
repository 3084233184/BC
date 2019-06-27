package pers.lasting.management.database.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import pers.lasting.management.database.SetDatabase;

public class UserInformationOperation {
	
	private static Connection con;//�������ӵ�
	/**@return
	 * ����success���ɹ�
	 * @param
	 * uid,upassword,uname,utoken,umodel,uphone,upost
	 * */
	/**
	 * @param Values
	 * @return
	 * @throws SQLException 
	 */
	
	protected static String getUserAttributeByUid(String uid,String attribute) throws SQLException {
		con = SetDatabase.getConection();
		 String sql = "SELECT "+attribute+" FROM UserInformation WHERE uid='"+uid+"'";
		 	try {
					Statement state = con.createStatement();
					ResultSet rs = state.executeQuery(sql);//execute��ʾ��ѯ���  ֻ�в��ܷ���ResultSet  ��������
					String dataBuffer = "NOT FOUND!";
					if(rs.next()){
							dataBuffer = rs.getString(attribute);
							return dataBuffer;
					}
					else {
						return dataBuffer;
					}
				}
			catch (Exception e) {
				// TODO: handle exception
				System.err.println(new Date());
				System.err.println(e.getMessage());
				return "ERROR!";
			}
		
	}
	
	protected static String getUserAttributeByName(String uname,String attribute) throws SQLException {
		con = SetDatabase.getConection();
		 String sql = "SELECT "+attribute+" FROM UserInformation WHERE uname='"+uname+"'";
		 	try {
					Statement state = con.createStatement();
					ResultSet rs = state.executeQuery(sql);//execute��ʾ��ѯ���  ֻ�в��ܷ���ResultSet  ��������
					String dataBuffer = "NOT FOUND!";
					if(rs.next()){
							dataBuffer = rs.getString(attribute);
							return dataBuffer;
					}
					else {
						return dataBuffer;
					}
				}
			catch (Exception e) {
				// TODO: handle exception
				System.err.println(new Date());
				System.err.println(e.getMessage());
				return "ERROR!";
			}
		
	}
	
	protected static String userAdd(String []Values) throws SQLException {
		con = SetDatabase.getConection();
		int i=0;
		String sql = "INSERT INTO UserInformation VALUES('"+Values[i++]+"','"+Values[i++]+"','"+Values[i++]+"','"+Values[i++]+"','"+Values[i++]+"','"+Values[i++]+ "','"+Values[i++]+"')";
		PreparedStatement pstmt;
	    try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			i = pstmt.executeUpdate();
	        pstmt.close();
	        return "Success!";
	    }
	    catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
	    	Object[] options = { "ȷ��", "ȡ��" }; 
			JOptionPane.showOptionDialog(null, "�˺Ż������ѱ�ע�ᣡ", "����", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
	    	return "false";
		}
	    catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(new Date());
			System.err.println(e.getMessage());
			return "false";
		}
	}

	/**
	 * @param
	 * "UPDATE UserInformation
	 * SET sname='"+values[i++]+"',umodel='"+values[i++]+"',upassword='"+values[i++]+"', upost='"+values[i++]+"' 
	 * WHERE uid='"+uid+"'";
	 * @return
	 * �����ַ���success��false
	 * @throws SQLException 
	 * */
	protected static int userUpdate(String values[],String uid) throws SQLException {
		con = SetDatabase.getConection();
		int i = 0;
		String sql = "UPDATE UserInformation SET uname='"+values[i++]+"',umodel='"+values[i++]+"',upassword='"+values[i++]+"', upost='"+values[i++]+"',uphone='"+values[i++]+"' WHERE uid='"+uid+"'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) con.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        return i;
	    } catch (SQLException e) {
			System.err.println(new Date());
			System.err.println(e.getMessage());
		    return i;
	    }
	}
	/***
	 * ��½
	 * @param username
	 * @return
	 */
	/**
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	protected static String userCheck(String username) throws SQLException {
		con = SetDatabase.getConection();
		 String sql = "SELECT * FROM UserInformation WHERE uid='"+username+"'";
		 	try {
				Statement state = con.createStatement();
				ResultSet rs = state.executeQuery(sql);//execute��ʾ��ѯ���  ֻ�в��ܷ���ResultSet  ��������
				String dataBuffer = "";
				boolean flag = true ;
				if(rs.next())
				{
					dataBuffer = dataBuffer.concat(rs.getString("upassword"));
					return dataBuffer;
				}
				else {
					return "NOT FOUND THIS USER!";
//				System.err.println(rs.getString(3));//rs.getString(columnIndex)columnIndex��д����
				//ÿһ��ʹ���궼�ùر�״̬�����ӡ�
			}
				}
			catch (Exception e) {
				// TODO: handle exception
				System.err.println(new Date());
				System.err.println(e.getMessage());
				return "USER CHECK ERROR!";
			}
	}
	
	/**
	 * @param
	 * �����û��Ĺ���Ȩ��
	 * @return
	 * ������ֵ����0����������ģʽ��-1δ�ҵ��û���-2�������ݿ����
	 * @throws SQLException 
	 * */
	protected static String modelCheck(String username) throws SQLException {
		con = SetDatabase.getConection();
		 String sql = "SELECT * FROM UserInformation WHERE uid='"+username+"'";
		 	try {
					Statement state = con.createStatement();
					ResultSet rs = state.executeQuery(sql);//execute��ʾ��ѯ���  ֻ�в��ܷ���ResultSet  ��������
					String dataBuffer = "NOT FOUND!";
					if(rs.next()){
							dataBuffer = rs.getString("umodel");
							return dataBuffer;
					}
					else {
						return dataBuffer;
					}
				}
			catch (Exception e) {
				// TODO: handle exception
				System.err.println(new Date());
				System.err.println(e.getMessage());
				return "ERROR!";
			}
	}
	/***
	 * ɾ���û�
	 * @param username
	 * @return
	 * @throws SQLException 
	 */
	@SuppressWarnings("unused")
	protected static int userDelete(String username) throws SQLException {
		con = SetDatabase.getConection();
		PreparedStatement pstmt;
		try {
			String sql="DELETE FROM UserInformation WHERE uid='"+username+"';";
			pstmt = con.prepareStatement(sql);
	        int i = pstmt.executeUpdate();
	        pstmt.close();
			return i;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}
		return 0;
	}
	/***
	 * �û���ѯ
	 * @param args
	 * @return Vector<Vector<String>> rowData
	 * @throws SQLException 
	 */
	public static Vector<Vector<String>> getRowData() throws SQLException{
		con = SetDatabase.getConection();
		Vector<Vector<String>> rowDatas = new Vector<Vector<String>>();
		String sql = "SELECT * FROM UserInformation WHERE uid<>'admin';";
		String[]columnNames = {"uid","uname","upassword","upost","umodel","uphone"};
			try {
				Statement state = con.createStatement();
				ResultSet rs = state.executeQuery(sql);//execute��ʾ��ѯ���  ֻ�в��ܷ���ResultSet  ��������
				boolean flag = true ;
				while(rs.next())
				{
					Vector<String> rowData = new Vector<String>();
					for (String columnName:columnNames) {
						rowData.add(rs.getString(columnName));
					}
					rowDatas.add(rowData);
				}
				return rowDatas;
				//ÿһ��ʹ���궼�ùر�״̬�����ӡ�
			}
			
			catch (Exception e) {
				// TODO: handle exception
				System.err.println(new Date());
				System.err.println(e.getMessage());
				return null;
			}
	}
	
	protected static String getUserInformation(String uid) throws SQLException {
		con = SetDatabase.getConection();
		String sql = "SELECT * FROM UserInformation WHERE uid='"+uid+"';";
		String[]columnNames = {"uid","uname","upassword","upost","umodel","uphone"};
			try {
				Statement state = con.createStatement();
				ResultSet rs = state.executeQuery(sql);//execute��ʾ��ѯ���  ֻ�в��ܷ���ResultSet  ��������
				String rowData = "";
				if(rs.next())
				{
					for (String columnName:columnNames) {
						rowData = rowData + " " +(rs.getString(columnName));
					}
					return rowData;
				}
				else return "";
				//ÿһ��ʹ���궼�ùر�״̬�����ӡ�
			}
			
			catch (Exception e) {
				// TODO: handle exception
				System.err.println(new Date());
				System.err.println(e.getMessage());
				return "ERROR!";
			}
	}
}
