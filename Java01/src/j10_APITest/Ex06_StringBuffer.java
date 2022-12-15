package j10_APITest;

/*
  < String, StringBuffer, StringBuilder 차이 및 장단점 >
 => https://ifuwanna.tistory.com/221
 
 
 ** String : 문자열 연산이 적고 멀티쓰레드 환경일 경우
 ** StringBuffer : 문자열 연산이 많고 멀티쓰레드 환경일 경우
 ** StringBuilder : 문자열 연산이 많고 단일쓰레드이거나 동기화를 고려하지 않아도 되는 경우  


  < String >
 - '불변(immutable)' 속성을 가짐. 
   그러므로 문자열의 연산(입력,수정,삭제등)이 빈번한 경우 힙(Heap)메모리에 
   많은 가비지(Garbage)가 생성되므로 비효율적.
   equals 메서드를 오버라이딩 해서 문자열의 내용을 비교할 수 있도록 했음.
   동기화 키워드를 지원하여 멀티쓰레드 환경에서 안전 (thread-safe).

-----------------------------------------------------------------

  => (정석 Chap 9, p477~ )
  < StringBuffer / StringBuilder >
 - 내부적으로 buffer를 가지고 있으므로 '가변성(mutable)'을 가짐.
   인스턴스 생성 시 크기 지정가능 (편집할 문자를 고려하여 충분히 잡는 것이 좋음)
   .append() .delete() 등을 이용하여 동일 객체 내에서 문자열 변경가능
   그러므로 문자열의 연산(입력, 수정, 삭제등)이 빈번한 경우 String 보다 적합.


  < StringBuffer vs StringBuilder 차이점은 동기화의 유무 >
 - 동기화 유무 
 - StringBuffer : 동기화 키워드를 지원하여 멀티쓰레드 환경에서 안전 (thread-safe)
 - StringBuilder : 동기화를 지원하지 않으므로 멀티쓰레드 환경에서 적합하지 않지만
                   단일쓰레드에서의 성능은 StringBuffer보다 뛰어남.

 - equals 메서드 오버라이딩 하지 않았기 때문에 내용을 비교하지 않으므로 '==' 과 동일결과(주소값 비교).
 - toString은 오버라이딩 되어있어서 담고있는 문자열을 String으로 반환 한다.  


  < StringBuffer클래스 특징 >
 - 문자열 처리속도 높고, 중간에 변경 가능함


  => (정석 p480 ~ 481) 
  < StringBuffer클래스 메서드 >
 - String 클래스와 유사한 메서드를 많이 가지고 있으며,
   저장된 내용을 변경할 수 있는 insert, replace, delete 등을 추가로 제공한다. 
   
 - 기본 용량은 16(16자의 문자열 빌더)이고 필요 시 자동으로 늘려준다.

 * append : 문자열로 이어줌

 * deleteCharAt(10) : 지정된 위치의 문자 제거  

 * delete(3, 6) : 3 <= , < 6 사이의 문자 제거

 * insert(int pos, "abc") : pos 위치에 문자열 "abc" 삽입
   단, pos는 0 부터 시작.  
                
 * replace(int s, int e, "END")
   s <= ~ < e 구간의 문자열을 "END"로 변경함.
   
 * capacity() : StringBuffer 인스턴스의 buffer 크기 (단위 : byte)
   
 * length() : buffer에 담긴 문자열의 길이
*/

public class Ex06_StringBuffer {

	public static void main(String[] args) {
		
		// < StringBuffer 기본 특징 >
		// - 기본 용량은 16(16자의 문자열 빌더)이고 필요 시 자동으로 늘려준다.
		// - 생성 시 용량 지정 가능 (도중에 늘리는 것 보다는 충분한 용량을 지정하는 것이 바람직함)
		
		// 명시적 생성 (new 연산자) - 내용이 같아도 다른 주소값 가짐
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		
		StringBuffer sb = new  StringBuffer(10); // 생성 시 용량 지정 가능
		// ctrl + space -> StringButter - int capacity
		
		System.out.println(sb);

	//------------------------------------------------------------------------------------
		
		// == 연산자 : 주소값 비교 / equals : 대상의 내용(값) 비교
		
		// < StringBuffer 클래스 >
		// - equals메서드를 오버라이딩하지 않아서 StringBuffer클래스의 equals메서드를 사용해도
		//   등가비교연산자 (==)로 비교한 것과 같은 결과를 얻는다.
		
		System.out.println("sb1 == sb2 => " + (sb1 == sb2)); // false
		// 주소값이 다르기 때문에 False
		
		System.out.println("sb1.equals(sb2) => " + (sb1.equals(sb2))); // false
		// 내용("abc")은 같지만 등가비교연산자 (==)로 비교한 것과 같은 결과 False
		
		//---------------------------------------------------------------------------------
		
		// String s1 = sb1; => Type mismatch Error
		String s1 = sb1.toString(); // String s1 = new String(sb1);과 같다.
		String s2 = sb2.toString();
		
		// StringBuffer의 내용을 toString() 이용해서 String Type으로 변환
		System.out.println("\ns1 == s2 => " + (s1 == s2)); // false
		// String Type이라도 주소값은 다르기 때문에 False
		
		System.out.println("s1.equals(s2) => " + (s1.equals(s2))); // true
		// String Type으로 내용("abc")을 비교하기 때문에 True
		
	//------------------------------------------------------------------------------------
		
		// < StringBuffer 메서드 >
		System.out.println("\n< StringBuffer 메서드 Test >");
		
		s1 = "우리나라";
		s2 = "대한민국";
		sb1.append(s1);
		sb1.append(s2);
		sb1.append(sb2);
		
		System.out.println("** After append sb1 = " + sb1);
		// => toString 메서드가 오버라이드 되어있으므로 값이 출력됨
		
		
		StringBuffer sb3 = new StringBuffer("03");
		
		sb3.append(100);
		sb3.append(200).append(300).append(400.567);
		// 숫자연산을 하지 않는다.(문자열로 연결되어 출력)
		
		System.out.println("** After append sb3 = " + sb3); // 03100200300400.567
		
		
		System.out.println("\n** insert sb3 = " + sb3.insert(0, "abcd"));
		System.out.println("** insert2 sb3 = " + sb3.insert(5, "abcd"));
		
		
		// => replace(시작위치, 끝 지점 + 1, "변경값" -> .부터 끝까지 END로 변경
		System.out.println("\n** replace sb3 = " + 
							sb3.replace(sb3.lastIndexOf("."), sb3.length(), "END"));
		
	
		System.out.println("\n** deleteCharAt sb3 = " + sb3.deleteCharAt(5)); // 지정위치
		System.out.println("** delete sb3 = " + sb3.delete(0, 3)); // 구간 0부터 3이전까지 삭제
		
		
		System.out.println("\n** capacity sb3 = " + sb3.capacity()); // 용량 : 38(byte)
		
		
	} // main

} // class
