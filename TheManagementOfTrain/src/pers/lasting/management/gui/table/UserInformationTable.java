package pers.lasting.management.gui.table;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import pers.lasting.management.database.operation.UserInformationOperation;


public class UserInformationTable extends AbstractTableModel {
	static Vector<Vector<String>> rowData;
	static Vector<String> columnNames;

	
	public UserInformationTable() throws SQLException {
		init();
	}
	
	private void init() throws SQLException {
		// TODO Auto-generated method stub
		rowData = UserInformationOperation.getRowData();
		columnNames = new Vector<String>();
		columnNames.add("账号");
		columnNames.add("姓名");
		columnNames.add("密码");
		columnNames.add("岗位");
		columnNames.add("访问权限");
		columnNames.add("手机号");
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowData.size();
	}
	
	@Override
	public String getColumnName(int column) {
	        // TODO Auto-generated method stub
	      return (String) this.columnNames.get(column);
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		fireTableDataChanged();
		return rowData.get(rowIndex).get(columnIndex);
	}
	
}
