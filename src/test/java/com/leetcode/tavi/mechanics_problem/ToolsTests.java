package com.leetcode.tavi.mechanics_problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ToolsTests {
	
	@Test
	@DisplayName("Middle between 50 and 100 is 75")
	public void findMiddleBetween50x100() {
		double result = Tools.getMiddle(50, 100);
		Assertions.assertEquals(75, result);
	}
	
	@Test
	@DisplayName("Middle between 300 and 400 is 350")
	public void findMiddleBetween300x400() {
		double result = Tools.getMiddle(300, 400);
		Assertions.assertEquals(350, result);
	}
	
	@Test
	@DisplayName("Middle between 5 and 10 is 7, not 7.5")
	public void findMiddleAndCast() {
		int result = (int) Tools.getMiddle(5, 10);
		Assertions.assertEquals(7, result);
	}
	
	@Test
	@DisplayName("From [4,2,3,1] max is 4")
	public void maximalNumberTest() {
		int[] numbers = new int[] {4,2,3,1};
		int result = Tools.findMax(numbers);
		Assertions.assertEquals(4, result);
	}
	
	@Test
	@DisplayName("Parallel computation is the same as with a single thread")
	public void parallelIsValid() {
		int[] ranks = new int[] {4,2,3,1};
		long minutes = 16;
		int surelyValid = Tools.countBasic(ranks, minutes);
		long questionable = Tools.countParallelAbs(ranks, minutes);
		Assertions.assertEquals(surelyValid, questionable);
	}
	
}
