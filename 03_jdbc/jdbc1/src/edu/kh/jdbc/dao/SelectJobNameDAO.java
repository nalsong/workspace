package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.dto.Employee2;

public class SelectJobNameDAO {
	
//	public 반환형 select(매개변수) {
//		return 변수명;
//	}
	
	
	
	public List<Employee2> select(String SelectJobName) {
		
		List<Employee2> empList = new ArrayList<>(); 
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost"; 
			String port = ":1521";
			String dbName = ":ORCL";
			String user = "kh_jsy";
			String pw = "oracle_jsy123A";
			
			conn = DriverManager.getConnection(type + ip + port + dbName + user + pw); 
		
			
			
			String sql = " SELECT NVL(DEPT_TITLE, '부서없음'), JOB_NAME, EMP_NAME, EMAIL  "
					+ "FROM EMPLOYEE "
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) "
					+ "JOIN JOB USING (JOB_CODE) "
					+ "WHERE JOB_NAME = '" + input + "'"
					+ "ORDER BY EMP_NAME";
			
			
			
			stmt = conn.createStatement(); // Statement 객체 생성
			
			rs = stmt.executeQuery(sql); // SELECT 수행 후 결과 반환 받기
			
			
			
			while(rs.next()) { // 커서를 1행씩 이동. 다음 행이 없을 때 까지 
				
				String deptTitle = rs.getString("SELECT NVL(DEPT_TITLE, '부서없음')");
				String jabName = rs.getString("JOB_NAME"); // 조회 결과 컬럼 순서
				String empName = rs.getString("EMP_NAME"); 				
				String email = rs.getNString("EMAIL");
				
				// 조회된 컬럼 값을 Employee1 객체에 저장
				Employee2 emp = new Employee2(deptTitle, jabName, empName, email);
				
				// 컬럼 값이 저장된 객체를 empList에 추가
				empList.add(emp);
				
			}
			
			
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if( rs != null) rs.close();
				if( stmt != null) stmt.close();
				if( conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return empList;
		
	}

}


















