package j13_Collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/*
< List >
- 순서 O, 중복 O

< Set >
- 순서 X, 중복 X

< Map >
- 순서 X, 중복 Key : X / Value : O
*/

/*
 < 해싱과 해시함수 >
 : 정석 p.???? 
 해싱 => 해시 함수를 이용해서 데이터를 해시 테이블에 저장하고
         검색하는 기법

 < Map ( Key, Value ) >
 - HashMap (Key 값의 중복을 허용하지 않고, 순서 유지를 보장받지 못한다.) 
 - TreeMap (Key 값의 중복을 허용하지 않고, 키값으로 오름차순 정렬이 된다.)
 - LinkedHashMap (Key 값의 중복을 허용하지 않고, 입력순서 유지를 보장받는다.)

 < HashMap : Key, Value 정보 지정 >
 - key 는 유일, Value 는 중복 허용 
 - null 값 허용 map.put(null, null) 또는 map.get(null) 가능
*/

public class Ex07_HashMap {

	public static void main(String[] args) {
		
		// 1. HashMap
		// 1-1) 정의
		Map<Integer, String> hm = new HashMap<Integer, String>(); // Map 생성
		
	//------------------------------------------------------------------------------------------------
		
		// 1-2) put
		// => Key : 중복 불허, Value : 중복 무관
		// -> Key의 중복은 허용하지 않지만 중복 입력 시 컴파일/런타임 오류 없고,
		//    먼저 입력된 Key 위치에서, 나중에 입력된 값(Value)이 보관, 출력된다.
		hm.put(1, " Python");
		hm.put(10, " Spring");
		hm.put(2, " Java");
		hm.put(20, " Spring");
		hm.put(3, " My Sql");
		hm.put(30, " Oracle");
		hm.put(4, " JDBC");
		// hm.put(new Integer(4), "JDBC"); -> 사용 가능
		hm.put(5, " Servlet");
		hm.put(1, " JSP");
		
	//------------------------------------------------------------------------------------------------
		
		// 1-3) 출력
		System.out.println("** HashMap 1 = " + hm);
		
	//------------------------------------------------------------------------------------------------
		
		// 1-4) 활용
		// => get, remove, size
		// => Key로 접근
		//    -> Integer라서 숫자 입력했을 뿐, String이면 "문자열"로 접근.
		//    -> get(n), remove(n)에서 n은 Index Number아니고 그냥 Key 값일 뿐!!
		System.out.println("** HashMap size = " + hm.size());
		System.out.println("\n** HashMap get(4) = " + hm.get(4)); // Key = 4 인 자료
		System.out.println("\n** HashMap remove(3) = " + hm.remove(3)); // Key = 3 인 자료
		System.out.println("\n** HashMap get(4) = " + hm.get(4));
		System.out.println("\n** HashMap 2 = " + hm);
		System.out.println("** HashMap size = " + hm.size());
		
	//------------------------------------------------------------------------------------------------
		
		// 2. 각종 Map 비교
		// => 생성자의 매개변수로 위의 HashMap(hm)을 사용
		
		// < TreeMap >
		// - Key 값의 중복을 허용하지 않고, Key 값으로 오름차순 정렬이 된다.
		
		Map<Integer, String> tm = new TreeMap<Integer, String>(hm);

		System.out.println("\n** TreeMap = " + tm);
		System.out.println("** TreeMap = " + tm.size());
		
		//---------------------------------------------------------------
		
		// < LinkedHashMap >
		// - Key 값의 중복을 허용하지 않고, 입력 순서 유지를 보장받는다.
		
		Map<Integer, String> lm = new LinkedHashMap<Integer, String>(hm);

		System.out.println("\n** LinkedHashMap 1 = " + lm);
		// => hm의 입력 순서가 아닌 86행에서 매개변수를 통해 전달된 순서가 적용됨.
		// => 입력순서 확인
		lm = new LinkedHashMap<Integer, String>();
		
		lm.put(1, " Python");
		lm.put(10, " Spring");
		lm.put(2, " Java");
		lm.put(20, " Spring");
		lm.put(3, " My Sql");
		lm.put(30, " Oracle");
		lm.put(4, " JDBC");
		lm.put(5, " Servlet");
		lm.put(1, " JSP");
		
		System.out.println("\n** LinkedHashMap 2 = " + lm);

	} // main

} // class
