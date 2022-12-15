package javaTest;

public class StudentTest {

	public static void main(String[] args) {

		Student[] studentA = {new Student("S001", "홍길동", 50, 60),
								new Student("S002", "이재영", 100, 100),
								new Student("S003", "홍영우", 70, 80),
								new Student("S004", "최보라", 90, 80),
								new Student("S005", "최수빈", 60, 70)};
		
		System.out.println("** 석차순 출력 **");
		
		Student.studentSort(studentA);
		
		for (Student s : studentA) {
			System.out.println("*-----------------*");
			s.infoPrint();
		}
		
	} // main
	
} // class
