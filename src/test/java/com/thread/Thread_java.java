package com.thread;

public class Thread_java extends Thread{
	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			System.out.println(i);
		}
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		Thread_java th = new Thread_java();
		Thread_java th1 = new Thread_java();
		th.start();
		th1.start();
		//It runs parallel to each other
	}
}
