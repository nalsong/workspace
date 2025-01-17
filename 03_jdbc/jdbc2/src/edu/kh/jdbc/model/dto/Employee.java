package edu.kh.jdbc.model.dto;


// DTO (Data Transfer Object) : 값 전달용 객체
public class Employee {
	
		private int empId;       // 사원 번호(사번)
		private String empName; // 사원 이름
		private String empNo;    // 주민등록번호
		private String email;    // 이메일
		private String phone;    // 전화번호
		private String departmentTitle; // 부서명
		private String jobName; // 직급명
		private int salary;    // 급여
		private String deptCode; // 부서코드
		private String jobCode; // 직급코드
		private String salLevel; // 급여등급
		private double bonus; // 보너스
		private int managerId; // 사수번호
	   
		
	public Employee() { // 기본생성자
		
	}

	
	// 매개변수 생성자
	public Employee(int empId, String empName, String phone, String departmentTitle, String jobName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.phone = phone;
		this.departmentTitle = departmentTitle;
		this.jobName = jobName;
	}

	
	
	// 5. 사원 정보 추가(insertEmployee)에 필요한 매개변수 담기~~~
	
	public Employee(String empName, String empNo, String email, String phone, int salary, String deptCode,
			String jobCode, String salLevel, double bonus, int managerId) {
		super();
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
		this.bonus = bonus;
		this.managerId = managerId;
	}

	

	// getter/setter
	public int getEmpId() {
		return empId;
	}

	
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	
	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpNo() {
		return empNo;
	}


	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getDepartmentTitle() {
		return departmentTitle;
	}


	public void setDepartmentTitle(String departmentTitle) {
		this.departmentTitle = departmentTitle;
	}


	public String getJobName() {
		return jobName;
	}


	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getDeptCode() {
		return deptCode;
	}


	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}


	public String getJobCode() {
		return jobCode;
	}


	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}


	public String getSalLevel() {
		return salLevel;
	}


	public void setSalLevel(String salLevel) {
		this.salLevel = salLevel;
	}


	public double getBonus() {
		return bonus;
	}


	public void setBonus(double bonus) {
		this.bonus = bonus;
	}


	public int getManagerId() {
		return managerId;
	}


	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
}




































