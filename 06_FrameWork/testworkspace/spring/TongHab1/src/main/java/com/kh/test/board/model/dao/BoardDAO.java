package com.kh.test.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.test.board.model.vo.Board;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sql;

	public List<Board> search(String boardTitle) {
		
		return sql.selectList("boardMapper.search", boardTitle);
	}
	
}
