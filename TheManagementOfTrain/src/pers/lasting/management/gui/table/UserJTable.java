package pers.lasting.management.gui.table;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class UserJTable extends JTable {

	public UserJTable() {
		// TODO Auto-generated constructor stub
	}

	public UserJTable(TableModel dm) {
		super(dm);
		// TODO Auto-generated constructor stub
	}

	public UserJTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
		// TODO Auto-generated constructor stub
	}

	public UserJTable(int numRows, int numColumns) {
		super(numRows, numColumns);
		// TODO Auto-generated constructor stub
	}

	public UserJTable(Vector rowData, Vector columnNames) {
		super(rowData, columnNames);
		// TODO Auto-generated constructor stub
	}

	public UserJTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
		// TODO Auto-generated constructor stub
	}

	public UserJTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
		super(dm, cm, sm);
		// TODO Auto-generated constructor stub
	}

	public void inti() {
		// TODO Auto-generated method stub
		setEnabled(false);
		setAutoCreateRowSorter(true);
		getTableHeader().setReorderingAllowed(false);
		setFont(new Font("ÐÂËÎÌå", Font.PLAIN, 16));
		setRowHeight(30);
		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        setDefaultRenderer(Object.class,r);
        setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
	}
}
