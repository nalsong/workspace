package edu.kh.control.loop.practice;


import java.util.Scanner;

//실습문제용 클래스
public class ForPractice {
	
	
	
	
	
//	연습문제1
//	사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.
//	단, 입력한 수는 1보다 크거나 같아야 합니다.
//	만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.

//	ex.
//	1이상의 숫자를 입력하세요 : 4 
//	1 2 3 4
	
//	1이상의 숫자를 입력하세요 : 0
//	1 이상의 숫자를 입력해주세요.
	
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
	

	
	
//	연숩문제2
//	사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
//	단, 입력한 수는 1보다 크거나 같아야 합니다.
//
//	ex.
//	1이상의 숫자를 입력하세요 : 4 
//	4 3 2 1 
//
//	1이상의 숫자를 입력하세요 : 0
//	1 이상의 숫자를 입력해주세요.
	
	
	
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
		

	
	
//	연습문제3
//	1부터 사용자에게 입력 받은 수까지의 정수들의 합을 for문을 이용하여 출력하세요.
	
//	ex.
//	정수를 하나 입력하세요 : 8
//	1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 = 36

	
	
	public void practice3() {  
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 하나 입력하세요. : ");
		int input = sc.nextInt();

		
		
		
		
		int sum= 0; //합계용 변수
		
		for( int i = 1 ; i < input ; i++ ) {
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
	
	
	
	
	
	
//	연습문제4
//	사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
//	만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요.

//	ex.
//	첫 번째 숫자 : 8
//	두 번째 숫자 : 4
//	4 5 6 7 8
//	
//	첫 번째 숫자 : 4
//	두 번째 숫자 : 8
//	4 5 6 7 8
//	
//	첫 번째 숫자 : 9
//	두 번째 숫자 : 0
//	1 이상의 숫자를 입력해주세요.
	
	
	public void practice4() {  
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
		
		
		
		
		if(num1 < 1 || num2 < 1) {
			
			System.out.print("1 이상의 숫자를 입력해주세요.");
		}else if (num1 < num2) {
			for( int i = num1  ; i >= num1 && i <= num2  ; i++ ) {
				System.out.print(i + " ");
		}
			
		}else {
			for( int i = num2  ; i >= num2 && i <= num1  ; i++ ) {
				System.out.print(i + " ");
			
			}
		
		}	
	}		
			
	
	
	
//	연습문제5
//	사용자로부터 입력 받은 숫자의 단을 출력하세요.
//	ex.
//	숫자 : 4
//	===== 4단 =====
//	4 * 1 = 4
//	4 * 2 = 8
//	4 * 3 = 12
//	4 * 4 = 16
//	4 * 5 = 20
//	4 * 6 = 24
//	4 * 7 = 28
//	4 * 8 = 32
//	4 * 9 = 36
	
	
	
	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 : ");
		int num1 = sc.nextInt();
		
		System.out.printf("===== %d단 =====\n" , num1);
		
		for(int i = 1 ; i <=9 ; i++ ) {
			System.out.printf("%d * %d = %d\n", num1, i, num1*i);
		}
	
	}
	
	
	
	
//	연습문제6
//	사용자로부터 입력 받은 숫자의 단부터 9단까지 출력하세요.
//	단, 2~9를 사이가 아닌 수를 입력하면 “2~9 사이 숫자만 입력해주세요”를 출력하세요
//
//	숫자 : 4
//	===== 4단 ===== 
//	===== 5단 =====
//	===== 6단 =====
//	===== 7단 =====
//	===== 8단 =====
//	===== 9단 =====
//	(해당 단의 내용들은 길이 상 생략)
//
//	숫자 : 10
//	2~9 사이 숫자만 입력해주세요.
	
	
	public void practice6() {  
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		
		if(num <= 1 || num >= 10){
			System.out.print("2~9사이의 숫자만 입력해주세요.");	
		}else {
			for( int i = num ; i<10 ; i++ ) {
				System.out.printf("===== %d단 =====\n", i);
				for( int x = 1; x<=9 ;x++ ) {
					System.out.printf("%d * %d = %d\n", i, x, i*x );
				}	
			}
			
		}
			
		
	}
	
	
	
	
//	연습문제7
//	다음과 같은 실행 예제를 구현하세요.
//	ex.
//	정수 입력 : 4
//	*
//	**
//	***
//	****

	public void practice7() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		
		for( int x = 1 ; x <= num ; x++ ) {
			for( int i = 1; i <= x ; i++) {
			System.out.print("*");
			}	
			System.out.println();
		}		
	}		
			
		

	
	
	
	
	
	
//	연습문제8
//	다음과 같은 실행 예제를 구현하세요.
//	ex.
//	정수 입력 : 4
//	****
//	***
//	**
//	*
	
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		
		//내가 푼 것
		for( int x= 1 ; x <= num ; x++) {
			for( int i = num ; i >= x ; i--) {
				System.out.printf("*");
			}
			System.out.println();
		}
		
