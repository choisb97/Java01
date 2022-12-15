package jv1_2345_test;

import java.util.Scanner;

// < 복습 과제 >
// - 이름과 나이를 입력하면 평생 먹은 밥값 계산 후 출력하기
// 한 끼니에 5,000원으로
// ex) 나이 : 20살 -> 20 * 365 * 3 * 5,000

public class Ex01_BasicTest {

	public static void main(String[] args) {
		
		// 1) 입력받기
		Scanner sc = new Scanner(System.in);
		// Scanner 빨간밑줄(에러) => ctrl + shift + o => java.util 선택
		
		System.out.println("이름을 입력하세용 : ");
		String name = sc.nextLine();
		
		System.out.println("나이를 입력하세용 : ");
		int age = sc.nextInt();
		
		sc.close();
		
		// 2) 밥값 계산하기
		int price = age * 365 * 3 * 7000;
		
		// 3) 출력하기
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		// System.out.println("밥값 : " + price + "원");
		System.out.printf("밥값 : %,d원 \n", price);

	}

}
