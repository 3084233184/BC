package pers.lasting.management.gui.table;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class StudyJTable extends JTable {

	public StudyJTable() {
		init();
		// TODO Auto-generated constructor stub
	}

	public StudyJTable(TableModel dm) {
		super(dm);
		init();
		// TODO Auto-generated constructor stub
	}

	public StudyJTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
		init();
		// TODO Auto-generated constructor stub
	}

	public StudyJTable(int numRows, int numColumns) {
		super(numRows, numColumns);
		init();
		// TODO Auto-generated constructor stub
	}

	public StudyJTable(Vector rowData, Vector columnNames) {
		super(rowData, columnNames);
		init();
		// TODO Auto-generated constructor stub
	}

	public StudyJTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
		init();
		// TODO Auto-generated constructor stub
	}

	public StudyJTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
		super(dm, cm, sm);
		init();
		// TODO Auto-generated constructor stub
	}
	private void init() {
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
