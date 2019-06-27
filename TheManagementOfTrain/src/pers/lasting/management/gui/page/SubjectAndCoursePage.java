package pers.lasting.management.gui.page;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import pers.lasting.management.gui.function.CourseOperate;
import pers.lasting.management.gui.function.SubjectOperate;
import pers.lasting.management.gui.tools.SetWindow;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import javax.swing.JSeparator;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class SubjectAndCoursePage extends JFrame {

	private JPanel contentPane;
	private JTextField sidTextForAdd_1;
	private JTextField cidTextForAdd;
	private JTextField cnameTextForAdd;
	private JTextField ctimeTextForAdd;
	private JTextField sidTextForAdd;
	private JTextField snameTextForAdd;
	private JTextField getsidTextForDelete;
	private JTextField sidTextForDelete;
	private JTextField snameTextForDelete;
	private JTextField stimeTextForDelete;
	private JTextField getcidTextForDelete;
	private JTextField cidTextForDelete;
	private JTextField cnameTextForDelete;
	private JTextField ctimeTextForDelete;
	private JTextField sidTextForCourseDelete;
	private JTextField getSidTextForSelect;
	private JTextField stimeTextForSelect;
	private JTextField snameTextForSelect;
	private JTextField sidTextForSelect_1;
	private JTextField getCidTextForSelect;
	private JTextField cidTextForSelect;
	private JTextField cnameTextForSelect;
	private JTextField ctimeTextForSelect;
	private JTextField sidTextForSelect;
	private JTextField getsidTextForUpdate;
	private JTextField sidTextForUpdate;
	private JTextField snameTextForUpdate;
	private JTextField stimeTextForUpdate;
	private JTextField getcidTextForUpdate;
	private JTextField cidTextForUpdate;
	private JTextField cnameTextForUpdate;
	private JTextField ctimeTextForUpdate;
	private JTextField sidTextForCourseUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubjectAndCoursePage frame = new SubjectAndCoursePage();
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
	public SubjectAndCoursePage() {
		setTitle("\u6DFB\u52A0\u79D1\u76EE\u5185\u5BB9");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SubjectAndCoursePage.class.getResource("/pers/lasting/management/image/enter_background.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 456, 533);
		SetWindow.setWindowCenter(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u6309\u63D0\u793A\u8F93\u5165\u4FE1\u606F\uFF1A");
		label.setBounds(22, 63, 162, 21);
		contentPane.add(label);
		label.setFont(new Font("新宋体", Font.PLAIN, 18));
		
		final JPanel ShowPanel = new JPanel();
		ShowPanel.setBounds(14, 115, 420, 339);
		contentPane.add(ShowPanel);
		final CardLayout showPanelLayout= new CardLayout(0, 0);
		ShowPanel.setLayout(showPanelLayout);
		
		JPanel addSubject = new JPanel();
		ShowPanel.add(addSubject, "添加科目");
		addSubject.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("\u79D1\u76EE\u7F16\u53F7\uFF1A");
		lblNewLabel_4.setBounds(60, 63, 90, 21);
		lblNewLabel_4.setFont(new Font("新宋体", Font.PLAIN, 18));
		addSubject.add(lblNewLabel_4);
		
		sidTextForAdd = new JTextField();
		sidTextForAdd.setBounds(185, 60, 164, 27);
		sidTextForAdd.setFont(new Font("新宋体", Font.PLAIN, 18));
		sidTextForAdd.enableInputMethods(false);
		addSubject.add(sidTextForAdd);
		sidTextForAdd.setColumns(15);
		
		JLabel lblNewLabel_5 = new JLabel("\u79D1\u76EE\u540D\u79F0\uFF1A");
		lblNewLabel_5.setBounds(60, 160, 90, 21);
		lblNewLabel_5.setFont(new Font("新宋体", Font.PLAIN, 18));
		addSubject.add(lblNewLabel_5);
		
		snameTextForAdd = new JTextField();
		snameTextForAdd.setBounds(185, 157, 164, 27);
		snameTextForAdd.setFont(new Font("新宋体", Font.PLAIN, 18));
		addSubject.add(snameTextForAdd);
		snameTextForAdd.setColumns(10);
		
		JButton addSubjectButton = new JButton("添加科目");
		addSubjectButton.setFont(new Font("新宋体", Font.PLAIN, 18));
		addSubjectButton.setFocusPainted(false);
		addSubjectButton.setBounds(236, 253, 113, 27);
		addSubjectButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addSubjectAction();
			}
		});
		addSubject.add(addSubjectButton);
		
		
		JButton resetAddButton = new JButton("重置");
		resetAddButton.setFont(new Font("新宋体", Font.PLAIN, 18));
		resetAddButton.setFocusPainted(false);
		resetAddButton.setBounds(61, 253, 113, 27);
		resetAddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				snameTextForAdd.setText("");
				sidTextForAdd.setText("");
			}
		});
		addSubject.add(resetAddButton);
		
		JPanel addCourse = new JPanel();
		ShowPanel.add(addCourse, "添加内容");
		addCourse.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("所属科目编号：");
		lblNewLabel.setBounds(20, 16, 126, 21);
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 18));
		addCourse.add(lblNewLabel);
		
		sidTextForAdd_1 = new JTextField();
		sidTextForAdd_1.setBounds(191, 13, 184, 27);
		sidTextForAdd_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		sidTextForAdd_1.enableInputMethods(false);
		addCourse.add(sidTextForAdd_1);
		sidTextForAdd_1.setColumns(15);
		
		JLabel lblNewLabel_1 = new JLabel("\u5185\u5BB9\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setBounds(57, 78, 124, 21);
		lblNewLabel_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		addCourse.add(lblNewLabel_1);
		
		cidTextForAdd = new JTextField();
		cidTextForAdd.setBounds(191, 75, 184, 27);
		cidTextForAdd.setFont(new Font("新宋体", Font.PLAIN, 18));
		cidTextForAdd.enableInputMethods(false);
		addCourse.add(cidTextForAdd);
		cidTextForAdd.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel(" \u5185\u5BB9\u540D\u79F0\uFF1A");
		lblNewLabel_2.setBounds(48, 140, 101, 21);
		lblNewLabel_2.setFont(new Font("新宋体", Font.PLAIN, 18));
		addCourse.add(lblNewLabel_2);
		
		cnameTextForAdd = new JTextField();
		cnameTextForAdd.setBounds(191, 137, 184, 27);
		cnameTextForAdd.setFont(new Font("新宋体", Font.PLAIN, 18));
		addCourse.add(cnameTextForAdd);
		cnameTextForAdd.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel(" \u5185\u5BB9\u65F6\u957F\uFF1A");
		lblNewLabel_3.setBounds(48, 202, 109, 21);
		lblNewLabel_3.setFont(new Font("新宋体", Font.PLAIN, 18));
		addCourse.add(lblNewLabel_3);
		
		ctimeTextForAdd = new JTextField();
		ctimeTextForAdd.setBounds(191, 199, 184, 27);
		ctimeTextForAdd.setFont(new Font("新宋体", Font.PLAIN, 18));
		ctimeTextForAdd.enableInputMethods(false);
		addCourse.add(ctimeTextForAdd);
		ctimeTextForAdd.setColumns(10);
		
		JButton button_3 = new JButton("添加内容");
		button_3.setFont(new Font("新宋体", Font.PLAIN, 18));
		button_3.setFocusPainted(false);
		button_3.setBounds(240, 280, 113, 27);
		button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addCourseAction();
			}
		});
		addCourse.add(button_3);
		
		JButton button_4 = new JButton("重置");
		button_4.setFont(new Font("新宋体", Font.PLAIN, 18));
		button_4.setFocusPainted(false);
		button_4.setBounds(62, 280, 113, 27);
		button_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sidTextForAdd_1.setText("");
				cidTextForAdd.setText("");
				cnameTextForAdd.setText("");
				ctimeTextForAdd.setText("");
			}
		});
		addCourse.add(button_4);
		
		JPanel updateSubject = new JPanel();
		ShowPanel.add(updateSubject, "修改科目");
		updateSubject.setLayout(null);
		
		JButton submitButtonForUpdate = new JButton("\u4FEE\u6539\u79D1\u76EE");
		submitButtonForUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		submitButtonForUpdate.setFocusPainted(false);
		submitButtonForUpdate.setBounds(243, 286, 113, 27);
		submitButtonForUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateSubjectAction();
			}
		});
		updateSubject.add(submitButtonForUpdate);
		
		JButton resetButtonForUpdate = new JButton("\u91CD\u7F6E");
		resetButtonForUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		resetButtonForUpdate.setFocusPainted(false);
		resetButtonForUpdate.setBounds(67, 286, 113, 27);
		resetButtonForUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getsidTextForUpdate.setText("");
				getsidTextForUpdate.requestFocus();
			}
		});
		updateSubject.add(resetButtonForUpdate);
		

		
		JLabel label_17 = new JLabel("\u9700\u8981\u4FEE\u6539\u7684\u79D1\u76EE\u7F16\u53F7\uFF1A");
		label_17.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_17.setBounds(14, 29, 189, 18);
		updateSubject.add(label_17);
		
		getsidTextForUpdate = new JTextField();
		getsidTextForUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		getsidTextForUpdate.setColumns(10);
		getsidTextForUpdate.setBounds(197, 26, 130, 24);
		updateSubject.add(getsidTextForUpdate);
		
		JButton button_19 = new JButton("查询");
		button_19.setFont(new Font("新宋体", Font.PLAIN, 18));
		button_19.setBounds(336, 25, 84, 27);
		button_19.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sid = getsidTextForUpdate.getText();
				String[] values = null;
				try {
					values = SubjectOperate.selectValues(sid);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println(new Date());
					System.err.println(e1.getMessage());
				}
				if(!values[0].equals("未找到!")) {
				int i = 0 ; 
				sidTextForUpdate.setText(values[i++]);
				snameTextForUpdate.setText(values[i++]);
				stimeTextForUpdate.setText(values[i++]);
				}
				else {
					Object[] options = {"确定"}; 
				JOptionPane.showOptionDialog(null, "未找到！", "科目操作", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
				}
			}
		});
		updateSubject.add(button_19);
		
		JLabel lbll = new JLabel("\u8BF7\u8F93\u5165\u65B0\u4FE1\u606F\uFF1A");
		lbll.setFont(new Font("新宋体", Font.PLAIN, 18));
		lbll.setBounds(24, 64, 130, 18);
		updateSubject.add(lbll);
		
		JLabel label_18 = new JLabel("\u79D1\u76EE\u7F16\u53F7\uFF1A");
		label_18.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_18.setBounds(83, 112, 92, 18);
		updateSubject.add(label_18);
		
		sidTextForUpdate = new JTextField();
		sidTextForUpdate.setEnabled(false);
		sidTextForUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		sidTextForUpdate.setColumns(10);
		sidTextForUpdate.setBounds(176, 110, 130, 24);
		updateSubject.add(sidTextForUpdate);
		
		snameTextForUpdate = new JTextField();
		snameTextForUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		snameTextForUpdate.setColumns(10);
		snameTextForUpdate.setBounds(176, 167, 130, 24);
		updateSubject.add(snameTextForUpdate);
		
		JLabel label_19 = new JLabel("\u79D1\u76EE\u540D\u79F0\uFF1A");
		label_19.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_19.setBounds(83, 169, 92, 18);
		updateSubject.add(label_19);
		
		JLabel label_20 = new JLabel("\u79D1\u76EE\u65F6\u957F:");
		label_20.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_20.setBounds(85, 222, 90, 18);
		updateSubject.add(label_20);
		
		stimeTextForUpdate = new JTextField();
		stimeTextForUpdate.setEnabled(false);
		stimeTextForUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		stimeTextForUpdate.setColumns(10);
		stimeTextForUpdate.setBounds(176, 220, 130, 24);
		updateSubject.add(stimeTextForUpdate);
		
		JPanel updateCourse = new JPanel();
		ShowPanel.add(updateCourse, "修改内容");
		updateCourse.setLayout(null);
		
		JButton submitTextForCourseUpdate = new JButton("\u4FEE\u6539\u5185\u5BB9");
		submitTextForCourseUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		submitTextForCourseUpdate.setFocusPainted(false);
		submitTextForCourseUpdate.setBounds(231, 283, 113, 27);
		submitTextForCourseUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateCourseAction();
			}
		});
		updateCourse.add(submitTextForCourseUpdate);
		
		JButton resetButtonTextForCourseUpdate = new JButton("重置");
		resetButtonTextForCourseUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		resetButtonTextForCourseUpdate.setFocusPainted(false);
		resetButtonTextForCourseUpdate.setBounds(55, 283, 113, 27);
		resetButtonTextForCourseUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getcidTextForUpdate.setText("");
				cidTextForUpdate.setText("");
				cnameTextForUpdate.setText("");
				ctimeTextForUpdate.setText("");
				sidTextForCourseUpdate.setText("");
			}
		});
		updateCourse.add(resetButtonTextForCourseUpdate);
		
		JLabel label_21 = new JLabel("\u9700\u8981\u4FEE\u6539\u7684\u5185\u5BB9\u7F16\u53F7\uFF1A");
		label_21.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_21.setBounds(2, 22, 189, 18);
		updateCourse.add(label_21);
		
		getcidTextForUpdate = new JTextField();
		getcidTextForUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		getcidTextForUpdate.setColumns(10);
		getcidTextForUpdate.setBounds(185, 19, 130, 24);
		updateCourse.add(getcidTextForUpdate);
		
		JButton button_20 = new JButton("查询");
		button_20.setFont(new Font("新宋体", Font.PLAIN, 18));
		button_20.setBounds(324, 18, 84, 27);
		button_20.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cid = getcidTextForUpdate.getText();
				String[] values = null;
				try {
					values = CourseOperate.selectValues(cid);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println(new Date());
					System.err.println(e1.getMessage());
				}
				int i = 0 ;
				cidTextForUpdate.setText(values[i++]);
				cnameTextForUpdate.setText(values[i++]);
				ctimeTextForUpdate.setText(values[i++]);
				sidTextForCourseUpdate.setText(values[i++]);
			}
		});
		updateCourse.add(button_20);
		
		cidTextForUpdate = new JTextField();
		cidTextForUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		cidTextForUpdate.setColumns(10);
		cidTextForUpdate.setBounds(185, 77, 130, 24);
		updateCourse.add(cidTextForUpdate);
		
		JLabel label_22 = new JLabel("\u5185\u5BB9\u7F16\u53F7\uFF1A");
		label_22.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_22.setBounds(92, 79, 92, 18);
		updateCourse.add(label_22);
		
		JLabel label_23 = new JLabel("\u5185\u5BB9\u540D\u79F0\uFF1A");
		label_23.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_23.setBounds(92, 136, 92, 18);
		updateCourse.add(label_23);
		
		cnameTextForUpdate = new JTextField();
		cnameTextForUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		cnameTextForUpdate.setColumns(10);
		cnameTextForUpdate.setBounds(185, 134, 130, 24);
		updateCourse.add(cnameTextForUpdate);
		
		JLabel label_24 = new JLabel("\u5185\u5BB9\u65F6\u957F:");
		label_24.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_24.setBounds(94, 189, 90, 18);
		updateCourse.add(label_24);
		
		ctimeTextForUpdate = new JTextField();
		ctimeTextForUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		ctimeTextForUpdate.setColumns(10);
		ctimeTextForUpdate.setBounds(185, 187, 130, 24);
		updateCourse.add(ctimeTextForUpdate);
		
		JLabel label_25 = new JLabel("\u79D1\u76EE\u7F16\u53F7:");
		label_25.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_25.setBounds(92, 244, 90, 18);
		updateCourse.add(label_25);
		
		sidTextForCourseUpdate = new JTextField();
		sidTextForCourseUpdate.setFont(new Font("新宋体", Font.PLAIN, 18));
		sidTextForCourseUpdate.setColumns(10);
		sidTextForCourseUpdate.setBounds(185, 241, 130, 24);
		updateCourse.add(sidTextForCourseUpdate);
		
		JPanel deleteSubject = new JPanel();
		ShowPanel.add(deleteSubject, "删除科目");
		deleteSubject.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("\u9700\u8981\u5220\u9664\u7684\u79D1\u76EE\u7F16\u53F7\uFF1A");
		lblNewLabel_6.setFont(new Font("新宋体", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(0, 31, 189, 18);
		deleteSubject.add(lblNewLabel_6);
		
		getsidTextForDelete = new JTextField();
		getsidTextForDelete.setFont(new Font("新宋体", Font.PLAIN, 18));
		getsidTextForDelete.setBounds(183, 28, 130, 24);
		deleteSubject.add(getsidTextForDelete);
		getsidTextForDelete.setColumns(10);
		
		JLabel label_1 = new JLabel("\u79D1\u76EE\u7F16\u53F7\uFF1A");
		label_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_1.setBounds(90, 88, 92, 18);
		deleteSubject.add(label_1);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setFont(new Font("新宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(322, 27, 84, 27);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sid = getsidTextForDelete.getText();
				String[] values = null;
				try {
					values = SubjectOperate.selectValues(sid);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println(new Date());
					System.err.println(e1.getMessage());
				}
				int i = 0 ;
				sidTextForDelete.setText(values[i++]);
				snameTextForDelete.setText(values[i++]);
				stimeTextForDelete.setText(values[i++]);
			}
		});
		deleteSubject.add(btnNewButton);
		
		LineBorder nullBoder = new LineBorder(null, 0);
		
		sidTextForDelete = new JTextField();
		sidTextForDelete.setFont(new Font("新宋体", Font.PLAIN, 18));
		sidTextForDelete.setEnabled(false);
		sidTextForDelete.setBounds(183, 86, 130, 24);
		deleteSubject.add(sidTextForDelete);
		sidTextForDelete.setColumns(10);
		sidTextForDelete.setBorder(nullBoder);
		
		JLabel label_2 = new JLabel("\u79D1\u76EE\u540D\u79F0\uFF1A");
		label_2.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_2.setBounds(90, 145, 92, 18);
		deleteSubject.add(label_2);
		
		snameTextForDelete = new JTextField();
		snameTextForDelete.setFont(new Font("新宋体", Font.PLAIN, 18));
		snameTextForDelete.setEnabled(false);
		snameTextForDelete.setBounds(183, 143, 130, 24);
		deleteSubject.add(snameTextForDelete);
		snameTextForDelete.setColumns(10);
		snameTextForDelete.setBorder(nullBoder);
		
		
		JLabel lblNewLabel_7 = new JLabel("\u79D1\u76EE\u65F6\u957F:");
		lblNewLabel_7.setFont(new Font("新宋体", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(92, 198, 90, 18);
		deleteSubject.add(lblNewLabel_7);
		
		stimeTextForDelete = new JTextField();
		stimeTextForDelete.setFont(new Font("新宋体", Font.PLAIN, 18));
		stimeTextForDelete.setEnabled(false);
		stimeTextForDelete.setBounds(183, 196, 130, 24);
		deleteSubject.add(stimeTextForDelete);
		stimeTextForDelete.setColumns(10);
		stimeTextForDelete.setBorder(nullBoder);
		
		JButton submitButtonForDelete = new JButton("\u5220\u9664\u79D1\u76EE");
		submitButtonForDelete.setFont(new Font("新宋体", Font.PLAIN, 18));
		submitButtonForDelete.setFocusPainted(false);
		submitButtonForDelete.setBounds(239, 276, 113, 27);
		submitButtonForDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sid = sidTextForDelete.getText();
				Object[] options = {"确定"}; 
				
				try {
					if(SubjectOperate.isDelete(sid))
					JOptionPane.showOptionDialog(null, "删除成功！", "科目操作", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]); 
					else 
						JOptionPane.showOptionDialog(null, "删除失败！", "科目操作", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
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
		deleteSubject.add(submitButtonForDelete);
		
		JButton resetButtonForDelete = new JButton("\u91CD\u7F6E");
		resetButtonForDelete.setFont(new Font("新宋体", Font.PLAIN, 18));
		resetButtonForDelete.setFocusPainted(false);
		resetButtonForDelete.setBounds(63, 276, 113, 27);
		resetButtonForDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getsidTextForDelete.setText("");
				getsidTextForDelete.grabFocus();
				sidTextForDelete.setText("");
				snameTextForDelete.setText("");
				stimeTextForDelete.setText("");
			}
		});
		deleteSubject.add(resetButtonForDelete);
		
		JPanel deleteCourse = new JPanel();
		ShowPanel.add(deleteCourse, "删除内容");
		deleteCourse.setLayout(null);
		
		JLabel label_3 = new JLabel("\u9700\u8981\u5220\u9664\u7684\u5185\u5BB9\u7F16\u53F7\uFF1A");
		label_3.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_3.setBounds(0, 17, 189, 18);
		deleteCourse.add(label_3);
		
		getcidTextForDelete = new JTextField();
		getcidTextForDelete.setFont(new Font("新宋体", Font.PLAIN, 18));
		getcidTextForDelete.setColumns(10);
		getcidTextForDelete.setBounds(183, 14, 130, 24);
		deleteCourse.add(getcidTextForDelete);
		
		JLabel label_4 = new JLabel("\u5185\u5BB9\u7F16\u53F7\uFF1A");
		label_4.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_4.setBounds(90, 74, 92, 18);
		deleteCourse.add(label_4);
		
		JButton button = new JButton("查询");
		button.setFont(new Font("新宋体", Font.PLAIN, 18));
		button.setBounds(322, 13, 84, 27);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cid = getcidTextForDelete.getText();
				String[] values = null;
				try {
					values = CourseOperate.selectValues(cid);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int i = 0 ;
				cidTextForDelete.setText(values[i++]);
				cnameTextForDelete.setText(values[i++]);
				ctimeTextForDelete.setText(values[i++]);
				sidTextForCourseDelete.setText(values[i++]);
			}
		});
		deleteCourse.add(button);
		
		cidTextForDelete = new JTextField();
		cidTextForDelete.setFont(new Font("新宋体", Font.PLAIN, 18));
		cidTextForDelete.setEnabled(false);
		cidTextForDelete.setColumns(10);
		cidTextForDelete.setBounds(183, 72, 130, 24);
		cidTextForDelete.setBorder(nullBoder);
		deleteCourse.add(cidTextForDelete);
		
		JLabel label_5 = new JLabel("\u5185\u5BB9\u540D\u79F0\uFF1A");
		label_5.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_5.setBounds(90, 131, 92, 18);
		deleteCourse.add(label_5);
		
		
		cnameTextForDelete = new JTextField();
		cnameTextForDelete.setFont(new Font("新宋体", Font.PLAIN, 18));
		cnameTextForDelete.setEnabled(false);
		cnameTextForDelete.setColumns(10);
		cnameTextForDelete.setBounds(183, 129, 130, 24);
		cnameTextForDelete.setBorder(nullBoder);
		deleteCourse.add(cnameTextForDelete);
		
		JLabel label_6 = new JLabel("\u5185\u5BB9\u65F6\u957F:");
		label_6.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_6.setBounds(92, 184, 90, 18);
		deleteCourse.add(label_6);
		
		ctimeTextForDelete = new JTextField();
		ctimeTextForDelete.setFont(new Font("新宋体", Font.PLAIN, 18));
		ctimeTextForDelete.setEnabled(false);
		ctimeTextForDelete.setColumns(10);
		ctimeTextForDelete.setBounds(183, 182, 130, 24);
		ctimeTextForDelete.setBorder(nullBoder);
		deleteCourse.add(ctimeTextForDelete);
		
		JLabel label_7 = new JLabel("\u79D1\u76EE\u7F16\u53F7:");
		label_7.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_7.setBounds(90, 239, 90, 18);
		deleteCourse.add(label_7);
		
		sidTextForCourseDelete = new JTextField();
		sidTextForCourseDelete.setFont(new Font("新宋体", Font.PLAIN, 18));
		sidTextForCourseDelete.setEnabled(false);
		sidTextForCourseDelete.setColumns(10);
		sidTextForCourseDelete.setBounds(183, 236, 130, 24);
		sidTextForCourseDelete.setBorder(nullBoder);
		deleteCourse.add(sidTextForCourseDelete);
		
		JButton submitButtonForCourseDelete = new JButton("删除内容");
		submitButtonForCourseDelete.setFont(new Font("新宋体", Font.PLAIN, 18));
		submitButtonForCourseDelete.setFocusPainted(false);
		submitButtonForCourseDelete.setBounds(233, 287, 113, 27);
		submitButtonForCourseDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cid = getcidTextForDelete.getText();

				Object[] options = {"确定"}; 
				try {
					if(CourseOperate.isDelete(cid)) {
						JOptionPane.showOptionDialog(null, "删除成功！", "内容操作", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
					}
					else {
						JOptionPane.showOptionDialog(null, "删除失败！", "内容操作", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]); 
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
		deleteCourse.add(submitButtonForCourseDelete);
		
		JButton resetButtonForCourseDelete = new JButton("\u91CD\u7F6E");
		resetButtonForCourseDelete.setFont(new Font("新宋体", Font.PLAIN, 18));
		resetButtonForCourseDelete.setFocusPainted(false);
		resetButtonForCourseDelete.setBounds(57, 287, 113, 27);
		resetButtonForCourseDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getcidTextForDelete.setText("");
				getcidTextForDelete.grabFocus();
				cidTextForDelete.setText("");
				cnameTextForDelete.setText("");
				ctimeTextForDelete.setText("");
				sidTextForCourseDelete.setText("");
			}
		});
		deleteCourse.add(resetButtonForCourseDelete);
		
		JPanel selectSubject = new JPanel();
		ShowPanel.add(selectSubject, "查询科目");
		selectSubject.setLayout(null);
		
		JLabel label_12 = new JLabel("\u9700\u8981\u67E5\u8BE2\u7684\u79D1\u76EE\u7F16\u53F7\uFF1A");
		label_12.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_12.setBounds(0, 63, 189, 18);
		selectSubject.add(label_12);
		
		getSidTextForSelect = new JTextField();
		getSidTextForSelect.setFont(new Font("新宋体", Font.PLAIN, 18));
		getSidTextForSelect.setColumns(10);
		getSidTextForSelect.setBounds(183, 60, 130, 24);
		getSidTextForSelect.enableInputMethods(false);
		selectSubject.add(getSidTextForSelect);
		
		JButton button_18 = new JButton("查询");
		button_18.setFont(new Font("新宋体", Font.PLAIN, 18));
		button_18.setBounds(322, 59, 84, 27);
		button_18.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectSubjectAction();
			}
		});
		selectSubject.add(button_18);
		
		JLabel label_13 = new JLabel("\u79D1\u76EE\u7F16\u53F7\uFF1A");
		label_13.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_13.setBounds(90, 120, 92, 18);
		selectSubject.add(label_13);
		
		JLabel label_14 = new JLabel("\u79D1\u76EE\u540D\u79F0\uFF1A");
		label_14.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_14.setBounds(90, 177, 92, 18);
		selectSubject.add(label_14);
		
		JLabel label_15 = new JLabel("\u79D1\u76EE\u65F6\u957F:");
		label_15.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_15.setBounds(92, 230, 90, 18);
		selectSubject.add(label_15);
		
		stimeTextForSelect = new JTextField();
		stimeTextForSelect.setFont(new Font("新宋体", Font.PLAIN, 18));
		stimeTextForSelect.setEnabled(false);
		stimeTextForSelect.setColumns(10);
		stimeTextForSelect.setBounds(183, 228, 130, 24);
		selectSubject.add(stimeTextForSelect);
		
		snameTextForSelect = new JTextField();
		snameTextForSelect.setFont(new Font("新宋体", Font.PLAIN, 18));
		snameTextForSelect.setEnabled(false);
		snameTextForSelect.setColumns(10);
		snameTextForSelect.setBounds(183, 175, 130, 24);
		selectSubject.add(snameTextForSelect);
		
		sidTextForSelect_1 = new JTextField();
		sidTextForSelect_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		sidTextForSelect_1.setEnabled(false);
		sidTextForSelect_1.setColumns(10);
		sidTextForSelect_1.setBounds(183, 118, 130, 24);
		selectSubject.add(sidTextForSelect_1);
		
		JPanel selectCourse = new JPanel();
		ShowPanel.add(selectCourse, "查询内容");
		selectCourse.setLayout(null);
		
		JLabel label_8 = new JLabel("\u9700\u8981\u67E5\u8BE2\u7684\u5185\u5BB9\u7F16\u53F7\uFF1A");
		label_8.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_8.setBounds(0, 32, 189, 18);
		selectCourse.add(label_8);
		
		getCidTextForSelect = new JTextField();
		getCidTextForSelect.setFont(new Font("新宋体", Font.PLAIN, 18));
		getCidTextForSelect.setColumns(10);
		getCidTextForSelect.setBounds(183, 29, 130, 24);
		selectCourse.add(getCidTextForSelect);
		
		JButton submitButtonForCourseSelect = new JButton("\u67E5\u8BE2");
		submitButtonForCourseSelect.setFont(new Font("新宋体", Font.PLAIN, 18));
		submitButtonForCourseSelect.setBounds(322, 28, 84, 27);
		submitButtonForCourseSelect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cid = getCidTextForSelect.getText();
				String[] values = null;
				try {
					values = CourseOperate.selectValues(cid);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println(new Date());
					System.err.println(e1.getMessage());
				}
				int i = 0 ;
				cidTextForSelect.setText(values[i++]);
				cnameTextForSelect.setText(values[i++]);
				ctimeTextForSelect.setText(values[i++]);
				sidTextForSelect.setText(values[i++]);
			}
		});
		selectCourse.add(submitButtonForCourseSelect);
		
		JLabel label_9 = new JLabel("\u5185\u5BB9\u7F16\u53F7\uFF1A");
		label_9.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_9.setBounds(90, 112, 92, 18);
		selectCourse.add(label_9);
		
		cidTextForSelect = new JTextField();
		cidTextForSelect.setFont(new Font("新宋体", Font.PLAIN, 18));
		cidTextForSelect.setEnabled(false);
		cidTextForSelect.setColumns(10);
		cidTextForSelect.setBounds(183, 110, 130, 24);
		selectCourse.add(cidTextForSelect);
		
		JLabel label_10 = new JLabel("\u5185\u5BB9\u540D\u79F0\uFF1A");
		label_10.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_10.setBounds(90, 169, 92, 18);
		selectCourse.add(label_10);
		
		cnameTextForSelect = new JTextField();
		cnameTextForSelect.setFont(new Font("新宋体", Font.PLAIN, 18));
		cnameTextForSelect.setEnabled(false);
		cnameTextForSelect.setColumns(10);
		cnameTextForSelect.setBounds(183, 167, 130, 24);
		selectCourse.add(cnameTextForSelect);
		
		JLabel label_11 = new JLabel("\u5185\u5BB9\u65F6\u957F:");
		label_11.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_11.setBounds(92, 222, 90, 18);
		selectCourse.add(label_11);
		
		ctimeTextForSelect = new JTextField();
		ctimeTextForSelect.setFont(new Font("新宋体", Font.PLAIN, 18));
		ctimeTextForSelect.setEnabled(false);
		ctimeTextForSelect.setColumns(10);
		ctimeTextForSelect.setBounds(183, 220, 130, 24);
		selectCourse.add(ctimeTextForSelect);
		
		JLabel label_16 = new JLabel("\u79D1\u76EE\u7F16\u53F7:");
		label_16.setFont(new Font("新宋体", Font.PLAIN, 18));
		label_16.setBounds(90, 277, 90, 18);
		selectCourse.add(label_16);
		
		sidTextForSelect = new JTextField();
		sidTextForSelect.setFont(new Font("新宋体", Font.PLAIN, 18));
		sidTextForSelect.setEnabled(false);
		sidTextForSelect.setColumns(10);
		sidTextForSelect.setBounds(183, 274, 130, 24);
		selectCourse.add(sidTextForSelect);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("新宋体", Font.PLAIN, 18));
		menuBar.setBounds(0, 13, 438, 26);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u529F\u80FD");
		mnNewMenu.setFont(new Font("新宋体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		JMenu menu = new JMenu("\u6DFB\u52A0");
		menu.setFont(new Font("新宋体", Font.PLAIN, 18));
		mnNewMenu.add(menu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("添加科目");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showPanelLayout.show(ShowPanel,"添加科目");
			}
		});
		mntmNewMenuItem.setFont(new Font("新宋体", Font.PLAIN, 18));
		menu.add(mntmNewMenuItem);
		
		JMenuItem menuItem = new JMenuItem("添加内容");
		menuItem.setFont(new Font("新宋体", Font.PLAIN, 18));
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showPanelLayout.show(ShowPanel,"添加内容");
			}
		});
		menu.add(menuItem);

		JMenu menu_1 = new JMenu("修改");
		menu_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		mnNewMenu.add(menu_1);

		
		JMenuItem menuItem_1 = new JMenuItem("修改科目");
		menuItem_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		menuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showPanelLayout.show(ShowPanel,"修改科目");
			}
		});
		menu_1.add(menuItem_1);
		JMenuItem menuItem_2 = new JMenuItem("修改内容");
		menuItem_2.setFont(new Font("新宋体", Font.PLAIN, 18));
		menuItem_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showPanelLayout.show(ShowPanel,"修改内容");
			}
		});
		menu_1.add(menuItem_2);
		JMenu menu_2 = new JMenu("删除");
		menu_2.setFont(new Font("新宋体", Font.PLAIN, 18));
		mnNewMenu.add(menu_2);
		JMenuItem menuItem_3 = new JMenuItem("删除科目");
		menuItem_3.setFont(new Font("新宋体", Font.PLAIN, 18));
		menuItem_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showPanelLayout.show(ShowPanel,"删除科目");
			}
		});
		menu_2.add(menuItem_3);
		JMenuItem menuItem_4 = new JMenuItem("删除内容");
		menuItem_4.setFont(new Font("新宋体", Font.PLAIN, 18));
		menuItem_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showPanelLayout.show(ShowPanel,"删除内容");
			}
		});
		menu_2.add(menuItem_4);
		JMenu menu_3 = new JMenu("查询");
		menu_3.setFont(new Font("新宋体", Font.PLAIN, 18));
		mnNewMenu.add(menu_3);
		
		JMenuItem menuItem_5 = new JMenuItem("查询科目");
		menuItem_5.setFont(new Font("新宋体", Font.PLAIN, 18));
		menuItem_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showPanelLayout.show(ShowPanel,"查询科目");
			}
		});
		menu_3.add(menuItem_5);
		JMenuItem menuItem_6 = new JMenuItem("查询内容");
		menuItem_6.setFont(new Font("新宋体", Font.PLAIN, 18));
		menuItem_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showPanelLayout.show(ShowPanel,"查询内容");
			}
		});
		menu_3.add(menuItem_6);
		JMenu mnNewMenu_1 = new JMenu("帮助");
		mnNewMenu_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_1);
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("说明");
		mnNewMenu_1.add(mntmNewMenuItem_1);
	}
	private void addSubjectAction() {
		// TODO Auto-generated method stub
		String sname = snameTextForAdd.getText();
		String sid = sidTextForAdd.getText();
		String [] values = {sid,sname};
		
		try {
			if(SubjectOperate.isAdd(values)){
				Object[] options = {"确定"}; 
				JOptionPane.showOptionDialog(null, "添加科目成功", "科目操作", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
			}
			else {
				Object[] options1 = {"确定"};
				JOptionPane.showOptionDialog(null, "添加科目失败", "科目操作", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options1, options1[0]); 
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
	private void selectSubjectAction() {
		String sid = getSidTextForSelect.getText();
		String[] values = null;
		try {
			values = SubjectOperate.selectValues(sid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(new Date());
			System.err.println(e.getMessage());
		}
		if(!values[0].equals("未找到!")) {
		int i = 0 ; 
		sidTextForSelect_1.setText(values[i++]);
		snameTextForSelect.setText(values[i++]);
		stimeTextForSelect.setText(values[i++]);
		}
		else {
			Object[] options = {"确定"}; 
		JOptionPane.showOptionDialog(null, "未找到！", "科目操作", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]); 
		}

	}
	
	private void updateSubjectAction() {
		String sid = sidTextForUpdate.getText();
		String sname = snameTextForUpdate.getText();
		String[] values = {sid,sname,sid};
		Object[] options = {"确定"}; 
		try {
			if(SubjectOperate.isUpdate(values)) {
				JOptionPane.showOptionDialog(null, "修改成功！", "科目操作", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
			}
			else {
				JOptionPane.showOptionDialog(null, "修改失败！", "科目操作", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]); 
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
	
	private void addCourseAction() {
		String sid = sidTextForAdd_1.getText();
		String cid = cidTextForAdd.getText();
		String cname = cnameTextForAdd.getText();
		String ctime = ctimeTextForAdd.getText();
		String[] values = {cid,cname,ctime,sid};
		Object[] options = {"确定"}; 
		try {
			if(CourseOperate.isAdd(values)) {
				JOptionPane.showOptionDialog(null, "添加成功！", "内容操作", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
			}
			else {
				JOptionPane.showOptionDialog(null, "添加失败！", "内容操作", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]); 
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
	private void updateCourseAction() {
		String sid = sidTextForCourseUpdate.getText();
		String cid = cidTextForUpdate.getText();
		String cname = cnameTextForUpdate.getText();
		String ctime = ctimeTextForUpdate.getText();
		String[] values = {cid,cname,ctime,sid};
		Object[] options = {"确定"}; 
		try {
			if(CourseOperate.isUpdate(values, cid)) {
				JOptionPane.showOptionDialog(null, "修改成功！", "内容操作", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]); 
			}
			else {
				JOptionPane.showOptionDialog(null, "修改失败！", "内容操作", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]); 
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
	/***
	 * 未实现的功能
	 */
	private void deteleCourseAction() {
		
	}
}
