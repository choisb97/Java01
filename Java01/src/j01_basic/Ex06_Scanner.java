package j01_basic;

import java.util.Scanner;

public class Ex06_Scanner {

	public static void main(String[] args) {

		// 1) 입력받기
		// nextInt : 값만 가져온다
		// nextLine : 값 + enter키 가져온다
		
		//-----------------------------------------------------------------------------
		
		// 생성 시 매개변수(System.in) 넣기.
		Scanner sc = new Scanner(System.in); // String name = "최수빈";
		
		System.out.println("이름을 입력하세용 : ");
		String name = sc.nextLine(); // 입력완료(Enter_Key 클릭) 시 까지 대기, 입력완료된 값을 return
		             // Scanner .next 어쩌구 -> 입력 받아주는..?
		
		//-----------------------------------------------------------------------------
		
		System.out.println("나이를 입력하세용 : ");
		// String age = Integer.parseInt(sc.nextLine());
		int age = sc.nextInt();	// 정상 실행
		
		//-----------------------------------------------------------------------------
		
		System.out.println("금액을 입력하세용 : ");
		int price = sc.nextInt();	// 입력 시 문자형태 포함되면 Error
		
		//-------------------------------------------------------------------------------
		
		System.out.println("메뉴를 입력하세용 : ");
		String menu = sc.nextLine(); // 아래 문장으로 흘러감 - nextInt() 가 두고 간 Enter_key 를 인식하기 때문
		// nextInt 여러개 쓰고 nextLine 사용하면 그 부분에서 바로 close로 이동.
		
		//-------------------------------------------------------------------------------
		
		// 2) 출력하기
		
		System.out.println("이름 : " + name);  // 입력하고 엔터키 눌러야 다음 동작 실행 됨.
		System.out.println("나이 : " + age);	 // 마저 입력 후 엔터키 누르면 전체 동작 확인 됨.
		System.out.println("금액 : " + price);	 
		System.out.println("메뉴 : " + menu);	  
		
		sc.close(); // 다 썼으면 메모리에서 지워야 됨, close문을 넣어주지 않으면 노란 밑줄(경고) 생김.
		// job 을 끝마쳤다는 뜻으로 입/출력과 관련된 것들은 자동으로 지워지지 않음.
		
	}	// main

}	// class
