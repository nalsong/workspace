package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.jdbc.model.dao.EmpDAO;
import edu.kh.jdbc.model.dto.Emp;

public class EmpService {

	private EmpDAO dao = new EmpDAO();

	
	
	
	
	
	/**
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> selectAll() throws SQLException{
		
		Connection conn = getConnection();
		
		List<Emp> empList = dao.selectAll(conn);
		
		close(conn);
		
		
		return empList;
	}






	/**
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> selectRetire() throws SQLException{
		
		Connection conn = getConnection();
		
		List<Emp> empList = dao.selectRetire(conn);
		
		close(conn);
		
		return empList;
	}






	/**
	 * @param input
	 * @return
	 * @throws SQLException
	 */
	public Emp selectOne(int input) throws SQLException{
		Connection conn = getConnection();
		
		Emp emp = dao.selectOne(conn, input);
		
		close(conn);
		
		return emp;
	}






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






	public int updateEmp(Emp emp) throws SQLException{
		
		Connection conn = getConnection();
		
		// 2. DAO메서드 호출 후 결과 반환 받기
		int result = dao.updateEmp(conn, emp);
		
		// 3. 트랜잭션 제어 처리 
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		// 4. 커넥션 반환
		close(conn);
		
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






	public int retireEmp(int input) throws SQLException{
		
		Connection conn = getConnection();
		
		// 2. DAO메서드 호출 후 결과 반환 받음
		int result = dao.retireEmp(conn, input);
				
		// 3. 트랜잭션 제어 처리
		if(result > 0)  commit(conn);
		else 			rollback(conn);
			
		// 4. 커넥션 반환
		close(conn);	
		
		return result;
	}

	
	
	
	
	
	
}
