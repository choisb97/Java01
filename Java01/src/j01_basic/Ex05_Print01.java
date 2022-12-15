package j01_basic;

import java.util.Date; // java.util 안에 있는 Date 라는 class 이다.

public class Ex05_Print01 {

	public static void main(String[] args) {
		// < Escape 문자 :  역할이 정해져 있는 문자 >
		// - \n 줄 바꿈, \t 탭 간격, ...
		
		System.out.println(" < 경로 출력 > ");
		System.out.println("C:\\MTest\\myWork\\Java01\\src\\j01_basic");
		                   // 출력하려면 연속 두 개 (\\) -> 출력 시 \ 한 개 나옴.
		
		System.out.println("------------------------------------------------");
		
		System.out.println(" < \" \" 문자 출력 > "); // 출력 할 " 앞에 \ 붙이기. -> 형태 : \"
		System.out.println("'A', \"A\" ");	// 'A', "A"
		
		System.out.println("------------------------------------------------");
		
		System.out.println("abcd\tefghi\tjk123\n"); 
		System.out.println("abcd \t efghi \t jk123 \n"); 
		// \t, \n 출력하고 싶은 문자랑 붙여써도 알아서 간격, 줄 바꿈 가능하지만 띄어쓰면 한 칸씩 더 벌어짐.
		
		System.out.println("------------------------------------------------");
		
		System.out.println("\n"); // 줄바꿈
		System.out.println('\n'); // 한 문자만(char) 출력하는 경우 => 작은 따옴표 ('') 허용.
		System.out.println('\''); // char 로 ' 하나 줄력
		System.out.println('\"'); // char 로 " 하나 출력
		System.out.println('A');
		System.out.println('가');
		
		System.out.println("------------------------------------------------");

		// < print, println, printf >
		System.out.print("print1 : 줄 바꿈이 안 됨. "); // 안 됨. 다음 띄어쓰기 때문에 한 칸 띄워짐.
		System.out.print("print2\t"); // 탭 간격
		System.out.print("print3\t");
		System.out.print("print4");
		System.out.println("");	// 내용 없이 써서 줄 바꿈
		System.out.println(" 줄 바꿈 가능.");
		
		System.out.println("------------------------------------------------");
		
		// 출력 포맷에서 % 가 들어가면 지시자..!
		System.out.printf("금액1 : %d원 \n", 1234567);   // 금액1 : 1234567원
		System.out.printf("금액2 : %9d원 \n", 1234567);  // 자릿수(9자리) 위치선정. / 금액2 :   1234567원
		System.out.printf("금액3 : %-9d원 \n", 1234567); // -n => 앞에서부터 n자리 위치선정. / 금액3 : 1234567  원
		System.out.printf("금액4 : %09d원 \n", 1234567); // n자리 중 숫자 없는 부분에 0 채움. / 금액4 : 001234567원
		
		System.out.printf("금액1 : %,d원 \n", 1234567); // 금액1 : 1,234,567원
		System.out.printf("금액4 : %,09d원 \n", 1234567); // 전체 9자리 중 ',' 두 개 포함해서 0 없어짐. / 금액1 : 1,234,567원

		System.out.println("------------------------------------------------");
		
		System.out.printf("반지름이 %d인 원의 넓이 = %10.2f \n", 10, 10 * 10 * Math.PI);
		                        // %10.2f : %f 총 10자리 숫자(.포함), 없는 공간은 빈 칸 /.2 -> 소수점 뒤 자릿수, 나머지는 반올림
		
		System.out.printf("%s은(는) %d학년 %d반, 학점은 %s입니다. \n", "최수빈", 3, 6, 'A');
		// System.out.printf(" %s은(는) %d학년 %d반, 학점은 %s입니다. \n ", "최수빈", "3", 6, 'A');
		// 출력 Data 와 Format Type 이 안 맞으면 컴파일 오류는 없고, 런타임 오류 발생
		// -> java.util.IllegalFormatConversionException
		
		System.out.println("------------------------------------------------");

		// < 날짜 출력 >
		
		// java.util.Date now; => import 하지 않은 경우
		Date now;	// String name; 과 같음.	// 빨간 밑줄 보면 java.util 있음 -> 누르면 import 됨 (#3 참고) 
		
		// => java.lang 에 있는 class 들은 import 하지 않아도 바로 사용 가능.
		
		now = new Date(); // '년, 월, 일, 시, 분, 초' 데이터 포함
		
		System.out.println(" < 날짜 출력 > ");
		
		System.out.printf("오늘은 %tY년 %tm월 %td일입니다. \n", now, now, now); // 20nn년 nn월 nn일입니다.
		System.out.printf("오늘은 %ty년 %tm월 %td일입니다. \n", now, now, now); // nn년 nn월 nn일입니다.
		System.out.printf("Today %tD \n", now, now, now);				         // 월(nn)/일(nn)/년(nn)
	//-------------------------------------------------------------------------------------------
		System.out.printf("오늘은 %1$tY년 %1$tm월 %1$td일입니다. \n", now); // 1$ -> 매개변수의 개수(하나로) 줄임.
		// 오늘은 20nn년 nn월 nn일입니다.
		
		System.out.println("------------------------------------------------");
		
		System.out.println(" < 시간 출력 > ");
		
		System.out.printf("지금은 %tH시 %tM분 %tS초입니다. \n", now, now, now);
		System.out.printf("지금은 %1$tH시 %1$tM분 %1$tS초입니다. \n", now); // 1$ -> 매개변수의 개수(하나로) 줄임.
		
		/*
		 % : 출력형식을 의미하는 문자열은 반드시 %로 시작,
	     %d : 정수 , %f 실수, %s 문자 
	     %,d : 정수에 3자리마다  , 표시 
	     %t : 날짜 시간을  
	     %n , \n : 줄바꿈
	     $ 사용하면 매개변수의 개수를 줄일 수 있음
	     => %2$d : 2번째 매개변수 10진수
		*/
		
		System.out.println("------------------------------------------------");
		
		char c = 'A';
		c = 'B';
	    int finger = 10;
	    long big = 100_000_000_000L;
	    long hex = 0xFFFF_FFFF_FFFF_FFFFL;
	    int octNum = 010; // 8진수 => 8 '0' 1 0
	                                     // 8 1
	    int hexNum = 0x10; // 16진수 => 16 '0x' 1 0
	                                        // 16 1
	    int binNum = 0b10; // 2진수 => 2 '0b' 1 0
	                                       // 2 1
	    
	    System.out.printf("c = %c, %d %n", c, (int)c);  
	    System.out.printf("finger = [%d] %n", finger);  
	    System.out.printf("finger = [%-5d] %n", finger);  
	    System.out.printf("finger = [%05d] %n", finger);
	    
	    System.out.printf("big = %d %n", big);
	    System.out.printf("hex = %#x %n", hex);  // '#' 은 접두사 (16진수 #x, 8진수 #o)
	    System.out.printf("hex = %d %n", hex); // -1 왜 -1인지 알 수 없음.
	    
	    System.out.printf("octNum = %#o, %d %n", octNum, octNum);
	    System.out.printf("hexNum = %#x, %d %n", hexNum, hexNum);
	    System.out.printf("binNum = %s, %d %n", Integer.toBinaryString(binNum), binNum);
	    
	    System.out.printf("Float.SIZE = %d %n", Float.SIZE);
	    
	    System.out.println("------------------------------------------------");

	    // - 는 왼쪽 정렬방식
	    System.out.printf("%3d %10s %8s %-5d %n", 1, "jang", "장희정", 20);
	    System.out.printf("%3d %10s %8s %-5d %n", 22, "hee", "정효욱", 03);
	    System.out.printf("%3d %10s %8s %-5d %n", 3, "rew97", "장정희", 20);
	    System.out.printf("%3d %10s %8s %-5d %n", 4, "jang", "장희정", 20);
	    
	}	// main

}	// class
