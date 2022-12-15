package jv1_67_test; // p.285, 286

// ** 연습문제 07_04 **
// MyTv클래스의 멤버변수 isPowerOn(boolean), channel(int), volume(int)을
// 클래스 외부에서 접근할 수 없도록 제어자를 붙이고 (private)
// 대신 이 멤버변수들의 값을 어디서나 읽고 변경할 수 있도록
// getter와 setter메서드)를 추가하시오. -> public getter / setter

// channel과 volume의 범위를 아래 상수의 범위로 제한하도록 작성.

// 결과 = CH : 10
//      VOL : 20

//-----------------------------------------------------------------------

// ** 연습문제 07_05 **
//연습문제 7-4에서 작성한 MyTv2클래스에 이전 채널(previous channel)로
//이동하는 기능의 메서드를 추가해서 실행결과와 같은 결과를 얻도록 하시오.

//Hint - 이전 채널의 값을 저장할 멤버변수를 정의하라


//결과 = CH : 10
//     CH : 20
//     CH : 10
//     CH : 20

class MyTv2 {
	
	private boolean isPowerOn;
	private int channel;
	private int volume;
	
	// final 변수명 = 모두 대문자
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	// 연습문제 07_05
	// => 이전 채널의 값을 저장할 멤버변수 정의
	// - gotoPrevChannel메서드 작성
	
	/*
	 메서드명 : gotoPrevChannel
	 기능 : 현재 채널을 이전 채널로 변경한다.
	 반환타입 : 없음
	 매개변수 : 없음
	 */
	
	private int prevChannel;
	
	public void gotoPrevChannel() {
		setChannel(prevChannel);
	}
	
	// => 채널이 변경될 때 현재 채널의 값을 prevChannel에 보관하기
	//    setChannel에서 처리하는 것이 적합.
	
	//-----------------------------------------------------------------------
	
	// *변수명의 두 번째 알파벳이 대문자인 경우에는 
	//  자동완성 방법이 다른 경우가 있어 혼동이 일어날 수 있으므로
	//  대부분 사용하지 않는다.
	// 예)
	// private int tEst;
	// public int gettEst() { return tEst; } -> 이클립스에서 자동완성한 코드의 예
		
	// (1) 알맞은 코드를 넣어 완성하시오.
	public boolean getIsPowerOn() {
		return this.isPowerOn;
	}
		
	
	public void setIsPowerOn(boolean isPowerOn) {
		this.isPowerOn = isPowerOn;
	}
		
		
	public int getChannel() {
		return channel;
	}
		
	
	public void setChannel(int channel) {
		if (channel > MAX_CHANNEL || channel < MIN_CHANNEL) {
			// channel이 MAX_CHANNEL보다 크거나 MIN_CHANNEL보다 작을 때
		System.out.println("** channel이 범위를 초과했습니다. **");
		} else {
			prevChannel = this.channel;
			// 채널이 변경되기 전에 현재 채널의 값을 prevChannel 에 보관
			this.channel = channel;
		}
	} // setChannel

		
	public int getVolume() {
		return volume;
	}

	
	public void setVolume(int volume) {
		if (volume > MAX_VOLUME || volume < MIN_CHANNEL) {
			System.out.println("** volume이 범위를 초과했습니다. **");
			return;
		}
		this.volume = volume;
	} // setVolume
	
} // c_MyTv2


public class Chap07_04 {

	public static void main(String[] args) {
		
		MyTv2 t = new MyTv2();
		
		// ** 연습문제 07_04
		System.out.println("<연습문제 07_04 >");
		
		t.setChannel(10);
		System.out.println("CH : " + t.getChannel()); // CH : 10
		
		t.setVolume(20);
		System.out.println("VOL : " + t.getVolume()); // VOL : 20
		
		System.out.println("-----------------------------------");
		
		//----------------------------------------------------
		
		// < 오류 Test >
		t.setChannel(0); // ** channel이 범위를 초과했습니다. **
		t.setVolume(110); // ** volume이 범위를 초과했습니다. **

		System.out.println("-----------------------------------");
		
		//----------------------------------------------------

		// ** 연습문제 07_05
		System.out.println("< 연습문제 07_05 >");
		
		t.setChannel(10);
		System.out.println("CH : " + t.getChannel()); // 10
		
		t.setChannel(20);
		System.out.println("CH : " + t.getChannel()); // 20, prevChannel 10보관
		
		t.gotoPrevChannel(); // prevChannel에 보관된 10 -> channel로 set, prevChannel 20보관
		System.out.println("CH : " + t.getChannel()); // 10
		
		t.gotoPrevChannel(); // prevChannel에 보관된 20 -> channel로 set
		System.out.println("CH : " + t.getChannel()); // 20
		
	} // main

} // class
