package pers.lasting.management.gui.page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import pers.lasting.management.gui.function.CourseOperate;
import pers.lasting.management.gui.function.ScheduleOperate;
import pers.lasting.management.gui.function.SubjectOperate;
import pers.lasting.management.gui.table.ScheduleJTable;
import pers.lasting.management.gui.table.UserInformationTable;
import pers.lasting.management.gui.table.UserJTable;
import pers.lasting.management.gui.table.model.ScheduleTableModel;
import pers.lasting.management.gui.tools.SetWindow;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class AttendancePage extends JFrame{
	
	private JPanel contentPane;
	private ScheduleJTable oprateTable;
	private JTextField sc_datetextField;
	
	public AttendancePage() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AttendancePage.class.getResource("/pers/lasting/management/image/enter_background.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 644, 491);
		SetWindow.setWindowCenter(this);
		setTitle("用户管理");
		
		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);
		
		JMenu mnNewMenu = new JMenu("\u529F\u80FD");
		mnNewMenu.setFont(new Font("新宋体", Font.PLAIN, 18));
		menuBar_1.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u8BF4\u660E\u4E66");
		mntmNewMenuItem.setFont(new Font("新宋体", Font.PLAIN, 18));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem menuItem = new JMenuItem("\u5237\u65B0");
		mnNewMenu.add(menuItem);
		menuItem.setFont(new Font("新宋体", Font.PLAIN, 18));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel ShowPanel = new JPanel();
		ShowPanel.setBounds(14, 86, 592, 335);
		contentPane.add(ShowPanel);
		ShowPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u5185\u5BB9\uFF1A");
		lblNewLabel_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(291, 51, 69, 18);
		contentPane.add(lblNewLabel_1);
		oprateTable  = new ScheduleJTable(new ScheduleTableModel());
		oprateTable.init();
		JScrollPane jsp = new JScrollPane();
		jsp.setLocation(0, 0);
		jsp.setViewportView(oprateTable);
		jsp.setSize(592, 322);
		ShowPanel.add(jsp);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFont(new Font("等线", Font.PLAIN, 18));
		toolBar.setBounds(0, 0, 606, 35);
		contentPane.add(toolBar);
		
		JButton btnNewButton = new JButton("\u5237\u65B0");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				oprateTable = new ScheduleJTable(new ScheduleTableModel());
				oprateTable.init();
				jsp.setViewportView(oprateTable);
				repaint();
			}
		});
		btnNewButton.setFont(new Font("等线", Font.PLAIN, 17));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0\u8BFE\u7A0B");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddSchedulePage().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("等线", Font.PLAIN, 17));
		toolBar.add(btnNewButton_1);
		
		JButton deleteButton = new JButton("\u5220\u9664\u8BFE\u7A0B");
		toolBar.add(deleteButton);
		deleteButton.setFont(new Font("新宋体", Font.PLAIN, 18));
		
		JButton button = new JButton("\u7F3A\u52E4\u767B\u8BB0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RemedialAddPage().setVisible(true);
			}
		});
		button.setFont(new Font("等线", Font.PLAIN, 17));
		toolBar.add(button);
		
		JButton button_1 = new JButton("\u7F3A\u52E4\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RemedialDeletePage().setVisible(true);
			}
		});
		button_1.setFont(new Font("等线", Font.PLAIN, 17));
		toolBar.add(button_1);
		
		JButton btnNewButton_2 = new JButton("\u7F3A\u52E4\u67E5\u8BE2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RemedialQueryPage().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("等线", Font.PLAIN, 17));
		toolBar.add(btnNewButton_2);
		
		JButton button_2 = new JButton("\u5B66\u4E60\u60C5\u51B5\u67E5\u8BE2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudyQueryPage().setVisible(true);
			}
		});
		button_2.setFont(new Font("等线", Font.PLAIN, 17));
		toolBar.add(button_2);
		
		JLabel label = new JLabel("\u5C97\u4F4D\uFF1A");
		label.setFont(new Font("新宋体", Font.PLAIN, 18));
		label.setBounds(10, 51, 72, 18);
		contentPane.add(label);
		
		JComboBox upostcomboBox = new JComboBox();
		upostcomboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5C97\u524D", "\u521D\u7EA7"}));
		upostcomboBox.setFont(new Font("新宋体", Font.PLAIN, 18));
		upostcomboBox.setBounds(53, 49, 88, 24);
		contentPane.add(upostcomboBox);
		
		JLabel lblNewLabel = new JLabel("\u79D1\u76EE\uFF1A");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(148, 51, 72, 18);
		contentPane.add(lblNewLabel);
		
		JComboBox snamecomboBox = new JComboBox();
		snamecomboBox.setFont(new Font("新宋体", Font.PLAIN, 18));
		snamecomboBox.setBounds(195, 48, 94, 24);
		try {
			snamecomboBox.removeAllItems();
			String[] items = SubjectOperate.getAllSubjectName();
			for (String item : items) {
				snamecomboBox.addItem(item);
			}
		} 
		catch (NullPointerException e) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}
		catch (SQLException e2) {
			// TODO Auto-generated catch block
			System.err.println(new Date());
			System.err.println(e2.getMessage());
		}
		contentPane.add(snamecomboBox);
		
		JComboBox cnamecomboBox = new JComboBox();
		cnamecomboBox.setFont(new Font("新宋体", Font.PLAIN, 18));
		cnamecomboBox.setBounds(338, 49, 96, 24);

		cnamecomboBox.removeAllItems();
		String sname = (String) snamecomboBox.getSelectedItem();
		String []items = null;
		try {
			items = CourseOperate.getAllCourseNameBySname(sname);
			for (String item : items) {
				cnamecomboBox.addItem(item);
			}
		} 
		catch (NullPointerException e1) {
			// TODO: handle exception
			System.err.println(new Date());
			System.err.println(e1.getMessage());
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.err.println(new Date());
			System.err.println(e1.getMessage());
		}
		contentPane.add(cnamecomboBox);
		
		JLabel label_1 = new JLabel("\u65E5\u671F\uFF1A");
		label_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_1.setBounds(448, 51, 54, 18);
		contentPane.add(label_1);
		
		sc_datetextField = new JTextField();
		sc_datetextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.err.println("action!!!!------------------------------");
				if(sc_datetextField.getText().length()>12||sc_datetextField.getText().length()<12) {
					Object[] options = { "确认", "取消" }; 
					JOptionPane.showOptionDialog(null, "日期格式不合法！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
					return;
				}
				if(sc_datetextField.getText().length()==12) {
//					upost='"+values[i++]+"' AND cid='"+values[i++]+"' AND sc_date='"+values[i++]+"'";
					try {
					String upost =(String) upostcomboBox.getSelectedItem();
					String cid =CourseOperate.getCourseID((String) cnamecomboBox.getSelectedItem());
					String sc_date = sc_datetextField.getText();
					String[] values = {upost,cid,sc_date};
					for (String value : values) {
						System.err.println(value);
					}
					oprateTable = new ScheduleJTable(new ScheduleTableModel(values));
					jsp.setViewportView(oprateTable);
					repaint();
					}catch (SQLException e1) {
							// TODO Auto-generated catch block
						System.err.println(new Date());
						System.err.println(e1.getMessage());
						}
				}
					
			}
		});

		
		sc_datetextField.setFont(new Font("新宋体", Font.PLAIN, 18));
		sc_datetextField.setBounds(499, 48, 107, 24);
		contentPane.add(sc_datetextField);
		sc_datetextField.setColumns(10);
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				oprateTable = new ScheduleJTable(new ScheduleTableModel());
				oprateTable.init();
				jsp.setViewportView(oprateTable);
				repaint();
			}
		});
			snamecomboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String cname = (String) cnamecomboBox.getSelectedItem();
				cnamecomboBox.removeAllItems();
				String sname = (String) snamecomboBox.getSelectedItem();
				String []items = null;
				try {
					items = CourseOperate.getAllCourseNameBySname(sname);
					for (String item : items) {
						cnamecomboBox.addItem(item);
					}
				} 
				catch (NullPointerException e1) {
					// TODO: handle exception
					System.err.println(new Date());
					System.err.println(e1.getMessage());
					return;
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println(new Date());
					System.err.println(e1.getMessage());
					e1.printStackTrace();
					return;
				}
			}
			
		});
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cname =  (String) cnamecomboBox.getSelectedItem();
				String upost = (String) upostcomboBox.getSelectedItem();
				String sc_date = sc_datetextField.getText();
				String[] values = {upost,cname,sc_date,sc_date};
				new ChangeSchedulePage(values).setVisible(true);
			}
		});
	}
	public static void main(String[] args) {
		try {
			new AttendancePage().setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
