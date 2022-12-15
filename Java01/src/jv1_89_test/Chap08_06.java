package jv1_89_test; // p.319

// 아래의 코드가 수행되었을 때의 실행결과를 적으시오.

// 결과 = 1

public class Chap08_06 {
	
	static void method(boolean b) {
		try {
			System.out.println(1);
			if (b)
				System.exit(0); // method(b)가 true인 경우 실행한다.
			// exit(0)은 finally도 실행하지 않고 즉시 프로그램을 종료한다.
			System.out.println(2);
			
		} catch (RuntimeException e) {
			System.out.println(3);
			return;
		}catch (Exception e) {
			System.out.println(4);
			return;
		} finally {
			System.out.println(5);
		} // t~c~f
		
		System.out.println(6);
	} // method

	public static void main(String[] args) {

		method(true);
		method(false);
		
	} // main

} // class
