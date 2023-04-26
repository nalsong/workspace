package edu.kh.project.member.model.service;

import edu.kh.project.member.model.dto.Member;

// Service Interface 사용 이유

// 1. 프로젝트에 규칙성을 부여하기 위해서

// 2. 클래스간의 결합도를 약화시키기 위해서 (객체 지향적 설계)
// 		-> 유지보수성 향상

// 3. Spring AOP 사용을 위해서
// 		-> AOP는 spring-proxy를 이용해서 동작하는데 이 때 Service인터페이스가 필요하다!


public interface MemberService {
	
	
	/**
	 * @param inputMember
	 * @return email, pw 가 일치하는 정보 또는 null
	 */
	Member login(Member inputMember);
	
}

