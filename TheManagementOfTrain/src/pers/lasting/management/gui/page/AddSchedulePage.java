package pers.lasting.management.gui.page;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pers.lasting.management.database.operation.CourseInformationOperation;
import pers.lasting.management.gui.function.CourseOperate;
import pers.lasting.management.gui.function.ScheduleOperate;
import pers.lasting.management.gui.function.SubjectOperate;
import pers.lasting.management.gui.tools.SetWindow;

import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToolBar;
import java.awt.Toolkit;

public class AddSchedulePage extends JFrame {

	private JPanel contentPane;
	private JTextField sc_dateTextField;
	private JTextField willtimeTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSchedulePage frame = new AddSchedulePage();
					frame.setVisible(true);
				} catch (Exception e) {
					System.err.println(new Date());
					System.err.println(e.getMessage());
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public AddSchedulePage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddSchedulePage.class.getResource("/pers/lasting/management/image/enter_background.jpg")));
		setTitle("\u8BFE\u7A0B\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 584, 495);
		SetWindow.setWindowCenter(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel showPanel = new JPanel();
		showPanel.setBounds(10, 33, 546, 407);
		contentPane.add(showPanel);
		final CardLayout showpanelLayout = new CardLayout();
		showPanel.setLayout(showpanelLayout);
		
		JPanel add = new JPanel();
		showPanel.add(add, "add");
		add.setLayout(null);
		
		JLabel label = new JLabel("\u79D1\u76EE\uFF1A");
		label.setFont(new Font("新宋体", Font.PLAIN, 18));
		label.setBounds(327, 43, 54, 15);
		add.add(label);
		
		JComboBox<String> snamecomboBoxAdd = new JComboBox<String>();

		snamecomboBoxAdd.setFont(new Font("新宋体", Font.PLAIN, 18));
		snamecomboBoxAdd.setBounds(394, 39, 101, 23);
		try {
			snamecomboBoxAdd.removeAllItems();
			String[] items = SubjectOperate.getAllSubjectName();
			for (String item : items) {
				snamecomboBoxAdd.addItem(item);
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
		add.add(snamecomboBoxAdd);
		
		JLabel label_1 = new JLabel("\u5185\u5BB9\uFF1A");
		label_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_1.setBounds(327, 108, 54, 15);
		add.add(label_1);
		
		JLabel label_2 = new JLabel("\u8BAD\u7EC3\u65F6\u957F\uFF1A");
		label_2.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_2.setBounds(23, 121, 93, 15);
		add.add(label_2);
		
		JComboBox<String> cnamecomboBoxAdd = new JComboBox<String>();
		
		cnamecomboBoxAdd.setFont(new Font("新宋体", Font.PLAIN, 18));
		cnamecomboBoxAdd.setBounds(394, 104, 138, 23);
		
		add.add(cnamecomboBoxAdd);
		
		JLabel lblNewLabel = new JLabel("\u8BAD\u7EC3\u65E5\u671F\uFF1A");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(23, 195, 93, 15);
		add.add(lblNewLabel);
		
		JButton buttonAddReset = new JButton("\u91CD\u7F6E");
		buttonAddReset.setFont(new Font("新宋体", Font.PLAIN, 18));
		buttonAddReset.setBounds(131, 340, 115, 23);
		add.add(buttonAddReset);
		
		JButton buttonAddSubmit = new JButton("\u8BFE\u7A0B\u6DFB\u52A0");
		buttonAddSubmit.setFont(new Font("新宋体", Font.PLAIN, 18));
		buttonAddSubmit.setBounds(315, 340, 115, 23);
		
		add.add(buttonAddSubmit);
		
		sc_dateTextField = new JTextField();
		sc_dateTextField.setFont(new Font("新宋体", Font.PLAIN, 18));
		sc_dateTextField.setBounds(131, 191, 101, 23);
		add.add(sc_dateTextField);
		sc_dateTextField.setColumns(10);
		
		JLabel lbln = new JLabel("\u8BAD\u7EC3\u65E5\u671F\u683C\u5F0F\u4E3A\uFF1A\u4F8B\u59822019\u5E745\u670826\u65E59\u70B9  201905260900");
		lbln.setFont(new Font("新宋体", Font.PLAIN, 18));
		lbln.setBounds(23, 263, 538, 23);
		add.add(lbln);
		
		willtimeTextField = new JTextField();
		willtimeTextField.setBounds(131, 118, 101, 24);
		add.add(willtimeTextField);
		willtimeTextField.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5269\u4F59\u65F6\u957F\uFF1A");
		label_4.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_4.setBounds(327, 193, 101, 18);
		add.add(label_4);
		
		JLabel needTime = new JLabel("");
		needTime.setFont(new Font("新宋体", Font.PLAIN, 18));
		needTime.setBounds(424, 192, 72, 18);
		add.add(needTime);
		
		JLabel label_3 = new JLabel("\u5C97\u4F4D\uFF1A");
		label_3.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_3.setBounds(44, 41, 72, 18);
		add.add(label_3);
		
		JComboBox upostcomboBox = new JComboBox();
		upostcomboBox.setFont(new Font("新宋体", Font.PLAIN, 18));
		upostcomboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5C97\u524D", "\u521D\u7EA7"}));
		upostcomboBox.setBounds(131, 40, 101, 24);
		add.add(upostcomboBox);
		
		snamecomboBoxAdd.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				cnamecomboBoxAdd.removeAllItems();
				String sname = (String) snamecomboBoxAdd.getSelectedItem();
				String []items = null;
				try {
					items = CourseOperate.getAllCourseNameBySname(sname);
					for (String item : items) {
						cnamecomboBoxAdd.addItem(item);
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
					return;
				}
			}
			
		});
		cnamecomboBoxAdd.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String upost = (String) upostcomboBox.getSelectedItem();
				String cname = (String) cnamecomboBoxAdd.getSelectedItem();
				if(upost==null ||cname==null)
				   return;
				if(upost.equals("")||cname.equals(""))
					return;
				System.err.println("upost="+upost+"cname="+cname);
				String[]values = {upost,cname};
				try {
					int donetime = ScheduleOperate.queryStudyTime(values);
					Integer alltime = new Integer(CourseOperate.getCourseTime(cname));
					Integer needtime = alltime.intValue()-donetime;
					System.err.println("----------------------donetime="+donetime+" -------------alltime="+alltime+"----------needtime="+needtime);
					needTime.setText(needtime.toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println(new Date());
					System.err.println(e1.getMessage());
				}
			}
		});
		buttonAddSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cname =  (String) cnamecomboBoxAdd.getSelectedItem();
				String upost = (String) upostcomboBox.getSelectedItem();
				String willtime = willtimeTextField.getText();
				String sc_date = sc_dateTextField.getText();
				String[] values = {upost,cname,sc_date,willtime};
				Integer needtimenumber = new Integer(needTime.getText());
				Integer willtimenumber = new Integer(willtime);
				if(willtimenumber>needtimenumber) {
					Object[] options = {"确认"};
					JOptionPane.showOptionDialog(null, "训练时长超出剩余时长！", "课程操作", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
					return;
				}
					
				Object [] options = {"取消","确定"};
				try {
					if(ScheduleOperate.isAdd(values)){
						JOptionPane.showOptionDialog(null, "添加课程成功！", "课程操作", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
						dispose();
					}
					else {
						JOptionPane.showOptionDialog(null, "该岗位同内容同时段已有课程添加！", "课程操作", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]); 
					}
				} catch (SQLException  e1) {
					// TODO: handle exception
					System.err.println(new Date());
					System.err.println(e1.getMessage());
				}catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					System.err.println(new Date());
					System.err.println(e1.getMessage());
				}
					
			}
		});
	}
	
}
