package jv1_67_test; // p.215

// 다음과 같이 정의된 메서드르ㄹ 작성하고 테스트하시오.

// Hint : String클래스의 charAt(int i)메서드를 사용하면 문자열의 i번째 위치한 문자를 얻을 수 있다.

// 결과 = 123는 숫자입니까? true
//      1234o는 숫자입니까? false

public class Chap06_18 {
	
	/*
	 메서드명 : isNumber
	 기능 : 주어진 문자열이 모두 숫자로만 이루어져있는지 확인한다.
	      모두 숫자로만 이루어져 있으면 true를 반환하고, 그렇지 않으면 false를 반환한다.
	      만일 주어진 문자열이 null이거나 빈문자열""이라면 false를 반환한다.
	 반환타입 : boolean
	 매개변수 : String str - 검사할 문자열
	 */
	
	// (1) isNumber메서드를 작성하시오.
	public static boolean isNumber (String str) {
		
		if (str == null || str.equals(""))
			return false;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (c < '0' || c > '9') // if (!(c >= '0' && c <= '9')) 와 같음
		// c가 0보다 작거나 c가 9보다 크면  / c가 0과 같거나 크고 c가 9와 같거나 작지 않으면(! not)
				return false;
			
		} // for
		
		return true;
		
	} // isNumber
	

	public static void main(String[] args) {

		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		// 123는 숫자입니까? true
		
		str = "1234o";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		// 1234o는 숫자입니까? false
		
	} // main

} // class
