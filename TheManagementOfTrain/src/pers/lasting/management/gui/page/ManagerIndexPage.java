package pers.lasting.management.gui.page;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pers.lasting.management.gui.tools.BuildString;
import pers.lasting.management.gui.tools.SetWindow;

import javax.swing.JToolBar;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.awt.Toolkit;

public class ManagerIndexPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerIndexPage frame = new ManagerIndexPage("1120259135");
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
	public ManagerIndexPage(String uid) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManagerIndexPage.class.getResource("/pers/lasting/management/image/enter_background.jpg")));
		setTitle("\u8BAD\u7EC3\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 461);
		SetWindow.setWindowCenter(this);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 131, 26);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u529F\u80FD");
		mnNewMenu.setFont(new Font("新宋体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem.setFont(new Font("新宋体", Font.PLAIN, 18));
		mnNewMenu.add(menuItem);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 70, 752, 319);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(1, 0, 250, 319);
		panel_1.add(panel);
		
		JButton userManage = new JButton("");
		userManage.setVerticalAlignment(SwingConstants.TOP);
		userManage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				---------------------------------------------------用户管理界面
				new UserManegementPage().setVisible(true);
			}
		});
		userManage.setIcon(new ImageIcon(ManagerIndexPage.class.getResource("/pers/lasting/management/image/user.jpg")));

		userManage.setFocusPainted(false);
		userManage.setBorderPainted(false);
		panel.add(userManage);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(251, 0, 250, 319);
		panel_1.add(panel_2);
		
		JButton subjectAndCourse = new JButton("");
		subjectAndCourse.setIcon(new ImageIcon(ManagerIndexPage.class.getResource("/pers/lasting/management/image/subjectCourse.jpg")));
		subjectAndCourse.setFocusPainted(false);
		subjectAndCourse.setBorderPainted(false);
		subjectAndCourse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SubjectAndCoursePage().setVisible(true);			}
		});
		panel_2.add(subjectAndCourse);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(501, 0, 250, 319);
		panel_1.add(panel_3);
		
		JButton attendancePage = new JButton("");
		attendancePage.setIcon(new ImageIcon(ManagerIndexPage.class.getResource("/pers/lasting/management/image/attdence.jpg")));
		attendancePage.setFocusPainted(false);
		attendancePage.setBorderPainted(false);
		attendancePage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new AttendancePage().setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println(new Date());
					System.err.println(e1.getMessage());
				}
			}
		});
		panel_3.add(attendancePage);
		JLabel welcomeString = new JLabel(BuildString.buildHello(uid));
		welcomeString.setFont(new Font("等线 Light", Font.PLAIN, 17));
		welcomeString.setBounds(503, 21, 313, 36);
		contentPane.add(welcomeString);
		BuildString bs = new BuildString(welcomeString,uid);
		Thread t = new Thread(bs, "问候语");
		t.start();
	}
}
