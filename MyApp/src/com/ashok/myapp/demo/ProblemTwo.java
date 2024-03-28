package com.ashok.myapp.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemTwo {

	public static void main(String[] args) {
		
		/** Problem statement-2
		 * we have 2 collections Employee name with columns
		 * name
		 * age
		 * departmentid
		 * yoe (years of experience)
		 * 
		 * another table department with columns
		 * departmentid
		 * departmentname
		 * location
		 * using lamdas can we find all employees with age in department greater than 30 years and have their deparment names as well 
		 **/
		//List of employees
		List<Employee> employeesList = Arrays.asList(
				new Employee("John", 40, 1, 4),
				new Employee("Sam", 20, 2, 2),
				new Employee("Kiran", 30, 3, 3),
				new Employee("Srikanth", 35, 2, 5)
		);
		//List of departments
		List<Department> departmentsList=Arrays.asList(
				new Department(1, "IT", "Hyderabad"),
				new Department(2, "DevOps", "Bangalore"),
				new Department(3, "QA", "Chennai")
		);
		/**
		 * Here I had collected Employee Name, DepartmentId, YearsOfExperience and DepartmentName
		 * as String and added to result  of String type
		 */
		System.out.println("\nApproach 1: Without adding departmentName in Employee class\n");
		List<String> result = employeesList.stream()
			.filter(emp->emp.getAge()>30)
			.map(employee->{
				String departmentName = departmentsList.stream()
						.filter(dept->dept.getDepartmentId()==employee.getDepartmentId())
						.map(Department::getDepartmentName)
						.findFirst()
						.orElse("");
				return String.format("Name:%s, Age:%d, DepartmentId:%d, YearsOfExperience:%d, DepartmentName:%s ",
				employee.getName(),employee.getAge(),employee.getDepartmentId(),
				employee.getYearsOfExperience(),departmentName);
		}).collect(Collectors.toList());
		//printing result to console
		result.forEach(System.out::println);
		/**
		 * Here I had taken one extra variable in Employee class named departmentName to store 
		 * departmentName in employee object and collected the result to res List of Employee type
		 */
		System.out.println("\nApproach 2: By adding departmentName additionally in Employee class\n");
		List<Employee> res = employeesList.stream()
			.filter(emp->emp.getAge()>30)
			.map(employee->{
				String departmentName = departmentsList.stream().filter(dept->dept.getDepartmentId()==employee.getDepartmentId()).
				map(Department::getDepartmentName).findFirst().orElse("");
				employee.setDepartmentName(departmentName);
				return employee;
		}).collect(Collectors.toList());
		//printing result to console
		res.forEach(System.out::println);
	}
}
