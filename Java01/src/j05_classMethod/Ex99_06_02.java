package j05_classMethod; // p.207 연습문제 6-2

// 다음과 같은 실행결과를 얻도록 Student클래스에 생성자와 info()를 추가하시오.

// T Hint : info() 메서드 : toString 메서드 참고

// 결과 : 홍길동, 1, 1, 100, 60, 76 -> 이름, 반, 번호, java점수, html점수, js점수


class Student {

	// 1) 멤버변수 정의
	String name;
	int classNum;
	int stNum;
	int javaSc;
	int htmlSc;
	int jsSc;

	//------------------------------------------------------------------------------------

	// 2) 변수를 초기화하는 생성자
	Student(String name, int classNum, int stNum, int javaSc, int htmlSc, int jsSc) {

		this.name = name;
		this.classNum = classNum;
		this.stNum = stNum;
		this.javaSc = javaSc;
		this.htmlSc = htmlSc;
		this.jsSc = jsSc;

	} // Student

	//---------------------------------------------------------------------------------

	// 3) info 메서드(toString return)

	public String info() { // 객체의 상태를 문자열로 반환하는 메서드
		return	"* 이름 : " + name + " \n" +
		"* 반 : " + classNum + " \n" +
		"* 번호 : " + stNum + " \n" +
		"* Java 점수 : " + javaSc + " \n" +
		"* HTML 점수 : " + htmlSc + " \n" +
		"* JS 점수 : " + jsSc + " \n" + 
		"* 합 계 : " + (javaSc + htmlSc + jsSc) + " \n" +
		"* 평 균 : " + ((float)(javaSc + htmlSc + jsSc) / 3);

	} // info

	//----------------------------------------------------------------------------

	public String toString() { // 객체의 상태를 문자열로 반환하는 메서드
		return  "* 이름 : " + name + " \n" +
		"* 반 : " + classNum + " \n" +
		"* 번호 : " + stNum + " \n" +
		"* Java 점수 : " + javaSc + " \n" +
		"* HTML 점수 : " + htmlSc + " \n" +
		"* JS 점수 : " + jsSc + " \n" + 
		"* 합 계 : " + (javaSc + htmlSc + jsSc) + " \n" +
		"* 평 균 : " + ((float)(javaSc + htmlSc + jsSc) / 3);

	} // toString

} // class Student

//==========================================================================

public class Ex99_06_02 {

	public static void main(String[] args) {

		Student s1 = new Student("홍길동", 1, 1, 100, 60, 76);

		String str = s1.info();

		System.out.println("< 학생 정보 > \n" + str);

		System.out.println("---------------------------------------------------");

		//-----------------------------------------------------------------------------

		System.out.println("< 학생 정보 > \n" + s1);
		// toString 메서드가 없으면 주소 출력
		// j05_classMethod.Student@2d363fb3

		System.out.println("---------------------------------------------------");

		Student s2 = new Student("이재영", 1, 2, 100, 100, 100);
		System.out.println("< 학생 정보 > \n" + s2);

		System.out.println("---------------------------------------------------");

		Student s3 = new Student("대장동 션", 1, 3, 100, 73, 85);
		System.out.println("< 학생 정보 > \n" + s3);

		System.out.println("---------------------------------------------------");

		//---------------------------------------------------------------------

		// < 반 별 통계 >
		// - 배열 적용
		// String[] ss = { " " };

		Student[] ss = { s1, s2, s3, 
				new Student("최보라", 1, 4, 100, 87, 93),
				new Student("최수빈", 1, 5, 100, 53, 87)};

		System.out.println("< 학생 정보 > \n" + new Student("최보라", 1, 4, 100, 87, 93));

		System.out.println("---------------------------------------------------");

		System.out.println("< 학생 정보 > \n" + new Student("최수빈", 1, 5, 100, 53, 87));

		//------------------------------------------------------------------------------------

		int jTotal = 0,
				hTotal = 0,
				jsTotal = 0;


		for (int i = 0; i < ss.length; i++) {

			// 1) 과목 별 점수 합계 (반 전체)
			jTotal += ss[i].javaSc;
			hTotal += ss[i].htmlSc;
			jsTotal += ss[i].jsSc;

		} // for_i

		System.out.println("---------------------------------------------------");

		System.out.println("*Java Total = " + jTotal);
		System.out.println("*HTML Total = " + hTotal);
		System.out.println("*JScript Total = " + jsTotal);

	} // main

} // class
