package com.latitude.genoapay.codingchallenge;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;

import static com.latitude.genoapay.codingchallenge.service.MaxProfitCalculator.getMaxProfit;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CodingChallengeApplicationTests {
	/**
	 * This is the example from the description. Checks if the solution returns 6 (buy at $5 sell at $11).
	 */
	@Test
	public void exampleFromDescription() {
		int[] stockPrices = {10, 7, 5, 8, 11, 9};
		assertEquals(6, getMaxProfit(stockPrices));
	}


	@Test
	public void buyBeforeSell() {
		int[] stockPrices = {105, 7, 5, 8, 11, 9};
		assertEquals(6, getMaxProfit(stockPrices));
	}

	@Test
	public void sellAfterBuy() {
		int[] stockPrices = {10, 7, 5, 8, 11, 1};
		assertEquals(6, getMaxProfit(stockPrices));
	}

	@Test(expected = IllegalArgumentException.class)
	public void noBuyAndSellInSameTime() {
		int[] stockPrices = {1};
		getMaxProfit(stockPrices);
	}

	@Test
	public void twoElements() {
		int[] stockPrices = {1, 21};
		assertEquals(20, getMaxProfit(stockPrices));
	}

	@Test
	public void handleConstantPrices() {
		int[] stockPrices = {2, 2, 2, 2, 2, 2, 2};
		assertEquals(0, getMaxProfit(stockPrices));
	}

	@Test(expected = IllegalArgumentException.class)
	public void priceCannotBeNegative() {
		int[] stockPrices = {1, 2, 3, -4};
		getMaxProfit(stockPrices);
	}

	@Test(expected = IllegalArgumentException.class)
	public void priceCannotBeZero() {
		int[] stockPrices = {1, 2, 3, 0};
		getMaxProfit(stockPrices);
	}
}
