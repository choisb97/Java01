package j18_fileIOTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// ** 怨쇱젣
// => DB �뿉�꽌  member Table �쓽 紐⑤뱺 Record, 紐⑤뱺 而щ읆�쓣 
//   硫붾え�옣�뿉�꽌 蹂� �닔 �엳�뒗 �뀓�뒪�듃 臾몄꽌濡� ���옣 �븳�떎.

// => 議곌굔1) �솕�씪寃쎈줈�뒗 �봽濡쒖젥�듃 �쐞移섏뿉 member.txt 濡� ���옣 �븯湲�
// => 議곌굔2) 媛� 而щ읆�� , 濡� 援щ텇
// => 議곌굔3) �젅肄붾뱶 蹂꾨줈 以꾨컮轅�  

// ** �빐寃�
// 1) DB �뿉�꽌 memberList 媛��졇�삤湲�
// 2) �뒪�듃由� �깮�꽦 & write
// 3) 硫붾え�옣 �뿉�꽌 �솗�씤

// ** 2. 臾몄옄 �뒪�듃由� �쟻�슜
// => �븘�꽣 臾몄옄 �뒪�듃由�, BufferedWriter , BufferedReader �쑝濡� 泥섎━
// => Java �봽濡쒓렇�옩�궡�뿉�꽌�룄 �궗�슜媛��뒫 �븯怨�, 硫붾え�옣 �벑 �� �봽濡쒓렇�옩�쑝濡쒕룄 �씤�떇 媛��뒫.

public class MemberMain2 {
	
	static MemberDAO dao = new MemberDAO();
	
	public static void main(String[] args) throws IOException {
		// 1) DB �뿉�꽌 memberList 媛��졇�삤湲�
		List<MemberVO> list = dao.selectList();
		
		//2) �뒪�듃由� �깮�꽦 & write
		// => 臾몄옄 �뒪�듃由쇱쑝濡� 泥섎━
		//    �븘�꽣 臾몄옄 �뒪�듃由�, BufferedWriter , BufferedReader �쑝濡� 泥섎━
		// => write , read console 異쒕젰 �솗�씤
		BufferedWriter out = new BufferedWriter(new FileWriter("memberBuf.txt"));
		BufferedReader in = new BufferedReader(new FileReader("memberBuf.txt"));
		
		try {
			// ** write
			for (MemberVO vo : list) {
				out.write(vo.toString());  // vo �쓽 toString() 硫붿꽌�뱶�뿉 �썝�븯�뒗 �룷留룹쓣 �젙�쓽�븯怨� �솢�슜 
				out.newLine();
			}// for
			out.flush();
			// ** read
			while(true) {
				String str = in.readLine();
				if (str != null) {
					System.out.println("member : " + str);
				}else break;
			} //while
		} catch (Exception e) {
			System.out.println("main Exception => " + e.toString());
		} finally {
			// ** �뒪�듃由� �냼硫�
			if (in != null) in.close();
			if (out != null) out.close();
		}
		System.out.println("** ** Member Test2: BufferedReader/Writer 醫낅즺 **");
	} // main
} // class
