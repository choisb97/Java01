package j09_innerClass;

// < Outer, Inner 인스턴스 관계 Test >

class OuterName {
	
	private String name;
	private int num = 0; // int num; -> default = 0
	
	OuterName(String name) {
		System.out.println("< OuterName_name 초기화 생성자 >");
		this.name = name;
	}
	
	
	void whoAreU() {
		num++;
		System.out.printf("** whoAreU : name = %s, num = %d \n", name, num);
	}
	
	
	class InName { // Inner Class
		/*
		String name2;
		// String name; => Outer와 동일한 이름의 멤버변수를 사용
		InName(String name2) {
			System.out.println("< InName_name2 초기화 생성자 >");
			this.name2 = name2; // this는 Inner를 가리킴
			// => Outer와 Inner 변수명이 모두 name으로 동일한 경우
			//    Inner에서 매개변수로 전달받은 값을 Outer의 name 변수에 넣어주려면 this로는 불가능
			name = name2; // inner의 name을 outer에 전달 -> inner의 name 출력

			whoAreU();
		} // InName_name2
		*/
		
		String name;
		// String name; => Outer와 동일한 이름의 멤버변수를 사용
		InName(String name) {
			System.out.println("< InName_name2 초기화 생성자 >");
			this.name = name; // this는 Inner를 가리킴
			// => Outer와 Inner 변수명이 모두 name으로 동일한 경우
			//    Inner에서 매개변수로 전달받은 값을 Outer의 name 변수에 넣어주려면 this로는 불가능
			OuterName.this.name = name; // 주석걸고 실행하면 name = Outer name으로 출력됨.
			// OuterName.this로는 접근 가능
			
			whoAreU();
		} // InName_name
		
	} // ic_InName
	
} // c_OuterName


//======================================================================================

public class Ex02_InstanceTest {

	public static void main(String[] args) {
		
		// 1) Outer 생성
		OuterName on1 = new OuterName("Out1");
		OuterName on2 = new OuterName("Out2");
		
		on1.whoAreU();
		on2.whoAreU();
		
		System.out.println("");
		
	//----------------------------------------------------------------------------------
		
		// 2) Inner 생성
		// => OuterClass의 인스턴스를 통해 생성됨
		// - OuterName.InName test = new OuterName("Test").new InName("test");
		OuterName.InName in11 = on1.new InName("Out1_In1");
		OuterName.InName in12 = on1.new InName("Out1_In2");
		OuterName.InName in13 = on1.new InName("Out1_In3");

		System.out.println("");
		
		on1.whoAreU(); // ** whoAreU : name = Out1_In3, num = 5
		
		System.out.println("");
		
		OuterName.InName in21 = on2.new InName("Out2_In1");
		OuterName.InName in22 = on2.new InName("Out2_In2");
		
		System.out.println("");

		on2.whoAreU(); // ** whoAreU : name = Out2_In2, num = 4 
		
		System.out.println("");

		on1.whoAreU(); // ** whoAreU : name = Out1_In3, num = 6
		
		System.out.println("");
		
		System.out.printf("밑줄 없애기" + in11, in12, in13, in21, in22);
	} // main

} // class
