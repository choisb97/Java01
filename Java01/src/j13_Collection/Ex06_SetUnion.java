package j13_Collection;

import java.util.HashSet;

/*
< List >
- 순서 O, 중복 O

< Set >
- 순서 X, 중복 X

< Map >
- 순서 X, 중복 Key : X / Value : O
*/

/*
 < 대량 연산 메서드 >
 : ppt 33 ~ 35, 대량연산
 - set1과 set2의 합집합, 교집합... 
*/

public class Ex06_SetUnion {

	public static void main(String[] args) {
		
		// 1. Set 2개 정의
		HashSet<String> set1 = new HashSet<String>();
		
		set1.add("Red");
		set1.add("Blue");
		set1.add("Green");
		set1.add("Pink");
		set1.add("Black");
		System.out.println("** set1 = " + set1);
		
		
		HashSet<String> set2 = new HashSet<String>();
		
		set2.add("Seoul");
		set2.add("Busan");
		set2.add("Green");
		set2.add("Paris");
		set2.add("Korea");
		System.out.println("** set2 = " + set2);

	//----------------------------------------------------------------------------------
		
		// 2. 대량연산
		
		set1.addAll(set2); // set1에 합집합 union
		System.out.println("\n** 합집합 set1 = " + set1);
		
		set1.retainAll(set2); // 교집합 intersection : set1의 원소 = set2의 원소
		System.out.println("\n** 교집합 set1 = " + set1);

		// * 부분집합 subset => set2가 set1의 부분집합이면 true / 아니면 false
		System.out.println("\n** 부분집합 => " + set1.containsAll(set2));
		                                        // containsAll : 부분집합

		// * 차집합(difference of sets)
		set1.add("Red");
		set1.add("Blue");
		System.out.println("\n** add 후 set1 = " + set1);
		
		set1.removeAll(set2); // set1 - set2
		  // removeAll : 차집합
		System.out.println("\n** 차집합 set1 = " + set1);
		
	} // main

} // class
