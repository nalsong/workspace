package edu.kh.control.loop.practice;

import java.util.Scanner;

//실습문제용 클래스
public class ForPractice {
	
	
	public void practice1() {
		
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
		if(input < 1) {
			 System.out.print("1이상의 숫자를 입력해주세요.");
		 }else {
			 for( int i = 1 ; i <= input ; i++ ) {
				 System.out.print(i + " ");
			 }
			 
			 }
	
		 }
	
	
	
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
		if(input < 1) {
			 System.out.print("1이상의 숫자를 입력해주세요.");
		 }else {
			 for( int i = input ; i>= 1 ; i-- ) {
				 System.out.print(i + " ");
			 }
			 
			 }
	
		 }
		

	
	
	public void practice3() {  
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 하나 입력하세요. : ");
		int input = sc.nextInt();

		
		
		
		
		int sum= 0; //합계용 변수
		
		for( int i = 1 ; i <= input ; i++ ) {
			sum += i;
			System.out.print(i + " + ");
		}
		sum += input;

		System.out.print(input + " = " +sum);
	
		
		
		
//		for( int i = 1 ; i <= input ; i++ ) {
//			sum += i;
//			if(i == input) { //마지막O
//				System.out.print(i + " = " + sum);
//				
//			}else { //마지막X
//				System.out.print(i + " + ");	
//			}
//			
//		}
		
		
		
		
//		for( int i = 1 ; i <= input ; i++ ) {
//			
//			sum += i;
//			System.out.print( i );
//			
//			
//			// i == input -> 마지막
//			if (i != input) {  //마지막이 아니다.
//				System.out.printf(" + ");
//			}
//		}
//		
//		System.out.printf(" = ", sum );
		
	}
	
	
	
	
	
	
	public void practice4() {  //??????????
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
		
		if(num1 < 1 || num2 < 1) {
			
			System.out.print("1 이상의 숫자를 입력해주세요.");
		}else
			for( int i = 1 ; i >= num1 && i <= num2 ; i++ ) {
				System.out.print(i + " ");
			}
		
			
	}		
			
	
	
	public void practice5() {
	
	}
	
	
	public void practice6() {
		
	}
	
	
	public void practice7() {
		
	}
	
	
	public void practice8() {
		
	}
	
	
	public void practice9() {
		
	}
	
	
	public void practice10() {
		
	}
	
	
	public void practice11() {
		
	}
	
	
	public void practice12() {
		
	}
	
	
	public void practice13() {
		
	}
	
	
}
	
	
	

