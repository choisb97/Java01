package j02_ifSwitch;

import java.util.Random;
import java.util.Scanner;

/*
 < 숫자 맞추기 게임 >
 1 ~ 10 범위에서 숫자 하나를 입력받아
 -> 입력 숫자가 이 범위를 벗어나면 "잘못 입력했습니다."
    다시 1 ~ 0 범위의 숫자를 입력하세요.
 -> Random 함수의 결과와 일치하면 금메달
 -> 차이가 1이면 은메달, 차이가 2면 동메달, 아니면 꽝
*/

public class Ex03_ifRandomGame {

	public static void main(String[] args) { //void(무효의, 빈, 없는)
		
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
		
		// => 입력값 확인
		// myNum 가 1 이상이고 10 이하여야 함.
		// 1 <= myNum <= 10 / 이렇게 사용 XXXXX
		
		// (myNum < 1 || myNum > 10) // 1보다 작거나 10보다 크면
		if (!(myNum >= 1 && myNum <= 10)) { // 1이상 10이하의 반대(! not)
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요."); // 반복문 써야하기 때문에 그냥 종료하는 걸로.
			return; // #15 void 메서드에서 return 을 단독으로 사용하면 메서드 종료.
			// return 후 다른 문장이 있어도 처리하지 않음.
		}
				
		// 3) 결과처리(당첨여부)
		// Random 함수의 결과와 일치하면 금메달,
		// 차이가 1이면 은메달, 차이가 2면 동메달, 아니면 꽝
		
		/**
		if (myNum == r) System.out.println("^^ 금메달 ^^");
		else if (myNum - r == 1 || myNum - r == -1) System.out.println("^^ 은메달 ^^");
		else if (myNum - r == 2 || myNum - r == -2) System.out.println("^^ 동메달 ^^");
		else System.out.println("^^ 꽝!!! ^^");

		System.out.println("----------------------");
		
		System.out.println("당첨번호 : " + r);
		System.out.println("My Number : " + myNum);
		*/
		
		// 절대값을 지원하는 Math class의 메서드 'abs' 적용하면 짧게 줄여서 조금 더 편리함.
		
		if (myNum == r) System.out.println("^^ 금메달 ^^");
		else if (Math.abs(myNum - r) == 1) System.out.println("^^ 은메달 ^^");
		else if (Math.abs(myNum - r) == 2) System.out.println("^^ 동메달 ^^");
		else System.out.println("^^ 꽝!!! ^^");
		
		System.out.println("----------------------");
		
		System.out.println("당첨번호 : " + r);
		System.out.println("내 번호 : " + myNum);
		
	} // main

} // class
