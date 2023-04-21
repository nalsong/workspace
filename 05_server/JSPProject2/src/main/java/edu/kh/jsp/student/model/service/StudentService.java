package edu.kh.jsp.student.model.service;
import static edu.kh.jsp.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.jsp.student.model.dao.StudentDAO;
import edu.kh.jsp.student.model.dto.Student;

public class StudentService {

	private StudentDAO dao = new StudentDAO();
	
	
	
//	학생 전체조회
	
	public List<Student> selectAll() throws SQLException{
		// 1. Connection생성
		Connection conn = getConnection();
			
		//2. DAO호출
		List<Student> stdList = dao.selectAll(conn);
		
		// 3. 트랜젝션 처리 필요 없음 
				
				
		//4. 반환
		close(conn);
				
		//5. 결과 반환
		return stdList;
		
	}

}
