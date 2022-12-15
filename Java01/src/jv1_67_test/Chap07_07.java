package jv1_67_test; // p. 287

// Outer클래스의 내부 클래스 Inner의 멤버변수 iv의 값을 출력하시오.

// 결과 = 200


class Outer2 {

	static class Inner2 {
		
		int iv = 200;
	
	} // ic_Inner2
	
} // c_Outer2


//==============================================================================================

public class Chap07_07 {

	public static void main(String[] args) {
		
		Outer2.Inner2 inner = new Outer2.Inner2();
		// static클래스(static class Inner2)는 인스턴스클래스와 달리 외부 클래스의 인스턴스를 생성하지 않고도 사용할 수 있다.
		
		System.out.println(inner.iv);

	} // main

} // class
