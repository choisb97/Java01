package j17_fileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

// ** InputStream, OutputStream 2
// => Byte Stream이지만 byte 배열을 이용해서 처리속도 높이기
// => ppt 18-19p
public class Ex02_FileStreamBuf {
	
	public static void main(String[] args) throws IOException {
		// ** MTest에 존재하는 ~.txt 문서 이용
		// => 그러므로 InputStream부터 생성해도 됨.
		// => MTest에 존재하는 ~.txt 문서를 현재 프로젝트 내에 동일 이름으로 복사본 만들기
		InputStream in = new FileInputStream("d:\\MTest\\sql1209.sql"); 
		OutputStream out = new FileOutputStream("sql1209.sql");
		try {
			// ** read -> write 복사본 만들기
			// => byte Type의 배열을 만들어 1024 Byte 씩 처리하도록 함
			byte[] buff = new byte[1024];
			int len ;
			
			while(true) {
				// ** read(byte[] buff)
            	// => buff 크기 만큼 읽어 buff에 저장하고 읽은 byte 수를 반환
            	// => 다 읽으면 -1 반환
				len = in.read(buff);
				System.out.println("buff = >" + Arrays.toString(buff));
				if (len == -1) break;
				out.write(buff);
			} // while
		} catch (Exception e) {
			System.out.println("Exception => " + e.toString());
		} finally {
			// 스트림 소멸
			if (in != null) in.close();
			if (out != null) out.close();
		} // finally
		System.out.println("** Program Stop **");
	} // main
} // class
