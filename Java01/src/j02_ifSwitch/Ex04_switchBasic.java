package j02_ifSwitch;

/*
 < switch - case - break 문 >

 1. switch(key) 문 인자의 Type 은 int, char, String 만 가능.
 2. break :  무조건 탈출(없으면 아래로 계속 default 까지 진행)
 3. case 블럭에 구문이 없어도 됨 (아래 구문으로 진행됨.)
 4. case 블럭에는 복합구문에도 {...} 사용하지 않음.
 5. case 값으로 변수 사용은 불가, 그러나 변수를 사용하지 않은 수식은 허용.
*/

public class Ex04_switchBasic {

	public static void main(String[] args) {
		
		// < ** int ** >
		int i = 3;
		
		System.out.println("< int >");
		
		switch (i) {	
		case 1 :
			System.out.println("1 입력"); // 같은 case 가 여러개 있으면 Error
			break;
				
		case 2 :
			System.out.println("2 입력");
		
		case 3 :
			System.out.println("3 입력");
		
		case 4 : 
		
		case 5 :
			System.out.println("5 입력");

		default :
			System.out.println("default 는 생략 가능");

		// 출력 : case 3, 5, default
			
		// case 번호, 순서는 상관 없음. > 바로 답을 찾기 때문에 처리가 빠름.
		
		// case 1은 처리 후 break, int = 3 => case 3 처리 후 break 가 없어서 case 5, default 까지 처리
		};
		
		System.out.println("---------------------------");
		
		//---------------------------------------------------------------------------------
		
		// < ** if ~ else if 와 비교 >
		
		// => switch 가 direct 분기하므로 더 효율적이다.
		// if 부터 순차적으로 내려오면서 비교, 확인. > 작업량이 많아지고 속도가 느림.
		
		System.out.println("< if ~ else if 비교 >");
		
		if (i == 1) 
			System.out.println("1 입력");
		else if (i == 2) 
			System.out.println("2 입력");
		else if (i == 3) 
			System.out.println("3 입력");
		else 
			System.out.println("default 는 생략 가능.");
		
		System.out.println("---------------------------");
		
		//---------------------------------------------------------------------------------
		
		/*
		// < ** double, float 불가능 **>
		double dd = 2.2;
		
		switch (dd) {
		// Cannot switch on a value of type double.
		case 1 : System.out.println("1 입력"); 
		}
		*/
		
		//---------------------------------------------------------------------------------
		
		// < ** char ** >
		char code = 'A';
				
		System.out.println("< char >");
		switch (code) {
				
		case 'A' :
			System.out.println("예술가");
    		break;
				
		case 'P' :
			System.out.println("운동선수");
			break;
					 
		case 'D' :
			System.out.println("개발자");
			break;
						 
		default :
			System.out.println("학생");
		};
				
		// case 'A' 에 break 가 없으면 전부 출력.
				
		System.out.println("----------------------------------------");
				
		//---------------------------------------------------------------------------------
				
		
		// < ** char ** >
		// => 중첩 구문 연습
		// code = 'A' 일 때, i 가 짝수이면 i 를 10배로 변경 후 출력한다. 
		char code1 = 'A';
		
		System.out.println("< char 중첩 구문 연습 >");
		switch (code1) {
		
		case 'A' :
			System.out.println("예술가");
			if (i % 2 == 0) {
     		// i 나누기 2의 나머지가 0 이면 짝수
				i *= 10; // i = i * 10
			System.out.println("i = " + i);
			// i = 3 -> 숫자 값 출력할 것 없음.
			}
			break;
		
		case 'P' :
			System.out.println("운동선수");
			break;
				 
		case 'D' :
			System.out.println("개발자");
			break;
				 
		default :
			System.out.println("학생");
		};
		
		// case 'A' 에 break 가 없으면 전부 출력.
		
		System.out.println("----------------------------------");
		
		//---------------------------------------------------------------------------------
		
		// < ** String ** >
		String color = "purple";
		
		System.out.println("< String >");
		
		switch (color) {
		case "red" :
			System.out.println("빨강");
			break;
					
		case "blue" :
			System.out.println("파랑");
			break;
					
		case "purple" :
			System.out.println("보라");
			break;
					
		case "black" :
			System.out.println("검정");
			break;
					
		default :
			System.out.println("white");
		};
		
		System.out.println("----------------------------------");
		
		//---------------------------------------------------------------------------------
		
		// < ** String ** >
		// => 중첩 구문 연습
		// i 가 홀수이면 color 출력하기
		String color1 = "purple";
		
		System.out.println("< String 중첩 구문 연습 >");
		
		if (i % 2 == 1) { // i(3) 나누기 2의 나머지가 1이면
			
			// String color1 = "purple"; // 지역변수
			switch (color1) {
				
			case "red" :
				System.out.println("빨강");
				break;
						
			case "blue" :
				System.out.println("파랑");
				break;
						
			case "purple" :
				System.out.println("보라");
				break;
						
			case "black" :
				System.out.println("검정");
				break;
						
			default :
				System.out.println("white");
			} // switch
			
		} // if
		
		// < 지역변수(블럭 내에서만 적용 가능한 변수) >
		// => 선언된 내부에서만 사용 가능.
		System.out.println("color : " + color);
		// i = 3 -> 홀수이기 때문에 color 값 출력
		
	} // main

} // class
