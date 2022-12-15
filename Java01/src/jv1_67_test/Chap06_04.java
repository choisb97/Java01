package jv1_67_test; // p.209

// 두 점의 거리를 계산하는 getDistance()를 완성하시오.
// Hint : 제곱근 계산은 Math.sqrt(double a)를 사용하면 된다.

// 결과 = 1.4142135623730951

// 두 점의 거리를 계산하는 공식 = ((x좌표 차이의 제곱) + (y좌표 차이의 제곱))의 제곱근(루트)

// 참고 : Math.pow(double a, double b) -> 제곱값을 return

public class Chap06_04 {
	
	// 두 점 (x, y)와 (x1, y1)간의 거리를 구한다.
	public static double getDistance(int x, int y, int x1, int y1) {
		
		// (1) 알맞은 코드를 넣어 완성하시오.
		return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
		// x좌표 차이의 제곱이라 (x - x1) * (x - x1)
		// sqrt = 제곱근(루트) 식
		
		// -> Math.pow() 호출하는 것보다 연산식으로 처리하는 것이 더 효율적이다.
	
	} // getDistance

	public static void main(String[] args) {
		
		System.out.println(getDistance(1, 1, 2, 2));
		// 1.4142135623730951
		System.out.println(getDistance(10, 5, 20, 5));
		// 10.0
		System.out.println(getDistance(10, 5, 20, 15));
		// 14.142135623730951
		
	} // main

} // class
