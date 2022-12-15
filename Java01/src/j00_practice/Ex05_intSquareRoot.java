package j00_practice;

/*
 < 정수 제곱근 판별 >
 - 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
   n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고,
   n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요. 
   
 - 제한사항 : n은 1이상, 50000000000000 이하인 양의 정수입니다.
 
 - 입출력 예 1) 121은 양의 정수 11의 제곱이므로, (11+1)를 제곱한 144를 리턴합니다.
 - 입출력 예 2) 3은 양의 정수의 제곱이 아니므로, -1을 리턴합니다.
*/

public class Ex05_intSquareRoot {
	
	public long intsr (long n) {
		
		long answer = 0;
		
		// 1)
		double base = Math.sqrt(n);
		
		if (n % 1 > 0) {
			answer = -1;
		} else
			answer = (long)Math.pow(base + 1, 2);
		
		/*
		// 2)
		for (long i = 1; i <= n; i++) {
			if ( i * i == n) {
				answer = (i + 1) * (i + 1);
				break;
			} else
				answer = -1;
		} // for
		*/
		
		return answer;
	} // intsr

	public static void main(String[] args) {
		
		Ex05_intSquareRoot isr = new Ex05_intSquareRoot();
		
		System.out.println("** 121 => " + isr.intsr(121));
		System.out.println("** 3 => " + isr.intsr(3));
		

	} // main

} // class
