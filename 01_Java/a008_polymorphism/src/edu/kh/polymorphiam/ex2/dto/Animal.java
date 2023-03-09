package edu.kh.polymorphiam.ex2.dto;


//추상클래스(abstract class)
// - 추상 메서드가 포함된 클래스
// 단, 추상메서드가 없어도 추상클래스가 될 수 있다!
public abstract class Animal /*extends Object*/{
					//->미작성시 컴파일러가 자동 추가
	
	//추상화, 캡슐화
	
	
	
	//필드
	private String type; //종( 양서류, 포유류, 파충류....)
	private String eatType; // 식성
	
	
	
	//생성자
	public Animal() {  //기본생성자 
	
		super(); //부모생성자 호출
				// 미작성 시 컴파일러가 자동 추가(매개변수 생성자도 마찬가지)
		
	}
	
	
	public Animal(String type, String eatType) {  //매개 변수 생성자
		this.type = type;
		this.eatType = eatType;
	}
	
	
	
	
	//매서드
	// getter/setter
	public String getType() {
		return type;
	}
	
	
	public void setType(String type) {
		this.type = type;
	}

	
	public String getEatType() {
		return eatType;
	}
	
	
	public void setEatType(String EatType) {
		this.eatType = EatType;
	}
	
	
	
	//String Objext.toString()
	//- 객체가 가지고 있는 필드를 하나의 문자열로 반환하는 용도의 메서드
	//(자식이 오버라이딩해서 사용하길 권장)
	// - 오버라이딩 하지 않으면 패키지명 + 클래스명@해시코드 문자열 반환
	@Override
	public String toString() {
		return type + " / " + eatType;
	}
	
	
	// 추상 메서드(미완성된 메서드)
	// -> 상속받은 자식 메서드에서 반드시 오버라이딩 해야 한다!(오버라이딩 강제화)
	//--> 추상메서드를 포함한 클래스는 반드시 abstract class여야만 한다.
	public abstract void breath();
	
	

}
