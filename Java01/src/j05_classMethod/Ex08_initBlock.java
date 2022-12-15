package j05_classMethod;

import java.util.Arrays;

/*
 < 멤버 변수 초기화 >
 - 선언과 동시에 초기화 (간단한 경우) : 명시적 초기화(explicit initialization) 
 - 초기화블럭 또는 생성자 (복잡한 경우) 

 < 수행순서 >
 => 프로그램 로딩-> 클래스초기화블럭 -> main 메서드실행 -> 인스턴스 생성 (new)
     -> 인스턴스초기화 블럭 -> 생성자 실행
    그러므로 인스턴스 초기화 블럭은 인스턴스 생성시마다 실행 됨
*/

public class Ex08_initBlock {
	/*
	 < p.203 타입별 기본값 확인 >
	 boolean - false
	 char - '\u0000'
	 byte, short, int - 0
	 long - 0L
	 float - 0.0f
	 double - 0.0d 또는 0.0
	 참조형 - null
	*/
	//-----------------------------------------------
	
	static int[] arr = new int[10];
	static int count = 100; // 명시적 초기화 -> 선언하면서 동시에 값 지정
	
	String color = "White"; // 명시적 초기화 > 값 지정 없을 시 default = null = 참조형
	double num; // default(기본값) = 0.0
	
	// < 초기화블럭 >
	// - 초기화 하는데 코드가 필요한 경우 작성.
	//   => 실행문 작성 가능.

	static {
		
		System.out.println("< static 변수 초기화 블럭 >");
		System.out.println("static {    }");

		System.out.println("-----------------------------------");
		
		// < 실습 >
		// => 배열 arr 초기화 : 1 ~ 10 사이 임의의 수 저장 -> Math.random() * 10 + 1 이용
		
		for (int i = 0; i < arr.length; i++) {
			
			arr[i] = (int)(Math.random() * 10 + 1);
			
		} // for_i
		
	} // static 초기화
	
	//--------------------------------------------------------------
	
	{
		System.out.println("< 인스턴스 변수 초기화 블럭 >");
		System.out.println("{    }");

		System.out.println("-----------------------------------");
		
		color = "White";
		num = (Math.random() * 10 + 1);

		System.out.println("-----------------------------------");
	} // 인스턴스 초기화
	
	// System.out.println("실행문 작성 Test => class에 직접 작성 불가능");
	
	//---------------------------------------------------------------
	
	// < 생성자 추가 >
	Ex08_initBlock() {
		System.out.println("< default 생성자 >");

		System.out.println("-----------------------------------");
	}

	public static void main(String[] args) {
		
		// < 실행 순서 >
		// => static -> main -> new -> 인스턴스 -> 생성자
		
		System.out.println("< main Start >");

		System.out.println("-----------------------------------");
		
		System.out.println("< 실습 main_arr > = " + Arrays.toString(arr)); // main 다음 출력
		// < 실습 main_arr > = [4, 8, 1, 6, 1, 7, 8, 2, 2, 7]
		
		System.out.println("-----------------------------------");
		
		//------------------------------------------------------------------------------
		
		System.out.println("< new test1 >");
		Ex08_initBlock test1 = new Ex08_initBlock();
		
		System.out.println("main_color1 = " + test1.color);
		// main_color1 = White
		System.out.println("main_num1 = " + test1.num);
		// main_num1 = 2.7584741697181796
		
		System.out.println("-----------------------------------");
		
		//------------------------------------------------------------------------------
		
		System.out.println("< new test2 >");
		Ex08_initBlock test2 = new Ex08_initBlock();
		
		System.out.println("main_color2 = " + test2.color);
		// main_color2 = White
		System.out.println("main_num2 = " + test2.num);
		// main_num2 = 7.667902463360118
		
	} // main

} // class
