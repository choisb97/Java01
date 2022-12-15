package j13_Collection;

import java.util.ArrayList;

import j10_APITest.Ex05_Person;

/*
< List >
- 순서 O, 중복 O

< Set >
- 순서 X, 중복 X

< Map >
- 순서 X, 중복 Key : X / Value : O
*/

//< 계층도 >
//=> Collection(i) -> List(i) -> LinkedList, ArrayList
//=> Collection(i) -> List(i), Deque(i) -> LinkedList

/*
 < ArrayList > (ppt 18, 19 ~)

 < ArrayList<E>의 저장용량 >
 => 데이터가 증가하면 메서드 호출하지 않아도 저장용량은 자동증가 함
 => 필요시엔 미리 설정가능
 
 1) 생성자 
 => 초기값 지정 가능 : new ArrayList<>(100);
 
 2) 메서드 이용
 => public void ensureCapacity(int minCapacity) : ArrayList에 정의 
*/

public class Ex01_ArrayList {

	public static void main(String[] args) {
		
		// 1. 정의
		
		ArrayList<Object> list = new ArrayList<Object>();
		
		/*
		 < 저장용량 >
		 => 필요시에 자동으로 늘려줌
		    (매우 비효율적 : 큰공간을 할당하고 기존의 값들을 이동함)
		 => 생성 시에 할당가능 : 생성자 매개변수로 지정
		 
		 < 비교 >
		 => 사이즈는 리스트의 요소의 수,
		    용량은 리스트는 잠재적으로 그 내부구조를 재할당없이 수용할 수 있는 요소의 수 
		*/
		
		System.out.println("** size 00 = " + list.size());
		list.ensureCapacity(20);
		System.out.println("** size 01 = " + list.size());
		
	//---------------------------------------------------------------------------------
		
		// 2. 초기화
		// => add(기본 자료형 -> Wrapper : 자동 형변환)
		
		// ArrayList에는 객체만 저장 가능.
		// autoboxing에 의해 기본형이 참조형으로 자동 변환.
		list.add(100);
		// list.add(new Integer(200));
		list.add(200); // 원래는 new Integer(200) 사용이 맞음.
		list.add(100);
		list.add("홍길동");
		list.add(300);
		list.add(400);
		list.add(500);
		
	//---------------------------------------------------------------------------------

		// 3. 사용
		// => get, set(수정), remove
		
		int sum = (int)list.get(0) + (int)list.get(1);
		System.out.println("\n** sum = "+ sum);
		
		System.out.println("\n** size 1 = " + list.size()); // 배열의 길이(length) 대신 크기(size)

		list.set(0, sum); // 수정 -> index 0 번째를 sum으로
		list.add(2, 888); // 끼워넣기 -> index 2 번째에 888 추가
		list.remove(5);	  // 삭제 -> index 5 번째 배열 삭제
		list.remove(6);
		System.out.println("** size 2 = " + list.size());
		
		System.out.println("");
		
	//---------------------------------------------------------------------------------
		
		// 4. 출력
		
		for (Object o : list) { 
			System.out.print(o + " ");
		} // eachFor
		
		System.out.println("\n");
		
	//---------------------------------------------------------------------------------
		
		// 5. Person 추가하기
		
		list.add(1, new Ex05_Person("920605-1234567", "이그린"));
		// index 1 번째에 Ex05_Person - 끼워넣기
		
		
		for (Object o : list) { // eachFor
			System.out.print(o + " \n");
		} // for
		
		System.out.println("\n** size 3 = " + list.size());
		
	} // main

} // class
