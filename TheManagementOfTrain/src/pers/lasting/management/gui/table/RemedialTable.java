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

public class RemedialTable extends JTable {

	public RemedialTable() {
		init();
		// TODO Auto-generated constructor stub
	}

	public RemedialTable(TableModel dm) {
		super(dm);
		init();
		// TODO Auto-generated constructor stub
	}

	public RemedialTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
		init();
		// TODO Auto-generated constructor stub
	}

	public RemedialTable(int numRows, int numColumns) {
		super(numRows, numColumns);
		init();
		// TODO Auto-generated constructor stub
	}

	public RemedialTable(Vector rowData, Vector columnNames) {
		super(rowData, columnNames);
		init();
		// TODO Auto-generated constructor stub
	}

	public RemedialTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
		init();
		// TODO Auto-generated constructor stub
	}

	public RemedialTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
		super(dm, cm, sm);
		init();
		// TODO Auto-generated constructor stub
	}
	
	private void init() {
		// TODO Auto-generated method stub
		setEnabled(false);
		setAutoCreateRowSorter(true);
		getTableHeader().setReorderingAllowed(false);
		setFont(new Font("新宋体", Font.PLAIN, 16));
		setRowHeight(30);
		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        setDefaultRenderer(Object.class,r);
        setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        TableColumn column=getColumnModel().getColumn(2);
		column.setPreferredWidth(column.getWidth()+70);//width为你要设置的宽度
	}
	
}
