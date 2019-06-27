package pers.lasting.management.gui.page;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pers.lasting.management.gui.table.RemedialTable;
import pers.lasting.management.gui.table.ScheduleJTable;
import pers.lasting.management.gui.table.StudyJTable;
import pers.lasting.management.gui.table.model.RemedialTableModel;
import pers.lasting.management.gui.table.model.ScheduleTableModel;
import pers.lasting.management.gui.table.model.StudyTableModel;
import pers.lasting.management.gui.tools.BuildString;
import pers.lasting.management.gui.tools.SetWindow;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.function.Consumer;

import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StudentIndexPage extends JFrame {

	private JPanel contentPane;
	private JTextField sc_dateTextField;
	private ScheduleJTable opreateTable;
	private JScrollPane jsp;
	private String uid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentIndexPage frame = new StudentIndexPage("1120259135");
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
	public StudentIndexPage(String uid1) {
		setTitle("\u8BAD\u7EC3\u7BA1\u7406\u7CFB\u7EDF");
		this.uid = uid1;
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentIndexPage.class.getResource("/pers/lasting/management/image/enter_background.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 535);
		SetWindow.setWindowCenter(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 594, 41);
		contentPane.add(toolBar);
		
		JButton scheduleSwitchButton = new JButton("\u8BFE\u8868\u67E5\u8BE2");
		scheduleSwitchButton.setFont(new Font("等线", Font.PLAIN, 17));
		toolBar.add(scheduleSwitchButton);
		
		JButton remedialSwitchButton = new JButton("\u7F3A\u52E4\u60C5\u51B5\u67E5\u8BE2");
		remedialSwitchButton.setFont(new Font("等线", Font.PLAIN, 17));
		toolBar.add(remedialSwitchButton);
		
		JButton StudySwitchButton = new JButton("\u5B66\u4E60\u60C5\u51B5\u67E5\u8BE2");
		StudySwitchButton.setFont(new Font("等线", Font.PLAIN, 17));
		toolBar.add(StudySwitchButton);
		
		JPanel showPanel = new JPanel();
		showPanel.setBounds(14, 54, 589, 421);
		contentPane.add(showPanel);
		final CardLayout showPanelLayout = new CardLayout(0, 0);
		showPanel.setLayout(showPanelLayout);
		
		JPanel scheduleQuery = new JPanel();
		showPanel.add(scheduleQuery, "课表查询");
		scheduleQuery.setLayout(null);
		
		JLabel label = new JLabel("\u65E5\u671F\uFF1A");
		label.setFont(new Font("新宋体", Font.PLAIN, 18));
		label.setBounds(25, 30, 58, 18);
		scheduleQuery.add(label);
		
		sc_dateTextField = new JTextField();
		sc_dateTextField.setFont(new Font("新宋体", Font.PLAIN, 18));
		sc_dateTextField.setBounds(81, 27, 122, 24);
		sc_dateTextField.enableInputMethods(false);
		scheduleQuery.add(sc_dateTextField);
		sc_dateTextField.setColumns(10);
		sc_dateTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			if(e.getKeyChar()<48||e.getKeyChar()>57)
				e.consume();
			}
		});
		
		JButton selectButton = new JButton("\u67E5\u8BE2");
		selectButton.setFont(new Font("新宋体", Font.PLAIN, 18));
		selectButton.setBounds(221, 26, 73, 27);
		scheduleQuery.add(selectButton);
		
		jsp = new JScrollPane();
		jsp.setBounds(14, 85, 561, 323);
		opreateTable = new ScheduleJTable(new ScheduleTableModel(uid));
		jsp.setViewportView(opreateTable);
		scheduleQuery.add(jsp);
		
		JPanel remedialQuery = new JPanel();
		showPanel.add(remedialQuery, "缺勤情况查询");
		remedialQuery.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(new RemedialTable(new RemedialTableModel(uid)));
		scrollPane.setBounds(14, 49, 561, 359);
		remedialQuery.add(scrollPane);
		
		JPanel studyPanel = new JPanel();
		showPanel.add(studyPanel, "学习情况查询");
		studyPanel.setLayout(null);
		
		JScrollPane studyScrollPane = new JScrollPane(new StudyJTable(new StudyTableModel(uid)));
		studyScrollPane.setBounds(14, 47, 561, 361);
		StudyJTable studyJtable = new StudyJTable(new StudyTableModel(uid));
		studyScrollPane.setViewportView(studyJtable);
		studyPanel.add(studyScrollPane);
		String helloString = BuildString.buildHello(uid);
		
		
		JLabel hello1 = new JLabel(helloString);
		hello1.setBounds(339, 0, 313, 36);
		hello1.setFont(new Font("等线 Light", Font.PLAIN, 17));
		studyPanel.add(hello1);
		
		JLabel hello2 = new JLabel(helloString);
		hello2.setBounds(339, 0, 313, 36);
		hello2.setFont(new Font("等线 Light", Font.PLAIN, 17));
		scheduleQuery.add(hello2);
		
		JLabel hello3 = new JLabel(helloString);
		hello3.setBounds(339, 0, 313, 36);
		hello3.setFont(new Font("等线 Light", Font.PLAIN, 17));
		remedialQuery.add(hello3);
		
		BuildString bs = new BuildString(hello1, hello2, hello3,uid);
		Thread t = new Thread(bs, "问候语");
		t.start();
		
		sc_dateTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectAction(e);
			}
		});
		selectButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			selectAction(e);
			}
		});
		scheduleSwitchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showPanelLayout.show(showPanel, "课表查询");
			}
		});
		remedialSwitchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showPanelLayout.show(showPanel, "缺勤情况查询");
			}
		});
		StudySwitchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showPanelLayout.show(showPanel, "学习情况查询");
			}
		});
	}
	private boolean selectAction(ActionEvent e) {
		String sc_date = sc_dateTextField.getText();
		if(sc_date.length()!=8) {
			Object[] options = { "确认", "取消" }; 
			JOptionPane.showOptionDialog(null, "日期格式不合法！", "警告", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
			return false;
		}
		else {
			opreateTable = new ScheduleJTable(new ScheduleTableModel(uid,sc_date));
			jsp.setViewportView(opreateTable);
			repaint();
			return true;
		}
	}
}
