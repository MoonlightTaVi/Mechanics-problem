package com.leetcode.tavi.mechanics_problem;

public class BinarySolution extends IProblemSolution {
	
	public BinarySolution() {
		
	}
	
	public BinarySolution(boolean isLogging) {
		this.isLogging = isLogging;
	}

	@Override
	public long solve(int[] ranks, int cars) {
		
		log(ranks.length, "mechanics repair", cars, "cars");
		
		// Can't make it slower, then the worst of them alone
		int worstRank = Tools.findMax(ranks);
		long maxTime = IProblemSolution.getTimeTaken(worstRank, cars);
		
		// Default to 0, being very optimistic (actually, they will truly
		// repair 0 cars in 0 minutes)
		long minTime = 0;
		
		// Start from middle
		long time = (long) Tools.getMiddle(minTime, maxTime);
		
		long repaired = 0;
		
		/* 
		 * Do while:
		 * - Haven't repaired the enough amount of cars OR
		 * - There is still a pretty large gap between minimal and maximal possible time taken
		*/
		log("Starting boundaries:", minTime, ",", maxTime);
		while (repaired < cars || (maxTime - minTime) > 1) {
			if (isLogging) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					log("Interrupted");
					System.exit(0);
				}
			}
			
			// Cars repaired by this time
			repaired = Tools.countParallel(ranks, time);
			
			log("Repaired", repaired, "cars withing", time, "minutes");
			
			// Repaired enough or even more
			if (repaired >= cars) {
				log(">>> Repaired more than needed");
				maxTime = time; // The result surely equals or is less than that
				
				time = (long) Tools.getMiddle(minTime, time);
			} else { // Not enough cars
				log(">>> Repaired not enough");
				minTime = time; // This time is surely not enough, make it the lowest limit
				
				time = (long) Tools.getMiddle(minTime, maxTime);
			}
			log("New boundaries:", minTime, ",", maxTime);
		}
		
		log(maxTime, "minutes is enough");
		
		return maxTime; // Mechanics can't possibly make it faster
	}

}
