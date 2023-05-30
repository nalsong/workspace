package com.kh.test.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.test.user.model.service.UserService;
import com.kh.test.user.model.vo.User;


@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	
	@PostMapping("/index")
	public List<User> search(String userId, Model model){
		
		List<User> user = service.search(userId);	
		
		String a =  null;
		
		if(userId == null) {
			
		}else {
			
		}
		
		return a;
	}

}
