package j00_practice;

/*
 < 약수의 합 >
 - 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수를 완성해주세요.
 
 - 제한사항 : n은 0이상 3000이하 정수
 
 - 입출력 예
   1) 12의 약수는 1, 2, 3, 4, 6, 12입니다.
      이를 모두 더하면 28입니다.
   2) 5의 약수는 1, 5입니다. 이를 모두 더하면 6입니다.
*/

public class Ex03_SumDivisor {
	
	public int sumdivisior(int n) {
		
		int answer = 0;
		/*
		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				answer += i;
		} // for
			return answer;
		*/
		
		/*
		for (int i = 1; i <= n/2; i++) {
			if (n % i == 0) {
				answer += i;
			} // if
		} // for
		return answer + n;
		*/
		
		// 제한사항 : n은 0이상 3000이하 정수
		if (n < 0 || n > 3000) {
			System.out.println("\n** 정수의 범위를 다시 확인해주세요");
			return 0;
		} else {
			for (int i = 1; i <= n/2; i++) {
				if (n % i == 0) {
					answer += i;
				}
			} // for
			return answer + n;
		}
	} // sumdivisior

	public static void main(String[] args) {

		Ex03_SumDivisor sd = new Ex03_SumDivisor();
		
		System.out.println("5 약수의 합 = " + sd.sumdivisior(5));
		System.out.println("12 약수의 합 = " + sd.sumdivisior(12));
		System.out.println("15 약수의 합 = " + sd.sumdivisior(15));
		System.out.println("3005 약수의 합 = " + sd.sumdivisior(3005));
		System.out.println("5000 약수의 합 = " + sd.sumdivisior(5000));
		
	} // main

} // class
