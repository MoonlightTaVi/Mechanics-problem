package com.leetcode.tavi.mechanics_problem;

import java.util.Arrays;

public class Tools {
	
	public static long getMiddle(long a, long b) {
		long result = (a + b) / 2;
		return result == a ? b : result;
	}
	
	public static int findMin(int[] intArray) {
		return Arrays.stream(intArray).min().getAsInt();
	}
	
	public static int findMax(int[] intArray) {
		return Arrays.stream(intArray).max().getAsInt();
	}
	
	public static int countBasic(int[] ranks, long minutes) {
		int repaired = 0;
		for (int worker : ranks) {
            repaired += Tools.efficiency(worker, minutes);
        }
		return repaired;
	}
	
	public static long countParallel(int[] ranks, long minutes) {
		return Math.abs(Arrays.stream(ranks).parallel().mapToLong(r -> (long) r).map(r -> Tools.efficiency(r, minutes)).sum());
	}
	
	private static long efficiency(long rank, long minutes) {
		return (long) Math.abs(Math.sqrt(minutes / rank));
	}
	
}
