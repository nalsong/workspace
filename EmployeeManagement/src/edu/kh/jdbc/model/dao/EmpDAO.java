package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dto.Emp;

public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	
	/** 재직중인 사원 전체 조회 SQL수행 후 결과 반환
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectAll(Connection conn) throws SQLException{
		
		List<Emp> empList = new ArrayList<>();
		
		try {
			
			String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, PHONE, EMAIL \r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)\r\n"
					+ "WHERE ENT_YN = 'N'\r\n"
					+ "ORDER BY JOB_CODE";
			
		
						stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String departmentName = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				
				Emp emp = new Emp();
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setDepartmentTitle(departmentName);
				emp.setJobName(jobName);
				emp.setSalary(salary);
				emp.setPhone(phone);
				emp.setEmail(email);
				
				empList.add(emp);
			}
		}finally {
			close(rs);
			close(stmt);
		}
		return empList;
	}

	


	/** 퇴직한 사원 전체 조회 SQL수행 후 결과 반환
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectRetire(Connection conn) throws SQLException{
		
		List<Emp> empList = new ArrayList<>();
		
		try {
			String sql = "SELECT EMP_ID, EMP_NAME, PHONE, EMAIL, "
					+ "TO_CHAR(ENT_DATE, 'YYYY\"년\" MM\"월\" DD\"일\"') ENT_DATE \r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "WHERE ENT_YN = 'Y'\r\n"
					+ "ORDER BY ENT_DATE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String entDate = rs.getString(5); // TO_CHAR로 형변환 해서 조회
				
				
				Emp emp = new Emp();
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setPhone(phone);
				
				empList.add(emp);
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		
		return empList;
	}






	/** 사번이 일치하는 사원 조회 SQL수행 후 결과 반환
	 * @param conn
	 * @param input
	 * @return emp
	 * @throws SQLException
	 */
	public Emp selectOne(Connection conn, int input) throws SQLException{
		
		Emp emp = null;
		
		try {
			
			String sql = "SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, SALARY, PHONE, EMAIL, HIRE_DATE, ENT_YN\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) "
					+ "WHERE EMP_ID = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				emp = new Emp();

				emp.setEmpId(rs.getInt("EMP_ID"));
				emp.setEmpName(rs.getString("EMP_NAME"));
				emp.setJobName(rs.getString("JOB_NAME"));
				emp.setDepartmentTitle(rs.getString("DEPT_TITLE"));
				emp.setSalary(rs.getInt("SALARY"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPhone(rs.getString("PHONE"));
				emp.setHireDate(rs.getDate("HIRE_DATE"));
				emp.setEntYN(rs.getString("ENT_YN"));
			}
		}finally {
			close(rs);
			close(stmt);
		}
		return emp; // 조회결과가 있으면 null이 아님
					// 조회결과가 없으면 null
	}



	
	
	
	
	/** 사원 추가 SQL수행 후 결과 반환
	 * @param conn
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int insertEmployee(Connection conn, Emp emp) throws SQLException{
		
		int result = 0;
		
		try {
			String sql = "INSERT INTO EMPLOYEE VALUES( SEQ_EMP_ID.NEXTVAL, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, NULL, 'N' )";
			// ORA-02289: 시퀀스가 존재하지 않습니다.
			
			
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
	
	
	
	
	
	
	/**  사번으로 사원 정보 수정 SQL수행 후 결과 반환
	 * @param conn
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int updateEmp(Connection conn, Emp emp) throws SQLException{
		
		// 1. 결과 저장용 변수/ 객체 선언
		int result = 0;
		
		
		try {
			// 2. SQL구문 작성
			// PrepaerdStatement / Statement생성
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
			
			
			// 3. 수행 후 결과 반환 받아 결과 저장용 변수에 저장
			// SELECT문 : executeQuery([SQL])
			// DML문 : executeUpdate([SQL])
			// [SQL] 작성하는 경우 : Statememt 객체 사용 할 때
			result = pstmt.executeUpdate();
			
			
		}finally {
			// 4. JDBC 객체 자원 반환
			close(pstmt);
		}
		// 5. 결과 반환
		return result;
	}



	/** 사번으로 사원 정보 삭제 SQL수행 후 결과 반환
	 * @param conn
	 * @param input
	 * @return result
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

			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}




	/** 퇴직처리 SQL 수행
	 * @param conn
	 * @param input
	 * @throws SQLException
	 */
	public void retireService(Connection conn, int input) throws SQLException{
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
			pstmt.executeQuery(); // 1행 성공, 0행 성공
			
		}finally {
			// 4. JDBC객체 자원 반환
			close(pstmt);
		}
	}




	/** 존재하는 사원인지, 퇴직한 사원인지 조회하는 SQL수행 후 결과 반환
	 * @param conn
	 * @param input
	 * @return check
	 * @throws SQLException
	 */
	public int checkEmployee(Connection conn, int input) throws SQLException{
		
		int check = 0;
		
		try {
			
			String sql = "SELECT CASE \r\n"
					+ "		WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = ?) = 0\r\n"
					+ "		THEN 0\r\n"
					+ "		WHEN (SELECT COUNT(*) FROM EMPLOYEE \r\n"
					+ "				WHERE EMP_ID = ? AND ENT_YN = 'Y') = 1\r\n"
					+ "		THEN 1\r\n"
					+ "		ELSE 2\r\n"
					+ "	END \"CHECK\"\r\n"
					+ "FROM DUAL";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			pstmt.setInt(2, input);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = rs.getInt("CHECK");
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return check;
	}




	/** 부서별 통계 조회 SQL수행 후 결과 반환
	 * @param conn
	 * @return matList
	 * @throws SQLException
	 */
	public List<Map<String, Object>> selectDepartment(Connection conn) throws SQLException{
		
		// 1. 결과 저장용 객체 생성
		List<Map<String, Object>> mapList = new ArrayList<>();
		
		try {
			// 2. SQL작성 후 수행
			String sql = "SELECT DEPT_CODE, NVL(DEPT_TITLE,'부서없음') DEPT_TITLE, COUNT(*) 인원, FLOOR(AVG(SALARY)) 평균\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "GROUP BY DEPT_CODE, DEPT_TITLE\r\n"
					+ "ORDER BY DEPT_CODE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String deptTitle = rs.getString("DEPT_TITLE");
				int count = rs.getInt("인원");
				int avg = rs.getInt ("평균");
				
				Map<String, Object> map = new LinkedHashMap<>();
				
				map.put("deptTitle", deptTitle);
				map.put("count", count);
				map.put("avg", avg);
				
				mapList.add(map);
				
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		// 5. 결과 반환
		return mapList;
	}
	
}























































