package jv1_67_test; // p.288

// 다음과 같은 실행결과를 얻도록 (1) ~ (4)의 코드를 완성하시오.

// 결과 = 30
//		 20
//		 10


class Outer3 {
	
	int value = 10;
	
	class Inner3 {
		
		int value = 20;
		
		void method1() {

			int value = 30;
			
			// System.out.println(  (1)  );
			// System.out.println(  (2)  );
			// System.out.println(  (3)  );
			
			System.out.println(value);
			System.out.println(this.value);
			System.out.println(Outer3.this.value);
			// 외부 클래스의 인스턴스 변수는 내부 클래스에서 '외부클래스이름.this.변수이름'으로 접근할 수 있다.
			
		} // method1
		
	} // ic_Inner3
	
} // c_Outer3

//============================================================================================

public class Chap07_08 {

	public static void main(String[] args) {
		
		// (4) 알맞은 코드를 넣어 완성하시오.
		
		Outer3 outer = new Outer3(); // 내부 클래스의 종류가 인스턴스 클래스이기 때문에 외부 클래스의 인스턴스를 생성한 다음에야 
		Outer3.Inner3 inner = outer.new Inner3(); // 내부 클래스의 인스턴스를 생성할 수 있다.
		// Chap07_06 참고
		
		
		inner.method1();

	} // main

} // class
