package j13_Collection;

import java.util.HashSet;
import java.util.Iterator;


/*
< List >
- 순서 O, 중복 O

< Set >
- 순서 X, 중복 X

< Map >
- 순서 X, 중복 Key : X / Value : O
*/

/*
 < Set >
 : ppt 30p
 - 원소의 중복을 허용하지 않고, 순서가 없음
 - HashSet, TreeSet, LinkedHashSet

 < HashSet >
 - HashSet은 해쉬 테이블에 원소를 저장하기 때문에 성능면에서 가장 우수,
   하지만 원소들의 순서가 일정하지 않은 단점이 있다.

 < Iterator 클래스를 이용한 처리 (출력등..) >
 => 배열 -> Set
 => Set -> Iterator : 순차 처리 적용 
*/

public class Ex04_HashSet {

	public static void main(String[] args) {
		
		// 1. 정의
		// - 순서 없고, 중복 불가
		// - 통일성 Test
		//   제네릭을 적용하지 않거나, Object Type인 경우
		//   값은 같지만 Type이 다른 경우 Test(다른 데이터로 취급)
		
		
		// 1-1) Object
		// Object[] ob = {"가", "나", "123", new Integer(123), "가", "나", "다", "123"};
		Object[] ob = {"가", "나", "123", 123, "가", "나", "다", "123"};
		// Object Type이라 new Integer 없이 숫자만 써도 됨

		HashSet<Object> oset = new HashSet<>();
		
		for (Object o : ob) { // 배열의 타입과 동일하게 int, char, String 등 변경
			// add(Object e : boolean)
			if(!oset.add(o)) // 
			System.out.println("** 중복자료 => " + o);
		} // for

		System.out.println("** oset => " + oset);
		// ** oset => [가, 123, 다, 나, 123] -> 값은 같지만 Type이 다른 경우에 다른 데이터로 취급
		// 문자열 123은 한 개만 출력되고, 타입이 다른 123도 같이 출력된다.

	//----------------------------------------------------------------------------------
		
		// 1-2) String
		HashSet<String> set = new HashSet<String>();
		
	//----------------------------------------------------------------------------------

		// 2. add
		set.add("김치볶음밥");
		set.add("오므라이스");
		set.add("123");
		// set.add(123); -> Type 불일치
		// set.add(new Integer(123)); // Type 불일치 -> 컴파일 오류
		// => HashSet<String> -> Type을 String으로 지정했기 때문에
		set.add("쌀국수");
		set.add("오므라이스");

	//----------------------------------------------------------------------------------
	
		// 3. 출력
		System.out.println("\n** set = " + set);
		// ** set = [123, 쌀국수, 오므라이스, 김치볶음밥]
		// => 같은 Type의 오므라이스는 두 개 중 한 개만 출력됨
		
	//----------------------------------------------------------------------------------
		
		// 4. 활용
		// => 삭제(반복처리 필요), 크기확인(size)
		
		System.out.println("** set.size = " + set.size());
		
		
		/*
		 < Iterator를 이용한  순차처리 >
	      - 순차적으로 비교하면서 원하는 값 찾기, 삭제하기 
	      - iset의 remove는 set 에 반영됨
		*/
		
		Iterator<String> iset = set.iterator();
		
		while(iset.hasNext()) {
			if (iset.next().contains("3")) // 3이 포함되는 요소 remove(삭제)
				iset.remove();
			
			//set.add("볶음밥");
			// => 반복문 내부에서 set으로 접근 : java.util.ConcurrentModificationException
			
		} // while
		
		set.add("볶음밥");
		
		System.out.println("\n** iset = " + iset);
		// Iterator 인스턴스(변수)는 toString 정의되어 있지 않아서 그냥 주솟값 출력
		// toString 정의되어 있지 않은 인스턴스는 주솟값 출력 default
		System.out.println("** set = " + set);
		System.out.println("** set.size = " + set.size());
		
		
		/*
		 < Iterator 인스턴스 재사용 >
       	 - Iterator는 한 번 사용을 마치면 자료를 포인트하는 커서가  
           끝에 가 있어 hasNext()가 false를 return 하기 때문에 
           재할당해야 한다.
		*/
		
		iset = set.iterator();
		while(iset.hasNext()) {
			String menu = iset.next();
			if (menu.contains("밥")) // "밥"이 포함되어 있는 요소 출력
			System.out.println("\n** Iterator 인스턴스 재사용 = " + menu);
			
			// => 코드 비교
			//   -> 위에서 .next() 사용하고 또 사용 시 "밥"이 포함된 요소의 다음 값을 출력함
//	         if (iset.next().contains("밥"))
//	            System.out.println("** Iterator 인스턴스 재사용 => " + iset.next());
			
		} // while
		
	
		// < 반복문 사용 예 >
		// - set은 인덱스를 이용해서 차례대로 꺼내어 사용하는 것이 불가능한 것이지,
		//   무조건 반복문 내에서 사용할 수 없다는 것은 아님.
		for (int i = 0; i < 3; i++) {
			set.add(String.valueOf(i));
			// => set.add("0"), set.add("1"), set.add("2")
		}
		
		System.out.println("\n** set = " + set);
		System.out.println("** set.size = " + set.size());
		
	} // main

} // class
