package org.sys.employee;

import java.util.ArrayList;
import java.util.List;

/*** 这个类用于保存员工数据
* @author Kuronitz
* @version 1.5
*/

public class EmployeeDao {
	private static List<Employee> employeeList;

	static {
		employeeList = new ArrayList<Employee>();
	}

	public static List<Employee> getEmployeeList() {
		return employeeList;
	}

	public static void setEmployeeList(List<Employee> employeeList) {
		EmployeeDao.employeeList = employeeList;
	}

	public static Employee addEmployee(Employee employee) {
		Employee ret = null;
		employeeList.add(employee);
		ret = employee;
		return ret;
	}

	public static boolean selectGH(Integer gh) {
		boolean ret = false;
		for (Employee e : employeeList) {
			if (e.getNum().equals(gh)) {
				ret = true;
				break;
			}
		}
		return ret;
	}
}
