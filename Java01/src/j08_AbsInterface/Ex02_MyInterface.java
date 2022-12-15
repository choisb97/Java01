package j08_AbsInterface; 

/*
 < interface 1 >
 - 상수, 추상메서드
 - static, default 메서드 (구현부(Body)가 있는 메서드, Java8부터 추가됨)
*/

public interface Ex02_MyInterface {
	/*
	 ** 생성자 허용되지 않음
	  - Ex02_MyInterface() {} -> Error
	*/

	// * 상수만 가능 -> public static final은 생략 가능
	public static final int NUM = 123;
	// == int NUM = 123;
	String NAME = "Green"; 
	// == public static final String NAME
	
	// * 추상 메서드만 가능 - public abstract는 생략 가능
	public abstract int getNum();
	// == int getNum();
	
	abstract void setNum(); // 접근범위 : public
	// == void setNum();
	
	String getName(); // -> public abstract 생략
	// == public abstract String getName
	
	
} // interface
