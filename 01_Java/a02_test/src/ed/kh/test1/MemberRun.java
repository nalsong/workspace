package ed.kh.test1;



public class MemberRun {
	public static void main(String[] args) {  // 실행을 위한 메인메서드
		
		Member m = new Member(); // [기본생성자 없을 시 The constructor Member() is undefined 라는 오류가 뜸!]
		// Member의 객체 m을 생성, new Member()메소드를 실행 
		
		
		m.setName("홍길동"); // m 객체의 setName을 홍길동으로 수정(변경)
		m.setAge(25); // m 객체의 setAge을 25로 수정(변경)
		m.setAddress("서울시 영등포구"); // m 객체의 setAdress를 서울시 영등포구로 수정(변경)
		m.setHobby("독서"); // m 객체의 setHobby을 독서로 수정(변경)
		
		System.out.println("이름 : " + m.getName()); // m객체의 변경된 getName값을 받아 출력 
		System.out.println("나이 : " + m.getAge()); // m객체의 변경된 getAge값을 받아 출력
		System.out.println("주소 : " + m.getAddress()); // m객체의 변경된 getAddress값을 받아 출력
		System.out.println("취미 : " + m.getHobby()); // m객체의 변경된 getHobby값을 받아 출력
	}	

}
