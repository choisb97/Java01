package j08_AbsInterface; // Abstract(추상)

/*
 < 추상(Abstract) 클래스 >
 - 추상메서드가 하나라도 정의되면 그 클래스는 반드시 추상클래스로 정의해야 한다.
 - 직접 인스턴스를 생성하지 못 함(new 사용 불가)
   그러나 참조형 변수(인스턴스)의 타입으로 선언은 가능하다.
   그리고 후손으로 인스턴스를 생성할 수 있음.

------------------------------------------------------------

 < 추상 메서드 >
 - Body 부분이 없고, Header만 선언.
 - 앞쪽에 abstract, 중괄호{} 없고 소괄호(매개변수) 사용 뒤에 세미콜론(;) 붙여야 됨.
 - Body 부분은 Child클래스에서 반드시 재정의(오버라이딩) 해야 함.
  (실행문 없어도 공백으로 작성해야 함 -> { })
 - 추상 메서드 목적 : 후손에게 오버라이딩의 강제성을 부여 (메서드명의 통일성)

------------------------------------------------------------

 < 다형성(polymorphism) 적용 >
 - 조상의 타입으로 변수 선언, 후손의 타입으로 인스턴스 생성
 - 조상에 정의된 범위내에서만 후손의 멤버 사용 가능.
 - 후손의 타입에 따라 다양한 형태로 실행 됨.


 < 다형성 적용의 장점 >
 - 계층 구조에서 일괄 작업 가능(개발 및 유지보수의 효율을 높여줌)
 - 실행 시 클래스의 교체가 간편

------------------------------------------------------------

 < instanceof 연산자 >
 - A(Object) instanceof B(Class, Interface) 형태로 사용
   => A 위치에는 Object(인스턴스), B 위치에는 클래스나 인터페이스
   
 - A Object를 B 클래스나 인터페이스로 캐스팅이 가능한 것인지를 확인하는 연산자.
   즉, 명시적 형변환이 가능한 지를 묻는 연산자임
   A(인스턴스0가 B(클래스 또는 인터페이스)의 집안에 해당 되는지(상속관계인지) 묻는 연산자
 - True / False
 
 - 따라서 B가 클래스일 경우에는 A가 반드시 B클래스와 상속관계에 있어야만 유효하며,
   상속관계가 없을 경우 캐스팅이 불가능하기에 컴파일 타임 에러 발생
   (왜냐하면 컴파일 타임에 내부적으로 캐스팅 처리를 해야하기 때문)
 - 그러나 B가 인터페이스라면 컴파일 타임 에러는 안 나지만 런타임 에러 발생
   -> 런타임 에러 예방을 위해 확인 필요
*/

//=================================================================================

abstract class Animal {
	
	String kind;
	
	// 생성자 : 작성해도 오류는 없지만 생성이 가능해지는 것은 아님
	Animal() {
		System.out.println("< Animal Default 생성자 >");
	} // Animal default
	
	
	void breath() { // *일반 메서드 : 후손의 구현(Override) 의무 없음.
		System.out.println(kind + "는 숨을 쉽니다.");
	}
	
	//-------------------------------------------------------------
	/*
	 < 추상 메서드 >
	 - 반드시 abstract를 사용해서 추상메서드임을 표시해야 한다.
	 - 후손의 구현(Override) 의무 있음.
	 - 추상 메서드를 하나라도 가진 클래스는 반드시 추상 클래스로 정의해야 한다.
	 => 앞에 abstract 쓰고 중괄호{} 없이 소괄호() 뒤에 세미콜론(;) 찍기
	*/
	abstract void sound();
	
	abstract void special();
	
	// abstract 사용한 sound와 special은 후손이 의무구현(Override) 해야한다.
	
} // c_Animal

//---------------------------------------------------------------------------------

class Cat extends Animal {
	
	Cat() {
		kind = "고양이";
		System.out.println("< Cat Default 생성자 >");
	} // Cat default
	
	
	@Override
	void sound() { // 의무 구현
		System.out.println("~~ 야옹 야옹 웁니다 ~~");
	}
	
	
	@Override
	void special() { // 의무 구현
		System.out.println("~~ 고양이는 눈의 색이 멋지다 ~~");
	}
	
	
	void eyeColor() {
		System.out.println("OLD : ~~ 고양이는 눈의 색이 멋지다 ~~");
	}
	
} // c_Cat

