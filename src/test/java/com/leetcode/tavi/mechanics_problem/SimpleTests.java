package com.leetcode.tavi.mechanics_problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.leetcode.tavi.mechanics_problem.solutions.AbstractProblemSolution;
import com.leetcode.tavi.mechanics_problem.solutions.SimpleSolution;

public class SimpleTests {
	
	@Test
	@DisplayName("Case with [4,2,3,1] ranks and 10 cars")
	public void firstCase() {
		AbstractProblemSolution solution = new SimpleSolution();
		double result = solution.solve(new int[] {4,2,3,1}, 10);
		Assertions.assertEquals(16, result);
	}
	
	@Test
	@DisplayName("Case with [5,1,8] ranks and 6 cars")
	public void secondCase() {
		AbstractProblemSolution solution = new SimpleSolution();
		double result = solution.solve(new int[] {5,1,8}, 6);
		Assertions.assertEquals(16, result);
	}
	
}
