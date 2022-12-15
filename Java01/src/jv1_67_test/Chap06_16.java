package jv1_67_test; // p.213

// 다음 코드의 실행 결과를 예측하여 적으시오.

public class Chap06_16 {
	
	public static void change(String str) {
		str += "456"; // 기존 문자열에 456을 붙인다.
		
	} // change

	public static void main(String[] args) {
		
		String str = "ABC123";
		System.out.println(str); // ABC123
		
		change(str); // change를 호출하면서 문자열 str을 넘겨준다.
		System.out.println("After change : " + str); // ABC123

	} // main

} // class