//---------------------------------------------------------------------------------

class Dog extends Animal {
	
	Dog() {
		kind = "강아지";
	} // Dog default
	
	
	@Override
	void sound() { // 의무 구현
		System.out.println("~~ 멍멍 멍멍 웁니다 ~~");
	}
	
	
	@Override
	void special() { // 의무 구현
		System.out.println("~~ 강아지는 빠르게 달립니다 ~~");
	}
	
	
	void speed() {
		System.out.println("OLD : ~~ 강아지는 빠르게 달립니다 ~~");
	}
	
} // c_Dog

//---------------------------------------------------------------------------------

class Eagle extends Animal {
	
	Eagle() {
		kind = "독수리";
	} // Eagle default
	
	
	@Override
	void sound() {
		// 의무 구현 : 구현 내용이 없어도 반드시 body를 작성해야 한다.
	}
	
	
	@Override
	void special() { // 의무 구현
		System.out.println("~~ 독수리는 훨훨 훨훨 날아다닙니다 ~~");
	}
	
	
	void flying() {
		System.out.println("OLD : ~~ 독수리는 훨훨 훨훨 날아다닙니다 ~~");
	}
	
} // Eagle

//---------------------------------------------------------------------------------

class Bear { // Animal 상속 X
	
	void breath() {
		System.out.println("곰은 숨을 쉽니다.");
	}
	
	
	void sound() {
		System.out.println("~~ 곰 곰 곰 웁니다 ~~");
	}
	
	
	void tree() {
		System.out.println("~~ 곰은 크지만 나무를 잘 탑니다 ~~");
	}
	
} // c_Bear


public class Ex01_AbsAnimal {
	
//==================================================================================

