package javaTest;

public class Person {

	private String no;
	private String name;
	
	public Person() {
		// Person default 
	}
	
	public Person(String no, String name) {
		this.no = no;
		this.name = name;
	} // Person_no, name

	public String getNo() {
		return no;
	}

	public String getName() {
		return name;
	}
	
	public void infoPrint() {
		System.out.println("번호 : " + getNo());
		System.out.println("이름 : " + getName());
	}

} // c_Person
