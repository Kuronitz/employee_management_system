package org.sys.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sys.employee.UserDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*** 这个类用于登录
* @author Kuronitz
* @version 1.5
*/

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JPasswordField passwordField;

	public Login() {
		setVisible(true);
		setTitle("员工信息管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 160);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("员工号");
		label.setBounds(32, 39, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(32, 64, 54, 15);
		contentPane.add(label_1);
		
		tf = new JTextField();
		tf.setBounds(96, 36, 116, 21);
		contentPane.add(tf);
		tf.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(96, 61, 116, 21);
		contentPane.add(passwordField);
		
		JButton LoginButton = new JButton("登录");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = new String(passwordField.getPassword());
				if (UserDao.checkeUser(tf.getText(), s)) {
					MainUI mainui = new MainUI();
					mainui.setVisible(true);
					Login.this.dispose();
				} else {
					 JOptionPane.showConfirmDialog(Login.this, "登录失败", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
				}
			}
		});
		LoginButton.setBounds(32, 89, 66, 23);
		contentPane.add(LoginButton);
		JButton RegisteButton = new JButton("注册");
		RegisteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registe a = new Registe();
				Login.this.dispose();
			}
		});
		RegisteButton.setBounds(146, 89, 66, 23);
		contentPane.add(RegisteButton);
		
		JLabel LoginMess = new JLabel("登录系统");
		LoginMess.setHorizontalAlignment(SwingConstants.CENTER);
		LoginMess.setBounds(10, 10, 224, 15);
		contentPane.add(LoginMess);
	}
}
