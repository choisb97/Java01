package j13_Collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
 < HashSet을 이용한 로또번호 생성하기 >
 - 중복자료가 허용되지 않는 Set의 특징을 이용하여 로또 번호 생성하기
 - Random 또는 Math로 1 ~ 45 범위내의 정수를 중복되지 않도록
   6개를 추출 후 출력하기
 - 오름차순으로 출력하기 
*/

public class Ex05_SetLotto {

	public static void main(String[] args) {

		// 1. set 정의
		// => Random 또는 Math로 1 ~ 45 범위내의 정수가 6개 채워지도록.
		HashSet<Integer> set = new HashSet<Integer>(); // int 안 됨.
		
		Random rn = new Random();
		
		
		// 2. 번호 생성
		// => Math, while 또는 for
		// => 조건 : set.size()가 6이 될 때까지
		//         자료가 없을 때 (size = 0)부터 시작하므로 6 미만으로 써야 됨.
		while(set.size() < 6) { // 인덱스처럼 생각하는 게 편함
			set.add(rn.nextInt(45) + 1);
		} // while
		
		
		// 3. 출력
		System.out.println("** 정렬 전 Lotto => " + set);
		
		
		// 4. 오름차순 출력
		// 4-1) Arrays 활용
		// => set -> 배열로
		Object[] oset = set.toArray();
		Arrays.sort(oset); // sort => 오름차순
		
		System.out.println("\n** 오름차순 정렬 후(Arrys.toString) => " + Arrays.toString(oset));
		System.out.println("\n** 정렬 후 set => " + set); // 원본(정렬 전 Lotto) 유지
		
		
		// 4-2) Collections
		/*
		 - Collection들의 WrapperClass
		   Collection과 관련된 편리한 메서드를 제공
		   단, interface Collection 과 구별
		      interface Collector의 구현클래스 Collectors와 구별
		 - Collections.sort(List<T> list)
		   인자로 List 타입이 필요함

		 < 오름차순 출력 >
		 => Set -> 순차구조 (Iterator , List)
		 => Set -> List
		    LinkedList의 생성자 중에 set을 매개변수로 사용하면
		    이 set을 list 생성해주는 생성자가 있음.
		*/
		
		List<Integer> list = new LinkedList<Integer>(set);
		Collections.sort(list); // 오름차순
		
		System.out.println("\n** Collections.sort(list) => " + list); // 오름차순 정렬
		
	} // main

} // class
