package j13_Collection;

import java.util.Enumeration;
import java.util.Properties;

/*
< List >
- 순서 O, 중복 O

< Set >
- 순서 X, 중복 X

< Map >
- 순서 X, 중복 Key : X / Value : O
*/

/*
 < Properties >
 => Properties는 HashMap의 구버전인 Hashtable을 상속받아 구현한 것으로, 
    Hashtable은 키와 값을 (Object, Object)의 형태로 저장하는데 비해 
    Properties는 (String, String)형태로 저장하는 보다 단순화된 컬렉션 클래스 이다. 

 => Properties SourceCode header
    public class Properties extends Hashtable<Object,Object> {...

 => 주로 애플리케이션의 환경설정과 관련된 속성을 저장하는데 사용되며 
    데이터를 파일로부터 읽고 쓰는 편리한 기능을 제공한다. 
    그래서 간단한 입출력은 Properties를 활용하면 몇 줄의 코드로 쉽게 해결할 수 있다. 
*/

public class Ex10_Properties {

	public static void main(String[] args) {
		
		// < 정의 & Data 입력 >
		// - 동일 Key 허용되지 않고, 동일 Key 입력 시에는 나중 값이 적용 됨.
		Properties pp = new Properties();
		
		pp.setProperty("insert", "MemberInsert.java");
		pp.setProperty("update", "MemberUpdate.java");
		pp.setProperty("delete", "MemberDelete.java");
		pp.setProperty("list", "MemberList.java");
		pp.setProperty("detail", "MemberDetail.java");
		pp.setProperty("list", "MemberPrint.java");
		// pp.setProperty("test", 12345); -> String Type 아닌 값이 입력되면 오류
		// => 컴파일오류 발생 : setPoperty(String k, String v) 만 허용됨
		
		System.out.println("** pp = " + pp);
		System.out.println("");
		
		// < 순차처리 >
		// - Enumeration 사용
		Enumeration<?> ep = pp.propertyNames(); // Properties의 Key 값들만 return
		
		while (ep.hasMoreElements()) {
			String eKey = (String) ep.nextElement();
			System.out.printf("key = %s, getProperty = %s, get = %s\n", eKey, pp.getProperty(eKey), pp.get(eKey));
		} // while
		
	} // main

} // class
