package jv1_67_test; // p.287

// Outer클래스의 내부 클래스 Inner의 멤버변수 iv의 값을 출력하시오.

// 결과 = 100


class Outer1 {
	
	class Inner1 {
		
		int iv = 100;
		
	} // ic_Inner1
	
} // c_Outer1

//================================================================================================

public class Chap07_06 {

	public static void main(String[] args) {

		// (1) 알맞은 코드를 넣어 완성하시오.
		Outer1 out = new Outer1(); // 내부 클래스(인스턴스 클래스)의 인스턴스를 생성하기 위해서는 먼저 외부클래스의 인스턴스를 생성해야한다.
		Outer1.Inner1 inner = out.new Inner1(); // 외부 통해서 내부 불러오기
		
		System.out.println(inner.iv);
		
	} // main

} // class
