package pers.lasting.management.gui.page;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pers.lasting.management.gui.function.Authentication;
import pers.lasting.management.gui.tools.SetWindow;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import java.awt.Toolkit;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JPasswordField;

public class EnterPage extends JFrame {

	private JPanel contentPane;
	private JTextField userIDText;
	private JPasswordField pwdText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterPage frame = new EnterPage();
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
	public EnterPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EnterPage.class.getResource("/pers/lasting/management/image/enter_background.jpg")));
		setTitle("训练管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u767B\u5F55\u540D\uFF1A");
		label.setFont(new Font("新宋体", Font.PLAIN, 18));
		label.setBounds(59, 95, 75, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_1.setBounds(60, 142, 72, 18);
		contentPane.add(label_1);
		
		JButton registerButton = new JButton("注册");
		registerButton.setFont(new Font("新宋体", Font.PLAIN, 18));
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterPage().setVisible(true);
			}
		});
		registerButton.setBounds(134, 184, 72, 27);
		contentPane.add(registerButton);
		
		JButton enterButton = new JButton("登陆");
		enterButton.setFont(new Font("新宋体", Font.PLAIN, 18));
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterButtonAction();
			}
		});
		enterButton.setBounds(273, 184, 72, 27);
		SetWindow.setWindowCenter(this);
		contentPane.add(enterButton);
		
		userIDText = new JTextField();
		userIDText.setFont(new Font("新宋体", Font.PLAIN, 18));
		userIDText.setBounds(134, 92, 211, 24);
		userIDText.enableInputMethods(false); 
		contentPane.add(userIDText);
		userIDText.setColumns(10);
		
		JLabel label_2 = new JLabel("训练管理系统");
		label_2.setFont(new Font("书体坊米芾体", Font.PLAIN, 39));
		label_2.setBounds(110, 13, 308, 61);
		contentPane.add(label_2);
		
		pwdText = new JPasswordField();
		pwdText.setFont(new Font("新宋体", Font.PLAIN, 18));
		pwdText.setBounds(134, 139, 211, 24);
		contentPane.add(pwdText);
		pwdText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				enterButtonAction();
			}
		});
	}
	private void enterButtonAction() {
		String uid = userIDText.getText();
		String upassword = pwdText.getText();
		try {
			if(Authentication.isCorrespond(uid, upassword)){
				dispose();
				switch (Authentication.userModel(uid)) {
				case "副管理员":
					Object[] options = { "管理模式", "学员模式" }; 
					int i = JOptionPane.showOptionDialog(null, "请选择！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
					switch(i) {
					case 0:
						new ManagerIndexPage(uid).setVisible(true);
						break;
					case 1:
					case -1:
					default:
						new StudentIndexPage(uid).setVisible(true);
					}
					break;
				case "管理员":
					new ManagerIndexPage(uid).setVisible(true);
					break;
				case "学员":
					new StudentIndexPage(uid).setVisible(true);
					break;
				default :
					break;
				}
			}
			else {
			Object[] options = { "确认", "取消" }; 
			JOptionPane.showOptionDialog(null, "密码或账号错误！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			System.err.println(new Date());
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}
	}
}
