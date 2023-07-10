package com.example.hello2.util;

public class TvRemocon implements Remocon{

	@Override
	public void up() {
		System.out.println("채널을 올립니다.");
	}

	@Override
	public void down() {
		System.out.println("채널을 내립니다.");
	}
}