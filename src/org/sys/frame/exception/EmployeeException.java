package org.sys.frame.exception;

/*** 这个类用于输出错误
* @author Kuronitz
* @version 1.5
*/

public class EmployeeException extends RuntimeException {
	private static final long serialVersionUID = 4114979120038242193L;

	public EmployeeException(String message) {
		super(message);
	}
}
