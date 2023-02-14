package edu.kh.array.practice;

import java.util.Scanner;

public class ArrayPractice {

	
//	실습문제1
//	길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
//	순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
//	짝수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
//	
//	[실행 화면]
//	1 2 3 4 5 6 7 8 9
//	 : 25
	
		public void practice1(){
		
		int arr[] = new int[9];
		
		int sum = 0;
		
		
		
		
		for( int i = 0 ; i < arr.length ; i++ ) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
			
			
			if(i % 2 == 0 ) {  
				
				sum += arr[i];   //1, 3, 5, 7, 9????
			}
			
		}
		System.out.printf("\n짝수 번째 인덱스 합 : %d ", sum);
	}
	
	
	
//	실습 문제2
//	길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여
//	순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
//	홀수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
//	
//	[실행 화면]
//	9 8 7 6 5 4 3 2 1 
//	홀수 번째 인덱스 합 : 20
	public void practice2(){	
		
		int arr[] = new int[9];
		
		int sum = 0;
		for( int i = arr.length-1  ; i >= 0 ; i-- ) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
			
			
			if(i % 2 != 0) {  // 8 6 4 2????
				sum += arr[i]; 
			}
		}
		System.out.printf("\n홀수 번째 인덱스 합 : %d ", sum);
		
	}
	

//	사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
//	1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요
//	
//	[실행 화면]
//	양의 정수 : 5
//	1 2 3 4 5 
//	
//	[실행 화면]
//	양의 정수 : 8
//	1 2 3 4 5 6 7 8

	public void practice3(){	//????
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("양의 정수 : ");
		int num = sc.nextInt();
		
		int arr[] = new int[num];
		
		for( int i = 1 ; i < arr.length ; i++ ) {
		

			
			System.out.print(arr[i] + " ");
		}
		
		
		
		
	}
	
	
//	실습문제 4
//	정수 5개를 입력 받아 배열을 초기화 하고
//	검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
//	배열에 같은 수가 없을 경우 “일치하는 값이 존재하지 않습니다“ 출력
//	
//	[실행 화면 1]
//	입력 0 : 5
//	입력 1 : 8
//	입력 2 : 9
//	입력 3 : 10
//	입력 4 : 4
//	검색할 값 : 8
//	인덱스 : 1
//	
//	[실행 화면 2]
//	입력 0 : 5
//	입력 1 : 8
//	입력 2 : 9
//	입력 3 : 10
//	입력 4 : 4
//	검색할 값 : 1
//	일치하는 값이 존재하지 않습니다.

	
	public void practice4(){	
		
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[5];
		
		for(int i = 0 ; i <arr.length ; i++ ) {
		
		System.out.printf("입력 %d : ", i );
		arr[i] = sc.nextInt();
		
		}
		
		System.out.print("검색할 값 : ");
		int search = sc.nextInt();
		
//		if(arr[i] ==  search) {
//			System.out.printf("인덱스 : %d", ??);
//		}else {
//			System.out.print("일치하는 값이 존재하지 않습니다.");
//		}
		
		
		
		
	}
	
	public void practice5(){	
	}
	
	public void practice6(){	
	}
	
	public void practice7(){	
	}
	
	public void practice8(){	
	}
	
	public void practice9(){	
	}
	
	public void practice10(){	
	}
	
	public void practice11(){	
	}
	
	public void practice12(){	
	}
	
	public void practice13(){	
	}
	
	public void practice14(){	
	}
	
	public void practice15(){	
	}
	
	public void practice16(){	
	}
	
	public void practice17(){	
	}
	
	public void practice18(){	
	}
	
	public void practice19(){	
	}
	
	public void practice20(){	
	}
	
	public void practice21(){	
	}
	
	public void practice22(){	
		
	}
	
	
	
	
	public void practice23(){	
		
	}
	
	
	
	public void practice24(){	
		
	}
	
	
	
	public void BingoGame(){	
		
	}
	
	
	
	
}
