package org.sys.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sys.employee.Employee;
import org.sys.employee.EmployeeDao;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*** 这个类用于输出员工信息，统计信息
* @author Kuronitz
* @version 1.5
*/

public class StaDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public StaDialog() {
		setVisible(true);
		setTitle("员工信息统计");
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				JTextArea textArea = new JTextArea();
				textArea.setLineWrap(true);
				scrollPane.setViewportView(textArea);
				List<Employee> list = EmployeeDao.getEmployeeList();
				for(int i=0;i<list.size();i++){
					textArea.append(list.get(i).toString()+"\n");;
				}
			}
		}
	}

}
