package jv1_2345_test; // p.157

import java.util.Scanner;

// 단어의 글자위치를 섞어서 보여주고 원래의 단어를 맞추는 예제이다.
// 실행결과와 같이 동작하도록 예제의 빈 곳을 채우시오. 

// 결과
// Q1. lvtsieeoin 의 정답을 입력하세요. > television
// 맞았습니다.

// Q2. otepcumr의 정답을 입력하세요. > computer
// 맞았습니다.

// Q3. usemo 의 정답을 입력하세요. > asdf
// 틀렸습니다.

// Q4. ohpne 의 정답을 입력하세요. > phone
// 맞았습니다.

public class Chap05_06 {

	public static void main(String[] args) {

		String[] words = {"television", "computer", "mouse", "phone"};
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < words.length; i++) {
			
			char[] question = words[i].toCharArray(); // String을 char[]로 변환
			// words 배열 안의 "단어"를 char로 형변환하여 알파벳 하나씩 추출
			
			//-------------------------------------------------------------------------
			
			// (1) 알맞은 코드를 넣어 완성하시오.
			// 과제 -> char 배열 question에 담긴 문자의 위치를 임의로 바꾼다.
			for (int j = 0; j < question.length; j++) {
				
				int idx = (int)(Math.random() * question.length);
				
				char temp = question[i]; // 문자의 위치를 임의로 변경하는 것이기 때문에 [i] 사용
				question[i] = question[idx];
				question[idx] = temp;
				
			} // for_j
			
			System.out.printf("Q%d. %s의 정답을 입력하세요. > ", i + 1, new String(question));
															// char[] question => String 
			
			// String name = : 묵시적 선언
			// new String () : 명시적 선언 (괄호 안에 정확한 크기(값) 지정) 
			
			String answer = sc.nextLine();
			
			// trim()으로 answer의 좌우 공백을 제거한 후, equals로 words[i]와 비교
			// < trim() >
			// - 문자열의 처음과 마지막의 공백을 제거. String 클래스에 정의되어 있음.
			// => 사용법 : 문자열.trim();
			
			if ( words[i].equals(answer.trim()) )
			// == 사용 불가. String은 동등비교 시 equals 사용해야 됨
			// if (words[i] == answer.trim()) => else 값 출력됨.
				System.out.printf("맞았습니다. %n%n");
			else
				System.out.printf("틀렸습니다. %n%n");

		} // for_i
		
		sc.close();
		
	} // main

} // class