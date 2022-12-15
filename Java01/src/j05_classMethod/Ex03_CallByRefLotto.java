package j05_classMethod;

import java.util.Arrays;

/*
 < CallByReference (매개변수 참조자료형, 주소전달) >
 => 배열

 < 과제 >
 => Ex04_Lotto02.java 의 Sort 부분을 메서드로 만들기
 => 메서드명 : mySort
        -> 매개변수 (배열, char_Asccending/Descending)
        -> 전달된 배열을 오름차순 또는 내림차순으로 정렬
*/

public class Ex03_CallByRefLotto {
	
	public void mySort(int[] arr, char c) {
		
		/*
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				// < 오름차순 >
				if (c == 'A') {
					if (arr[i] > arr[j]) {
						
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				};
				
				// < 내림차순 >
				if (c == 'D') {
					if (arr[i] < arr[j]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				};
				
			} // for_j
		
		} // for_i
		*/
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				
				// < 오름차순, 내림차순 >
				if ( (c == 'A' && arr[i] > arr[j]) || (c == 'D' && arr[i] < arr[j]) ) {
					// && 연산이 || 연산보다 우선순위이지만 가독성이나 더 확실하게 하기 위해 각각 소괄호()로 묶음
					
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;	
				};
				
			} // for_j
		
		} // for_i
		
	} // mySort
	
	//================================================================

	public static void main(String[] args) {
		
		// 1) 배열생성
		int[] lotto = {7, 22, 44, 5, 25, 10};
		
		System.out.println("정렬 전 lotto = " + Arrays.toString(lotto));
		
		System.out.println("---------------------------------------");
		
		//---------------------------------------------------------------
		
		// 인스턴스화                          생성자 메서드
		Ex03_CallByRefLotto ex03 = new Ex03_CallByRefLotto();
		
		// 2) 오름차순 정렬
		ex03.mySort(lotto, 'A');
		
		System.out.println("lotto 오름차순 정렬 = " + Arrays.toString(lotto));

		System.out.println("---------------------------------------");
		
		//---------------------------------------------------------------
		
		// 3) 내림차순 정렬
		ex03.mySort(lotto, 'D');
		
		System.out.println("lotto 내림차순 정렬 = " + Arrays.toString(lotto));
		
		System.out.println("---------------------------------------");
		
	} // main

} // class
