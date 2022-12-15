package jv0_00_study;

// j14_generic -> Ex01_GenStore, Ex02_GenArray에 사용

import java.util.Calendar;

// ** Person
// => 주민등록번호,  이름을 전달받으면
// => 주민등록번호를 이용해서, age, 성별을 set 하고
// => info 출력하기 

// => 멤버필드(private) : idNo(String), name(String), age(int), gender(char)
// => 생성자 2개
//		* default
//		* 주민등록번호,이름을 매개변수로 전달받아 초기화 
//		-> 나이 계산, 성별도 찾아서 set
// => setter/getter
//    이름만 수정 가능, 
//    모든필드를 사용가능 (그러나 주민번호는 뒷자리는 * 로표시)
// => infoPrint()
// => toString 은 오버라이딩

// ** info
// 이름 : 000
// 번호 : 090909-*******
// 나이 : 20세
// 성별 : "남" 또는 "여"

// ** Person 의 sub 클래스 만들기
// => 자유롭게 Student 또는 Programmer , Employee 등 후손클래스를 만들어보세요
// => 맴버변수 2개, 생성자 2개 (default, 조상필드까지 모두 초기화 하는 생성자),
//    infoPrint 는 오버라이딩 해서 모든 정보 출력
//    setter/getter, toString 
// ** ChildTest 클래스 
// => 인스턴스 2개 생성 후 실행
//    default 생성자로 1개 생성 (idNo 전달 안되어 출력안됨)
//    초기화 생성자로 1개 생성 (모든정보 출력됨) 

public class Ex01_Person {
	private String idNo;
	private String name;
	private int age;
	private char gender;
	// 생성자1
	public Ex01_Person() {
		System.out.println("** Person Default 생성자 **");
	}
	// 생성자2
	public Ex01_Person(String idNo, String name) {
		super();
		System.out.println("** Person 초기화 생성자 **");
		this.idNo = idNo;
		this.name = name;
		
		// idNo : 6자리-7자리 총14 자리 -> 900909-1022333 , 010101-3011222
		// 1) 성별 찾기
		// => 뒷자리1번째 (1,3->"남" / 2,4->"여" / 5->"외국인" 외국인등록번호 )
		gender = idNo.charAt(idNo.indexOf("-")+1);
				
		// 2) 나이 계산
		// => 올해 : 2021 (추후 System 날짜 이용으로 Up)  
		// => 태어난해 : 주민번호의 앞2자리와 뒷자리1번째 (1,2->1900 / 3,4->2000)
		
		// age =  2021 - Integer.parseInt(idNo.substring(0,2)) ; 
		
		// ** 2021 -> 시스템 날짜 에서 가져온다
		// => Calendar Class 적용하기
		// Calendar now = Calendar.getInstance();
		// int year = now.get(Calendar.YEAR); //2021
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		age =  year - Integer.parseInt(idNo.substring(0,2)) ; 
		
		if (gender =='1' || gender =='2')
			age -= 1900;
		else 
			age -= 2000;
	}
	// setter 
	public void setName(String name) {
		this.name = name;
	}
	// getter
	public String getIdNo() {
		//  "090909-1234567" 
		if ( idNo != null )
			 return (idNo.substring(0, idNo.indexOf("-")) + "-*******");
		else return null ;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public char getGender() {
		if (gender == '1' || gender == '3') 
			return '남';
		else 
			return '여';
	}
	// infoPrint()
	public void infoPrint() {
		System.out.println("** info Print **");
		System.out.println("* 번호 : " + getIdNo());
		System.out.println("* 이름 : " + getName());
		System.out.println("* 나이 : " + getAge());
		System.out.println("* 성별 : " + getGender());
	}
	// toString
	@Override
	public String toString() {
		return "Ex04_Person [idNo=" + idNo + ", name=" + name + ", age=" + age + ", gender=" + gender + "]\n";
	}

} // class
