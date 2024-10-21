package org.sys.employee;

/*** 这个类是员工类
* @author Kuronitz
* @version 1.5
*/

public class Employee {
	private Integer num;// 员工号
	private String name;// 姓名
	private Boolean sex;// 性别
	private Integer age;// 年龄
	private Boolean hobby1;// 爱好
	private Boolean hobby2;// 爱好
	private Boolean hobby3;// 爱好
	private Boolean hobby4;// 爱好   
	private String cate;// 员工类别
	private String synopsis;// 个人简介

	public Employee() {
		this("未知", true, 0, "普通员工");
	}

	public Employee(String name, Boolean sex, Integer age, String cate) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.cate = "普通员工";
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getHobby1() {
		return hobby1;
	}

	public void setHobby1(Boolean hobby1) {
		this.hobby1 = hobby1;
	}

	public Boolean getHobby2() {
		return hobby2;
	}

	public void setHobby2(Boolean hobby2) {
		this.hobby2 = hobby2;
	}

	public Boolean getHobby3() {
		return hobby3;
	}

	public void setHobby3(Boolean hobby3) {
		this.hobby3 = hobby3;
	}

	public Boolean getHobby4() {
		return hobby4;
	}

	public void setHobby4(Boolean hobby4) {
		this.hobby4 = hobby4;
	}

	public String getCate() {
		return cate;
	}	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("\n工号："+getNum());
		sb.append("\n姓名："+getName());
		sb.append("\n年龄："+getAge());
		sb.append("\n性别："+(getSex()?"男":"女"));
		sb.append("\n职务："+getCate());
		sb.append("\n爱好：");
		if(hobby1!=null && hobby1.booleanValue())sb.append("唱歌  ");
		if(hobby2!=null && hobby2.booleanValue())sb.append("跳舞  ");
		if(hobby3!=null && hobby3.booleanValue())sb.append("篮球  ");
		if(hobby4!=null && hobby4.booleanValue())sb.append("说唱");
		sb.append("\n简介："+getSynopsis());
		return sb.toString();
	}
}