	public static void main(String[] args) {
		/*
		 < 추상클래스 Animal 생성 확인 >
		 - 추상 클래스는 직접 인스턴스를 생성할 수 없다.
		   그러나 인스턴스의 타입으로는(좌측에서) 정의 가능하고, 우측에서는 후손으로 생성함.
		   이 때, 이 인스턴스의 접근 범위는 조상에 정의된 만큼만 가능.
		*/
		// Animal animal = new Animal(); // => Error -> 직접 인스턴스 생성 불가
		// Cat c1 = new Animal(); // => Error -> 후손을 좌측에 생성, 정의 불가

		System.out.println("\n< 추상 클래스 Animal 생성 확인 >");
		System.out.println("");
		
		// 좌측(타입) : 조상 = 우측(생성) : 후손
		// 조상에 정의된 만큼만
		Animal a1 = new Cat();
		
		a1.breath();
		a1.sound(); // Cat.sound 실행
		a1.special();
		System.out.println("");
		
		
		Animal a2 = new Dog();
		
		a2.breath();
		a2.sound(); // Dog.sound 실행
		a2.special();
		// a2.speed(); // 접근불가(조상에 정의된 범위내에서만 후손의 멤버 사용 가능) -> is undefined Error
		System.out.println("");
		
		
		Animal a3 = new Eagle();
		
		a3.breath(); // 독수리는 숨을 쉽니다
		a3.sound(); // Eagle.sound -> body 없어서 출력 X
		a3.special();
		System.out.println("");
		
		System.out.println("----------------------------------");
		
		// < Bear Test >
		// - Animal을 상속받지 않은 Bear클래스는 적용 불가
		// Animal a4 = new Bear();
		
		//-------------------------------------------------------------------------
		/*
		 < 다형성(polymorphism) 적용 >
		 - 조상의 타입으로 정의하고, 후손 클래스로 인스턴스를 생성함
		 - 우측의 생성자만 교체하면 쉽게 클래스 교체 가능
		 => 코드 내에서 조상에 정의된 멤버만 사용했다는 의미.
		 => 추상 뿐만 아니라 상속관계에서는 모두 적용 가능하다.(j07 - Ex02_Animal 참고)
		    추상을 사용하면 의무 구현의 강제성을 줄 수 있음 (메서드명을 일원화 할 수 있음)
		*/
		
		System.out.println("< Animal : 다형성 적용 Test >");
		System.out.println("");
		
		Animal animal = new Dog(); // Cat(), Dog(), Eagle() 변경하면 클래스 교체 용이
		
		animal.breath();
		animal.sound();
		animal.special();
		// animal.eyeColor(); // new Cat() => 접근 불가 -> is undefined Error
		// animal.speed(); // new Dog() => 접근 불가 -> is undefined Error
		
		System.out.println("----------------------------------");

		//-------------------------------------------------------------------------
		
		// < Cat, Dog, Eagle, Bear 개별 Test >
		
		System.out.println("\n< Cat, Dog, Eagle, Bear 개별 Test >");
		System.out.println("");
		
		
		Cat cat = new Cat();
		
		cat.breath();
		cat.sound();
		cat.special();
		cat.eyeColor();
		System.out.println("");
		

		Dog dog = new Dog();
		
		dog.breath();
		dog.sound();
		dog.special();
		dog.speed();
		System.out.println("");
		

		Eagle eagle = new Eagle();
		
		eagle.breath();
		eagle.special();
		eagle.flying();
		System.out.println("");
		

		Bear bear = new Bear();
		
		bear.breath();
		bear.sound();
		bear.tree();
		System.out.println("");
		
		System.out.println("----------------------------------");
		
//----------------------------------------------------------------------------------
		
		// < 메서드의 매개변수로 다형성 Test >
		// Animal Type
		System.out.println("\n< 메서드의 매개변수 다형성 Test - Animal Type >");
		System.out.println("");
		
		animalUse(animal);
		System.out.println("");
		animalUse(cat); // Cat 후손 -> Animal 조상 자동 형변환		
		System.out.println("");
		animalUse(new Dog());
		System.out.println("");
		animalUse(new Eagle());
		System.out.println("");
		
		// animalUse(bear); => Animal과 무관한 Bear는 사용불가

		System.out.println("----------------------------------");
		
		// < Object Type 추가 후 >
		System.out.println("\n< 메서드의 매개변수 다형성 Test - Object Type >");
		System.out.println("");
		
		animalUse(bear); // => Object animal 호출 -> 주소 출력
	
		animalUse((Object)animal); // 객체의 형변환 -> 주소 출력

		System.out.println("----------------------------------");
		
		// < 배열 Type 추가 후 >
		// => Animal Type 배열 정의 후 전달
		System.out.println("\n< 메서드의 매개변수 다형성 Test - Animal Type 배열 >");
		System.out.println("");
		
		Animal[] ans = {animal, new Cat(), dog, new Eagle()};
 		
		animalUse(ans);

		System.out.println("----------------------------------");
		
		//-------------------------------------------------------------------------
		
		// < 연산자 instanceof >
		// - 인스턴스 확인 연산자
		if (cat instanceof Animal)
			System.out.println("** cat은 Animal의 인스턴스입니다.");
		/*
		=> bear처럼 타입이 맞지 않는 경우에는 컴파일 오류 발생
		   instanceof의 필요성을 못 느낄 수 있지만, 
	       비교대상이 인터페이스가 되면 컴파일 오류 없고, 런타임 오류 발생.
		   그러므로 런타임 오류를 예방하기 위해 확인 필요
		*/
		// if (bear instanceof Animal)
		//	System.out.println("** bear는 Animal의 인스턴스가 아닙니다.");
		
	} // main

//==================================================================================

	// < animalUse 메서드 오버로드 >
	// - Animal[], Animal, Object
	
	public static void animalUse(Animal[] animals) {
		
		for (Animal an : animals) {
			
			an.breath();
			an.sound();
			an.special();
			
		} // for(each_for)
		
	} // animalUse_Animal[]
	
	
	public static void animalUse(Animal animal) {
		
		animal.breath();
		animal.sound();
		animal.special();
		
	} // animalUse_Animal
	
	
	// < 매개변수 Type : Object >
	// - 모든 클래스 사용 가능하고, Object에 정의된 멤버만큼 사용 가능.
	public static void animalUse(Object animal) {
		
		System.out.println("* Your Address = " + animal);
		
	} // animalUse_Obj
	
} // class
