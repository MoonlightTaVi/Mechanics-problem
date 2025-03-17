package com.leetcode.tavi.mechanics_problem.solutions;

import com.leetcode.tavi.mechanics_problem.Tools;

/**
 * Utilizes a straight-forward, brute-force solution of the problem.
 * It always returns a valid result (so it can be used to assert the results of other
 * solutions), but it is very slow (about 3000 times slower than binary)
 * @see AbstractProblemSolution
 * @see BinarySolution
 */
public class SimpleSolution extends AbstractProblemSolution {

	/**
	 * Default constructor; logging is disabled
	 */
	public SimpleSolution() {
		
	}
	
	/**
	 * Initializes a SimpleSolution instance with possibility to
	 * turn on the logging into the console
	 * @param isLogging - Whether log into console or not
	 * (it is actually simpler than usual `Debug run` in this case)
	 */
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
