package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.Pagination;

@Repository
public class BoardDAO {

	// 마이바티스 객체(root-context.xml에서 bean등록)
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	/** 제시판 종류 목록 조회
	 * @return boardTypeList
	 */
	public List<Map<String, Object>> selectBoardTypeList() {
		
		return sqlSession.selectList("boardMapper.selectBoardTypeList");
	}


	/** 특정 게시판의 삭제되지 않은 게시글 수 조회
	 * @param boardCode
	 * @return listCount
	 */
	public int getListCount(int boardCode) {
		
		return sqlSession.selectOne("boardMapper.getListCount", boardCode);
	}


	/** 특정 게시판에서 현재 페이지에 해당하는 부분에 대한 게시글 목록 조회
	 * @param pagination
	 * @param boardCode
	 * @return 
	 */
	public List<Board> selectBoardList(Pagination pagination, int boardCode) {
		
		// RowBounds객체 : 마이바티스에서 페이징 처리를 위해 제공하는 객체
		//				  offset만큼 건너뛰고 그 다음 지정된 행 개수(limit)만큼 조회
		
		// 1) offset계산
		int offset = (pagination.getCurrentPage()-1) * pagination.getLimit();
		
		// 2) Rowbounds객체 생성
		RowBounds rowbounds = new RowBounds(offset, pagination.getLimit());
		
		// 3) selectList("namespace.id", 파라미터, Rowbounds) 호출
		return sqlSession.selectList("boardMapper.selectBoardList", boardCode, rowbounds);
	}
}















