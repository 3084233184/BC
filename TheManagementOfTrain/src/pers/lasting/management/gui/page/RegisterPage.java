package pers.lasting.management.gui.page;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pers.lasting.management.database.operation.UserInformationOperation;
import pers.lasting.management.gui.function.Authentication;
import pers.lasting.management.gui.function.CheckString;
import pers.lasting.management.gui.function.RightString;
import pers.lasting.management.gui.tools.BuildString;
import pers.lasting.management.gui.tools.SetWindow;
import pers.lasting.management.gui.tools.UserIDLegalListener;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.TextField;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegisterPage extends JFrame {

	private JPanel contentPane;
	private JTextField userIDText;
	private JTextField telText;
	private JPasswordField pwdText;
	private JPasswordField pwdConfirmText;
	private JTextField userNameText;
	private JComboBox upostComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
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
	public RegisterPage() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterPage.class.getResource("/pers/lasting/management/image/enter_background.jpg")));
		setFont(new Font("新宋体", Font.PLAIN, 16));
		setTitle("\u6CE8\u518C");
		setSize(432,490);
		SetWindow.setWindowCenter(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u6309\u63D0\u793A\u8F93\u5165\u4FE1\u606F\uFF1A");
		label.setFont(new Font("新宋体", Font.PLAIN, 18));
		label.setBounds(60, 13, 219, 18);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 58, 338, 336);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 0, 0);
		panel.add(separator);
		
		JLabel lblNewLabel = new JLabel("用户名：");
		lblNewLabel.setBounds(15, 2, 72, 21);
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		userIDText = new JTextField();
		userIDText.setBounds(101, 0, 224, 26);
		userIDText.setFont(new Font("新宋体", Font.PLAIN, 18));
		panel.add(userIDText);
		userIDText.setColumns(10);
		userIDText.enableInputMethods(false);
		userIDText.addKeyListener(new UserIDLegalListener(userIDText));
		
		JLabel label_2 = new JLabel("\u7528\u6237\u540D\u53EA\u80FD\u7531\u5B57\u6BCD\u6570\u5B57\u6784\u6210");
		label_2.setFont(new Font("新宋体", Font.PLAIN, 15));
		label_2.setBounds(123, 33, 180, 18);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("姓   名：");
		label_3.setBounds(15, 61, 81, 21);
		label_3.setFont(new Font("新宋体", Font.PLAIN, 18));
		panel.add(label_3);
		
		userNameText = new JTextField();
		userNameText.setBounds(101, 58, 224, 27);
		userNameText.setFont(new Font("新宋体", Font.PLAIN, 18));
		panel.add(userNameText);
		userNameText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("密码：");
		lblNewLabel_1.setBounds(24, 125, 54, 21);
		lblNewLabel_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);
		
		pwdText = new JPasswordField();
		pwdText.setBounds(101, 122, 224, 27);
		pwdText.setFont(new Font("新宋体", Font.PLAIN, 18));
		pwdText.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		panel.add(pwdText);
		
		JLabel lblNewLabel_4 = new JLabel("确认密码：");
		lblNewLabel_4.setBounds(6, 181, 90, 21);
		lblNewLabel_4.setFont(new Font("新宋体", Font.PLAIN, 18));
		panel.add(lblNewLabel_4);
		pwdConfirmText = new JPasswordField();
		pwdConfirmText.setBounds(101, 178, 224, 27);
		pwdConfirmText.setFont(new Font("新宋体", Font.PLAIN, 18));
		pwdConfirmText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			CheckString.textTrim(pwdConfirmText);
			}
		});
		panel.add(pwdConfirmText);
		
		JLabel lblNewLabel_2 = new JLabel("手机号：");
		lblNewLabel_2.setBounds(15, 242, 72, 27);
		lblNewLabel_2.setFont(new Font("新宋体", Font.PLAIN, 18));
		panel.add(lblNewLabel_2);
		
		telText = new JTextField();
		telText.setBounds(101, 242, 224, 27);
		telText.setFont(new Font("新宋体", Font.PLAIN, 18));
		telText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				telText.setText(RightString.rightTel(telText.getText()));
			}
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				telText.setText(RightString.rightTel(telText.getText()));
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				telText.setText(RightString.rightTel(telText.getText()));
			}
		});
		panel.add(telText);
		telText.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("岗  位：");
		lblNewLabel_3.setBounds(15, 302, 72, 21);
		lblNewLabel_3.setFont(new Font("新宋体", Font.PLAIN, 18));
		panel.add(lblNewLabel_3);
		
		upostComboBox = new JComboBox();
		upostComboBox.setFont(new Font("新宋体", Font.PLAIN, 18));
		upostComboBox.setModel(new DefaultComboBoxModel(new String[] {"岗前", "初级"}));
		upostComboBox.setBounds(101, 302, 90, 24);
		panel.add(upostComboBox);
		
		JButton resetButton = new JButton("重置");
		resetButton.setFont(new Font("新宋体", Font.PLAIN, 18));
		resetButton.setBounds(60, 404, 113, 27);
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				userIDText.setText("");
				telText.setText("");
				pwdText.setText("");
				pwdConfirmText.setText("");
			}
		});
		contentPane.add(resetButton);	
		JButton submitButton = new JButton("提交");
		submitButton.setFont(new Font("新宋体", Font.PLAIN, 18));
		submitButton.setBounds(249, 404, 113, 27);
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				-------------------------------------------------------------这需要写一个方法  插入新用户
//				submitButtonAction();
//				dispose();
				submitButtonAction();
			}
		});
		contentPane.add(submitButton);
	}

	private void submitButtonAction() {
		// TODO Auto-generated method stub
		String uid = userIDText.getText();
		String upassword1 = pwdText.getText();
		String upassword2 = pwdConfirmText.getText();
		String uname = userNameText.getText();
		String telephone = telText.getText();
		String upost = (String)upostComboBox.getSelectedItem();
		String token = BuildString.buildToken(32);
		String umodel = "学员";
		String [] values  = {uid,upassword2,uname,token,umodel,telephone,upost};
		
		
		if(upassword1.equals(upassword2)){
			try {
				if(Authentication.isAdd(values)) {
					dispose();
				}
				else {
					Object[] options = { "确认", "取消" }; 
					JOptionPane.showOptionDialog(null, "注册失败，请联系管理员！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
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
		else {
		Object[] options = { "确认", "取消" }; 
		JOptionPane.showOptionDialog(null, "两次密码不一致！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
		}
	}
}
