package pers.lasting.management.gui.page;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pers.lasting.management.gui.function.Authentication;
import pers.lasting.management.gui.table.RemedialTable;
import pers.lasting.management.gui.table.model.RemedialTableModel;
import pers.lasting.management.gui.tools.SetWindow;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.UID;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RemedialQueryPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private RemedialTable remedialTable;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemedialQueryPage frame = new RemedialQueryPage();
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
	public RemedialQueryPage() {
		setTitle("\u7F3A\u52E4\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 447);
		SetWindow.setWindowCenter(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setFont(new Font("等线 Light", Font.PLAIN, 17));
		label.setBounds(284, 40, 61, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPer();
			}
		});
		textField.setFont(new Font("等线 Light", Font.PLAIN, 17));
		textField.setBounds(344, 37, 119, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5 \u8BE2");
		btnNewButton.setFont(new Font("等线 Light", Font.PLAIN, 17));
		btnNewButton.setBounds(477, 36, 81, 27);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		remedialTable = new RemedialTable(new RemedialTableModel(""));
		scrollPane.setViewportView(remedialTable);
		scrollPane.setBounds(14, 75, 544, 312);
		contentPane.add(scrollPane);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actionPer();
			}
		});
	}
	private void actionPer() {
		// TODO Auto-generated method stub
		String uid = "";
		try {
			uid = Authentication.getUserIDByName(textField.getText());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}
		remedialTable = new RemedialTable(new RemedialTableModel(uid));
		scrollPane.setViewportView(remedialTable);
		repaint();
	}
}
