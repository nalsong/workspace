package com.kh.test.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.board.model.service.BoardService;
import com.kh.test.board.model.vo.Board;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;

	
	@GetMapping("/index")
	public List<Board> search(String boardTitle){
		
		List<Board> boardList = service.search(boardTitle);
		
		
		
		
		String a = "rediect:";
		
		if(boardTitle=="마지막") {
			a += "/searchFall";
			
		}else {
			a += "/searchSuccess";
		}
		
		return a;
	}
	
};
