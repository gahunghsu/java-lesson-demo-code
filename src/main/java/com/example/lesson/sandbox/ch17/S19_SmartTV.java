package com.example.lesson.sandbox.ch17;

interface SmartDevice {
	void turnOn();

	void turnOff();

	default void pair() {
		System.out.println("配對中...");
	}

	static void checkNetwork() {
		System.out.println("檢查網路連線正常");
	}
}

interface VoiceControl {
	void voiceCommand(String command);
}

class SmartTV implements SmartDevice, VoiceControl {
	@Override
	public void turnOn() {
		System.out.println("SmartTV 開機");
	}

	@Override
	public void turnOff() {
		System.out.println("SmartTV 關機");
	}

	@Override
	public void voiceCommand(String command) {
		System.out.println("SmartTV 收到語音指令: " + command);
	}

	@Override
	public void pair() {
		System.out.println("電視配對中，請輸入 PIN 碼");
	}
}

public class S19_SmartTV {
	public static void main(String[] args) {
		SmartDevice.checkNetwork();
		SmartTV tv = new SmartTV();
		tv.pair();
		tv.voiceCommand("播放電影");
	}
}
