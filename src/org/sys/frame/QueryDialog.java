package org.sys.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sys.employee.Employee;
import org.sys.employee.EmployeeDao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

/*** 这个类用于查询员工信息
* @author Kuronitz
* @version 1.5
*/

public class QueryDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tf;
	private JTextArea textArea;

	public QueryDialog() {
		setVisible(true);
		setTitle("员工信息查询");
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
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
				int x=JOptionPane.showConfirmDialog(QueryDialog.this, "是否查询？", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
				if (x==JOptionPane.OK_OPTION) {
						JOptionPane.showConfirmDialog(QueryDialog.this, "查询成功", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
						QueryInf();
		         }else{
		             JOptionPane.showConfirmDialog(QueryDialog.this, "查询失败", "系统提示", JOptionPane.OK_CANCEL_OPTION,JOptionPane.CANCEL_OPTION);
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
	
	public void QueryInf(){
			List<Employee> list = EmployeeDao.getEmployeeList();
			List<Integer> listID = new ArrayList<Integer>();
          for (int a = 0; a < list.size(); a++) {
              listID.add(list.get(a).getNum());
          }
          for (int b = 0; b < list.size(); b++) {
              if (listID.contains(Integer.valueOf(tf.getText()))) {
                  if (Integer.valueOf(tf.getText()) == list.get(b).getNum()) {
                	  textArea.setText(null);
                	  textArea.append(list.get(b).toString());
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
