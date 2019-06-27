package pers.lasting.management.gui.page;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pers.lasting.management.gui.table.UserInformationTable;
import pers.lasting.management.gui.table.UserJTable;
import pers.lasting.management.gui.tools.SetWindow;
import pers.lasting.management.gui.tools.UserIDLegalListener;
import javax.swing.JToolBar;

public class UserManegementPage extends JFrame {

	private JPanel contentPane;
	private JTextField uidTextFieldForSelect;
	private UserJTable oprateTable;
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManegementPage frame = new UserManegementPage();
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
	public UserManegementPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 638, 507);
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
		ShowPanel.setBounds(14, 68, 592, 353);
		contentPane.add(ShowPanel);
		ShowPanel.setLayout(null);
		
		
		
		uidTextFieldForSelect = new JTextField();
		uidTextFieldForSelect.setFont(new Font("新宋体", Font.PLAIN, 18));
		uidTextFieldForSelect.setBounds(372, 28, 105, 24);
		contentPane.add(uidTextFieldForSelect);
		uidTextFieldForSelect.setColumns(10);
		uidTextFieldForSelect.addKeyListener(new UserIDLegalListener(uidTextFieldForSelect));
		uidTextFieldForSelect.enableInputMethods(false);
		
		JLabel lblNewLabel_1 = new JLabel("账号：");
		lblNewLabel_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(320, 31, 69, 18);
		contentPane.add(lblNewLabel_1);
		
		JButton queryButton = new JButton("查询");
		queryButton.setFont(new Font("新宋体", Font.PLAIN, 18));
		queryButton.setBounds(499, 28, 84, 27);
		queryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String uid = uidTextFieldForSelect.getText();
				UserOpreatePage j = new UserOpreatePage(uid);
				j.setVisible(true);
				j.init();
			}
		});
		contentPane.add(queryButton);
		try {
			oprateTable  = new UserJTable(new UserInformationTable());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.err.println(new Date());
			System.err.println(e1.getMessage());
		}finally {
		oprateTable.inti();
		JScrollPane jsp = new JScrollPane();
		jsp.setViewportView(oprateTable);
		jsp.setSize(590, 400);
		ShowPanel.add(jsp);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFont(new Font("等线", Font.PLAIN, 18));
		toolBar.setBounds(0, 0, 125, 35);
		contentPane.add(toolBar);
		
		JButton btnNewButton = new JButton("\u5237\u65B0");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					oprateTable = new UserJTable(new UserInformationTable());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println(new Date());
					System.err.println(e1.getMessage());
				}
				oprateTable.inti();
				jsp.setViewportView(oprateTable);
				repaint();
			}
		});
		btnNewButton.setFont(new Font("等线", Font.PLAIN, 17));
		toolBar.add(btnNewButton);
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					oprateTable = new UserJTable(new UserInformationTable());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println(new Date());
					System.err.println(e1.getMessage());
				}
				oprateTable.inti();
				jsp.setViewportView(oprateTable);
				repaint();
			}
		});
	}
	}
}
