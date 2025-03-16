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
		long minRepaired = Tools.findMin(ranks);
		System.out.println(minRepaired);
		// Default to 0, being very optimistic (actually, they will truly
		// repair 0 cars in 0 minutes)
		long minTime = 0;
		
		// Start from middle
		long time = (long) Tools.getMiddle(minTime, maxTime);
		
		long lastRepaired = 0;
		
		while (lastRepaired < cars || Math.abs(lastRepaired - cars) > minRepaired && (maxTime - minTime) > 1) {
			if (isLogging) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					log("Interrupted");
					System.exit(0);
				}
			}
			
			log("Current boundaries:", minTime, ",", maxTime);
			
			// Cars repaired by this time
			long repaired = Tools.countParallel(ranks, time);
			lastRepaired = repaired;
			
			/*if (repaired < cars && lastRepaired >= cars) {
				return maxTime;
			}*/
			
			log("Repaired", repaired, "cars withing", time, "minutes");
			
			// Repaired enough or even more
			if (repaired >= cars) {
				log(">>> Repaired more than needed");
				maxTime = time; // The result surely equals or is less than that
				
				time = (long) Tools.getMiddle(minTime, time); // Maybe it's less...
				/*if (time <= minTime) { 	// Repaired "enough" cars, and the next iteration
					log(time, "is less than or equals", minTime);
					break;				// will give us "not enough" cars (because
				}*/						// we know, that "minTime = time"
				continue;				// happens only when "repaired < cars"
			}
			if (repaired < cars) { // Not enough cars
				log(">>> Repaired not enough");
				minTime = time; // This time is surely not enough, make it the lowest limit
				
				time = (long) Tools.getMiddle(minTime, maxTime);
				/*if (time <= minTime) {
					log(time, "is less than or equals", minTime);
					break;
				}*/
			}
		}
		
		log(maxTime, "minutes is enough");
		
		return maxTime; // Mechanics can't possibly make it faster
	}

}
