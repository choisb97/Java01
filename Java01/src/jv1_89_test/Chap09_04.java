package jv1_89_test; // p.361

// 다음과 같이 정의된 메서드를 작성하고 테스트하시오.

// Hint : String클래스의 indexOf()를 사용할 것.

// 결과 = true
//        false

public class Chap09_04 {

	/*
	 메서드명 : contains
	 기능 : 첫 번째 문자열(src)에 두 번째 문자열(target)이 포함되어 있는지 확인한다.
	        포함되어 있으면 true, 그렇지 않으면 false를 반환한다.
	 반환타입 : boolean
	 매개변수 : String src
	            String target 
	*/
	// (1) contains 메서드를 작성하시오.
	
	public static boolean contains(String src, String target) {
		 //return src.contains(target);
		
		 return src.indexOf(target) == 1; // indexOf 사용.

	} // contains_src, target
	
// ======================================================================================================================
	
	public static void main(String[] args) {
		
		System.out.println(contains("12345", "23"));
		System.out.println(contains("12345", "67"));
		

	} // main

} // class
