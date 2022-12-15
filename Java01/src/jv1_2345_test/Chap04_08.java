package jv1_2345_test; // p.127

// Math.random()을 이용해서 1 ~ 6 사이의 임의의 정수를 변수 value에 저장하는 코드를 완성하라.
// (1)에 알맞은 코드를 넣으시오.

public class Chap04_08 {

	public static void main(String[] args) {

		// int value = ( (1) );
		int value = (int)(Math.random() * 6) + 1;
		
		 System.out.println("value : " + value);
		
	} // main

} // class
