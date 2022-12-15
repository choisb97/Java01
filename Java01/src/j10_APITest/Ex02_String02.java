package j10_APITest;

/*
 < String 2 >
 => String의 메서드
 => 문자열 추출
    charAt, length, indexOf, lastIndexOf, substring, trim
 => 메서드 적용 시 변수의 값이 변경되는 것이 아니고, 메서드가 적용결과를 return 할 뿐. 
*/

public class Ex02_String02 {

	public static void main(String[] args) {
		
		String name = "홍길동";
		String city = "  ~~~~~SeoulKorea~~~~~  ";
		String country = "     I love Korea     ";
		
	//------------------------------------------------------------------------------------
		
		// < 1. charAt > - char Type(한 글자)의 배열이라고 생각할 수 있음
		
		System.out.printf("* charAt => %s, %s \n", name.charAt(1), city.charAt(10));
		// * charAt => 길, u
		
	//------------------------------------------------------------------------------------
	
		// < 2. indexOf >
	
		System.out.printf("* indexOf => %d, %d, %d \n"
				, name.indexOf("홍"), city.indexOf("e"), country.indexOf("o"));
		// * indexOf => 0, 8, 8 -> 같은 글자(알파벳)이 있는 경우 첫 번째 것 return
		
		
		System.out.printf("* indexOf 비교 => %d, %d \n"
				, name.indexOf("김"), city.indexOf("e", 10)); // * indexOf 비교 => -1, 15
		// 없으면 -1(음수), indexOf("e", fromIndex) fromIndex 이후 글자부터 적용가능,
		// 여러 개면 첫 번째 것 return
		
	//------------------------------------------------------------------------------------
	
		// < 3. lastIndexOf >
		
		System.out.printf("* lastIndexOf => %d, %d, %d \n"
				, name.lastIndexOf("홍"), city.lastIndexOf("e"), country.lastIndexOf("o"));
		// * lastIndexOf => 0, 15, 13
		
	//------------------------------------------------------------------------------------
	
		// < 4. substring >
		// substring(3) : 인덱스 3부터 끝까지 (3~ )
		// substring(4, 8) : 인덱스 4부터 8 이전까지 (4~7)
		
		System.out.printf("* substring => %s, %s \n"
				, city.substring(12), country.substring(0, 8));
		// substring(0, 8) : 인덱스 0부터 8 이전까지(0~7)
		// * substring => Korea~~~~~  ,      I l 
		
	//------------------------------------------------------------------------------------
	
		// < 5. trim >
		// trim : 앞, 뒤의 스페이스(공백) 제거 => 변수의 값이 변경되는 것이 아님.
		
		System.out.printf("* trim => %s, %s \n", city.trim(), country.trim());
		// 변경된 값을 해당 변수에 적용하려면 -> ("country = ", country.trim());
		
		// * trim => ~~~~~SeoulKorea~~~~~, I love Korea
		
	//------------------------------------------------------------------------------------
		
		// < 실습 > 
		
		// 1. 아래 url에서 파일명만 추출해서 출력하세요~
		// 2. 아래 url에서 파일의 확장자만 추출해서 출력하세용
		// 3. 위의 city, country에서 "Korea"만 추출해서 출력하세요~
		String url = "C:\\MTest\\myWork\\Java01\\src\\j10_APITest\\Ex02_String02.java";
		
		System.out.printf("\n** 1. 파일명 = %s \n"
				, url.substring(url.lastIndexOf("\\") + 1, url.lastIndexOf(".")));
										   // '\' 하나를 추출하려면 "\\" 두 개 써야됨
		System.out.printf("** 2. 확장자 = %s \n", url.substring(url.lastIndexOf(".") + 1));
		
		System.out.printf("** 3. Korea = %s, %s \n"
				, city.substring(city.indexOf("K"), city.indexOf("a") + 1)
				, country.substring(country.indexOf("K"), country.indexOf("a") + 1));
	
	} // main

} // class
