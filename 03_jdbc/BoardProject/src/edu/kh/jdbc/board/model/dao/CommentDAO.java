package edu.kh.jdbc.board.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static edu.kh.jdbc.common.JDBCTemplate.*;
import edu.kh.jdbc.board.model.dto.Comment;


public class CommentDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	
	public CommentDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("Comment-sql.xml"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/** 댓글 조회
	 * @param conn
	 * @param input
	 * @return commentList
	 * @throws Exception
	 */
	public List<Comment> selectCommentList(Connection conn, int input) throws Exception{
		
		List<Comment> commentList = new ArrayList<>();
		try {
			String sql = prop.getProperty("selectCommentList");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  input);;
			
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Comment c = new Comment();
				
				c.setCommentNo(rs.getInt(1));
				c.setCommentContent(rs.getString(2));
				c.setMemberNo(rs.getInt(3));
				c.setMemberName(rs.getString(4));
				c.setCreateDate(rs.getString(5));
				
				commentList.add(c); //리스트에 추가
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return commentList;
	}
	
	

	
	
	
	/** 댓글 등록 SQL 수행
	 * @param conn
	 * @param boardNo
	 * @param commentContent
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int insertComment(Connection conn, int boardNo, String commentContent, int memberNo) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertComment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, commentContent);
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, boardNo);
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	/** 댓글 확인 SQL수행
	 * @param conn
	 * @param commentNo
	 * @param boardNo
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public int checkCommentNo(Connection conn, int commentNo, int boardNo, int memberNo) throws Exception{

		int check = 0;

		try {
			String sql = prop.getProperty("checkCommentNo");

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentNo);
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, boardNo);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = rs.getInt(1);
			}

		}finally {
			close(pstmt);
		}

		return check;
	}

	
	
	

	/** 댓글 수정
	 * @param conn
	 * @param commentContent
	 * @param commentNo
	 * @return result
	 */
	public int updateBoard(Connection conn, int commentNo, String commentContent) throws Exception{
		
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateComment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, commentContent);
			pstmt.setInt(2, commentNo);
			
			
			result = pstmt.executeUpdate(); 
		}finally {
			close(pstmt);
		}
		return result;
	
	}



	public int deleteComment(Connection conn, int commentNo) throws Exception{
		
		int result = 0; // 결과 저장용 변수
		
		try {
			String sql = prop.getProperty("deleteBoard");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, commentNo);

			result = pstmt.executeUpdate();
							// DDL(CREATE, ALTER, DROP) 수행도 가능
							// 결과로 -1 반환
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
	

	
	
	
}








































