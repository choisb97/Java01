package j01_basic;

// < bit 연산 >

// - 쉬프트 연산, 논리 연산 => 암호화하는 곳에 많이 쓰임.


public class Ex04_Oper02 {

	public static void main(String[] args) {

		int x = 10;	// 1 0 1 0 -> 2 + 8
					// 8 4 2 1
		int y = 3;	// 0 0 1 1 -> 1 + 2
					// 8 4 2 1
		
		// 1) 쉬프트 연산 :  >> , <<
		
		System.out.println(" < 쉬프트 연산 > ");
		System.out.println("x >> y = " + (x >> y)); // 1
		// x 를 오른쪽으로 y 만큼 이동 : 1010(x) -> 0101 -> 0010 -> 0001 ==> 세 번(y = 3) 이동
		
		System.out.println("x = " + x);
		System.out.println("y = " + y);

		System.out.println("---------------------------");
		
		System.out.println("x >> y = " + (x >> 1)); // 0101 = 5 (4 + 1)
		System.out.println("x >> y = " + (x >> 2)); // 0010 = 2
		
		System.out.println("---------------------------");
		System.out.println("---------------------------");

		System.out.println("x << y = " + (x << y)); // 80
		// x 를 왼쪽으로 y 만큼 이동 : 1010(x) -> 1  0 1 0 0 -> 1 0   1 0 0 0 -> 1 0 1 0000 => 80 ==> 세 번(y = 3) 이동
		                               // 16  8 4 2 1   32     8         64  16
		
		//------------------------------------------------------------------------
		
		System.out.println("x << y = " + (x << 1)); // 1 0100 = 20 (16 + 4)
		System.out.println("x << y = " + (x << 2)); // 10 1000 = 40 (32 + 8)
		
		System.out.println("---------------------------");
		
		// 2) 논리 연산
		// - AND &, OR |, XOR ^ (같으면 0, 다르면 1)
		
		System.out.println(" < 논리 연산 > ");
		
		System.out.println("x & y = " + (x & y)); // 1010
		// 둘 다 1 이면 1, 하나라도 다르면 0				   // 0011
												   // 0010 => 2
		
		System.out.println("x | y = " + (x | y)); // 1010
		// 둘 중 하나라도 1 이면 1 					   // 0011
												   // 1011 => 11 (8 + 2 + 1)
		
		System.out.println("x ^ y = " + (x ^ y)); // 1010
		// 값이 같으면 0, 다르면 1						   // 0011
												   // 1001 => 9 (8 + 1)
		
	}	// main

}	// class
