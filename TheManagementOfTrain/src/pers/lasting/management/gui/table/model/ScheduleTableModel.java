package pers.lasting.management.gui.table.model;

import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import pers.lasting.management.gui.function.ScheduleOperate;

public class ScheduleTableModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector<Vector<String>> rowDatas = new Vector<Vector<String>>();
	private Vector<String> columnNames = new Vector<String>();
	
	public ScheduleTableModel() {
//		String[] columnNames = {"upost", "cid", "sc_date", "willtime"};
		
		// TODO Auto-generated constructor stub
		columnNames.add("岗位");
		columnNames.add("内容");
		columnNames.add("日期");
		columnNames.add("时长");
		try {
			rowDatas = ScheduleOperate.getRowDatas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}
		
	}
	/***
	 *  upost='"+values[i++]+"' AND cid='"+values[i++]+"' AND sc_date='"+values[i++]+"'";
	 * @param values
	 */
	public ScheduleTableModel(String[] values){
		columnNames.add("岗位");
		columnNames.add("内容");
		columnNames.add("日期");
		columnNames.add("时长");
		try {
			rowDatas = ScheduleOperate.getRowData(values);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}
	}
	/***
	 *  { "cid", "sc_date", "willtime"};
	 * @param uid
	 */
	public ScheduleTableModel(String uid) {
		columnNames.add("内容");
		columnNames.add("日期");
		columnNames.add("时长");
		try {
			rowDatas = ScheduleOperate.getRowDatas(uid);
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}
	}
	
	public ScheduleTableModel(String uid,String sc_date) {
		columnNames.add("内容");
		columnNames.add("日期");
		columnNames.add("时长");
		try {
			rowDatas = ScheduleOperate.getRowDatas(uid,sc_date);
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowDatas.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return rowDatas.get(rowIndex).get(columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames.get(column);
	}
}
