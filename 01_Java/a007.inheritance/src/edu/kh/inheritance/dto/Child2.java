package edu.kh.inheritance.dto;

public class Child2 extends Parent{
	
//	parent클래스에 final사용시 에러
//	The type Child2 cannot subclass the final class Parent
	
	private String house;
	
	public Child2() {
		System.out.println("Child2 기본 생성자");
	}
	
	
	public Child2(String house) {
		this.house = house;
		System.out.println("Child2(String) 매개변수 생성자");
	}
	
	
	public String getHouse() {
		return house;
	}
	
	public void setHouse(String house) {
		this.house = house;
	}
	
	
	// 부모의 getMoney() 존재
		/*
		 * public int getMoney() {
			return money;
		   }
			*/

		//자식이 상속 받은 getMoney()을 다시 작성(재정의)
		//@Override: 컴파일러에게 해당 메서드는 재정의 되었다는 것을 알려주는 컴퓨터용 주석
		//			-> 오버라이딩 형식이 맞는지 검사진행
		
		//오버라이딩 성립조건
//	    - 접근제한자 빼고 나머지 메서드 선언부 동일
//	        - 메소드 이름
//	        - 매개변수의 개수, 타입, 순서 동일
//	        - 리턴 타입 동일
//	    - private메소드 오버라이딩 불가
//	    - **접근제어자**는 부모와 **같거나 넓은 범위로** 변경 가능
//	    - **예외처리**는 부모와 **같거나 좁은 범위로** 예외처리 변경 가능
		
		@Override 
		public int getMoney() {
//			parent클래스의 getMoney메소드에 final사용시 에러
//			Cannot override the final method from Parent
			System.out.println("자식이 오버라이딩 한 getMOney()");
			return super.getMoney() +500;
			//부모의 getMoney() 반환값에 500원 추가
		
		
		
	}
	
	
}


































