package edu.kh.jdbc.dto;


// DTO (Data Transfer Object) : 값 전달용 객체
public class Employee1 {
	
	private String empId;
	private String empName;
	private int salary;
	private String DepartmentTitle;
	
	
	public Employee1() {} // 기본 생성자
	
	public Employee1(String empId, String empName, int salary, String DepartmentTitle) { // 매개변수 생성자
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.DepartmentTitle = DepartmentTitle;
	}
	
	
	// getter / setter
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartmentTitle() {
		return DepartmentTitle;
	}

	public void setDepartmentTitle(String departmentTitle) {
		DepartmentTitle = departmentTitle;
	} 
	
}




























































