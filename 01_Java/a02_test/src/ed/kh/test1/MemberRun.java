package ed.kh.test1;



public class MemberRun {
	public static void main(String[] args) {
		
		Member m = new Member(); //기본생성자 없을 시 The constructor Member() is undefined 라는 오류가 뜸
		
		m.setName("홍길동");
		m.setAge(25);
		m.setAddress("서울시 영등포구");
		m.setHobby("독서");
		
		System.out.println("이름 : " + m.getName());
		System.out.println("나이 : " + m.getAge());
		System.out.println("주소 : " + m.getAddress());
		System.out.println("취미 : " + m.getHobby());
	}	

}
