package j00_practice;

/*
 < 짝수와 홀수 >
 - 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수를 완성하세요.
 
 - 제한 조건
  1) num은 int 범위의 정수입니다.
  2) 0은 짝수입니다.
*/

public class Ex01_EvenOdd {
	
	public String solution (int num) {
		
		String answer = (num % 2) == 0 ? "Even" : "Odd";
		
		return answer;
		
	} // solution
	
	public static void main(String[] args) {
		
		Ex01_EvenOdd sol = new Ex01_EvenOdd();
		
		System.out.println("** 10 : " + sol.solution(10));
		System.out.println("** 5 : " + sol.solution(5));
		
	} // main
	
} // class
