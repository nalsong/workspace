package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.dto.Emp;

public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	
	/**
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> selectAll(Connection conn) throws SQLException{
		
		List<Emp> empList = new ArrayList<>();
		
		try {
			
			String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, PHONE, EMAIL \r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)\r\n"
					+ "WHERE ENT_YN = 'N'\r\n"
					+ "ORDER BY DEPT_CODE";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String empId = rs.getString(1);
				String empName = rs.getString(2);
				String departmentTitle = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);
				
				Emp emp = new Emp(salary, empName, email, phone, salary, departmentTitle, jobName);
				
				empList.add(emp);
			}
		}finally {
			close(stmt);
			close(rs);
			
		}
		return empList;
	}

	


	/**
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> selectRetire(Connection conn) throws SQLException{
		
		List<Emp> empList = new ArrayList<>();
		
		try {
			String sql = "SELECT EMP_ID, EMP_NAME, PHONE, EMAIL, ENT_DATE\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "WHERE ENT_YN = 'Y'\r\n"
					+ "ORDER BY ENT_DATE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String empId = rs.getString(1);
				String empName = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				Date entDate = rs.getDate(5);
				
				
				Emp emp = new Emp(0, empName, email, phone, email);
				
				empList.add(emp);
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		
		return empList;
	}






	/**
	 * @param conn
	 * @param input
	 * @return
	 * @throws SQLException
	 */
	public Emp selectOne(Connection conn, int input) throws SQLException{
		
		Emp emp = null;
		
		try {
			
			String sql = "SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY, PHONE, EMAIL, ENT_YN\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "WHERE EMP_ID = " + input ;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				String empId = rs.getString(1);
				String empName = rs.getString(2);
				String jobName = rs.getString(3);
				int salary = rs.getInt(4);
				String phone = rs.getString(5);
				String email = rs.getString(6);
				String emtYN = rs.getString(7);
				
				emp = new Emp(empId, empName, jobName, salary, phone, email, emtYN);
			}
		}finally {
			close(rs);
			close(stmt);
		}
		return emp;
	}



	
	
	
	/**
	 * @param conn
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int insertEmployee(Connection conn, Emp emp) throws SQLException{
		
		int result = 0;
		
		try {
			String sql = "INSERT INTO EMPLOYEE VALUES( SEQ_EMP_ID.NEXTVAL, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, NULL, 'N' )";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpNo());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getPhone());
			pstmt.setString(5, emp.getDeptCode());
			pstmt.setString(6, emp.getJobCode());
			pstmt.setString(7, emp.getSalLevel());
			pstmt.setInt(8, emp.getSalary());
			pstmt.setDouble(9, emp.getBonus());
			pstmt.setInt(10, emp.getManagerId());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}	
		return result;
	}
	
	
	
	
	
	
	
	/**
	 * @param conn
	 * @param emp
	 * @return
	 */
	public int updateEmp(Connection conn, Emp emp) throws SQLException{
			
		int result = 0;
		
		try {
			String sql = "UPDATE EMPLOYEE \r\n"
					+ "SET EMAIL = ?,\r\n"
					+ "	PHONE = ?,\r\n"
					+ "	SALARY = ?,\r\n"
					+ "	BONUS = ?\r\n"
					+ "WHERE EMP_ID = ?";
				
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getEmail());
			pstmt.setString(2, emp.getPhone());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setInt(4, emp.getEmpId());
			pstmt.setDouble(5, emp.getBonus());
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}



	/**
	 * @param conn
	 * @param input
	 * @return
	 * @throws SQLException
	 */
	public int deleteEmp(Connection conn, int input) throws SQLException{
		int result = 0;
		
		try {
			// 2. SQL 작성 + PreparedStatement 객체 생성 후 값 세팅
			String sql = "DELETE FROM EMPLOYEE\r\n"
					+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);

			result = pstmt.executeQuery();
			
		}finally {
			close(pstmt);
		}
		return result;
	}




	/**
	 * @param conn
	 * @param input
	 * @return
	 * @throws SQLException
	 */
	public int retireEmp(Connection conn, int input) throws SQLException{
		int result = 0;
		
		try {
			
			// 2. SQL 작성 + PreparedStatement 객체 생성 후 값 세팅
			String sql = "UPDATE EMPLOYEE \r\n"
						+ "SET ENT_YN = 'Y',\r\n"
						+ "ENT_DATE = SYSDATE\r\n"
						+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			
			
			// 3. SQL 수행 후 결과 반환 받기
			result = pstmt.executeUpdate(); // 1행 성공, 0행 성공
			
		}finally {
			// 4. JDBC객체 자원 반환
			close(pstmt);
		}
		// 5.결과 반환
		return result;
	}
	
	
	
	
	
	
	
	
}





















