package org.sys.frame;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sys.employee.Employee;
import org.sys.employee.EmployeeDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

/*** 这个类用于录入员工信息
* @author Kuronitz
* @version 1.5
*/

public class InputDialog extends JDialog {

	private static final long serialVersionUID = -7830922124151648555L;
	private JTextField txNum;
	private JTextField txName;
	private JTextField txAge;
	private JRadioButton rbSex1, rbSex2;
	private Employee employee;
	private boolean regOk = false;
	private boolean newEmployee = true;
	private JCheckBox ckb1, ckb2, ckb3, ckb4;
	private JComboBox comboBox;
	private JTextArea textArea;

	public InputDialog() {
		JPanel contentPanel = new JPanel();
		setTitle("员工信息登录");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 300, 390);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("工号：");
			label.setBounds(10, 35, 44, 15);
			contentPanel.add(label);
		}

		txNum = new JTextField();
		txNum.setBounds(44, 32, 230, 21);
		contentPanel.add(txNum);
		txNum.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setBounds(10, 60, 44, 15);
		contentPanel.add(lblNewLabel_1);

		txName = new JTextField();
		txName.setBounds(44, 57, 230, 21);
		contentPanel.add(txName);
		txName.setColumns(10);

		JLabel label = new JLabel("年龄：");
		label.setBounds(10, 85, 44, 15);
		contentPanel.add(label);

		txAge = new JTextField();
		txAge.setBounds(44, 85, 230, 21);
		contentPanel.add(txAge);
		txAge.setColumns(10);

		JLabel label_1 = new JLabel("性别：");
		label_1.setBounds(10, 110, 44, 15);
		contentPanel.add(label_1);

		rbSex1 = new JRadioButton("男");
		rbSex1.setBounds(44, 106, 44, 23);
		contentPanel.add(rbSex1);

		rbSex2 = new JRadioButton("女");
		rbSex2.setBounds(230, 106, 44, 23);
		contentPanel.add(rbSex2);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rbSex2);
		bg.add(rbSex1);

		JLabel label_2 = new JLabel("爱好：");
		label_2.setBounds(10, 135, 44, 15);
		contentPanel.add(label_2);

		ckb1 = new JCheckBox("唱歌");
		ckb1.setBounds(44, 131, 54, 23);
		contentPanel.add(ckb1);

		ckb2 = new JCheckBox("跳舞");
		ckb2.setBounds(100, 131, 66, 23);
		contentPanel.add(ckb2);

		ckb3 = new JCheckBox("篮球");
		ckb3.setBounds(163, 131, 54, 23);
		contentPanel.add(ckb3);

		ckb4 = new JCheckBox("说唱");
		ckb4.setBounds(219, 131, 55, 23);
		contentPanel.add(ckb4);

		JLabel label_3 = new JLabel("员工类别：");
		label_3.setBounds(10, 163, 66, 15);
		contentPanel.add(label_3);

		JLabel label_4 = new JLabel("个人简介：");
		label_4.setBounds(10, 188, 66, 15);
		contentPanel.add(label_4);

		JButton button = new JButton("保存");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int x=JOptionPane.showConfirmDialog(InputDialog.this, "是否保存？", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
		            if (x==JOptionPane.OK_OPTION) {
		                EmployeeDao dao = new EmployeeDao();
						 regOk = true;
						 dispose();
						JOptionPane.showConfirmDialog(InputDialog.this, "保存成功", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
						InputDialog.this.dispose();
            new InputDialog();
		        }else{
		                JOptionPane.showConfirmDialog(InputDialog.this, "保存失败", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
		        }
				
			}
		});
		button.setBounds(20, 323, 93, 23);
		contentPanel.add(button);

		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regOk = false;
				dispose();
			}
		});
		button_1.setBounds(170, 323, 93, 23);
		contentPanel.add(button_1);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "经理", "工程师", "普通员工" }));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(76, 160, 198, 21);
		contentPanel.add(comboBox);

		JLabel label_6 = new JLabel("请输入员工信息");
		label_6.setBounds(10, 10, 374, 15);
		contentPanel.add(label_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 204, 264, 112);
		contentPanel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
	}

	public Employee getEmployee() {
		boolean newE = employee == null;
		Employee emp = new Employee();
		String s = txNum.getText();
		s.trim();
		Integer i = null;
		if (!s.isEmpty()) {
			if (newE) { 
				if (!EmployeeDao.selectGH(i)) {
					emp.setNum(Integer.valueOf(s));
				} else {
					return null;
				}
			}
			emp.setAge(Integer.valueOf(this.txAge.getText()));
			emp.setSynopsis(this.textArea.getText());
			if (this.rbSex1.isSelected())
				emp.setSex(true);
			else if (this.rbSex2.isSelected())
				emp.setSex(false);
			emp.setName(this.txName.getText());
			emp.setHobby1(this.ckb1.isSelected());
			emp.setHobby2(this.ckb2.isSelected());
			emp.setHobby3(this.ckb3.isSelected());
			emp.setHobby4(this.ckb4.isSelected());
			if (comboBox.getSelectedIndex() == 0) {
				emp.setCate("经理");
			} else if (comboBox.getSelectedIndex() == 1) {
				emp.setCate("工程师");
			} else {
				emp.setCate("普通员工");
			}
		}
		return emp;
	}

	public void setEmployee(Employee employee) {
		if (employee == null)
			return;
		try {
			this.txNum.setText(employee.getNum().toString());
			this.txName.setText(employee.getName());
			this.txAge.setText(employee.getAge().toString());
			this.rbSex1.setSelected(employee.getSex());
			this.rbSex1.setSelected(!employee.getSex());
			this.textArea.setText(employee.getSynopsis());
		} catch (NullPointerException e) {

		}
	}

	public static Employee showEmployee(Employee employee) {
		Employee employee1 = null;
		try {
			InputDialog inpdia = new InputDialog();
			inpdia.setEmployee(employee);
			inpdia.setModal(true);
			inpdia.setVisible(true);
			if (inpdia.regOk) {
				EmployeeDao.addEmployee(inpdia.getEmployee());
				employee1 = inpdia.getEmployee();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee1;
	}
}
