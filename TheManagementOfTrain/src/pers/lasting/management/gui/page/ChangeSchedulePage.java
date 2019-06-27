package pers.lasting.management.gui.page;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pers.lasting.management.gui.function.CourseOperate;
import pers.lasting.management.gui.function.ScheduleOperate;
import pers.lasting.management.gui.function.SubjectOperate;
import pers.lasting.management.gui.tools.SetWindow;

public class ChangeSchedulePage extends JFrame{

	private JPanel contentPane;
	private JTextField sc_dateTextField;
	private JComboBox<String> snamecomboBox;
	private JComboBox<String> cnamecomboBox ;
	private JComboBox<String> upostcomboBox ;
	private String upost;
	private String cname;
	private String sname;
	private String sc_date;
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
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes"})
	/***
	 * 
	 * @param values
	 * values={upost,sname,cname,sc_date}
	 */
	public ChangeSchedulePage(String[]values) {
		int i = 0 ;
		upost = values[i++];
		sname = values[i++];
		cname = values[i++];
		sc_date = values[i++];
		
		
		setTitle("课程信息修改");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 405, 499);
		SetWindow.setWindowCenter(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel showPanel = new JPanel();
		showPanel.setBounds(10, 31, 363, 409);
		contentPane.add(showPanel);
		final CardLayout showpanelLayout = new CardLayout();
		showPanel.setLayout(showpanelLayout);
		
		JPanel add = new JPanel();
		showPanel.add(add, "add");
		add.setLayout(null);
		
		JLabel label = new JLabel("\u79D1\u76EE\uFF1A");
		label.setFont(new Font("新宋体", Font.PLAIN, 18));
		label.setBounds(62, 96, 54, 15);
		add.add(label);
		
		snamecomboBox = new JComboBox<String>();

		snamecomboBox.setFont(new Font("新宋体", Font.PLAIN, 18));
		snamecomboBox.setBounds(157, 92, 101, 23);
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
		add.add(snamecomboBox);
		
		JLabel label_1 = new JLabel("\u5185\u5BB9\uFF1A");
		label_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_1.setBounds(62, 144, 54, 15);
		add.add(label_1);
		
		cnamecomboBox = new JComboBox<String>();
		
		cnamecomboBox.setFont(new Font("新宋体", Font.PLAIN, 18));
		cnamecomboBox.setBounds(157, 140, 138, 23);
		
		add.add(cnamecomboBox);
		
		JLabel lblNewLabel = new JLabel("\u8BAD\u7EC3\u65E5\u671F\uFF1A");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(39, 209, 93, 15);
		add.add(lblNewLabel);
		
		JButton DeleteButton = new JButton("\u8BFE\u7A0B\u5220\u9664");
		DeleteButton.setFont(new Font("新宋体", Font.PLAIN, 18));
		DeleteButton.setBounds(118, 349, 115, 23);
		add.add(DeleteButton);
		
		sc_dateTextField = new JTextField();
		sc_dateTextField.setFont(new Font("新宋体", Font.PLAIN, 18));
		sc_dateTextField.setBounds(157, 205, 130, 23);
		add.add(sc_dateTextField);
		sc_dateTextField.setColumns(10);
		
		JLabel lbln = new JLabel("\u8BAD\u7EC3\u65E5\u671F\u683C\u5F0F\u4E3A\uFF1A\u4F8B\u59822019\u5E745\u670826\u65E59\u70B9");
		lbln.setFont(new Font("新宋体", Font.PLAIN, 18));
		lbln.setBounds(23, 263, 343, 23);
		add.add(lbln);
		
		JLabel needTime = new JLabel("");
		needTime.setFont(new Font("新宋体", Font.PLAIN, 18));
		needTime.setBounds(424, 192, 72, 18);
		add.add(needTime);
		
		JLabel label_3 = new JLabel("\u5C97\u4F4D\uFF1A");
		label_3.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_3.setBounds(60, 41, 72, 18);
		add.add(label_3);
		
		upostcomboBox = new JComboBox();
		upostcomboBox.setFont(new Font("新宋体", Font.PLAIN, 18));
		upostcomboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5C97\u524D", "\u521D\u7EA7"}));
		upostcomboBox.setBounds(157, 38, 101, 24);
		add.add(upostcomboBox);
		
		JLabel label_2 = new JLabel("  201905260900");
		label_2.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_2.setBounds(146, 301, 203, 18);
		add.add(label_2);
		
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
					return;
				}
			}
			
		});
		cnamecomboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String upost = (String) upostcomboBox.getSelectedItem();
				String cname = (String) cnamecomboBox.getSelectedItem();
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
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cname =  (String) cnamecomboBox.getSelectedItem();
				String upost = (String) upostcomboBox.getSelectedItem();
				String sc_date = sc_dateTextField.getText();
				String cid = "";
				try {
					cid = CourseOperate.getCourseID(cname);
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					System.err.println(new Date());
					System.err.println(e2.getMessage());
				}
				String[] values = {upost,cid,sc_date};
				Object [] options = {"取消","确定"};
				try {
					if(ScheduleOperate.isDelete(values)){
						JOptionPane.showOptionDialog(null, "删除课程成功！", "课程操作", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
					}
					else {
						JOptionPane.showOptionDialog(null, "无该课程，删除失败！", "课程操作", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]); 
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
