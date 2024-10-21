package org.sys.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sys.employee.Employee;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*** 这个类用于选择功能
* @author Kuronitz
* @version 1.5
*/

public class SelectFunction extends JFrame {

	private JPanel contentPane;
	private Employee employee;

	public SelectFunction() {
		setVisible(true);
		setTitle("选择");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 450, 170);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请选择你需要的功能");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 414, 15);
		contentPane.add(lblNewLabel);
		
		JButton Input_inf = new JButton("录入员工信息");
		Input_inf.setBounds(10, 35, 160, 23);
		contentPane.add(Input_inf);
		Input_inf.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	new InputDialog();
	        	SelectFunction.this.dispose();
	        	}
	        });
		
		JButton Edit_inf = new JButton("修改员工信息");
		Edit_inf.setBounds(264, 35, 160, 23);
		contentPane.add(Edit_inf);
		Edit_inf.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            new EditDialog();
	            SelectFunction.this.dispose();
	        }
	    });
		
		JButton Del_inf = new JButton("删除员工信息");
		
		Del_inf.setBounds(10, 68, 160, 23);
		contentPane.add(Del_inf);
		Del_inf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DelDialog();
				SelectFunction.this.dispose();
			}
		});
		
		JButton Que_inf = new JButton("查询员工信息");
		Que_inf.setBounds(264, 68, 160, 23);
		contentPane.add(Que_inf);
		Que_inf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new QueryDialog();
				SelectFunction.this.dispose();
			}
		});
		
		JButton Sta_inf = new JButton("统计员工信息");
		Sta_inf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StaDialog();
				SelectFunction.this.dispose();
			}
		});
		Sta_inf.setBounds(10, 101, 160, 23);
		contentPane.add(Sta_inf);
		
		JButton Exit0 = new JButton("退出本程序");
		Exit0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		Exit0.setBounds(264, 101, 160, 23);
		contentPane.add(Exit0);
	}

}
