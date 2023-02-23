package ed.kh.test1;

public class Day3_1 {
	
	public static void main(String[] args) {
		
		
//		1번
		String[] fruits = new String[5];
		fruits[0] = "사과";  // 1부터 시작할 시 ArrayIndexOutOfBoundsException 발생
		fruits[1] = "바나나";
		fruits[2] = "오렌지";
		fruits[3] = "키위";
		fruits[4] = "수박";
		for(String fruit : fruits) {
			System.out.println(fruit);
		}
		
	}
	
	
	
}
