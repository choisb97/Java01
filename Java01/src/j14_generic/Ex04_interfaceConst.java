package j14_generic;

interface ScaleI {
	// 상수 정의 => 상수만 정의 가능하므로 생략 가능
	// public static final String DO = "도";
	
	int Do = 0;
	int RE = 1;
	int MI = 2;
	int FA = 3;
	int SOL = 4;
	int RA = 5;
	int SI = 6;
	
} // i_ScaleI

public class Ex04_interfaceConst {

	public static void main(String[] args) {
		
		// < interface에 정의된 상수 직접 사용하기 >
		// - switch case문에 적용
		int key = ScaleI.Do;
		// 인터페이스명으로 접근 (ScaleI.)
		
		key = 123; // 0 ~ 6에 포함되지 않기 때문에 default 출력
		// key = 4; // ~~ 솔 ~~ 출력
		
		switch (key) {
			case 0 :
				System.out.println("~~ 도 ~~");
				break;
				
			case 1 :
				System.out.println("~~ 레 ~~");
				break;
				
			case 2 :
				System.out.println("~~ 미 ~~");
				break;
				
			case 3 :
				System.out.println("~~ 파 ~~");
				break;
				
			case 4 :
				System.out.println("~~ 솔 ~~");
				break;
				
			case 5 :
				System.out.println("~~ 라 ~~");
				break;
				
			case 6 :
				System.out.println("~~ 시 ~~");
				break;
				
			default :
				System.out.println("~~ 도, 레, 미, 파, 솔, 라, 시 ~~");
			
		} // switch~case
		
	} // main

} // class
