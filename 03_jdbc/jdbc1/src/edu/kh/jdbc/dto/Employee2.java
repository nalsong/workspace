package edu.kh.jdbc.dto;

public class Employee2 {
	
	// 부서명, 직급명, 이름, 이메일
	
	private String deptTitle;
	private String jabName;
	private String empName;
	private String email;
	
	
	
	public Employee2() {}

	
	
	public Employee2(String deptTitle, String jabName, String empName, String email) {
		this.deptTitle = deptTitle;
		this.jabName = jabName;
		this.empName = empName;
		this.email = email;
	}

	
	
	public String getDeptTitle() {
		return deptTitle;
	}

	public void setDeptTitle(String deptTitle) {
		this.deptTitle = deptTitle;
	}

	public String getJabName() {
		return jabName;
	}

	public void setJabName(String jabName) {
		this.jabName = jabName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Employee2 [deptTitle=" + deptTitle + ", jabName=" + jabName + ", empName=" + empName + ", email="
				+ email + "]";
	}
	
	
	
	
	
	
	
	
	

}
