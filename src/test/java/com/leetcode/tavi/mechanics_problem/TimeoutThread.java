package com.leetcode.tavi.mechanics_problem;

public class TimeoutThread extends Thread {
	
	private final long timeout;
	
	public TimeoutThread(long timeout) {
		super();
		this.timeout = timeout;
	}

	@Override
	public void run() {
		try {
			//System.out.println("Timeout thread sleeping...");
			Thread.sleep(timeout);
			//System.out.println("Timeout thread has woken up");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}