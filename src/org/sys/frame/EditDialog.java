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
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

/*** 这个类用于修改员工信息
* @author Kuronitz
* @version 1.5
*/

public class EditDialog extends JDialog {

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
	private JTextField tfNum1;

	public EditDialog() {
		JPanel contentPanel = new JPanel();
		setTitle("员工信息登录");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 300, 430);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("工号：");
			label.setBounds(10, 61, 44, 15);
			contentPanel.add(label);
		}

		txNum = new JTextField();
		txNum.setEnabled(false);
		txNum.setBounds(44, 58, 230, 21);
		contentPanel.add(txNum);
		txNum.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setBounds(10, 86, 44, 15);
		contentPanel.add(lblNewLabel_1);

		txName = new JTextField();
		txName.setEnabled(false);
		txName.setBounds(44, 83, 230, 21);
		contentPanel.add(txName);
		txName.setColumns(10);

		JLabel label = new JLabel("年龄：");
		label.setBounds(10, 111, 44, 15);
		contentPanel.add(label);

		txAge = new JTextField();
		txAge.setEnabled(false);
		txAge.setBounds(44, 108, 230, 21);
		contentPanel.add(txAge);
		txAge.setColumns(10);

		JLabel label_1 = new JLabel("性别：");
		label_1.setBounds(10, 136, 44, 15);
		contentPanel.add(label_1);

		rbSex1 = new JRadioButton("男");
		rbSex1.setEnabled(false);
		rbSex1.setBounds(44, 132, 44, 23);
		contentPanel.add(rbSex1);

		rbSex2 = new JRadioButton("女");
		rbSex2.setEnabled(false);
		rbSex2.setBounds(230, 132, 44, 23);
		contentPanel.add(rbSex2);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rbSex2);
		bg.add(rbSex1);

		JLabel label_2 = new JLabel("爱好：");
		label_2.setBounds(10, 161, 44, 15);
		contentPanel.add(label_2);

		ckb1 = new JCheckBox("唱歌");
		ckb1.setEnabled(false);
		ckb1.setBounds(44, 157, 54, 23);
		contentPanel.add(ckb1);

		ckb2 = new JCheckBox("跳舞");
		ckb2.setEnabled(false);
		ckb2.setBounds(100, 157, 66, 23);
		contentPanel.add(ckb2);

		ckb3 = new JCheckBox("篮球");
		ckb3.setEnabled(false);
		ckb3.setBounds(163, 157, 54, 23);
		contentPanel.add(ckb3);

		ckb4 = new JCheckBox("说唱");
		ckb4.setEnabled(false);
		ckb4.setBounds(219, 157, 55, 23);
		contentPanel.add(ckb4);

		JLabel label_3 = new JLabel("员工类别：");
		label_3.setBounds(10, 186, 66, 15);
		contentPanel.add(label_3);

		JLabel label_4 = new JLabel("个人简介：");
		label_4.setBounds(10, 211, 66, 15);
		contentPanel.add(label_4);

		JButton button = new JButton("保存");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int x=JOptionPane.showConfirmDialog(EditDialog.this, "是否修改？", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
		            if (x==JOptionPane.OK_OPTION) {
		            	int i = ImpEmployee(Integer.valueOf(txNum.getText()));
						EmployeeDao.getEmployeeList().set(i, getEmployee());
						dispose();
						JOptionPane.showMessageDialog(null,"修改成功！","注册成功",JOptionPane.INFORMATION_MESSAGE);
		        }else{
		                JOptionPane.showConfirmDialog(EditDialog.this, "修改失败", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
		        }
				
			}
		});
		button.setBounds(30, 358, 93, 23);
		contentPanel.add(button);

		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regOk = false;
				dispose();
			}
		});
		button_1.setBounds(161, 358, 93, 23);
		contentPanel.add(button_1);

		comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "经理", "工程师", "普通员工" }));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(76, 183, 198, 21);
		contentPanel.add(comboBox);

		JLabel label_6 = new JLabel("输入工号查询");
		label_6.setBounds(10, 36, 87, 15);
		contentPanel.add(label_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 236, 264, 112);
		contentPanel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		tfNum1 = new JTextField();
		tfNum1.setBounds(88, 33, 100, 21);
		contentPanel.add(tfNum1);
		tfNum1.setColumns(10);
		
		JButton SearchBtn = new JButton("查询");
		SearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer gh = Integer.valueOf(tfNum1.getText());
				Employee emp;
				emp = SearchEmployee(gh);
				if (emp.getNum() != null) {
					txNum.setText(emp.getNum().toString());
					txName.setText(emp.getName().toString());
					txAge.setText(emp.getAge().toString());
					rbSex1.setSelected(emp.getSex());
					rbSex2.setSelected(!emp.getSex());
					ckb1.setSelected(emp.getHobby1());
					ckb2.setSelected(emp.getHobby2());
					ckb3.setSelected(emp.getHobby3());
					ckb4.setSelected(emp.getHobby4());
					textArea.setText(emp.getSynopsis().toString());
					txName.setEnabled(true);
					txAge.setEnabled(true);
					rbSex1.setEnabled(true);
					rbSex2.setEnabled(true);
					ckb1.setEnabled(true);
					ckb2.setEnabled(true);
					ckb3.setEnabled(true);
					ckb4.setEnabled(true);
					if ("总经理".equals(emp.getCate())) {
						comboBox.setSelectedIndex(0);
					} else if ("总监".equals(emp.getCate())) {
						comboBox.setSelectedIndex(1);
					} else {
						comboBox.setSelectedIndex(2);
					}
					comboBox.setEnabled(true);
					textArea.setEnabled(true);
				} 
			}
		});
		SearchBtn.setBounds(191, 32, 83, 23);
		contentPanel.add(SearchBtn);
		
		JLabel lblNewLabel = new JLabel("员工信息修改");
		lblNewLabel.setBounds(10, 11, 93, 15);
		contentPanel.add(lblNewLabel);
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
			EditDialog india = new EditDialog();
			india.setEmployee(employee);
			india.setModal(true);
			india.setVisible(true);
			if (india.regOk) {
				EmployeeDao.addEmployee(india.getEmployee());
				employee1 = india.getEmployee();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee1;
	}
	
	public static Employee SearchEmployee(Integer gh) {
		Employee emp = new Employee();
		if (EmployeeDao.selectGH(gh)) {
			for (Employee emp1 : EmployeeDao.getEmployeeList()) {
				if (emp1.getNum() == gh) {
					emp = emp1;
				}
			}
		}
		return emp;
	}
	
	public static int ImpEmployee(Integer gh) {
		int index = -1;
		if (EmployeeDao.selectGH(gh)) {
			for (Employee emp1 : EmployeeDao.getEmployeeList()) {
				if (emp1.getNum() == gh) {
					index = EmployeeDao.getEmployeeList().indexOf(emp1);
				}
			}
		}
		return index;
	}
}
