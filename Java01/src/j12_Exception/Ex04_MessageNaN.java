package j12_Exception;

public class Ex04_MessageNaN {

	public static void main(String[] args) {
		
		// < by Zero ( 나누기 0 )
		// - 정수형 연산 : ArithmeticException
		// - 실수형 연산 : Exception XXXX
		//             Wrapper 클래스의 메서드 활용
		
		try {
			double d1 = 1.5 / 0.0; // Infinity : 무한 수
			double d2 = 1.5 % 0.0; // NaN (Not a Number) : 숫자 아님
			
			if (Double.isInfinite(d1) || Double.isNaN(d2)) // d1이 Infinity이거나 d2가 NaN일 때
				System.out.println("\n< Zero 연산은 허용하지 않습니다. >");
			else
				System.out.printf("\n** 실수형 연산 : d1 = %f, d2 = %f\n", d1, d2);
			
			
			// Exception 발생 Test
			System.out.printf("< Message Test : 정수 0 나누기 = %d \n", (100 / 0));
			
		} catch (Exception e) {
			System.out.println("** Exception - toString => " + e.toString());
			
			System.out.println("\n** Exception - getMessage => " + e.getMessage());
			// Simple Message
			
			System.out.println("\n** Exception - printStackTrace => ");
			
			e.printStackTrace();
			// => e.toString을 포함한 순차적인 실행경로 등이 출력되어 예외발생의 원인과 경로 파악에 도움.
		
		} finally {
			System.out.println("\n< finally : 무조건 실행 >");
		} // tcf
		
		System.out.println("\n< Program 정상 종료 >");
		
	} // main

} // class
