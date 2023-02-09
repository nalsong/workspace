

package edu.kh.operator.practice;

import java.util.Scanner;

public class operatorpraitice2 {
	
	public static void main(String[] agrs) {
		
		Scanner sc = new Scanner(System.in);
		
	
		
		
		
		System.out.print("이름 : " );
		String inputName = sc.next();
		
		System.out.print("학년(정수) : " );
		int input2 = sc.nextInt();
		
		System.out.print("반(정수) : " );
		int inputClass = sc.nextInt();
		
		System.out.print("번호(정수) : " );
		int inputNumber = sc.nextInt();
		
		System.out.print("성별(남학생/여학생) : " );
		String inputGender = sc.next();
		
		System.out.print("성적(소수점 아래 둘째자리까지) : ");
		float inputScore = sc.nextFloat();		
		
			
		System.out.printf("%s %d학년 %d반 %d번 %s의 성적은 %.2f점입니다.", inputName, input2, inputClass, inputNumber, inputGender, inputScore );
		
		
	}

}
