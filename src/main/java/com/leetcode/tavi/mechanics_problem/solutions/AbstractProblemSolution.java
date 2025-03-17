package com.leetcode.tavi.mechanics_problem.solutions;

/**
 * An abstract class, extended by any other solution.
 * Besides the abstract {@link #solve(int[] ranks, int cars)} method,
 * also has a static {@link #getTimeTaken(int rank, int cars)} method,
 * which is used by any implementation, and a predefined protected
 * {@link #log(Object... text)} method for logging.
 * @see SimpleSolution
 * @see BinarySolution
 */
public abstract class AbstractProblemSolution {
	
	public boolean isLogging = false;
	
	/**
	 * Utilizes predefined (specified at LeetCode's task description)
	 * formula for calculating time, which it takes for a mechanic of rank
	 * `rank` to repair `cars` number of cars. <br>
	 * The formula is: `rank * cars * cars`
	 * @param rank - The rank of some mechanic
	 * @param cars - Cars this mechanic must repair alone
	 * @return - Time it takes them to repair these cars alone
	 */
	public static long getTimeTaken(int rank, int cars) {
		return (long) rank * (long) Math.pow(cars, 2);
	}
	
	/**
	 * Returns the minimal time it takes for `ranks.length` mechanics of `ranks[i]` ranks
	 * to repair `cars` number of cars
	 * @param ranks - An `int[]` array of `ranks` of mechanics. A ranks must be above or equal 1
	 * @param cars - `int` number of cars, which must be repaired
	 * @return - Minimal time (in minutes) it will take them to repair all this cars
	 */
	public abstract long solve(int[] ranks, int cars);
	
	/**
	 * Solutions may log their current state into console (which is much handier then the `Debug run`)
	 * if the logging is enabled (disabled by default)
	 * @param text - A series of any kind of Objects, each having a `.toString()` method
	 * (may use primitives as arguments too)
	 */
	protected void log(Object... text) {
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
