package com.leetcode.tavi.mechanics_problem;

public class SimpleSolution extends IProblemSolution {

	public SimpleSolution() {
		
	}
	
	public SimpleSolution(boolean isLogging) {
		this.isLogging = isLogging;
	}

	@Override
	public long solve(int[] ranks, int cars) {
		long minutes = 0; // Start from 0, then instantly increase by 1
        int repaired = 0; // Cars repaired by current "minutes"
        
        log(ranks.length, "mechanics repair", cars, "cars");
        
        while (repaired < cars) { // While haven't repaired enough
        	// Increase minutes by 1
            minutes++;
            // Count, how much cars repaired by "minutes"
            repaired = Tools.countBasic(ranks, minutes);
            
        	log("Repaired", repaired, "cars withing", minutes, "minutes");
        }
        
        // Can't make it faster, proved by brute force
        log(minutes, "minutes is enough");
        
        return minutes;
	}

}
