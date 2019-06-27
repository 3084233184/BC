package pers.lasting.management.gui.table.model;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import pers.lasting.management.database.operation.RemedialOperation;
import pers.lasting.management.gui.function.RemedialOperate;

public class RemedialTableModel extends AbstractTableModel {

	Vector<Vector<String>> rowDatas = new Vector<Vector<String>>();
	Vector<String> columnNames = new Vector<String>();
	
	public RemedialTableModel(String uid) {
		// TODO Auto-generated constructor stub
		try {
			init(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames.get(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return rowDatas.get(rowIndex).get(columnIndex);
	}
	
	private void init(String uid) throws SQLException {
		// TODO Auto-generated method stub
//		[1120259135, KM00101, 2019-06-21 11:26:27, 3, 0]
		columnNames.add("账号");
		columnNames.add("内容号");
		columnNames.add("日期");
		columnNames.add("时长");
		columnNames.add("状态");
		if(uid.equals(""))
			return;
		rowDatas = RemedialOperate.getRemedial(uid);
	}
	
}
