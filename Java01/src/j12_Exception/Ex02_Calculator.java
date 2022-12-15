package j12_Exception;

import java.util.Scanner;

/*
 < 실습 >
 => 두개의 정수를 입력받아 4칙연산(+, -, *, /) 결과 출력하기
 => 입력 정수는 1 ~ 99 까지 허용
 => nextLine()으로 입력받기 -> try~catch 적용하기
 1) 범위를 벗어난 값를 입력하면 정상 값 입력할 때까지 반복
 2) 반복문 이용해서 종료하고 싶을 때까지 Test 하기.

 < Scanner 사용시 주의 사항 >
 => nextInt(), nextLine() 사용시 주의
    nextInt()는 개행문자 (\n)가 뒤에 붙고, 숫자만 받아 처리한다. 
    그래서 nextInt()만 계속되면 문제가 없는데, 
    뒤 이어서 nextLine()이 오면 앞 nextInt()의 
    남겨진 \n 을 한 줄로 인식한다. 
    -> InputMismatchException : 정수로 입력해야 하는데 문자나 실수를 입력한 경우 예외 발생
*/

public class Ex02_Calculator {

	public static void main(String[] args) {
		
		// 1. Scanner 인스턴스, 변수 정의
		Scanner sc = new Scanner(System.in);
		
		int num1,
			num2;
		
		
		// 2. 반복문(종료하고 싶을 때까지 : while, do~while), try ~ catch 적용
		// => 두 개의 정수를 입력받기
		// => 입력받은 정수 범위 확인 (1 ~ 99)
		//    Yes : 사칙연산(+, -, *, /) 결과 출력하고 종료
		//    No : 다시 입력받기 반복
		
		System.out.println("< 계산기(Calculator) 프로그램 >");

		while(true) { // true이면 무조건 진행
			try {
				System.out.println("\n** 정수 1을 입력하세요 : ");
				num1 = Integer.parseInt(sc.nextLine()); // NumberFormatException
				//num1 = sc.nextInt();
				// InputMismatchException 발생
				// => 주의사항 : 입력값 중 숫자만 가져가고 남아있는 Enter_Key 때문에 무한루프
				
				// 입력받은 정수 1 범위 확인
				if (num1 < 1 || num1 > 99) {
					System.out.println("입력한 정수 1이 범위(1~99)를 벗어납니다.");
					continue; // 종료하고 싶을 때까지
				}
				
				System.out.println("** 정수 2를 입력하세요 : ");
				num2 = Integer.parseInt(sc.nextLine()); // NumberFormatException
				//num2 = sc.nextInt(); // InputMismatchException
				
				// 입력받은 정수 2 범위 확인
				if (num2 < 1 || num2 > 99) {
					System.out.println("입력한 정수 2가 범위(1~99)를 벗어납니다.");
					continue; // 종료하고 싶을 때까지
				}
				
				System.out.println("\n< 결과 >");
				System.out.println("1. Add = " + (num1 + num2));
				System.out.println("2. Min = " + (num1 - num2));
				System.out.println("3. Mul = " + (num1 * num2));
				System.out.println("4. Div = " + (num1 / num2));
				System.out.println("5. Mod = " + (num1 % num2)); // 나머지 Modulo
				
				
				System.out.println("\n** 종료하시겠습니까? (Y : 종료) => ");
				
				// 대/소문자 모두 가능하도록 toUpperCase()추가
				if (sc.nextLine().toUpperCase().equals("Y")) {
				//if (sc.nextLine().equals("Y")) { // 대문자 Y 만 가능
					System.out.println("\n** Program 종료 ** ");
					break; // Y/y로 종료의사 표현
				} 
				
			} catch (NumberFormatException e) {
				  // 정수로 입력해야 하는데 문자나 실수를 입력한 경우 예외 발생
				System.out.println("\n** NumberFormatException = " + e.toString());
				System.out.println("** 정확하게 정수만 입력해주세요 **");

			} catch (Exception e) {
				System.out.println("\n** Exception = " + e.toString());
			} // t~c
			
		} // while
		
		sc.close();
		
	} // main

} // class
