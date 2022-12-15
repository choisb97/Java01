package j13_Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import j10_APITest.Ex05_Person;

/*
 < List >
 - 순서 O, 중복 O
 
 < Set >
 - 순서 X, 중복 X
 
 < Map >
 - 순서 X, 중복 Key : X / Value : O
*/

/*
 ** ppt 12 ~ 17 **
 < List 인터페이스 > - (ppt 18, 23)
 - List의 특징 : 순서가 있으며 중복된 원소를 가질 수 있다.
 - 구현 클래스 : ArrayList, LinkedList

 < LinkedList<E> >
 - ArrayList 및 배열의 단점을 보완하여 고안됨.   
 
 - 장점 
 1) 저장공간을 늘리는 과정이 간단.
 2) 자료 입력 & 삭제 과정이 단순.
 
 - 단점 : 순차처리의 access time이 ArrayList보다 느리다.
        => 빈번하게 삽입과 삭제가 일어나는 경우에 사용 


 < ArrayList<E> >
 - 순서를 유지하며 중복을 허용하는 자료구조  
 - 배열(Array)의 향상된 버전 또는 가변 크기의 배열이라고 생각하면 된다. 
 
 - 장점 : 자료구조가 간단하며 사용이 쉽고 순차처리의 access time이 가장 빠르다.
 
 - 단점
 1) 크기 변경시 새로운 배열을 생성하고 모든 자료를 복사해서 옮겨야 하므로 비효율적
 2) 비순차적인 자료의 추가,수정,삭제시에 복사 및 이동 때문에 비효율적
    => 크기가 일정하고 비순차적인 자료 수정이 발생하지 않는 경우 유리. 

-------------------------------------------------------------------------------------

 < source Code class header 참고 >
 public class LinkedList<E>
 extends AbstractSequentialList<E>
  implements List<E>, Deque<E>, Cloneable, java.io.Serializable
 {

 public class ArrayList<E> extends AbstractList<E>
  implements List<E>, RandomAccess, Cloneable, java.io.Serializable
 {

-------------------------------------------------------------------------------------
*/

// < 계층도 >
// => Collection(i) -> List(i) -> LinkedList, ArrayList
// => Collection(i) -> List(i), Deque(i) -> LinkedList

public class Ex02_LinkedList {

	public static void main(String[] args) {

		// 1. 정의
		LinkedList<Object> list = new LinkedList<Object>();
		
		
		// => 다형성 적용 예시
		// new ArrayList();, LinkedList(); 모두 가능
		List<String> list2 = new LinkedList<String>(); 
		// List list2 = new ArrayList();
				
	//---------------------------------------------------------------------------------
		
		// 2. 초기화
		// => add(기본 자료형 -> Wrapper : 자동 형변환)
		list.add("Java");
		list.add("HTML");
		list.add("CSS3");
		list.add("MySQL");
		list.add("Oracle");
		list.add("Servlet");
		list.add("JSP");
		list.add("Java");
		list.add("Spring");
		
	//---------------------------------------------------------------------------------
		
		// 3. 사용
		// => get, set(수정), remove
		list.remove(1);
		list.set(2, "홍길동");
		list.set(5, 12345);
		list.add(1, new Ex05_Person("920605-1234567", "이그린"));
		
	//---------------------------------------------------------------------------------

		// 4. 출력
		for (Object o : list) {
			System.out.println(o);
		} // for
		
	//---------------------------------------------------------------------------------

		// 5. 배열 -> List -> Iterator(순차처리를 지원하는 클래스)로 변환 가능
		String[] city = {"성남", "용인", "서울", "부산"};

		list2 = Arrays.asList(city); // Type 일치
		
		// ** 변환한 경우에는 원본을 변경할 수 없음
		// => 런타임 오류 발생 : java.lang.UnsupportedOperationException
		// list2.add("Test");
		
		
		// < Iterator >
		// - 순차처리를 편리하게 지원해주는 클래스
	    // => hasNext(), next() 메서드를 이용
		Iterator<String> iCity = list2.iterator();
		
		while(iCity.hasNext()) {
			System.out.println(iCity.next());
		}
		

	} // main

} // class
