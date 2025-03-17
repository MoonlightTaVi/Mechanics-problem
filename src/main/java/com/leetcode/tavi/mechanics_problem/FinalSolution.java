package com.leetcode.tavi.mechanics_problem;

import java.util.Arrays;

public class FinalSolution {
    public long repairCars(int[] ranks, int cars) {
    	int worstRank = Arrays.stream(ranks).max().getAsInt();
    	long maxTime = worstRank * (long) Math.pow(cars, 2);
    	long minTime = 0;
    	long time = maxTime / 2;
    	while ((maxTime - minTime) > 1) {
    		final long minutes = time;
    		int repaired = Math.abs(Arrays.stream(ranks).parallel().map(r -> (int) Math.sqrt(minutes / r)).sum());
    		if (repaired >= cars) {
    			maxTime = time;
    			time = (minTime + time) / 2;
    			continue;
    		}
    		if (repaired < cars) {
    			minTime = time;
    			time = (minTime + maxTime) / 2;
    		}
    	}
    	return maxTime;
    }
}