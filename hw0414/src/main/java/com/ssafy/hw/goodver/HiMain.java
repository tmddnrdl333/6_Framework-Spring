package com.ssafy.hw.goodver;

public class HiMain {
	public static void main(String[] args) {
		HiMsg hiMsgEng = new HiMsgEng();
		HiMsg hiMsgKor = new HiMsgKor();

		String greeting1 = hiMsgEng.Hi("seungwook");
		String greeting2 = hiMsgKor.Hi("승욱");

		System.out.println(greeting1);
		System.out.println(greeting2);

	}
}
