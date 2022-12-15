package j06_packageTest;

import j05_classMethod.Ex10_Phone;

// import j05_classMethod.Member; // Error -> not visible

//-----------------------------------------------------------

/*
 < Access Modifier (접근한정자_제어자) >
 => private : 해당 클래스내부에서만
 => default : 같은 Package 내
 => protected : package + 자손
 => public : 프로젝트내의 모든 Class 접근 가능
   (단, 다른 package 에서는 import 해야함)
*/

public class Ex01_accessTest {

	public static void main(String[] args) {
		
		// 1) public Test
		System.out.println("** Phone.company = " + Ex10_Phone.getCompany());
		// #3에 Ex10_Phone 자동 import
		// ** Phone.company = Green
		
		System.out.println("** Phone.PI = " + j05_classMethod.Ex10_Phone.PI);
		// import를 하면 패키지명(j05_classMethod) 생략 가능
		// ** Phone.PI = 3.14159
		
		/*
		 < 멤버수준 접근 범위 >
		 - private, default는 접근 불가
		 System.out.println("** Phone.company = " + Ex10_Phone.company());
		 private
		
		 Ex10_Phone ex10 = new Ex10_Phone();
		 System.out.println("** ex10.PI2 = " + ex10.PI2);
		 ex10.PI2 => Ex10_Phone #33에서 public 지워서 Error
		
		======================================================================
		
		 2) default(패키지 범위)
		 - 클래스 수준에서 허용되지 않음.
		   그러므로 멤버수준의 접근범위(public)는 무시됨
		   즉, 접근 불가함.
		
		 Member member = new Member(); // 강제로 import 해도 Error
		*/
	} // main

} // class
