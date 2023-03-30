package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.board.model.dto.Comment;
import edu.kh.jdbc.board.model.dao.CommentDAO;
public class CommentService {

	private CommentDAO dao = new CommentDAO();
	
	
	
	/** 댓글 등록 서비스
	 * @param boardNo
	 * @param commentContent
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int insertComment(int boardNo, String commentContent, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.insertComment(conn, boardNo, commentContent, memberNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	
	
	
	/** 댓글 확인 서비스
	 * @param commentNo
	 * @param boardNo
	 * @param memberNo
	 * @return check
	 * @throws Exception
	 */
	public int checkCommentNo(int commentNo, int boardNo, int memberNo) throws Exception{
		
		Connection conn = getConnection();

		int check = dao.checkCommentNo(conn, commentNo, boardNo, memberNo);

		close(conn);

		return check;
	}





	/** 댓글 수정하기
	 * @param string
	 * @param commentNo
	 * @return result
	 * @throws Exception
	 */
	public int updateComment(int commentNo, String commentContent) throws Exception{
		
		Connection conn = getConnection();
		
		//게시글 수정 DAO호출
		int result = dao.updateBoard(conn, commentNo, commentContent);
		
		//트랜잭션 처리
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}





	/** 게시글 삭제
	 * @param commentNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteComment(int commentNo) throws Exception{
		

		Connection conn = getConnection();
		
		int result = dao.deleteComment(conn, commentNo);
		
		if(result>0) commit(conn);
		else	rollback(conn);
		
		close(conn);
		
		return result;
		
	}










	
	
	
	


}








































