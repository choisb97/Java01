package jv1_2345_test; // p.96

// 아래는 화씨(Fahrenheit)를 섭씨(Celcius)로 변환하는 코드이다.
// 변환공식이 'C = 5 / 9 * (F - 32), (1)' 라고 할 때, float celcius = ; 에 알맞은 코드를 넣으시오.
// 단, 변환 결과값은 소수점 셋째자리에서 반올림해야 한다. (Math.round() 를 사용하지 말것)

// 결과 : Fahrenheit : 100, Celcius : 37.78

public class Chap03_06 {

	public static void main(String[] args) {

		int fahrenheit = 100;
		
		// float celcius = ; 에 알맞은 코드를 넣으시오.
		
		// 반올림하기 전 결과
		float celcius1 = (5 / 9f) * (fahrenheit - 32); // 37.77778
		
		// 결과를 '소수점 셋째자리'에서 반올림 => (결과 * 100 + 0.5) / 100f 
		float celcius2 = (int)((5 / 9f) * (fahrenheit - 32) * 100 + 0.5) / 100f; // 37.78
		// 정수형 나누기는 나머지를 버리기 때문에 두 피연산자 중 9를 실수형으로 변경해 실수형태의 결과를 얻는다.
		
		// 값 (37.77778)에 * 100 = 3777.778
		// 3777.778 + 0.5 = 3778.278
		// 위에서 나온 값을 int 로 변경한다. -> 3778
		// 3778 / 100 = 37.78
	
		System.out.println("Fahrenheit : " + fahrenheit);
		System.out.println("Celcius1 : " + celcius1 + "(반올림 전)");
		
		System.out.println("---------------------------------");
		
		System.out.println("Celcius2 : " + celcius2 + "(반올림 후)");
		
	}

}