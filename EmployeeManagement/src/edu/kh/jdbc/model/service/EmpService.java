package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dao.EmpDAO;
import edu.kh.jdbc.model.dto.Emp;

public class EmpService {

	private EmpDAO dao = new EmpDAO();

	
	
	
	
	
	/** 재직중인 사원 정보 반환 서비스
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> selectAll() throws SQLException{
		
		Connection conn = getConnection();
		
		List<Emp> empList = dao.selectAll(conn);
		
		close(conn);
		
		
		return empList;
	}






	/** 퇴직한 사원 정보 반환 서비스
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectRetire() throws SQLException{
		
		Connection conn = getConnection();
		
		List<Emp> empList = dao.selectRetire(conn);
		
		close(conn);
		
		return empList;
	}






	/** 사번이 일치하는 사원 정보 반환 서비스
	 * @param input
	 * @return emp
	 * @throws SQLException
	 */
	public Emp selectOne(int input) throws SQLException{
		Connection conn = getConnection();
		
		Emp emp = dao.selectOne(conn, input);
		
		close(conn);
		
		return emp;
	}






	/**
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int insertEmp(Emp emp) throws SQLException{
		
		Connection conn = getConnection();
		
		int result = dao.insertEmployee(conn, emp);
		
		
		if(result > 0) // 삽입 성공 시
			commit(conn);
		else // 삽입 실패 시
			rollback(conn);
		
		close(conn);
		
		return result;
	}






	/** 사번으로 사원 정보 수정 서비스
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int updateEmp(Emp emp) throws SQLException{
		  // 반환형이 int인 이유?
		  // -> DML 수행 결과는 반영된 (성공) 행의 개수 반환
		  // --> 행의 개수는 정수형 --> int 사용
		
		Connection conn = getConnection();
		
		// 2. DAO메서드 호출 후 결과 반환 받기
		int result = dao.updateEmp(conn, emp);
		
		
		// DML수행 -> 트랜잭션 처리
		// 3. 트랜잭션 제어 처리 
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		// 4. 커넥션 반환
		close(conn);
		
		
		//결과 반환
		return result;
	}






	/**
	 * @param input
	 * @return
	 * @throws SQLException
	 */
	public int deleteEmp(int input) throws SQLException{

		Connection conn = getConnection();
		
		int result = dao.deleteEmp(conn, input);
		
		if(result > 0)  commit(conn);
		else 			rollback(conn);
			
		// 4. 커넥션 반환
		close(conn);		
		
		
		return result;
	}

	

	/** 존재하는 사원인지, 퇴직한 사원인지 결과를 반환하는 서비스
	 * @param input
	 * @return check (0: 없는 사원, 1: 퇴직한 사원, 2: 재직중인 사원)
	 * @throws SQLException
	 */
	public int checkEmployee(int input) throws SQLException{
		
		Connection conn = getConnection();
		
		int check = dao.checkEmployee(conn, input);
		
		close(conn);
		
		return check;
	}
	
	



	/** 퇴직처리 서비스
	 * @param input
	 * @throws SQLException
	 */
	public void retireEmp(int input) throws SQLException{
		
		Connection conn = getConnection();
		
		// 2. DAO메서드 호출 후 결과 반환 받음
		dao.retireService(conn, input); // 성공 또는 예외
				 
		// 3. 트랜잭션 제어 처리
		// DB예외 발생 시 SQL수행이 정상적으로 진행되지 않음
		commit(conn);
		
			
		// 4. 커넥션 반환
		close(conn);	
		
		
	}






	/** 부서별 통계 조회 서비스
	 * @return mapList
	 * @throws SQLException
	 */
	public List<Map<String, Object>> selectDepartment() throws SQLException{
		
		Connection conn = getConnection();
		
		List<Map<String, Object>> mapList = dao.selectDepartment(conn);
		
		close(conn);
		
		return mapList;
		
		

	}







	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
}
