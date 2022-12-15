package j14_generic;

/*
 < enum 매개변수로 전달 >
 - 메서드에 적용
 - 일반상수의 사용과 안전성 비교
*/


enum Animal {
	DOG, CAT, BEAR
} // e_Animal

enum Person {
	MAN, WOMAN, CHILD
} // e_Person

//============================================================================================================

public class Ex07_argumentTest {
	
	// * 일반상수 정의
		static final int DOG = 0;
		static final int CAT = 1;
		static final int BEAR = 2;
		
		static final int MAN = 0;
		static final int WOMAN = 1;
		static final int CHILD = 2;
		
		
		// => 사람만 사용 가능한 메서드 -> 사람 외에는 입장불가
		// => 매개변수 : 기본자료형 등 일반 Type
		static void whoAreU1(int p) {
			
			switch (p) {
				
				case 0 :
					System.out.println("~~ MAN 입니다. ~~");
					break;
					
				case 1 :
					System.out.println("~~ WOMAN 입니다. ~~");
					break;
					
				case 2 :
					System.out.println("~~ CHILD 입니다. ~~");
					break;
					
				default :
					System.out.println("~~ 입장불가입니다. ~~");
				
			} // switch
			
		} // m_whoAreU1
		
		// => 매개변수 : enum Person Type
		//               Type을 제한
		static void whoAreU2(Person p) { // Person Type으로 하면 동물은 입장불가.
			
			switch (p) {
				
				case MAN :
					System.out.println("~~ MAN 입니다. ~~");
					break;
					
				case WOMAN :
					System.out.println("~~ WOMAN 입니다. ~~");
					break;
					
				case CHILD :
					System.out.println("~~ CHILD 입니다. ~~");
					break;
					
				default :
					System.out.println("~~ 입장불가입니다. ~~");
				
			} // switch
			
		} // m_whoAreU2
		
//=============================================================================================================
		
	public static void main(String[] args) {
		
		// < 1. 일반상수 Test >
		// - whoAreU1은 매개변수가 int이면 모두 통과되므로 Person, Animal 구분 불가능.
		// - 비교 가능한 Type이 없어서 논리적 오류를 예방할 수 없다.
		System.out.println("< 일반상수 Test >");
		whoAreU1(MAN);
		whoAreU1(WOMAN);
		
		// < 논리적 오류 >
		System.out.println("\n< 논리적 오류 >");
		whoAreU1(DOG); // ~~ MAN 입니다. ~~
		whoAreU1(CAT); // ~~ WOMAN 입니다. ~~
		
		// < 2. enum 사용 >
		// - 컴파일타임에 검증 가능
		// - Person Type의 MAN, WOMAN, CHILD만 가능.
		System.out.println("\n< 2. enum Person Type Test >");
		// whoAreU2(MAN); Person의 MAN이 아니기 때문에 컴파일 오류.
		whoAreU2(Person.MAN);
		whoAreU2(Person.WOMAN);
		// whoAreU2(Animal.DOG); // Type 안 맞아서 컴파일 오류
		
		// 2-1) Person 직접 사용
		whoAreU2(Person.MAN);
		whoAreU2(Person.CHILD);
		
		// 2-2) 인스턴스 정의
		// - 변수를 선언해서 상수 값을 전달받음 
		// > new 연산자로 생성하는 것이 아니고 static value 상수 값을 전달 받는 것이다.
		System.out.println("\n< 인스턴스 정의 >");
		Person p = Person.CHILD;
		whoAreU2(p);
		
		Animal a = Animal.BEAR;
		// whoAreU2(a); // Type 맞지 않아서 컴파일 오류
		
		// < 인스턴스  >
	    //if (a instanceof Person)  
	    // => 컴파일오류로 비교 불가 (비교 대상이 interface일 때만 컴파일오류 없이 비교가능) 
		
		System.out.println("\n< 인스턴스 확인 후 메서드 적용 >");
		if (a instanceof Animal)
			System.out.println("~~ whoAreU 입장 불가 ~~");

	} // main

} // class
