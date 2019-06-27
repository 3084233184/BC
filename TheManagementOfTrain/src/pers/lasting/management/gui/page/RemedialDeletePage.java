package pers.lasting.management.gui.page;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pers.lasting.management.gui.function.Authentication;
import pers.lasting.management.gui.function.CourseOperate;
import pers.lasting.management.gui.function.RemedialOperate;
import pers.lasting.management.gui.function.SubjectOperate;
import pers.lasting.management.gui.tools.SetWindow;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class RemedialDeletePage extends JFrame {

	private JPanel contentPane;
	private JTextField unameTextField;
	private JTextField sc_dateTextField;
	private JTextField remedialTimeTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemedialDeletePage frame = new RemedialDeletePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * ` (`uid`, `cid`, `remedialsc_date`, `remedialtime`, `remedialflag`)
	 */
	public RemedialDeletePage() {
		setTitle("\u7F3A\u52E4\u5220\u9664");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 376, 505);
		SetWindow.setWindowCenter(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u540D\u5B57:");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(81, 49, 72, 18);
		contentPane.add(lblNewLabel);
		
		unameTextField = new JTextField();
		unameTextField.setFont(new Font("新宋体", Font.PLAIN, 18));
		unameTextField.setBounds(158, 44, 117, 24);
		contentPane.add(unameTextField);
		unameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u79D1\u76EE\uFF1A");
		lblNewLabel_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(78, 111, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JComboBox snamecomboBox = new JComboBox();
		snamecomboBox.setFont(new Font("新宋体", Font.PLAIN, 18));
		snamecomboBox.setBounds(160, 103, 117, 24);
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
		
		JLabel lblNewLabel_2 = new JLabel("\u5185\u5BB9\uFF1A");
		lblNewLabel_2.setFont(new Font("新宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(84, 182, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		JComboBox cnamecomboBox = new JComboBox();
		cnamecomboBox.setFont(new Font("新宋体", Font.PLAIN, 18));
		cnamecomboBox.setBounds(160, 182, 117, 24);
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
		
		JLabel lblNewLabel_3 = new JLabel("\u7F3A\u52E4\u65F6\u95F4\uFF1A");
		lblNewLabel_3.setFont(new Font("新宋体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(52, 252, 93, 18);
		contentPane.add(lblNewLabel_3);
		
		sc_dateTextField = new JTextField();
		sc_dateTextField.setFont(new Font("新宋体", Font.PLAIN, 18));
		sc_dateTextField.setBounds(158, 252, 117, 24);
		sc_dateTextField.enableInputMethods(false);
		sc_dateTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			if(e.getKeyChar()<48||e.getKeyChar()>57)
				e.consume();
			}
		});
		contentPane.add(sc_dateTextField);
		sc_dateTextField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u7F3A\u52E4\u65F6\u957F\uFF1A");
		lblNewLabel_4.setFont(new Font("新宋体", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(52, 324, 95, 18);
		contentPane.add(lblNewLabel_4);
		
		remedialTimeTextField = new JTextField();
		remedialTimeTextField.setFont(new Font("新宋体", Font.PLAIN, 18));
		remedialTimeTextField.setBounds(159, 321, 117, 24);
		remedialTimeTextField.enableInputMethods(false);
		remedialTimeTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			if(e.getKeyChar()<48||e.getKeyChar()>57)
				e.consume();
			}
		});
		contentPane.add(remedialTimeTextField);
		remedialTimeTextField.setColumns(10);
		
		JButton button = new JButton("\u5220\u9664\u7F3A\u52E4");
		button.setFont(new Font("新宋体", Font.PLAIN, 18));
		button.setBounds(117, 389, 113, 27);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
				String sc_date = sc_dateTextField.getText();
				if(sc_date.length()!=12) {
					Object[] options = { "确认", "取消" }; 
					JOptionPane.showOptionDialog(null, "日期格式不合法！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
					return;
				}
				String remedialTime = remedialTimeTextField.getText();
				String uname = unameTextField.getText();
				String cname = (String) cnamecomboBox.getSelectedItem();
				String uid = Authentication.getUserIDByName(uname);
				System.err.println("uid="+uid);
				if(uid==null) {
					Object[] options = { "确认"}; 
					JOptionPane.showOptionDialog(null, "未找到此人！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]); 
					return;
				}
				String cid = CourseOperate.getCourseID(cname);
				String[] values = {uid,cid,sc_date,remedialTime};
				
				if(RemedialOperate.isDelete(values)) {
					Object[] options = { "确认"}; 
					JOptionPane.showOptionDialog(null, "删除成功！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]); 
				}
				else {
					Object[] options = { "确认"}; 
					JOptionPane.showOptionDialog(null, "删除失败！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
				}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println(new Date());
					System.err.println(e1.getMessage());
				}
				
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
					return;
				}
			}
			
		});
		contentPane.add(button);
	}
}
