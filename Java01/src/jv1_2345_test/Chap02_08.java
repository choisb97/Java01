package jv1_2345_test; // p.68

// 아래는 변수 x, y, z 의 값을 서로 바꾸는 예제이다.
// 결과와 같이 출력되도록 (1)에 알맞은 코드를 넣으시오.

// 결과 : x = 2, y = 3, z = 1

public class Chap02_08 {

	public static void main(String[] args) {

		int x = 1,
			y = 2,
			z = 3;
		
		// (1) 알맞은 코드를 넣어 완성하시오.
		
		int temp; // 임시로 값을 저장하기 위한 변수 (빈 컵 역할) / tmp;
		
		temp = x; // x의 값을 temp에 저장
		x = y; // y의 값을 x에 저장
		y = z; // z의 값을 y에 저장
		z = temp; // temp에 저장된 값(최초 x값)을 z에 저장
		
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("z = " + z);
		
		

	}

}
