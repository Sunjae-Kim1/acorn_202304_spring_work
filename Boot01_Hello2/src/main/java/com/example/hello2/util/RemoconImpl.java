package com.example.hello2.util;

public class RemoconImpl implements Remocon{

	@Override
	public void up() {
		System.out.println("볼륨을 올립니다.");
	}

	@Override
	public void down() {
		System.out.println("볼륨을 내립니다.");
	}
}