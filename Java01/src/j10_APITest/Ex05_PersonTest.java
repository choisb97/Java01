package j10_APITest;

import java.util.Arrays;

public class Ex05_PersonTest {
	
	// 쌤 풀이
	public static void pSort(Ex05_Person[] ars) { // Ex05_Person[] ars : 참조자료형
		
		for (int i = 0; i < ars.length; i++) {
			for (int j = i + 1; j < ars.length; j++) {
				if (ars[i].getAge() < ars[j].getAge()) { // 내림차순 비교( < ), 오름차순 비교( > )
					
					Ex05_Person temp = ars[i];
					ars[i] = ars[j];
					ars[j] = temp;
					
				} // if
			} // for_j
		} // for_i
	} // pSort
	
//========================================================================================

	public static void main(String[] args) {
		
		// 생성과 동시에 초기화
		Ex05_Person p1 = new Ex05_Person("970517-2345678", "최수빈");
		
		p1.infoPrint();
		
		System.out.println("** toString => " + p1);
		
		System.out.println("");

	//----------------------------------------------------------------------------------
		
		Ex05_Person p2 = new Ex05_Person("030605-3234567", "김철수");

		p2.infoPrint();

		System.out.println("** toString => " + p2);
		
		System.out.println("");
		
	//----------------------------------------------------------------------------------

		Ex05_Person p3 = new Ex05_Person("920605-1234567", "이재영");

		p3.infoPrint();

		System.out.println("** toString => " + p3);

		System.out.println("");

	//----------------------------------------------------------------------------------

		Ex05_Person p4 = new Ex05_Person("940313-2234567", "최보라");

		p4.infoPrint();

		System.out.println("** toString => " + p4);

		System.out.println("");

	//----------------------------------------------------------------------------------

		Ex05_Person p5 = new Ex05_Person("930208-1234567", "홍영우");

		p5.infoPrint();

		System.out.println("** toString => " + p5);
		
		System.out.println("");
		
	//----------------------------------------------------------------------------------
		
		// < Person Type의 배열에 5명을 채우고 나이가 많은 순서로 출력 >
		// => age : descending(내림차순)
		
		// * 순서 : Person Type 배열 정의, 5명으로 초기화, 정렬(반복문), 출력
		           // pa = person age
		Ex05_Person[] pa = {p1, p2, p3, p4, p5};
		/*
		 ** 과제처럼 한 번만 쓰는 경우 아래와 같이 바로 new 연산자 이용해서 배열에 넣어도 됨 - 일회성 **
		Ex05_Person[] pa = {p1, p2, new Ex05_Person("920605-1234567", "이재영")
								  , new Ex05_Person("940313-2234567", "최보라")
								  , new Ex05_Person("930208-1234567", "홍영우")};
		*/
		
		for (int i = 0; i < pa.length; i++) {
			for (int j = i + 1; j < pa.length; j++) {
				if (pa[i].getAge() < pa[j].getAge()) { // 내림차순
					
					Ex05_Person temp = pa[i];
					pa[i] = pa[j];
					pa[j] = temp;
					
				} // if
			} // for_j
		} // for_i

		System.out.println("** Person 배열 나이 많은 순 => \n" + Arrays.toString(pa));
		
		/*
		// 쌤 풀이
		// < for each 문 >
		// - 배열의 값만 순차적으로 사용가능하며 read만 가능. write 불가능 -> index 없기 때문에 접근(수정) 불가능.
		// for ( 변수타입 변수명 : 배열 이름 ) { 실행부 }
		
		pSort(pa); // 내림차순
		for(Ex05_Person p : pa) { // 배열의 타입과 동일하게 int, char, String 등 변경해야 함.
			System.out.println("------------------------------------");
			
			p.infoPrint(); // 실행부
		} 
		*/
	} // main

} // class
