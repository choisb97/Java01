package j05_classMethod;

/*
 < 재귀적 호출 ( Recursive Call ) >
 - 메서드가 메서드 내부에서 자신을 호출

 => Factorial 연산에 주로 이용됨 

 => 5! = 5 * 4 * 3 * 2 * 1
 => n! = n * (n - 1) * (n - 1 - 1) * (n - 1 - 1 - 1) * ... * 1
*/

public class Ex04_Factorial {
	
	public static int factorial(int n) {
		
		if (n == 1) return 1;
		
		return n * factorial(n - 1);
		// 메서드 내부에서 자신을 호출
		// 5! => 5 * factorial(4) -> 4 * factorial(3) -> 3 * factorial(2) -> 2 * factorial(1)
		
		// 1 나오면 return??? 2..6...?
		
		// 무슨 말인지 알 수 없음....
		
	} // factorial

	public static void main(String[] args) {
		
		// < Recursive_Call Test >
		// - static 메서드에서 static 멤버는 인스턴스 없이 사용 가능.
		
		System.out.println("10! = " + factorial(10));
		System.out.println("5! = " + factorial(5));

	} // main

} // class
