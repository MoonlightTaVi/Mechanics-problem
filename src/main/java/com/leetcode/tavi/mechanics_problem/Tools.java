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
            repaired += Tools.repairedAbs(worker, minutes);
        }
		return repaired;
	}
	
	public static long countParallelAbs(int[] ranks, long minutes) {
		return Math.abs(Arrays.stream(ranks).parallel().mapToLong(r -> (long) r).map(r -> Tools.repairedAbs(r, minutes)).sum());
	}
	
	public static long repairedAbs(long rank, long minutes) {
		return (long) Math.abs(Math.sqrt(minutes / rank));
	}
	
	public static long countParallel(int[] ranks, long minutes) {
		return Arrays.stream(ranks).parallel().mapToLong(r -> (long) r).map(r -> Tools.repairedCarsCount(r, minutes)).sum();
	}
	
	public static long repairedCarsCount(long rank, long minutes) {
		return (long) Math.sqrt(minutes / rank);
	}
	
	public static long countParallelDouble(int[] ranks, long minutes) {
		return Arrays.stream(ranks).parallel().mapToLong(r -> (long) r).map(r -> Tools.repairedDouble(r, minutes)).sum();
	}
	
	public static long repairedDouble(long rank, long minutes) {
		return (long) Math.sqrt((double) minutes / (double) rank);
	}
	
}
