package jv1_2345_test; // p.126

// 다음의 for문을 while문으로 변경하시오.

public class Chap04_05 {

	public static void main(String[] args) {
		
		/*
		for (int i = 0; i<= 10; i++) {
			for (int j = 0; j <= i; j++) {
				
				System.out.print("*");

			} // for_j
			
			System.out.println("");
		
		} // for_i
		*/
		
		//---------------------------------------------
		// p115 참고
		
		// while문
		
		int i = 0;
		
		while (i <= 10) {
			int j = 0;
			while (j <= i) {
				
				System.out.print("*");
				j++;
				
			} // while_j
			
			System.out.println("");
			i++;
			
		} // while_i

	} // main

} // class
