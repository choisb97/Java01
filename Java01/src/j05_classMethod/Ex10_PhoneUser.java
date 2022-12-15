package j05_classMethod;

public class Ex10_PhoneUser {

	public static void main(String[] args) {

		// 1) static Test : 클래스명으로 접근
		
		Ex10_Phone.setCompany("삼성갤럭시");
		// company - private라서 접근불가하기 때문에 setter 사용
		
		System.out.println("* company = " + Ex10_Phone.getCompany()); // 출력 시 getter 사용
		// * company = 삼성갤럭시
		
		Ex10_Phone.staticTest();
		// Ex10_Phone에서 System.out.printf("* PI = %f, company = %s \n", PI, company);
		// * PI = 3.141590, company = 삼성갤럭시
		
		System.out.println("----------------------------------------------");
		
		//---------------------------------------------------------------
		
		// 2) non-static : 인스턴스로 접근
		// => default 생성자
		// => setter 사용해서 초기화
		
		Ex10_Phone phone1 = new Ex10_Phone();
		phone1.setColor("Gold");
		phone1.setPrice(100000);
		
		System.out.println("* phone1 = " + phone1);
		// * phone1 = Ex10_Phone [color = Gold, price = 100000, company = 삼성갤럭시]
		
		//---------------------------------------------------------------
		
		// => 생성자로 초기화
		Ex10_Phone phone2 = new Ex10_Phone("Silver", 200000);
		
		System.out.println("* phone2 = " + phone2);
		// * phone2 = Ex10_Phone [color = Silver, price = 200000, company = 삼성갤럭시]
		
		System.out.println("----------------------------------------------");
		
		phone2.finalTest();
		// Ex10_Phone에서 System.out.printf("* PI = %f, PI2 = %f \n", PI, PI2);
		// * PI = 3.141590, PI2 = 3.141590

		System.out.println("----------------------------------------------");

		//---------------------------------------------------------------
		
		// 3) company 수정 & 상수 Test
		
		Ex10_Phone.setCompany("Apple");
		// company - private라서 접근불가하기 때문에 setter 사용해서 수정
		
		System.out.println("* phone1 = " + phone1);
		// * phone1 = Ex10_Phone [color = Gold, price = 100000, company = Apple]
		
		System.out.println("* phone2 = " + phone2);
		// * phone2 = Ex10_Phone [color = Silver, price = 200000, company = Apple]

		System.out.println("----------------------------------------------");
		
		System.out.println("* PI Test = " + phone2.getPrice() * Ex10_Phone.PI);
		// * PI Test = 628318.0
		// phone2의 price 200000 * 3.14159 -> float(실수) = 628318.0
		
		System.out.println("* PI2 Test = " + phone2.getPrice() * phone2.PI2);
		// * PI2 Test = 628318.0
		// phone2의 price 200000 * 3.14159 -> float(실수) = 628318.0
		
	} // main

} // class
