package org.sys.frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sys.employee.Employee;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/*** 这个类是主界面
* @author Kuronitz
* @version 1.5
*/

public class MainUI extends JFrame {

	private static final long serialVersionUID = 2550690154444020926L;
	private JPanel contentPane;
	private Employee employee;
	private JTextArea txArea;

	public MainUI() {
		setVisible(true);
		setResizable(false);
		setTitle("员工信息管理系统");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 314);
		this.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("开始");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("功能");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SelectFunction();
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("录入员工信息");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				employee = InputDialog.showEmployee(null);
				if (employee == null) {
					txArea.append("\n******未输入员工信息！******");
				} else {
					txArea.append("\n******员工信息如下*****");
					txArea.append(employee.toString());
				}
			}
		});
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("修改员工信息");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				employee = EditDialog.showEmployee(null);
			}
		});
		menu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("删除员工信息");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DelDialog();
			}
		});
		menu.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("查询员工信息");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new QueryDialog();
			}
		});
		menu.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("统计员工信息");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new StaDialog();
			}
		});
		menu.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("退出");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menu.add(menuItem_6);
		
		JMenu menu_1 = new JMenu("布局");
		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("查询");
		menuBar.add(menu_2);
		
		JMenu menu_3 = new JMenu("项目");
		menuBar.add(menu_3);
		
		JMenu menu_4 = new JMenu("窗口");
		menuBar.add(menu_4);
		
		JMenu menu_5 = new JMenu("帮助");
		menuBar.add(menu_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		txArea = new JTextArea();
		txArea.setLineWrap(true);
		txArea.setText("请点击开始按钮选择需要的功能");
		scrollPane.setViewportView(txArea);
	}
}
