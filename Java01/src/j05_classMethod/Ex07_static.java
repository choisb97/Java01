package j05_classMethod;

/*
 < static (클래스종속) >
 - 클래스변수(모든 인스턴스가 공유) , 클래스 메서드

 < non_static (인스턴스종속) - 인스턴스 >
 - 인스턴스변수(인스턴스 별로 관리) , 인스턴스 메서드

 < 사용(호출) 규칙 >
 => 인스턴스 메서드 : static, 인스턴스 모두 인스턴스 없이 호출가능 
 => static 메서드 : static만 인스턴스 없이 호출가능
*/

// < 사칙연산 계산기 >

public class Ex07_static {
	
	int result; // 인스턴스
	static int total; // static
	
	// < Static 메서드 - add, min >
	
	public static int add(int i, int j) {

		// result = i + j; // 인스턴스 없이 접근 불가
		total += (i + j);
		
		return i + j;
	
	} // add_ij
	
	//---------------------------------------
	
	public static int min(int i, int j) {
		
		total += (i - j);
		
		return i - j;
	
	} // min_ij

	//---------------------------------------
	
	// < 인스턴스 메서드 - mul, div >

	public int mul(int i, int j) {
		
		result = i * j;
		
		total += result;
		
		return i * j;
	
	} // mul_ij
	
	//---------------------------------------
	
	public int div(int i, int j) {
		
		result = i / j;
		
		total += result;
		
		return i / j;
	
	} // div_ij
	
	//---------------------------------------

	// < static 메서드, 인스턴스 메서드 모두 call >
	// - static 메서드로 작성하는 경우 => 인스턴스 필요
	//   인스턴스 멤버에 접근하기 위해서 반드시 인스턴스 필요
	
	public static void staticAll(int i, int j, Ex07_static test) {
		                                                // test = 주소만 전달해주는 변수
		
		System.out.println("sAll add = " + add(i, j));
		System.out.println("sAll min = " + min(i, j));
		System.out.println("sAll mul = " + test.mul(i, j));
		System.out.println("sAll div = " + test.div(i, j));
		
	} // staticAll
	
	//---------------------------------------

	// < 인스턴스 메서드로 작성하는 경우 >
	// - static, 인스턴스(메서드, 변수) 모두 인스턴스 없이 접근 가능
	
	public void instanceAll(int i, int j) {
		
		System.out.println("iAll add = " + add(i, j));
		System.out.println("iAll min = " + min(i, j));
		System.out.println("iAll mul = " + mul(i, j));
		System.out.println("iAll div = " + div(i, j));
		
		System.out.println("total = " + total);
		System.out.println("result = " + result);
		
	} // instanceAll
	
	
	//==================================================================
	//==================================================================
	
	
	public static void main(String[] args) {
		// main에 static 있기 때문에 static 메서드는 그냥 사용 가능.

		// 1) static 메서드
		// => 인스턴스 없이 호출 가능
		System.out.println("add = " + add(10, 20));
		System.out.println("min = " + min(10, 20));
		
		System.out.println("total = " + total);
		// System.out.println("result = " + result); // => result는 메모리에 아직 없음.
		// result는 인스턴스메서드라서 인스턴스가 있어야 접근 가능.
		
		System.out.println("------------------------------");
		
		//------------------------------------------------------
		
		// 2) 인스턴스 메서드
		// => 인스턴스가 있어야 접근 가능
		Ex07_static ex07 = new Ex07_static();
		
		System.out.println("mul = " + ex07.mul(10, 20));
		System.out.println("div = " + ex07.div(10, 20));
		
		System.out.println("------------------------------");
	
		System.out.printf("result = %d, total = %d \n", ex07.result, total); // 0, 220
		// result = 0, total = 220
		
		System.out.println("------------------------------");
		

		//------------------------------------------------------
		//------------------------------------------------------
		
		
		// 3) All Test
		Ex07_static all = new Ex07_static();
		// all 인스턴스 생성됨.
		
		staticAll(100, 30, all); // 클래스 메서드(static method)이지만, 매개변수에 인스턴스가 필요
		
		System.out.printf("all_result = %d, all_total = %d \n", all.result, total);
		System.out.println("------------------------------");
		
		all.instanceAll(100, 30); // 인스턴스 메서드이기 때문에 반드시 인스턴스를 통한 접근 필요
		
		System.out.println("------------------------------");

		System.out.printf("all_result = %d, all_total = %d \n", all.result, total); // 3, 3203 라고 생각되지만,
		// all_result = 3, all_total = 6626
		// static => 클래스 종속 -> total 값 전부 공유
		// 220 + 3203 + 3203 = 6626

		System.out.println("------------------------------");

		// #122 다시 출력했을 때
		System.out.println("< #130 다시 출력 >");
		System.out.printf("result = %d, total = %d \n", ex07.result, total); // 0, 6626
		// total 값을 전부 공유하기 때문에 total은 #153의 값과 같다.
		// #153 total = 6626
		
	} // main

} // class
