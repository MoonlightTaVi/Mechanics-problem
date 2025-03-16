package com.leetcode.tavi.mechanics_problem;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinaryTests {

	@Test
	@DisplayName("Case with [4,2,3,1] ranks and 10 cars")
	public void firstCase() {
		int[] ranks = new int[] {4,2,3,1};
		int cars = 10;
		
		long surelyValid = new SimpleSolution().solve(ranks, cars);
		long questionable = new BinarySolution().solve(ranks, cars);
		
		Assertions.assertEquals(surelyValid, questionable);
	}

	@Test
	@DisplayName("Case with [5,1,8] ranks and 6 cars")
	public void secondCase() {
		int[] ranks = new int[] {5,1,8};
		int cars = 6;
		
		long surelyValid = new SimpleSolution().solve(ranks, cars);
		long questionable = new BinarySolution().solve(ranks, cars);
		
		Assertions.assertEquals(surelyValid, questionable);
	}
	
	@Test
	@DisplayName("Case with 20 random ranks and random number (from 1 to 50) cars")
	public void randomCase() {
		Random random = new Random();
		int[] ranks = random.ints(20, 1, 10).toArray();
		int cars = random.nextInt(1, 50);
		System.out.printf("Current conditions:%nRanks: %s%nCars: %d", Arrays.toString(ranks), cars);
		long a = new SimpleSolution().solve(ranks, cars);
		long b = new BinarySolution().solve(ranks, cars);
		
		Assertions.assertEquals(a, b);
	}
	
}
