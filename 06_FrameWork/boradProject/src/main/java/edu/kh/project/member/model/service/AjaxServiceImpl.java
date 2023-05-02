package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dao.AjaxDAO;

@Service // 서비스 임을 명시 +bean등록
public class AjaxServiceImpl implements AjaxService{
	
	 @Autowired //DI
	 private AjaxDAO dao;
	
	 
	 @Override
	public String selectNickname(String email) {
		return dao.selectNickname(email);
	}
	 
	 
	@Override
	public String selectMemberTel(String nickname) {
		return dao.selcectMemberTel(nickname);
	} 

	// 이메일 중복 확인
	@Override
	public int checkEmail(String email) {
		return dao.checkEmail(email);
	}
	
	
	// 닉네임 중복 확인
	@Override
	public int checkNickname(String nickname) {
		return dao.checkNickname(nickname);
	}
	
	
}



















