package j02_ifSwitch;

import java.util.Random;
import java.util.Scanner;

/*
 < 숫자 맞추기 게임 >
 1 ~ 10 범위에서 숫자 하나를 입력받아
 -> Random 함수의 결과와 일치하면 금메달
 -> 차이가 1이면 은메달, 차이가 2면 동메달, 아니면 꽝

  Math class 이용
*/

public class Ex05_switchRandomGame {

	public static void main(String[] args) {
		
		// 1) Random Number 구하기
		Random rn = new Random(); // ctrl + shift + o => Random class - #3 에 자동 import
		
		int r = rn.nextInt(10) + 1; // 1 ~ 10 내에서 임의의 정수를 제공
				//       최댓값   최솟값
						
		// 2) myNumber 입력받기
		Scanner sc = new Scanner(System.in);
		// Scanner 는 괄호 안에 System.in 넣어줘야함.
		
		System.out.println("1 ~ 10 범위 내에서 정수를 입력하세요 : ");
				
		int myNum = sc.nextInt();
		
		sc.close();
		
		// 3) 결과처리(당첨여부)
		// Random 함수의 결과와 일치하면 금메달,
		// 차이가 1이면 은메달, 차이가 2면 동메달, 아니면 꽝
		
		switch (Math.abs(myNum - r)) {
		
		case 0 :
			System.out.println("^^ 금메달 ^^");
			break;
			
		case 1 : // 입력한 숫자와 당첨 번호의 차이가 1(case 1)인 경우 은메달
			System.out.println("^^ 은메달 ^^");
			break;
			
		case 2 :
			System.out.println("^^ 동메달 ^^");
			break;
			
		default :
			System.out.println("^^ 꽝!!! ^^");
		}
		
		System.out.println("당첨번호 : " + r);
		System.out.println("내 번호 : " + myNum);
		
	} // main

} // class