		//문제 풀이
//		for( int x= num ; x >= 1 ; x--) {
//			for( int i = x ; i >= x ; i--) {
//				System.out.printf("*");
//			}
//			System.out.println();
//		}
		
		
		
	}
	
	
	
	
	
//	연습문제9
//	다음과 같은 실행 예제를 구현하세요.
//	ex.
//	정수 입력 : 4
//	   *
//	  **
//	 ***
//	****

	
	public void practice9() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수입력 : ");
		int num = sc.nextInt();
		
		
		for (int x=1; x<=num ;x++) {
			for(int y= num-1 ; y>=x ; y-- ) {
				System.out.print(" ");
			}
			
			for(int i = 1; i<=x; i++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
//	연습문제10
//	다음과 같은 실행 예제를 구현하세요.
//	ex.
//	정수 입력 : 3
//	*
//	**
//	***
//	**
//	*
	
	public void practice10() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for( int x= 1; x<=num ; x++ ) {
			for( int y=1 ; y<=x ; y++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		for( int i = 0; i<num-1 ; i++) {
			for( int j = 1; j>=i ; j-- ) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		
	}
	
	
	
	
	
	
	
	
	
//	연습문제11
//	다음과 같은 실행 예제를 구현하세요.
//	ex.
//	정수 입력 : 4
//	  *
//	 ***
//  *****
// *******

	
	
	public void practice11() {  
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		//내가 푼 것
		for(int x = 1 ; x<=num ; x++ ) {  
			for( int y =num-1; y>=x ; y-- ) {
				System.out.print(" ");
			}		
			for( int i = 1; i<=x*2-1; i++ ) {
				System.out.print("*");
			}	
			System.out.println();
		}
		
		
		//풀이 1(for문 2개로)
//		for(int x = 1 ; x<=num ; x++ ) {  
//			//빈칸 출력
//			for( int y =num-x; y>=1 ; y-- ) {
//				System.out.print(" ");
//			}		
//			for( int i = 1; i<=x*2-1; i++ ) {
//				System.out.print("*");
//			}	
//			System.out.println();
//		}
		
		
		
		//풀이2(for문 1개, if-else문 1개)
//		for(int x = 1 ; x<=num ; x++ ) {  
//		
//			for( int i = 1; i <= num+x-1; i++) {
//				if(num-x>= i ) {
//					System.out.print(" ");
//				}else {
//					System.out.print("*");
//				}
//			
//			}
//		
//		}
//		
		
		
	}
	
	
	
	
	
	
//	연습문제12(){}
//	다음과 같은 실행 예제를 구현하세요.
//	ex.
//	정수 입력 : 5
//	*****
//	*   *
//	*   *
//	*   *
//	*****

	
	public void practice12() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print( "정수 입력 : ");
		int num = sc.nextInt();
		
		
		//내가 푼 것.
		for( int x = 1; x <= num  ; x++ ) {
			
				
				for( int i = 1 ; i <=num ; i++ ) {
					if( i==1 || x==num || x== 1) {
						System.out.print("*");
					}else if(i%5==0 ){
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
			System.out.println();
		}
	

		
		//문제 풀이
//		for( int x = 1; x <= num  ; x++ ) {
//				for( int i = 1 ; i <=num ; i++ ) {
//					if( i==1 || x==num || x== 1 || i ==num) {
//						System.out.print("*");
//					}else {
//						System.out.print(" ");
//					}
//				}
//			System.out.println();
//		}
		
		
		
		
		
	}
	
	
	
	
	
	
//	연습문제13
//	1부터 사용자에게 입력 받은 수까지 중에서
//	1) 2와 3의 배수를 모두 출력하고
//	2) 2와 3의 공배수의 개수를 출력하세요.
//	* ‘공배수’는 둘 이상의 수의 공통인 배수라는 뜻으로 어떤 수를 해당 수들로 나눴을 때
//	모두 나머지가 0이 나오는 수
//	ex.
//	자연수 하나를 입력하세요 : 15
//	2 3 4 6 8 9 10 12 14 15 
//	count : 2
	
	public void practice13() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("자연수 하나를 입력하세요 : ");
		int num = sc.nextInt();
		
		int count = 0;
		for( int i=1; i<=num ; i++ ) {
			if(i%2==0 || i%3==0) {
				System.out.print(i +" ");				
			}
			if(i%2==0 && i%3==0){
				count += 1;
			}
		}
		System.out.printf("\ncount : %d",count);
	}
	
	
}
	
	
	

