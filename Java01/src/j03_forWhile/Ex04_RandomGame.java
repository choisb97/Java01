package j03_forWhile;

import java.util.Random; 
import java.util.Scanner;

public class Ex04_RandomGame {

	public static void main(String[] args) {
		
		// 1) Random Number 구하기
		
		Random rn = new Random();
		
		int r = rn.nextInt(10) + 1;
		//				  최댓값  최솟값
		
		//-----------------------------------------------------
		
		// 2) myNumber 입력받기
		
		// => 반복문 적용 (while || do ~ while)
		//	  오류 시에는 계속 재입력 요청
		//	  아니면 결과 확인
		
		Scanner sc = new Scanner(System.in); // 선언문은 반복할 필요 없음.
		
		int myNum = 0;	// 초기화
		
		// 방법 1 : while 구문 사용
		/*
		while(true) {
			System.out.println("1 ~ 10 범위 내에서 정수를 입력하세요 : ");
		
			myNum = sc.nextInt();	// 지역변수
		
			// => 입력 값 확인
			if (myNum < 1 || myNum > 10) {	// myNum 이 1보다 작거나 10보다 크면
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			} else {	// 아니면
				sc.close();	// Scanner 종료
				break;
			}
		} // while
		*/
		
		//---------------------------------------------------------
		
		// 방법 2 : do ~ while 구문 사용
		// => 오류 조건을 반복문의 조건으로 이용
		do {
			System.out.println("1 ~ 10 범위 내에서 정수를 입력하세요 : "); // 오류일 시 반복문이 실행되면서 계속 출력됨
			
			myNum = sc.nextInt();	// 지역변수
			
		} while ((myNum < 1 || myNum > 10)); // myNum 이 1보다 작거나 10보다 크면 조건 반복
		
		sc.close();
		
		//---------------------------------------------------------
		
		// 3) 결과처리
		
		// Random 함수의 결과와 일치하면 금메달
		// 차이가 1이면 은메달, 차이가 2면 동메달, 아니면 꽝
		// 절대값을 지원하는 Math class 의 메서드 abs 적용.
		
		if (myNum == r) System.out.println("^^ 금메달 ^^");
		else if (Math.abs(myNum - r) == 1) System.out.println("^^ 은메달 ^^");
		else if (Math.abs(myNum - r) == 2) System.out.println("^^ 동메달 ^^");
		else System.out.println("^^ 꽝!!! ^^");
		
		System.out.println("----------------------");
		
		System.out.println("당첨번호 : " + r);
		System.out.println("내 번호 : " + myNum);
		
		System.out.println("**********************");
		System.out.println("Program Stop");

	} // main

} // class
