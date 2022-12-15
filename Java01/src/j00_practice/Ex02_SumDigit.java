package j00_practice;

/*
 < 자릿수 더하기 >
 - 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 함수를 만드세요.
   예를 들어 N = 123이면 1 + 2 + 3 = 6을 return하면 됩니다.
   
 - 제한사항 : N의 범위 : 100,000,000이하의 자연수
*/

public class Ex02_SumDigit {
	
	public int addDigit(int n) {
		
		int answer = 0;
		/*
		// 1. String 변환 방법
		String s = Integer.toString(n); // int n을 String으로 변환
		
		for (int i = 0; i < s.length(); i++) {
			answer += Integer.parseInt(s.substring(i, i + 1));
		} // for
		*/
		
		// 2. 정수 나눗셈
		while (n > 0 && n < 100000000) {
			
			answer += n % 10;
			
			n /= 10;
			
		} // while
		
		return answer;
	} // addDigit

	public static void main(String[] args) {

		Ex02_SumDigit ad = new Ex02_SumDigit();
		
		System.out.println("1 + 2 + 3 = " + ad.addDigit(123));
		System.out.println("9 + 8 + 7 = " + ad.addDigit(987));
		
	} // main

} // class
