package ed.kh.test1;

public class Member {
	
	public Member() {} //기본생성자
	
	private String name; // 같은 클래스 내에서만 공유 가능한 String자료형의 name필드변수 선언
	private int age; // 같은 클래스 내에서만 공유 가능한 int자료형의 age필드변수 선언
	private String address; // 같은 클래스 내에서만 공유 가능한 String자료형의 address필드변수 선언
	private String hobby; // 같은 클래스 내에서만 공유 가능한 String자료형의 hobby필드변수 선언
	public Member(String name, int age, String address, String hobby) { // 필드변수 String name, int age, String address, String hobby를 가진 Member 매개생성자
		this.name = name; // 필드변수 name은 name
		this.age = age; // 필드변수 age는 age
		this.address = address; // 필드변수 address는 address
		this.hobby = hobby; // 필드변수 hobby는 hobby
	}
	public String getName() {return name;} // String자료형의 getName필드에 name필드값을 외부클래스로 반환 
	public void setName(String name) {this.name = name;} // String자료형의 getName필드에 name필드값을 외부클래스에서 변경가능하게 해줌
	public int getAge() {return age;} // int자료형의 getAge필드에age필드값을 외부클래스로 반환 
	public void setAge(int age) {this.age = age;} // int자료형의 getAge필드에age필드값을 외부클래스에서 변경가능하게 해줌
	public String getAddress() {return address;} // String자료형의 getAddress필드에 address필드값을 외부클래스로 반환 
	public void setAddress(String address) {this.address = address;} //String자료형의 getAddress필드에 address필드값을 외부클래스에서 변경가능하게 해줌
	public String getHobby() {return hobby;} // String자료형의 getHobby필드에 hobby필드값을 외부클래스로 반환 
	public void setHobby(String hobby) {this.hobby = hobby;} // String자료형의 getHobby필드에 hobby필드값을 외부클래스에서 변경가능하게 해줌

}
