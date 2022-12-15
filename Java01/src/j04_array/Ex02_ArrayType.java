package j04_array;

import java.util.Arrays;

public class Ex02_ArrayType {

	public static void main(String[] args) {
		
		// 타입별로 배열을 정의하고 출력해본다. (묵시적 정의)
		// => float, char, String
		// => data 개수는 5개
		
		// 1) float
		System.out.println("< float - 배열(묵시적) >");
		
		float[] weight = {40.4f, 50.5f, 60.6f, 70.7f, 80.8f};
		
		for (float f : weight) {
			System.out.printf(f + " ");
		}
		System.out.println("");
		
		System.out.println("---------------------------------------");
		
		//---------------------------------------------------------------
		
		// 2) char
		System.out.println("< char - 배열(묵시적) >");
		
		char[] grade = {'A', 'B', 'C', 'D', 'E'};
		
		for (char c : grade) {
			System.out.printf(c + " ");
		}
		System.out.println("");
		
		System.out.println("---------------------------------------");
		
		//---------------------------------------------------------------
		
		// 3) String
		System.out.println("< String - 배열(묵시적) >");
		
		String[] food = {"돈까스", "떡볶이", "막국수", "라면", "고기"};
		
		for (String s : food) {
			System.out.printf(s + " ");
		}
		System.out.println("");
		
		System.out.println("--------------------------------------");
		
		//-----------------------------------------------------------------
		
		// < Wrapper Class >
		// - 배열지원 : Arrays
		System.out.println("< Wrapper Class >");
		
		System.out.println("float = " + Arrays.toString(weight));
		System.out.println("char = " + Arrays.toString(grade));
		System.out.println("String = " + Arrays.toString(food));
		// String은 class 이기 때문에 Arrays.to 매개변수를 Object 선택
		// -> 모든 class 들은 Object 의 후손.
		
	} // main

} // class
