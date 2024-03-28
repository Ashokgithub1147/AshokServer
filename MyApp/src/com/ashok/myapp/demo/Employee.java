package com.ashok.myapp.demo;

public class Employee {

	private String name;
	private int age;
	private int departmentId;
	private int yearsOfExperience;
	
	//This field was used only to store departmentName to display departmentName in 
	//employee object to users
	private String departmentName;
	public Employee() {
		super();
	}

	public Employee(String name, int age, int departmentId, int yearsOfExperience) {
		super();
		this.name = name;
		this.age = age;
		this.departmentId = departmentId;
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", departmentId=" + departmentId + ", yearsOfExperience="
				+ yearsOfExperience + ", departmentName=" + departmentName + "]";
	}	
}
