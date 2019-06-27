package pers.lasting.management.gui.page;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pers.lasting.management.gui.function.Authentication;
import pers.lasting.management.gui.table.StudyJTable;
import pers.lasting.management.gui.table.model.StudyTableModel;
import pers.lasting.management.gui.tools.SetWindow;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JScrollPane;

public class StudyQueryPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JLabel infoLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudyQueryPage frame = new StudyQueryPage();
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
	public StudyQueryPage() {
		setTitle("\u5B66\u4E60\u60C5\u51B5\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 633, 480);
		SetWindow.setWindowCenter(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setFont(new Font("新宋体", Font.PLAIN, 18));
		label.setBounds(305, 37, 57, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction() ;
			}
		});
		textField.setFont(new Font("新宋体", Font.PLAIN, 18));
		textField.setBounds(364, 34, 122, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setFont(new Font("新宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(500, 33, 82, 27);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane(new StudyJTable(new StudyTableModel("")));
		scrollPane.setBounds(14, 80, 587, 340);
		contentPane.add(scrollPane);
		
		infoLabel = new JLabel("");
		infoLabel.setFont(new Font("幼圆", Font.PLAIN, 14));
		infoLabel.setBounds(14, 42, 235, 18);
		contentPane.add(infoLabel);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonAction();
			}
		});
	}
	private void buttonAction() {
		// TODO Auto-generated method stub

		try {
			String uname = textField.getText();
			String uid = Authentication.getUserIDByName(uname);
			StudyJTable jtable = new StudyJTable(new StudyTableModel(uid));
			scrollPane.setViewportView(jtable);
			infoLabel.setText("当前查询的是"+uname);
			infoLabel.setBounds(14, 42, 235, 18);
			infoLabel.setFont(new Font("幼圆", Font.PLAIN, 14));
			contentPane.add(infoLabel);
			repaint();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}
	}
}
