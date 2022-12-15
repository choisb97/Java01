package jv1_89_test; // p. 318

// 아래의 코드가 수행되었을 때의 실행결과를 적으시오.

// 결과 = 3 5

/*
 < 풀이 >
 - main메서드에서 method1을 호출하고 method1에서 method2를 호출한다.
   method2에서 NullPointerException을 발생시키고 본인을 호출한 method1로 throw
   method1에서 해결할 수 있는 게 없어서 finally만 return해서 3을 출력하고 본인을 호출한 main메서드로 호출.
   main에서 Exception으로 처리한 후 5 return
*/

public class Chap08_05 {

	public static void main(String[] args) {
		
		try {
			method1();
		} catch (Exception e) {
			System.out.println(5);
		} // t~c

	} // main
	
	
	static void method1() {
		try {
			method2();
			System.out.println(1);
			
		} catch (ArithmeticException e) {
			System.out.println(2);
		} finally {
			System.out.println(3); // 무조건 출력
		} // t~c~f
		
		System.out.println(4);
	} // m_method1
	
	static void method2() {
		throw new NullPointerException();
	} // m_method2

} // class
