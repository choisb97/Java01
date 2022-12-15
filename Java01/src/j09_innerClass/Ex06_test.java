package j09_innerClass;

/*
 < 실습 >
 추상 메서드가 2개 있는 interface를 정의하고 
 이를 main 메서드에서 익명 클래스를 이용해서 구현하고
 실행시켜 보세요 ~~ 
*/


interface RemoteControl {
	
	void turnOn();
	void turnOff();
	
} // i_RemoteControl

public class Ex06_test {

	public static void main(String[] args) {

		// < 익명 클래스를 이용해서 구현하기 >
		RemoteControl rc = new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println(" ~~ turnOn ~~");
			}
			
			
			@Override
			public void turnOff() {
				System.out.println(" ~~ turnOff ~~");
			}
			
			/*
			// < new 메서드 >
			// => 정의는 가능하지만 사용은 불가능 
			// => 조상의 인스턴스로는 접근 불가능하므로
			public void myTest() {
				System.out.println(" ~~ myTest ~~");
			}
			*/
		}; // 익명클래스 종료 반드시 세미콜론(;) 필요함.
		
		rc.turnOn();
		rc.turnOff();
		
	} // main

} // class
