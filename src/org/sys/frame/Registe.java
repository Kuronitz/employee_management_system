package org.sys.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.sys.employee.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

/*** 这个类用于注册
* @author Kuronitz
* @version 1.5
*/

public class Registe extends JFrame {

	private JPanel contentPane;
	private static JTextField txName;
	private static JPasswordField Psw;
	private static boolean regOk = false;

	public Registe() {
		setVisible(true);
		setTitle("员工信息管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 155);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("账号");
		label.setBounds(21, 35, 54, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("密码");
		lblNewLabel.setBounds(21, 60, 54, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regOk = true;
				dispose();
				 int x=JOptionPane.showConfirmDialog(Registe.this, "是否注册？", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
		            if (x==JOptionPane.OK_OPTION) {
						JOptionPane.showConfirmDialog(Registe.this, "注册成功", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
						 regOk = true;
						 dispose();
						 new Login();
						 Registe.this.dispose();
		        }else{
		                JOptionPane.showConfirmDialog(Registe.this, "注册失败", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
		        }
				
			}
		});
		btnNewButton.setBounds(21, 85, 66, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBounds(156, 85, 66, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		

		txName = new JTextField();
		txName.setBounds(110, 32, 112, 21);
		contentPane.add(txName);
		txName.setColumns(10);
		
		Psw = new JPasswordField();
		Psw.setBounds(110, 57, 112, 21);
		contentPane.add(Psw);
		
		JLabel label_1 = new JLabel("注册账号");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 10, 224, 15);
		contentPane.add(label_1);
	}
	
	public static User EnterUser(User user) {
		User user1 = null;
		user = new User();
		Registe dialog = new Registe();
		dialog.setVisible(true);
		String s = new String(Psw.getPassword());
		user.setuName(txName.getText());
		user.setPsw(s);
		user1 = user;
		if (regOk) {
			UserDao.addUser(user1);
		}
		return user1;
	}
}
