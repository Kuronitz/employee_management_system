package org.sys.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/*** 这个类用于提示删除成功，目前用不到了
* @author Kuronitz
* @version 1.5
*/

public class DelSuccess extends JDialog {


	private static final long serialVersionUID = -3873459171627392140L;
		private final JPanel contentPanel = new JPanel();

		public DelSuccess() {
			setVisible(true);
			setBounds(550, 300, 300, 115);
			this.setLocationRelativeTo(null);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setLayout(new FlowLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			{
				JLabel label = new JLabel("删除成功");
				contentPanel.add(label);
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("确认");
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							new MainUI();
						}
					});
				}
			}
		}

	}
