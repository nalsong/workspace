package edu.kh.jdbc.board.model.dto;

import java.util.List;

// DTO
// Data Transfer Object : 
public class Board {
	
	private int boardNo; 
	private String boardTitle;
	private String boardContent;
	private String CreateDate;
	private int readCount;
	private int memberNo; //회원번호(작성자)
	private String memberName; //회원이름
	private int commentCount; //댓글 수
	
	private List<Comment> commentList;
	
	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public Board() {}//기본생성자

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(String CreateDate) {
		this.CreateDate = CreateDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	
	
	
	
}
