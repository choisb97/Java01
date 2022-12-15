package j02_ifSwitch;

import java.util.Scanner;

/*
 < 실습 >

 1. 월(month)을 입력 받아서

 2. 며칠까지인 지,
 => 1, 3, 5, 7, 8, 10, 12월 - ?월은 31일까지 입니다.
 => 4, 6, 9, 11월 - ?월은 30일까지 입니다.
 => 2월 - ?월은 29일까지 입니다.

 3. 무슨 계절인 지 출력하기.
 => 3 ~ 5 : 봄, 6 ~ 8 : 여름, 9 ~ 11 : 가을, 12 ~ 2 : 겨울

 < switch case 구문으로 작성하세용 >
*/

public class Ex06_switchMonth {

	public static void main(String[] args) {
		
		// 1) month 입력받기
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1 ~ 12 범위의 정수를 입력하세요 : ");
		
		int month = sc.nextInt();
		
		sc.close();
		
		//-------------------------------------------------

		String m, season;
		
		// 2) 며칠까지인 지
		
		/*// 예전에 쓰던 방식
		switch (month) {
		
		case 1 : case 3 : case 5 : 
		case 7 : case 8 : case 10 : 
		case 12 : m = "31";
			break;
			
		case 4 : case 6 : case 9 :
		case 11 : m = "30";
			
		case 2 : m = "29";
			break;
			
		default : m = "Error";
			
		}
		*/
		
		
		switch (month) {
		
		case 1, 3, 5, 7, 8, 10, 12 : m = "31"; 
		break;
		
		case 4, 6, 9, 11 : m = "30";
		break;
		
		case 2 : m = "29";
		break;
		
		default : m = "Error";
		} // switch
		
		//------------------------------------------------------------
		
		// 3) 무슨 계절인 지
		switch (month) {
		
		case 3, 4, 5 : season = "봄";
		break;
		
		case 6, 7, 8 : season = "여름";
		break;
		
		case 9, 10, 11 : season = "가을";
		break;
		
		case 12, 1, 2 : season = "겨울";
		break;
		
		default : season = "Error";
		} // switch
		
		System.out.printf("%d월은 %s일까지있고, %s입니다. \n", month, m, season);
		
	} // main

} // class
