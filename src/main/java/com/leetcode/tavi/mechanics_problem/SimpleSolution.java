package com.leetcode.tavi.mechanics_problem;

public class SimpleSolution extends IProblemSolution {

	public SimpleSolution() {
		
	}
	
	public SimpleSolution(boolean isLogging) {
		this.isLogging = isLogging;
	}

	@Override
	public long solve(int[] ranks, int cars) {
		long minutes = 0;
        int repaired = 0;
        log(ranks.length, "mechanics repair", cars, "cars");
        while (repaired < cars) {
            minutes++;
            repaired = Tools.countBasic(ranks, minutes);
        	log("Repaired", repaired, "cars withing", minutes, "minutes");
        }
        log(minutes, "minutes is enough");
        return minutes;
	}

}
