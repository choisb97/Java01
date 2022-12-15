package j18_fileIOTest;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

// ** 怨쇱젣
// => DB �뿉�꽌  member Table �쓽 紐⑤뱺 Record, 紐⑤뱺 而щ읆�쓣 
//    硫붾え�옣�뿉�꽌 蹂� �닔 �엳�뒗 �뀓�뒪�듃 臾몄꽌濡� ���옣 �븳�떎.

// => 議곌굔1) �솕�씪寃쎈줈�뒗 �봽濡쒖젥�듃 �쐞移섏뿉 memberObj.txt 濡� ���옣 �븯湲�
// => 議곌굔2) 媛� 而щ읆�� , 濡� 援щ텇
// => 議곌굔3) �젅肄붾뱶 蹂꾨줈 以꾨컮轅�  

// ** �빐寃�
// 1) DB �뿉�꽌 memberList 媛��졇�삤湲�
// 2) �뒪�듃由� �깮�꽦
// 3) write
// 4) 硫붾え�옣 �뿉�꽌 �솗�씤

// ** 1. Byte �뒪�듃由쇱쓽 媛앹껜吏곷젹�솕 �쟻�슜
// => Java �봽濡쒓렇�옩�궡�뿉�꽌�뒗 �궗�슜媛��뒫 �븯吏�留�, 硫붾え�옣�쑝濡쒕뒗 蹂쇱닔 �뾾�쓬

public class MemberMain {
	
	static MemberDAO dao = new MemberDAO();

	public static void main(String[] args) throws IOException {
		// 1) DB �뿉�꽌 memberList 媛��졇�삤湲�
		// => console 異쒕젰�븯湲�
		List<MemberVO> list = dao.selectList();
		for (MemberVO vo:list) {
			System.out.println(vo);
		}
		// 2) �뒪�듃由� �깮�꽦 & write
		// 2.1) byte �뒪�듃由쇱쓽 媛앹껜吏곷젹�솕
		// => Java Code 濡쒕뒗 �솗�씤媛��뒫�븯吏�留� 硫붾え�옣�쑝濡쒕뒗 �솗�씤遺덇�
		// => 臾몄옄�뒪�듃由쇱쑝濡� 泥섎━�빐�빞 �븿
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("memberObj.txt"));
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("memberObj.txt"));
		try {
			// * 媛앹껜 吏곷젹�솕 -> to �솕�씪
			for (MemberVO vo : list) {
				out.writeObject(vo);
			}
			System.out.println("** ReadObject Stream **");
			while (true) {
				// * 媛앹껜 �뿭吏곷젹�솕 -> to vo
				MemberVO vo = (MemberVO)in.readObject();
				if (vo != null) System.out.println(vo);
				else break;
			}
		} catch (EOFException e) {
			System.out.println("** readObject 醫낅즺 => " + e.toString());
			System.out.println("** �옄猷� 異쒕젰 �셿猷� **");
		} catch (Exception e) {
			System.out.println("main Exception => " + e.toString());
		} finally {
			// ** �뒪�듃由� �냼硫�
			if (in != null) in.close();
			if (out != null) out.close();
		}
		
		// 2.2) 臾몄옄 �뒪�듃由쇱쑝濡� 泥섎━
		// => MemberMain2.java �뿉�꽌 泥섎━
		
		System.out.println("** Member Test 醫낅즺 **");
	} // main
} // class
