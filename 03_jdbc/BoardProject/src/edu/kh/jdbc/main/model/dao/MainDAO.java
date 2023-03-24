package edu.kh.jdbc.main.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import edu.kh.jdbc.member.model.dto.Member;
import static edu.kh.jdbc.common.JDBCTemplate.*;

public class MainDAO {
	//필드
	//JDBC객체 참조변수
	private Statement stmt; // SQL수행, 결과 반환
	private PreparedStatement pstmt; // placeholder를 포함한 SQL 세팅/수행
	private ResultSet rs; // SELECT 수행 결과 저장
	
	private Properties prop;
	// - Map<String, String>형태
	// - XML파일 입/출력 메서드 제공
	
	
	public MainDAO() { //기본생성자
		
		//DAO객체가 생성될 때 XML파일을 읽어와 Properties 객체가 저장
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("main-sql.xml"));
			// -> Properties객체에
			//	  key:value 형식으로 xml내용이 저장됨
			
			// -> prop.getProperties("key") 호출
			// --> value(SQL)반환
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	/** 아이디 비밀번호 일치 회원 조회
	 * @param conn
	 * @param memberId
	 * @param memberPw
	 * @return member
	 * @throws Exception
	 */
	public Member login(Connection conn, String memberId, String memberPw) throws Exception{
		
		// 1. 결과 저장용 변수/객체 생성
		Member member = null;
		
		
		try {
			// 2. SQL작성 후 수행
			String sql = prop.getProperty("login"); 
			
			// prepareStatement객체를 생성하고 SQL를 담아둠
			pstmt = conn.prepareStatement(sql);
			
			// placeholder에 알맞은 값 대입
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			rs = pstmt.executeQuery(); // SELECT 수행 후 결과 반환 받기
			
			// 3. 조회 결과를 1행씩 접근해서 얻어오기
			if(rs.next()){
				int memberNo = rs.getInt("MEMBER_NO");
				
				// String memberId = rs.getString("MEMBER_ID");
				// 입력 받은 아이디 == 조회한 아이디
				// -> DB에서 얻어올 필요가 없음
				
				String memberName = rs.getString("MEMBER_NM");
				String memberGender = rs.getString("MEMBER_GENDER");
				String enrollDate = rs.getString("ENROLL_DT");
				
				// Member 객체 생성 후 값 세팅
				member = new Member();
				
				member.setMemberNo(memberNo);
				member.setMemberId(memberId);
				member.setMemberName(memberName);
				member.setMemberGender(memberGender);
				member.setEnrollDate(enrollDate);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		// 5. 결과 반환
		return member;
	}


	/** 아이디 중복 검사 SQL수행
	 * @param conn
	 * @param memberId
	 * @return result
	 * @throws Exception
	 */
	public int idDuplicataionCheck(Connection conn, String memberId) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("idDuploicationCheck"); 
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
		
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}finally {
		close(rs);
		close(pstmt);
		}
		return result;
	}


	/** 회원 가입 SQL수행(INSERT)
	 * @param conn
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member member) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			
			// ?에 세팅
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberGender());
			
			// 수행 후 결과 반환
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	

}































