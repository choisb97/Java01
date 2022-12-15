package j14_generic;

import jv0_00_study.Ex01_Person;

/*
 < 과제 >
 - 배열을 출력해주는 클래스 만들기
   배열 정의, setter/getter, arrayPrint()
 - 실행 시 원하는 타입을 결정 & 출력
 - 배열 타입 Generic 
*/

class GenArray <T> {
	
	private T[] arr;
	
	public void setArr(T[] arr) {
		this.arr = arr;
	} // set
	
	public T[] getArr() {
		return this.arr;
	} // get
	
	public void arrPrint() {
		for (T a : arr) {
			System.out.print(a + " ");
		} // eachfor
		
		System.out.println("");
	} // arrPrint
	
	// ** 마지막 자료 출력
	public T getLast() {
		return arr[arr.length - 1];
	} // getLast
	
} // GenArray

public class Ex02_GenArray {

	public static void main(String[] args) {
		
		// 1) String
		GenArray<String> ga1 = new GenArray<>(); 
		// <> 좌측은 정확하게 Type 표기, 우측은 내용 생략 가능
		
		String[] ss = {"가", "나", "DA", "RA", "마", "BA"};
		
		ga1.setArr(ss);
		ga1.arrPrint();
		System.out.println("** ga1.getLast = " + ga1.getLast());

	//--------------------------------------------------------------------------------------------
		
		// 2) Integer (int)
		GenArray<Integer> ga2 = new GenArray<Integer>(); 
		
		Integer[] ii = {1, 2, 3, 4, 5, 6, 7};
		
		ga2.setArr(ii);
		ga2.arrPrint();
		System.out.println("** ga2.getLast = " + ga2.getLast());
		
	//--------------------------------------------------------------------------------------------

		// 3) Double (double)
		GenArray<Double> ga3 = new GenArray<Double>(); 

		Double[] dd = {1.234, 2.345, 3.456, 4.567, 5.678, 6.789};

		ga3.setArr(dd);
		ga3.arrPrint();
		System.out.println("** ga3.getLast = " + ga3.getLast());
		
	//--------------------------------------------------------------------------------------------
		
		// 4) Character (char)
		GenArray<Character> ga4 = new GenArray<Character>(); 

		Character[] cc = {'A', 'B', 'c', 'd', 'e', 'F'};

		ga4.setArr(cc);
		ga4.arrPrint();
		System.out.println("** ga4.getLast = " + ga4.getLast());
		System.out.println("");
		
	//--------------------------------------------------------------------------------------------
		
		// 5) Ex01_Person
		GenArray<Ex01_Person> ga5 = new GenArray<Ex01_Person>(); 

		Ex01_Person[] ps = {new Ex01_Person("920605-1234567", "이재영"),
							new Ex01_Person("970517-2345678", "최수빈"),
							new Ex01_Person("030605-3234567", "김철수"),
							new Ex01_Person("940313-2234567", "최보라"),
							new Ex01_Person("930208-1234567", "홍영우")};

		ga5.setArr(ps);
		ga5.arrPrint();
		System.out.println("** ga5.getLast = " + ga5.getLast());
	
	
	
	} // main

} // class
