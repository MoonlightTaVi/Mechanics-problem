package com.leetcode.tavi.mechanics_problem;

public abstract class IProblemSolution {
	
	public boolean isLogging = false;
	
	public static long getTimeTaken(int rank, int cars) {
		return (long) rank * (long) Math.pow(cars, 2);
	}
	
	public abstract long solve(int[] ranks, int cars);
	
	public void log(Object... text) {
		if (!isLogging) {
			return;
		}
		for (Object word : text) {
			System.out.print(word.toString());
			System.out.print(" ");
		}
		System.out.println();
	}
	
}
