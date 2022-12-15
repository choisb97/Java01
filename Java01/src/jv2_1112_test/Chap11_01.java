package jv2_1112_test; // p. 449

/*
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;
*/
import java.util.*; // util.*; 이용해서 한 번에 처리 가능

// 다음 코드의 실행결과를 적으시오.

// 결과 = 7 6 3 2

public class Chap11_01 {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		/*
		 ** 원래 문제
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);
		*/
		// 쌤 추가문제
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(12);
		list.add(10);
		list.add(2);
		list.add(2);
		list.add(7);
		System.out.println("** list = " + list); // 중복 허용
		
		HashSet<Integer> set = new HashSet<Integer>(list); // 중복요소 제거, 순서 랜덤. 2, 6, 3, 7
		System.out.println("** set = " + set);
		
		LinkedHashSet<Integer> lset  = new LinkedHashSet<Integer>(set);
		System.out.println("** lset = " + lset);
		
		
		TreeSet<Integer> tset = new TreeSet<Integer>(set); // 오름차순으로 정렬. 2, 3, 6, 7
		System.out.println("** tset = " + tset);
		
		Stack<Integer> stack = new Stack<Integer>();

		stack.addAll(tset);
	
		while (!stack.empty()) // !stack.empty() : 다 비워지지 않았을(!not) 때
			System.out.println(stack.pop()); // pop() : stack에 저장된 값을 하나씩 꺼내는 메서드. 

	} // main

} // class
