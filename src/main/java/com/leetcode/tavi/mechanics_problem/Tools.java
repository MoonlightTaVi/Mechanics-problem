package com.leetcode.tavi.mechanics_problem;

import java.util.Arrays;

/**
 * A set of static methods, used by the other classes in the project
 */
public class Tools {
	
	/**
	 * Returns a middle between two numbers (their order does not matter)
	 * @param a - First Long number
	 * @param b - Second Long number
	 * @return - (a + b) / 2
	 */
	public static long getMiddle(long a, long b) {
		long result = (a + b) / 2;
		return result == a ? b : result;
	}
	
	/**
	 * Simply get the min number from an array
	 * @param intArray - an array of integers
	 * @return - An int, which is less then the others in this array
	 * (except for equal ones)
	 */
	public static int findMin(int[] intArray) {
		return Arrays.stream(intArray).min().getAsInt();
	}
	
	/**
	 * Simply get the max number from an array
	 * @param intArray - an array of integers
	 * @return - An int, which is greater then the others in this array
	 * (except for equal ones)
	 */
	public static int findMax(int[] intArray) {
		return Arrays.stream(intArray).max().getAsInt();
	}
	
	/**
	 * Brute-force (iteration) approach to get the number of cars,
	 * repaired by some mechanics in some time
	 * @param ranks - An array, containing the ranks of these mechanics
	 * @param minutes - The time these mechanics must repair cars
	 * @return - Time (in minutes) it takes them to repair these cars
	 * @see #countParallel(int[] ranks, long minutes)
	 */
	public static int countBasic(int[] ranks, long minutes) {
		int repaired = 0;
		for (int worker : ranks) {
            repaired += Tools.repairedAbs(worker, minutes);
        }
		return repaired;
	}

	/**
	 * Same as {@link #countParallel(int[] ranks, long minutes)}, but returns
	 * an absolute value (i.e. greater than 0). Sometimes JVM bugs and thinks
	 * a sum of square roots may be negative.
	 * @param ranks - An array, containing the ranks of these mechanics
	 * @param minutes - The time these mechanics must repair cars
	 * @return - Time (in minutes) it takes them to repair these cars
	 */
	public static long countParallelAbs(int[] ranks, long minutes) {
		return Math.abs(Arrays.stream(ranks).parallel().mapToLong(r -> (long) r).map(r -> Tools.repairedAbs(r, minutes)).sum());
	}
	
	/**
	 * Same as {@link #repairedCarsCount(long rank, long minutes)}, but returns
	 * an absolute result (i.e. greater than 0) after the calculation.
	 * Sometimes JVM bugs and thinks a square root may be negative.
	 * @param rank - A rank of a mechanic
	 * @param minutes - The time this mechanic must repair cars
	 * @return - The number of cars this mechanic will have repaired by that time
	 */
	public static long repairedAbs(long rank, long minutes) {
		return (long) Math.abs(Math.sqrt(minutes / rank));
	}
	
	/**
	 * A parallel approach to solving the {@link #countBasic(int[] ranks, long minutes)}
	 * (which is faster)
	 * @param ranks - An array, containing the ranks of these mechanics
	 * @param minutes - The time these mechanics must repair cars
	 * @return - Time (in minutes) it takes them to repair these cars
	 */
	public static long countParallel(int[] ranks, long minutes) {
		return Arrays.stream(ranks).parallel().mapToLong(r -> (long) r).map(r -> Tools.repairedCarsCount(r, minutes)).sum();
	}
	
	/**
	 * Calculates the amount of cars, which a mechanic can possibly repair by some time
	 * @param rank - A rank of a mechanic
	 * @param minutes - The time this mechanic must repair cars
	 * @return - The number of cars this mechanic will have repaired by that time
	 */
	public static long repairedCarsCount(long rank, long minutes) {
		return (long) Math.sqrt(minutes / rank);
	}
	
	/**
	 * Same as {@link #countParallel(int[] ranks, long minutes)}
	 * or {@link #countParallelAbs(int[] ranks, long minutes)}, but TRIES to return
	 * an absolute value (i.e. greater than 0). Sometimes JVM bugs and thinks
	 * a sum of square roots may be negative. This method may bug too, but with a lesser chance.
	 * @param ranks - An array, containing the ranks of these mechanics
	 * @param minutes - The time these mechanics must repair cars
	 * @return - Time (in minutes) it takes them to repair these cars
	 */
	public static long countParallelDouble(int[] ranks, long minutes) {
		return Arrays.stream(ranks).parallel().mapToLong(r -> (long) r).map(r -> Tools.repairedDouble(r, minutes)).sum();
	}
	
	/**
	 * Same as {@link #repairedCarsCount(long rank, long minutes)}, but casts to `double`
	 * when calculating (possibly saves from negative results, when working with large amounts
	 * of long numbers)
	 * @param rank - A rank of a mechanic
	 * @param minutes - The time this mechanic must repair cars
	 * @return - The number of cars this mechanic will have repaired by that time
	 */
	public static long repairedDouble(long rank, long minutes) {
		return (long) Math.sqrt((double) minutes / (double) rank);
	}
	
}
