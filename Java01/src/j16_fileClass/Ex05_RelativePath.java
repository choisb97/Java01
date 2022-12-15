package j16_fileClass;

import java.io.File;

// 실행 환경 및 실행위치에 따른 문제를 최소화하기 위해 
// 현재 디렉토리를 가져와서 이를 기준으로 작업하는 것이 좋음.
public class Ex05_RelativePath {

	public static void main(String[] args) {
		File curDir = new File("AAA");
		System.out.println(curDir.getAbsolutePath());
		
		File upperDir = new File("AAA" + File.separator + "BBB");
		System.out.println(upperDir.getAbsolutePath());
	} // main
} // class
