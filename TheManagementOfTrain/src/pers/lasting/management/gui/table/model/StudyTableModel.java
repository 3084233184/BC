package pers.lasting.management.gui.table.model;

import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import pers.lasting.management.gui.function.ScheduleOperate;

public class StudyTableModel extends AbstractTableModel {

	Vector<Vector<String>> rowDatas = new Vector<Vector<String>>();
	Vector<String> columnNames = new Vector<String>();
	
	
	public StudyTableModel(String uid) {
		init(uid);
		// TODO Auto-generated constructor stub
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
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames.get(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return rowDatas.get(rowIndex).get(columnIndex);
	}
	
	private void init(String uid) {
		// TODO Auto-generated method stub
		columnNames.add("岗位");
		columnNames.add("内容名");
		columnNames.add("已学时长");
		columnNames.add("应学时长");
		if(uid.equals(""))
			return;
		try {
			rowDatas = ScheduleOperate.getStudyRowDatas(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}
	}
}
