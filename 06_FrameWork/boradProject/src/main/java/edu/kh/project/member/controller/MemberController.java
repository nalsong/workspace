package edu.kh.project.member.controller;

import java.security.Provider.Service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;

@Controller // 요청/응답 클래스 + bean등록 (String이 관리하는 객체)

//@RequestMapping : 요청 주소에 맞는 클래스/메서드 연결

// @RequestMapping("요청주소")
// -> GET / POST 구분X(모두 받음, 주소만 맞으면 연결)

// @RequestMapping(value="요청주소", method=RequestMethod.GET/POST)
// -> GET / POST 방식을 구분


@RequestMapping("/member") // 공통된 주소 앞부분 작성
							// member로 시작하는 요청은 해당 컨트롤러에서 처리
public class MemberController {
	
	
	// 등록된 Bean중에서 필드와 타입이 일치하는 Bean을 주입
	// -> MemberService를 구현한 MemberServiceImpl의 Bean주입
	@Autowired
	private MemberService service;
	
	// 로그인 : /member/login
	// 로그아웃 : /member/logout
	
	// 로그인 (/member/login), POST 방식 처리
	
	
	
	
	/*
	번거로움
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest req) {
		
		String inputEmail = req.getParameter("inputEmail");
		
		System.out.println("inpputEmal : " + inputEmail);
		
		// ** redirect방법 ! **
		
		// "redirect: 요청주소"
		
		return "redirect:/";
	}
	*/
	
	
	/*
	위에 보단 간결하지만 역시 번거로움
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam ("inputEmail") String inputEmail) {
		
		System.out.println("inputEmail : " + inputEmail);
		
		
		// ** redirect방법 ! **
		
		// "redirect: 요청주소"
		
		return "redirect:/";
	}
	*/
	
	
	
	
	/*
	 간결한 방법
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String inputEmail, String inputPw) {
		
		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);
		
		
		// ** redirect방법 ! **
		
		// "redirect: 요청주소"
		
		return "redirect:/";
	}
	*/
	
	
	//-------------------------------------------------------------------------------
	

	
	// 로그인 (/member/login), POST 방식 처리
	// Class에 작성한 /member를 제외한 나머지 부분을 주소로 작성
//	@RequestMapping(value="/login", method=RequestMethod.POST) 
	public String login(HttpServletRequest req) {
		// 파라미터 전달 방법 1 : HttpServletRequset를 이용하는 방법
		// -> Controller 메서드에 매개변수로 HttpServletRequset 작성
		
		// 매개변수에 적으면 왜 사용 가능할까?
		// Spring Framework가 제공하는 Argument Resolver(매개변수 해결사)가 해결해줘서
		
		String inputEmail = req.getParameter("inputEmail");
		String inputPw = req.getParameter("inputPw");
		
		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);
		
		// ** redirect방법 ! **
		// "redirect: 요청주소"
		return "redirect:/";
	}
	
	
	
	// @PostMapping
	// -> RequestMapping의 자식으로 POST방식 요청을 연결하는 어노테이션
//	@PostMapping("/login")
	public String login(/* @RequestParam("inputEmail") String email */ String inputEmail, /* @RequestParam("inputPw") String pw */String inputPw) {
		
		// 파라미터 전달 방법 2 : @RequestParam 어노테이션 이용(+ 생략방법) ☆★
		
		// @RequestParam 어노테이션 
		// - request객체를 이용한 파라미터 전달 어노테이션
	    // - 매개변수 앞에 해당 어노테이션을 작성하면, 매개변수에 값이 주입됨.

		
		// ** 파라미터의 name속성 값과 매개변수명이 같으면 @RequestParam 생략 가능!! **
		
		// @RequestParam(value="name", required="fasle", defaultValue="1" )
	    // [속성]
	    // value : 전달 받은 input 태그의 name 속성값
	   
		// required : 입력된 name 속성값 파라미터 필수 여부 지정(기본값 true)
		// -> required = true인 파라미터가 존재하지 않는다면 400 Bad Request 에러 발생
		// -> required = true인 파라미터가 null인 경우에도 400 Bad Request
		
		// defaultValue : 파라미터 중 일치하는 name 속성 값이 없을 경우에 대입할 값 지정.
		// -> required = false인 경우 사용

		System.out.println("inputEmail : " + inputEmail);
		System.out.println("inputPw : " + inputPw);

		// 메인 페이지 리다이렉트(재요청)
		return "redirect:/";
	}
	
	
	@PostMapping("/login")
	public String login(/*@ModelAttribute*/ Member inputMember) {
		
		// 파라미터 전달 방법 3 : @ModelAttribute이용한 방법 ☆★
		
		// -> DTO(또는 VO) 와 같이 사용하는 어노테이션
		// - 전달 받은 파라미터의 name속성 값이 같이 사용되는 DTO의 필드명과 같다면 자동으로 setter를 호출해서 필드에 값을 세팅
		
		
		// *** @ModelAttribute 사용 시 주의사항 ***
		// - DTO에 기본 생성자가 필수로 존재해야 한다!
		// - DTO에 setter가 필수로 존재해야 한다!!
		
		// *** @ModelAttribute어노테이션은 생략이 가능하다! ***
		
		// *** @ModelAttribute를 이용해 값이 필드에 새팅된 객체를 "커맨드 객체" 라고 한다.***
		
		System.out.println(inputMember);
		
		return "redirect:/";
	}
	
	
	// -------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	// alt + shift + j : 설명용 주석
	/** 로그인 요청 처리(찐)
	 * @return 메인페이지 redirect주소
	 */
//	@PostMapping("/login")
	public String login(Member inputMember, Model model) {
		
		// Member inputMember : 커맨드 객체(필드에 파라미터 담겨있음)
		
		// 로그인 서비스 호출
		Member loginMember = service.login(inputMember);
		 
		//DB조회 결과 확인
		System.out.println(loginMember);
		
		return "redirect:/";
	}
}


