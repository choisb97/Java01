package javaTest;

public class Student extends Person {

	int java;
	int html;
	int sum;
	
	public Student (String pno, String pname, int java, int html) {
		super(pno, pname);
		this.java = java;
		this.html = html;
		this.sum = java + html;
	} // Student_java, html
	
	@Override
	public void infoPrint() {
		super.infoPrint();
		System.out.println("Java : " + java);
		System.out.println("Html : " + html);
		System.out.println("합계 : " + sum);
	} // infoPrint
	
	public static void studentSort(Student[] studentA) {
		// 합계(sum)을 기준으로 성적순으로 정렬
		for (int i = 0; i < studentA.length; i++) {
			for (int j = i + 1; j < studentA.length; j++) {
				if (studentA[i].sum < studentA[j].sum) { // 내림차순
					Student temp = studentA[i];
					studentA[i] = studentA[j];
					studentA[j] = temp;
				}
			} // for_j
		} // for_i
		
	} // studentSort
	
} // c_Student
