package jv1_89_test; // p.322

// 아래의 코드가 수행되었을 때의 실행결과를 적으시오.

// 결과 = 2 4 7

public class Chap08_08 {

	public static void main(String[] args) {
		
		try {
			method1();
			System.out.println(6);
			
		} catch (Exception e) {
			System.out.println(7);
		}
	} // main	
		
	static void method1() throws Exception {
		
		try {
			method2();
			System.out.println(1);
			
		} catch (NullPointerException e) {
			System.out.println(2);
			throw e;
		} catch (Exception e) {
			System.out.println(3);
		} finally {
			System.out.println(4);
		} // t~c~f

		System.out.println(5);
	} // method1
	
	static void method2() {
		throw new NullPointerException();
	} // method2

} // class
