package jv1_89_test; // p.317

// 아래의 코드가 수행되었을 때의 실행결과를 적으시오.


// 결과 = true => 1 3 5 / false => 1 2 5 6
/*
 * < 풀이 >
 - method(true)
  : 1을 return하고 참이므로 ArithmeticException 예외를 발생시키는데
    RuntimeException catch에서 잡히고 3을 return한 다음 finally를 무조건 실행한 후 종료.
    
 - method(false)
  : 1을 return하고 거짓이므로 예외발생을 시키지 않고 2를 출력한다.
    finally를 무조건 return하고 아래 6까지 출력한다.
   
*/

public class Chap08_04 {
	
	static void method(boolean b) {
		try {
			System.out.println(1);
			if (b)
				throw new ArithmeticException(); // method(b)가 true인 경우 실행
			System.out.println(2);
			
		} catch (RuntimeException e) {
			System.out.println(3);
			return;
		} catch (Exception e) {
			System.out.println(4);
			return;
		} finally {
			System.out.println(5);
		} // t~c~f
	
		System.out.println(6);
	} // m_method

	public static void main(String[] args) {
		
		method(true); // 1 3 5
		method(false);// 1 2 5 6
		
	} // main

} // class
