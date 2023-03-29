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
	
	
	
	
		/** 다음 댓글 번호 조회SQL 수행
		 * @param conn
		 * @return commentNo
		 * @throws Exception
		 */
		public int nextCommentNo(Connection conn) throws Exception{
		
		int commentNo = 0;
		
		try {
			String sql = prop.getProperty("nextCommentNo");
			
			stmt = conn.createStatement();
			rs= stmt.executeQuery(sql);
			
			if(rs.next()) {
				commentNo = rs.getInt(1); //컬럼 순서
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		return commentNo;
	}
	
	
	
	/** 댓글 입력하기
	 * @param conn
	 * @param boardNo
	 * @param commentNo
	 * @param commentContent
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int insertComment(Connection conn, int commentNo, String commentContent, int memberNo) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertComment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, commentNo);
			pstmt.setString(2, commentContent);
			pstmt.setInt(3, memberNo);
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}


	
	
	

	/** 댓글 수정
	 * @param conn
	 * @param commentContent
	 * @param boardNo
	 * @return result
	 */
	public int updateBoard(Connection conn, String commentContent, int boardNo) throws Exception{
		
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateComment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, commentContent);
			pstmt.setInt(2, boardNo);
			
			
			result = pstmt.executeUpdate(); 
		}finally {
			close(pstmt);
		}
		return result;
	
	}
	
	
	
	
	
	
	
	
	
}








































