package edu.kh.api.service;

import edu.kh.api.dto.Student;


public class APIService {
	
	// API (Application Programming Interface)
	//			응용	프로그래밍 	접점
	// -> 프로그래밍 언어가 이미 가지고 있는 클래스/기능/기술을 
	// 사용자가 쉽게 사용할 수 있도록 제공하는 것
	
	
	private Student[] studentList = new Student[10];
	
	public APIService() {
		studentList[0] = new Student(1, 1, 1, "김영희");
		studentList[1] = new Student(2, 3, 4, "홍길동");
		studentList[2] = new Student(3, 5, 12, "박민지");
	}
	
	
	
	// alt + shilt +j
	/**학생추가 서비스
	 * @param grade
	 * @param classRoom
	 * @param number
	 * @param name
	 * @return 추가성공시 true/ 실패 시 false
	 * 
	 * 	 
	 */
	
	
	public boolean addStudent(int grade, int classRoom, int number, String name) {
		
		
		int index = 0; // 비어있는 index 저장
		for ( Student s : studentList ) {
			
			if(s == null) break;	
			
			boolean check1 = s.getGrade() == grade;
			boolean check2 = s.getClassroom() == classRoom;
			boolean check3 = s.getNumber() == number;
			boolean check4 = s.getName() == name;
			
			// 학생 배열에 입력받은 학생이 존재한다면
			if(check1 && check2 && check3 && check4)
				return false;
			index++;
		}
		
		// 학생 배열에 학생이 가득 찬 경우
		if(index == studentList.length) return false;
		
		
		//지정된 index에 학생 추가
		studentList[index] = new Student(grade, classRoom, number, name);
		return true;
	
		
	}
	
	/**학생추가 서비스2(equals/ hashcode 사용)
	 * @param grade
	 * @param classRoom
	 * @param number
	 * @param name
	 * @return 추가성공시 true/ 실패 시 false 	 
	 */
	public boolean addStudent2(int grade, int classRoom, int number, String name) {
		
		//1. equals()를 이용한 비교
		// 1) 전달 받은 값을 임시 학생 객체 생성
		Student temp = new Student(grade, classRoom, number, name);
		
		// 2) 학생 배열을 순차 접근 하면서 같은 동등한 학생이 있는지 검사
		int index = 0;
		for(Student s : studentList) {
			
			if(s == null) break;
			
			//s가 참조하는 학생과 temp가 참조하는 학생이 필드 값이 같을 경우(동등한 경우)
//			if(s.equals(temp)) return false;
		
			System.out.println(s.hashCode());
			System.out.println(temp.hashCode());
			System.out.println("=============================");
			
			// hashCode()가 같다 == 필드가 같다 == 중복되는 학생이다
			if(s.hashCode() == temp.hashCode()) return false; 
			
			index++;
		}
		
		
		// 3) 학생 배열에 학생이 가득 찬 경우
			if(index == studentList.length) return false;
		
		// 4) 임시 학생 객체를 학생 배열에 추가
			studentList[index] = temp;
			
		
		return true;
	}
	
	
	
	
	
}


















