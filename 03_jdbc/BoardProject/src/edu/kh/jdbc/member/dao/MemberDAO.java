package edu.kh.jdbc.member.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.member.model.dto.Member;

public class MemberDAO {
	
	
	// JDBC 객체 참조 변수
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// xml에 작성된 SQL을 읽어와 저장할 객체 참조 변수
	private Properties prop;

	public MemberDAO() { //기본생성자로 객체 생성 시 XML 읽어오기
		try {
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream("member-sql.xml"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}


	/** 회원 목록 조회 SQL 수행
	 * @param conn
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectMemberList(Connection conn) throws Exception{
		// 결과 저장용 변수 선언 / 객체 생성
				
		List<Member> memberList = new ArrayList<>();
		
		
		try {
			
			String sql = prop.getProperty("selectMemberList"); 
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				String memberId = rs.getString("MEMBER_ID");
				String memberName = rs.getString("MEMBER_NM");
				String memberGender = rs.getString("성별"); // ResultSet의 컬럼명 작성
				
				// 컬럼 값을 Member객체에 저장
				Member member = new Member();
				
				member.setMemberId(memberId);
				member.setMemberName(memberName);
				member.setMemberGender(memberGender);
				
				// Member객체를 List에 추가
				memberList.add(member);
			}
		}finally {
			close(rs);
			close(stmt);
		}
		return memberList;
	}

	
	

	/** 회원정보 수정 SQL수행
	 * @param conn
	 * @param memberName
	 * @param memberGender
	 * @param memberNo
	 * @return result
	 */
	public int updateMember(Connection conn, String memberName, String memberGender, int memberNo) throws Exception {
		
		
		// 결과 저장용 변수
		int result = 0;
			//2 sql작성, 수행
			
		try {
			String sql = prop.getProperty("updateMember"); 
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberName);
			pstmt.setString(2, memberGender);
			pstmt.setInt(3, memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	/** 비밀번호 변경 sql수행
	 * @param conn
	 * @param userPw
	 * @param uewPassword1
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int updatePassword(Connection conn, String userPw, String uewPassword1, int memberNo) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updatePassword");
			pstmt = conn.prepareStatement(sql);	
			
			pstmt.setString(1, uewPassword1);
			pstmt.setString(2, userPw);
			pstmt.setInt(3, memberNo);
			
			result = pstmt.executeUpdate();
		
			
		}finally {
			close(pstmt);
		}
		return result;
	}


	
	
	
	
	/**회원탈퇴 sql수행
	 * @param conn
	 * @param memberPw
	 * @param memberNo
	 * @return result
	 */
	public int unRegisterMember(Connection conn, String memberPw, int memberNo) throws SQLException{
		
		int result = 0;
		try {
			String sql = prop.getProperty("unRegisterMember");
			pstmt = conn.prepareStatement(sql);	
			
			
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, memberPw);
			
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}



	
	
	
	
	
}































