package j08_AbsInterface;

// class = extends, interface = implements

class MyChild1 implements Ex02_MyInterface {
	
	MyChild1() {
		System.out.println("< MyChild1 Default 생성자 >");
	} // MyChild1 default
	
	
	// < 오버라이딩 >
	// - 반드시 조상의 접근범위와 같거나 보다 넓어야 함.
	@Override
	// String getName() {} => 접근범위 Default(package)
	// 접근범위가 Default(package)라서 조상의 접근범위(public)보다 좁기 때문에 Error
	// interface는 default = public, class default = package
	public String getName() { // public 붙여야 됨.
		return NAME;
	}
	
	
	@Override
	public int getNum() {
		return NUM;
	}
	
	
	@Override
	public void setNum() {
		// 의무 구현 : 구현 내용이 없어도 반드시 body를 작성해야 한다.
	}
	
	
	void child1() {
		System.out.println("< Child1 method Test >");
	}
	
} // c_MyChild1

//-----------------------------------------------------------------------------------

class MyChild2 implements Ex02_MyInterface {
	
	String name = "홍길동";
	int num;
	
	
	@Override
	public String getName() {
		return name;
	}
	
	
	@Override
	public int getNum() {
		return NUM * num; // NUM = 123
	}
	
	
	@Override
	public void setNum() {
		num = 100;
	}
	
	
	void child2() {
		System.out.println("< Child2 method Test >");
	}
	
} // c_MyChild2

//====================================================================================

public class Ex02_MyInterTest {

	public static void main(String[] args) {
		/*
		 < interface 생성 >
		 - 직접 생성은 불가
 		 => Ex02_MyInterface in1 = new Ex02_MyInterface(); -> Error
		 - 인스턴스의 Type으로는 정의가능, 구현 클래스를 통해 생성됨.
		 - 그러나 사용범위는 interface에 정의된 만큼만.
		*/
		
		Ex02_MyInterface in1 = new MyChild1(); // 후손으로 인스턴스 생성 가능
		// < MyChild1 Default 생성자 >
		
		System.out.printf("** main in1 : NAME = %s, NUM = %d \n"
							, in1.getName(), in1.getNum());
		// ** main in1 : NAME = Green, NUM = 123
		
		// in1.child1(); -> 호출 불가능 ( 조상에 정의된 만큼만 후손 사용 가능 )
		
		
		Ex02_MyInterface in2 = new MyChild2();
		
		in2.setNum();
		
		System.out.printf("** main in2 : NAME = %s, NUM = %d \n"
				, in2.getName(), in2.getNum());
		// ** main in2 : NAME = 홍길동, NUM = 12300
		
		System.out.println("");
		
		
		MyChild1 ch1 = new MyChild1();
		// < MyChild1 Default 생성자 >
		
		ch1.child1(); // 후손이 본인으로 인스턴스 생성해서 조상에 없는 멤버 사용 가능
		// < Child1 method Test >
		
		// MyChild2 생성 확인
		MyChild2 ch2 = new MyChild2();
		
		ch2.child2();
		// < Child2 method Test >
		
		System.out.println("");

		//---------------------------------------------------------------------------
		
		// < interface에 정의된 상수에 직접 접근 >
		// - interface 이름으로 접근 (인스턴스명으로 접근하면 경고)
		// System.out.printf("** main interface의 상수 : NAME = %s, NUM = %d \n"
		//						, ch1.NAME, in2.NUM);
		System.out.printf("** main interface의 상수 : NAME = %s, NUM = %d \n"
							, Ex02_MyInterface.NAME, Ex02_MyInterface.NUM);
		// ** main interface의 상수 : NAME = Green, NUM = 123 
		
		/*
		 < interface의 특징 >
		 - MyChild1, MyChild2는 서로 관련이 없지만,
		   동일 인터페이스를 구현했기 때문에 같은 계층 구조로 묶을 수 있게 됨.
		 => 다형성 적용 가능
		*/
		
		in1 = in2;
		System.out.printf("** main in1 = in2 : NAME = %s, NUM = %d \n"
				, in1.getName(), in1.getNum());
		// ** main in1 = in2 : NAME = 홍길동, NUM = 12300
		// in2를 in1에 넣어서 in2와 동일한 결과 출력
		
	} // main

} // class
