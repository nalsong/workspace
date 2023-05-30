package com.kh.test.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.user.model.service.UserService;
import com.kh.test.user.model.vo.User;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/selectNum")
	public String SelectUserNum(int inputNum, Model model) {
		
		List<User> user = service.SelectUserNum(inputNum);
		
		model.addAttribute("inputNum", inputNum);
		
		if(user == null) {
			return "/searchFail";
		}else {
			return "/searchSuccess";
		}
		
		
	}
	
	
}
