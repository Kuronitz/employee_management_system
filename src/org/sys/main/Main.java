package org.sys.main;

import java.awt.EventQueue;

import javax.swing.UIManager;

import org.sys.frame.Login;

/*** 这个类是主类
* @author Kuronitz
* @version 1.5
*/

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
					UIManager.setLookAndFeel(lookAndFeel);
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
