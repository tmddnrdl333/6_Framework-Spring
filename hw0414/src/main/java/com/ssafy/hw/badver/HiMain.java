package com.ssafy.hw.badver;

public class HiMain {
	public static void main(String[] args) {
		HiMsgEng hiMsgEng = new HiMsgEng();
		HiMsgKor hiMsgKor = new HiMsgKor();

		String greeting1 = hiMsgEng.HiEng("seungwook");
		String greeting2 = hiMsgKor.HiKor("승욱");

		System.out.println(greeting1);
		System.out.println(greeting2);

	}
}
