package j13_Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 < ArrayList >
 - 읽기(접근시간) : 빠름, 추가/삭제 : 느림
 - 순차적인 추가/삭제는 더 빠름, 비효율적인 메모리 사용
 
   배열 부족하면 => 더 큰 배열 생성 -> 기존 데이터 복사 -> 참조 변경
   처음부터 배열을 크게 생성하면 쓸 데 없는 메모리 사용으로 메모리 낭비이다.
   
 < LinkedList >
 - 읽기(접근시간) : 느림, 추가/삭제 : 빠름
 - 데이터가 많을 수록 접근성 떨어짐
*/

// < ArrayList와 LinkedList의 효율성 비교 >

public class Ex03_ArrayLinkedTest {
	
	// * 순차처리 add
	public static long add1(List<Object> list) {
		
		// 현재 시스템 시간을 밀리세컨드(ms) 단위로 전달해줌
		// return 값은 long Type 
		long start = System.currentTimeMillis();

		for (int i = 0; i < 1000000; i++)
			list.add(i + "");
		
		long end = System.currentTimeMillis();
		
		return end - start;
	} // add1
	
	
	// * 비순차처리 => 중간에 넣기
	public static long add2(List<Object> list) {
		
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < 10000; i++)
			list.add(500, "X");
		
		long end = System.currentTimeMillis();
		
		return end - start;
	} // add2
	
	
	// * 순차처리remove : 뒤에서부터 삭제
	public static long remove1(List<Object> list) {
		
		long start = System.currentTimeMillis();
		
		for (int i = list.size()-1; i >= 0; i--)
			list.remove(i);
		
		long end = System.currentTimeMillis();
		
		return end - start;
	} // remove1
	
	
	// * 중간에서 remove : 앞에서부터 삭제  
	public static long remove2(List<Object> list) {
		
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < 10000; i++)
			list.remove(i);
		
		long end = System.currentTimeMillis();
		
		return end - start;
	} // remove2
	
	
//======================================================================================

	public static void main(String[] args) {
		
		// 추가할 데이터의 개수를 고려하여 충분히 잡아야한다.
		//ArrayList<String> al = new ArrayList<>(2000000);
		ArrayList<Object> al = new ArrayList<Object>(100);
		LinkedList<Object> ll = new LinkedList<Object>();

		
		System.out.println("< 순차적으로 추가하기 >");
		System.out.println("ArrayList : " + add1(al)); // 승
		System.out.println("LinkedList : " + add1(ll));
		System.out.println();
		
		System.out.println("< 중간에 추가하기 >");
		System.out.println("ArrayList : " + add2(al));
		System.out.println("LinkedList : " + add2(ll)); // 승
		System.out.println();
		
		System.out.println("< 앞에서부터 삭제하기(비순차) >");
		System.out.println("ArrayList : " + remove2(al));
		System.out.println("LinkedList : " + remove2(ll)); // 승
		System.out.println();
		
		System.out.println("< 뒤에서부터 삭제하기(순차) >");
		System.out.println("ArrayList : " + remove1(al)); // 승
		System.out.println("LinkedList : " + remove1(ll));
		
		System.out.println("\n** Program Stop **");
		
	} // main

} // class

/*
 < 결과 >
 1. 충분한 용량 : new ArrayList<>(2000000)
 
 < 순차적으로 추가하기 >
 ArrayList : 112
 LinkedList : 172

 < 중간에 추가하기 >
 ArrayList : 2890
 LinkedList : 10

 < 앞에서부터 삭제하기(비순차) >
 ArrayList : 1639
 LinkedList : 102

 < 뒤에서부터 삭제하기(순차) >
 ArrayList : 7
 LinkedList : 25
 
 2. 부족한 용량 : new ArrayList<>(100)
 
 < 순차적으로 추가하기 >
 ArrayList : 154
 LinkedList : 175

 < 중간에 추가하기 >
 ArrayList : 2719
 LinkedList : 9

 < 앞에서부터 삭제하기(비순차) >
 ArrayList : 1629
 LinkedList : 109

 < 뒤에서부터 삭제하기(순차) >
 ArrayList : 7
 LinkedList : 23
*/