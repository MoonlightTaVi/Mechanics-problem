package com.leetcode.tavi.mechanics_problem;

/**
 * A Thread, which simply sleeps some time before
 * finishing
 */
public class TimeoutThread extends Thread {
	
	private final long timeout;
	
	/**
	 * Initializes a Thread, which sleeps for some time.
	 * Used to check if some time has passed after the start of another Thread.
	 * @param timeout - Time (in milliseconds) to sleep
	 */
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
			System.err.println("TimeoutThread has been interrupted");
		}
	}
	
}