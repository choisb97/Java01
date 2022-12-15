package j00_practice;

/*
 < 평균 구하기 >
 -  정수를 담고 있는 배열 arr의 평균값을 return하는 함수를 완성해보세요.
 
 - 제한사항
   1) arr은 길이 1 이상, 100 이하인 배열입니다.
   2) arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.
*/

public class Ex04_getAverage {

	public double getavg(int[] arr) {
		
		int sum = 0; // a.
		
		for (int i = 0; i < arr.length; i++) { // b.
			sum += arr[i];
		} // for
		
		double answer = (double) sum / arr.length; // c.
		
		return answer;
	
	} // getavg
	
	/*
	 a. 배열의 값을 더할 변수(sum)를 선언.
	 b. 반복문을 이용해 배열의 값 하나씩 sum 변수에 더한다.
	 c. sum / 배열의 길이를 나누어 평균 값을 낸다. 여기서 answer타입이 double형이기 때문에 형변환 한다.
	*/
	
	public static void main(String[] args) {
		
		Ex04_getAverage ga = new Ex04_getAverage();
		
		int[] test = { 1, 2, 3, 4 };
		
		int [] test2 = {5, 5};
		
		System.out.println("** test[] 합의 평균 = " + ga.getavg(test));
		System.out.println("** test2[] 합의 평균 = " + ga.getavg(test2));

	} // main

} // class
