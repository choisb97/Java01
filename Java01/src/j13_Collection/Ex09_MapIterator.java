package j13_Collection;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
< List >
- 순서 O, 중복 O

< Set >
- 순서 X, 중복 X

< Map >
- 순서 X, 중복 Key : X / Value : O
*/

/*
 < HashMap의 순차처리 ( Iterator, Entry ) >
 1) 키와 값(Value)을 같이 읽어 순차처리
 2) 키와 값(Value)을 따로 읽어 순차처리 
*/

public class Ex09_MapIterator {

	public static void main(String[] args) {
		
		// < 이름, 정수 >
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		hm.put("구준표 ", 80);
		hm.put("홍길동1 ", 90);
		hm.put("금잔디 ", 70);
		hm.put("유지오 ", 50);
		hm.put("홍길동2 ", 85);
		hm.put("구영표 ", 60);
		System.out.println("** hm = " + hm);
		
		// 1) 키와 값(Value) 같이 읽어 순차처리
		/*
		   => HashMap -> Set : entrySet()  
              키와 값을 같이 읽어 하나의 데이터(entry) 로 Set에 저장
      
          ***
          <?> => 모든 자료형을 의미, 내부적으로는 Object
          <? super 객체형 > => 명시된 객체형의 상위 객체
          <? extends 객체형 > => 명시된 객체형과 객체형을 상속한 하위 객체
		*/
		Set<?> set = hm.entrySet();
		// entrySet() : Key, Value에 대한 구분 없이 '구준표=60' 이렇게 하나의 값이다.
		System.out.println("\n** set by entrySet = " + set);
		System.out.println("");
		
		// => Set : Iterator 적용 가능
		Iterator<?> it = set.iterator();
		
		while (it.hasNext()) {
			//System.out.println("** while : " + it.next());
			// #60 실행시키려고 주석 걸어놨음
			
			// set의 Data를 읽어올 뿐, Key와 Value의 구분이 없음.
			// Key와 Value를 구별하고 싶은 경우
			// => Entry : set의 Entry를 Key와 Value로 구별
			
			// it.next() -> Map에 있는 Entry Type에 변수 선언을 하고
			// Entry Type으로 형변환
			Map.Entry<?, ?> e = (Map.Entry<?, ?>)it.next();
			// 인스턴스 e를 통해 Key와 Value get 가능
			System.out.println("** Entry : Key = " + e.getKey() + ", Value = " + e.getValue());
		} // while
		
		
	//--------------------------------------------------------------------------------------------------------
		
		// 2) 키와 값을 따로 읽어 순차처리
		// => HashMap -> Set : keySet()
		
		// 2-1) Key 값 가져오기
		set = hm.keySet(); 
		System.out.println("\n** set by keySet() = " + set); // Key만 출력
		System.out.println("");
		
		// => 반복문 적용하기 1 (while)
		it = set.iterator();
		
		while (it.hasNext()) {
			String hmkey = (String) it.next();
			System.out.println("** keySet : Key = " + hmkey + ", Value = " + hm.get(hmkey));
		} // while
		
		
		// => 반복문 적용하기 2 (for)
		System.out.println("\n< for Test >");
		
		for (String s : hm.keySet()) {
			System.out.println("** for : Key = " + s + ", Value = " + hm.get(s));
		} // eachfor
		
		// 2-2) Value 값 가져오기
		Collection<Integer> values = hm.values(); // Map의 Value들을 return하는 메서드
		// Collection -> Iterator : 순차처리 위해
		
		it = values.iterator();
		// it = hm.values().iterator();
		
		int sum = 0;
		
		while (it.hasNext()) {
			// Integer i = (Integer)it.next();
			// sum += i.intValue(); // Integer <-> int : 생략 가능
			sum += (Integer)it.next();
		} // while
		
		System.out.println(" \n** 합계 : " + sum);
		System.out.println(" \n** 평균 : " + (float) (sum / hm.size()));
		System.out.println(" \n** 최고점 : " + Collections.max(values));
		System.out.println(" \n** 최저점 : " + Collections.min(values));
		
	} // main
	
	/*
	   Map 인터페이스는 내부에 내부인터페이스 Entry를 가지고 있고, 
	   Object key, Object value는 Entry 인터페이스에 선언되어 있음.
	   그러므로 Map의 key와 value는 각각의 Object 이며 Map.Entry타입으로 저장됨. 
	   그래서 Map의 key와 value에 접근할 때는
	   => 먼저 Map의 인스턴스에서 entrySet으로 key와 value를 둘다 가져온다. 
	   => entrySet은 Set타입이므로 Set타입 인스턴스에 저장
	   => Set타입으로 가져온 인스턴스에서 iterator()메소드 호출해서 iterator가져옴
	   => 얻어온 iterator에서 hasNext메소드를 호출하여 HashMap 내부 요소에 접근.
	   => HashMap의 각 key와 value값은 결국 Map.Entry 타입의 배열에 들어있으므로    
	      HashMap에서 각 key와 value값에 접근하기위해서는  
	      Map.Entry 타입 인스턴스에 iterator의 next()메소드로 key와 value값 가져온다.
	*/

} // class
