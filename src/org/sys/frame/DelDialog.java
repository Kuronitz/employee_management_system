package org.sys.frame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sys.employee.Employee;
import org.sys.employee.EmployeeDao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

/*** 这个类用于删除员工信息
* @author Kuronitz
* @version 1.5
*/

public class DelDialog extends JDialog {

	private static final long serialVersionUID = -6535171740152670193L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tf;
	private JTextArea textArea;

	public DelDialog() {
		setVisible(true);
		setTitle("员工信息删除");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("请输入员工号：");
		panel.add(lblNewLabel);
		
		tf = new JTextField();
		panel.add(tf);
		tf.setColumns(10);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int x=JOptionPane.showConfirmDialog(DelDialog.this, "是否删除？", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
		         if (x==JOptionPane.OK_OPTION) {
		        	 DelInf();
						JOptionPane.showConfirmDialog(DelDialog.this, "删除成功", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
						dispose();
		         }else{
		             JOptionPane.showConfirmDialog(DelDialog.this, "删除失败", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
		         }
			}
		});
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
	}
	
	public void DelInf(){
		List<Employee> list = EmployeeDao.getEmployeeList();
		List<Integer> listID = new ArrayList<Integer>();
         for (int c = 0; c < list.size(); c++) {
             listID.add(list.get(c).getNum());
         }
         for (int q = 0; q < list.size(); q++) {
             if (listID.contains(Integer.valueOf(tf.getText()))) {
                 if (Integer.valueOf(tf.getText()) == list.get(q).getNum()) {
                     list.remove(q); 
                     break;
                 } else {
                     continue;
                 }
             	} else {
                 	textArea.append("没有该学生信息。");
                 	break;
             	}
         	}
		}
	}
