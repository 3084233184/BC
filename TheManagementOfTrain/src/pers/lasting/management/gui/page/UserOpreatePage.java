package pers.lasting.management.gui.page;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import pers.lasting.management.gui.function.Authentication;
import pers.lasting.management.gui.tools.SetWindow;

public class UserOpreatePage extends JFrame {

	private JPanel contentPane;
	private JTextField unametextField;
	private JTextField passwordTextField;
	private JComboBox umodelComboBoxForUpdate;
	private JComboBox upostComboBoxForUpdate;
	private final String UserID;
	private JTextField uidtextField;
	private JTextField uphonetextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserOpreatePage frame = new UserOpreatePage("");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserOpreatePage(String uid) {
		UserID = uid;
		setTitle("用户信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 400);
		SetWindow.setWindowCenter(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel ShowPanel = new JPanel();
		ShowPanel.setBounds(10, 10, 333, 356);
		contentPane.add(ShowPanel);
		ShowPanel.setLayout(null);
		
		JPanel UserForUpdatePanel = new JPanel();
		UserForUpdatePanel.setBounds(0, 0, 333, 356);
		ShowPanel.add(UserForUpdatePanel);
		UserForUpdatePanel.setLayout(null);
		
		JLabel unameLabelForUpdate = new JLabel("\u59D3\u540D:");
		unameLabelForUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		unameLabelForUpdate.setBounds(65, 84, 57, 15);
		UserForUpdatePanel.add(unameLabelForUpdate);
		
		unametextField = new JTextField();
		unametextField.setFont(new Font("新宋体", Font.PLAIN, 18));
		unametextField.setBounds(115, 81, 117, 21);
		UserForUpdatePanel.add(unametextField);
		unametextField.setColumns(10);
		
		JLabel upasswordLabelForUpdate = new JLabel("\u5BC6\u7801:");
		upasswordLabelForUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		upasswordLabelForUpdate.setBounds(65, 120, 73, 15);
		UserForUpdatePanel.add(upasswordLabelForUpdate);
		
		JLabel uomdelLabelForUpdate = new JLabel("\u5C97\u4F4D:");
		uomdelLabelForUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		uomdelLabelForUpdate.setBounds(65, 165, 73, 15);
		UserForUpdatePanel.add(uomdelLabelForUpdate);
		
		JLabel upostLabelForUpdate = new JLabel("\u7BA1\u7406\u6743\u9650:");
		upostLabelForUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		upostLabelForUpdate.setBounds(31, 249, 87, 15);
		UserForUpdatePanel.add(upostLabelForUpdate);
		
		JButton UpdateButtonForUpdateManager = new JButton("\u4FDD\u5B58");
		UpdateButtonForUpdateManager.setFont(new Font("新宋体", Font.PLAIN, 18));
		UpdateButtonForUpdateManager.setBounds(31, 288, 93, 23);
		UpdateButtonForUpdateManager.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String uid = uidtextField.getText();
				String uname = unametextField.getText();
				String upassword = passwordTextField.getText();
				String upost = (String) upostComboBoxForUpdate.getSelectedItem();
				String umodel = (String) umodelComboBoxForUpdate.getSelectedItem();
				String uphone = uphonetextField.getText();
				String[] values = {uname,umodel,upassword,upost,uphone};
				
//			String sql = "UPDATE UserInformation SET sname='"+values[i++]+"',umodel='"+values[i++]+"',upassword='"+values[i++]+"', upost='"+values[i++]+"' WHERE uid='"+uid+"'";
			try {
				if(Authentication.isUpdate(values, uid)){
					dispose();
					Object[] options = { "确认", "取消" }; 
					JOptionPane.showOptionDialog(null, "保存用户信息成功！", "提示", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
				}
				else {
					Object[] options = { "确认", "取消" }; 
					JOptionPane.showOptionDialog(null, "保存用户信息失败！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				System.err.println(new Date());
				System.err.println(e1.getMessage());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.err.println(new Date());
				System.err.println(e1.getMessage());
			}
			}
		});
		UserForUpdatePanel.add(UpdateButtonForUpdateManager);
		
		upostComboBoxForUpdate = new JComboBox();
		upostComboBoxForUpdate.setModel(new DefaultComboBoxModel(new String[] {"\u5C97\u524D", "\u521D\u7EA7"}));
		upostComboBoxForUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		upostComboBoxForUpdate.setBounds(115, 162, 104, 21);
		UserForUpdatePanel.add(upostComboBoxForUpdate);
		
		umodelComboBoxForUpdate = new JComboBox();
		umodelComboBoxForUpdate.setModel(new DefaultComboBoxModel(new String[] {"\u526F\u7BA1\u7406\u5458", "\u5B66\u5458"}));
		umodelComboBoxForUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		umodelComboBoxForUpdate.setBounds(128, 246, 104, 21);
		UserForUpdatePanel.add(umodelComboBoxForUpdate);
		
		JButton deleteButton = new JButton("\u5220\u9664");
		deleteButton.setFont(new Font("新宋体", Font.PLAIN, 18));
		deleteButton.setBounds(181, 288, 93, 23);
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(Authentication.isDelete(uid)) {
						Object[] options = { "确认", "取消" }; 
						JOptionPane.showOptionDialog(null, "删除用户成功！", "提示", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
					}
					else {
						Object[] options = { "确认", "取消" }; 
						JOptionPane.showOptionDialog(null, "删除用户失败！", "提示", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					System.err.println(new Date());
					System.err.println(e1.getMessage());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println(new Date());
					System.err.println(e1.getMessage());
				}
			}
		});
		UserForUpdatePanel.add(deleteButton);
		
		JLabel label = new JLabel("\u8D26\u53F7\uFF1A");
		label.setFont(new Font("新宋体", Font.PLAIN, 18));
		label.setBounds(65, 42, 73, 15);
		UserForUpdatePanel.add(label);
			
		passwordTextField = new JTextField();
		passwordTextField.setFont(new Font("新宋体", Font.PLAIN, 18));
		passwordTextField.setBounds(115, 119, 117, 21);
		UserForUpdatePanel.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		uidtextField = new JTextField();
		uidtextField.setFont(new Font("新宋体", Font.PLAIN, 18));
		uidtextField.setBounds(115, 41, 117, 21);
		UserForUpdatePanel.add(uidtextField);
		uidtextField.setEditable(false);
		uidtextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		label_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_1.setBounds(50, 208, 72, 18);
		UserForUpdatePanel.add(label_1);
		
		uphonetextField = new JTextField();
		uphonetextField.setBounds(115, 205, 117, 24);
		UserForUpdatePanel.add(uphonetextField);
		uphonetextField.setColumns(10);
	}
	
	/***
	 * String[]columnNames = {"uid","uname","upassword","upost","umodel"};
	 */
	 void init() {
		// TODO Auto-generated method stub
		try {
			String[] values= Authentication.getUserInformationArray(UserID);
			for (String value:values) {
				System.err.println(value);
			}
			uidtextField.setText(UserID);
			int i = values.length-1;
			uphonetextField.setText(values[i--]);
			umodelComboBoxForUpdate.setSelectedItem(values[i--]);
			upostComboBoxForUpdate.setSelectedItem(values[i--]);
			passwordTextField.setText(values[i--]);
			unametextField.setText(values[i--]);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			Object[] options = { "确认", "取消" }; 
			JOptionPane.showOptionDialog(null, "初始化信息失败，可能是未找到该用户！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
		}
	}
}
