package edu.kh.jdbc.member.service;

import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Random;

import edu.kh.jdbc.member.dao.MemberDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	
	
	
	/** 회원 목록 조회 서비스
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectMemberList() throws Exception{
		
		Connection conn = getConnection();
		
		List<Member> memberList = dao.selectMemberList(conn);
		
		close(conn);
		
		return memberList;
	}
	
	
	
	
	/**
	 * @param memberName
	 * @param memberGender
	 * @param memberNo
	 * @return result
	 */
	public int updateMember(String memberName, String memberGender, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		// dao호출 후 결과 반환
		int result = dao.updateMember(conn, memberName, memberGender, memberNo);
		
		// 트랜젝션 처리
		if(result>0) commit(conn);
		else		rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
	
	
	
	/** 비밀번호 변경 서비스
	 * @param userPw
	 * @param uewPassword1
	 * @param memberNo
	 * @return result
	 */
	public int updatePassword(String userPw, String uewPassword1, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updatePassword(conn, userPw, uewPassword1, memberNo);
		
		if(result>0) commit(conn);
		else		 rollback(conn);
		
		close(conn);
		
		return result;
	}



	/** 숫자 6자리 보안 코드 생성 서비스
	 * @return code
	 */
	public String createSecurityCode() {
		
		StringBuffer code = new StringBuffer();
		// String : 불변성 -> 변하지 않음
		// StringBuffer : 가변성 -> 변경 가능
		
		Random ran = new Random(); //난수 생성 객체
		
		
		for( int i=0 ; i<6; i++) {
			int x = ran.nextInt(10); // 0이상 10 미만 정수
			code.append(x); // StringBuffer 마지막에 추가(뒤에 이어 붙임)
		}
		return code.toString();
		
	}




	/** 회원탈퇴 서비스
	 * @param memberPw
	 * @param memberNo
	 * @return result
	 */
	public int unRegisterMember(String memberPw, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.unRegisterMember(conn, memberPw, memberNo);
		
		if(result>0) commit(conn);
		else		 rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	
	
	
	
	
	

}
























