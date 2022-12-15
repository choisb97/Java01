package jv1_67_test; // p.210

// 연습문제 6-4에서 작성한 클래스메서드 getDistance()를 MyPoint클래스의 인스턴스메서드로 정의하시오.
// 추가조건 : 기준 위치(x, y)는 멤버변수로 정의하고 생성자의 매개변수로 전달받아 초기화한다.
// getDistance()는 매개변수를 두 개만 사용하면 된다.

// 결과 = 1.4142135623730951

class MyPoint { // 기준위치(x, y) 멤버변수로 정의
// default = package 전체
	int x;
	int y;
	
	/*
	 ** 기본 생성자 = default 생성자
	 MyPoint() {}
	 */

	MyPoint(int x, int y) {  // 생성자의 매개변수로 전달받아 초기화
		                     // = 클래스랑 이름 동일, 매개변수, 중괄호, return X
		this.x = x;
		this.y = y;
	
	} // MyPoint
	
	// (1) 인스턴스메서드 getDistance를 작성하시오.
	double getDistance(int x1, int y1) { // 매개변수 두 개만 사용
	// 인스턴스메서드 = static X
		
		return Math.sqrt((this.x - x1) * (this.x - x1) + (this.y - y1) * (this.y - y1));
	
	} // getDistance
	
} // c_MyPoint


public class Chap06_06 { // class파일명과 동일해야 되고, main 포함되어 있어야 됨.

	public static void main(String[] args) {
		
		// 인스턴스
		MyPoint p = new MyPoint(1, 1);
		
		// p와 (2, 2)의 거리를 구한다.
		System.out.println("p = " + p.getDistance(2, 2));
		// p = 1.4142135623730951
		// (x, y) = (1, 1) / (x1, y1) = (2, 2) == Chap06_04 결괏값과 동일

		MyPoint p1 = new MyPoint(5, 5);
		System.out.println("p1 = " + p1.getDistance(10, 20));
		// p1 = 15.811388300841896
	
	
	} // main

} // class
