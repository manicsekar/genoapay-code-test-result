package com.latitude.genoapay.codingchallenge.service;

import com.latitude.genoapay.codingchallenge.dto.InputStockPrices;
import com.latitude.genoapay.codingchallenge.dto.OutputMaxStockProfit;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

public class MaxProfitCalculator {
    /**
     * Takes an array of stock prices and returns the best profit could have been made from 1 purchase and 1 sale of 1
     * stock.
     *
     * @param inputstockPrices array of stock prices
     * @return the best profit
     */
    public static OutputMaxStockProfit getMaxProfit(InputStockPrices inputstockPrices) {
        List<Integer> stockPrices = inputstockPrices.getPrices();
        int[] stockPriceArr = stockPrices.stream().mapToInt(Integer::intValue).toArray();
        validateSeries(stockPriceArr);
        OutputMaxStockProfit maxStockProfit = new OutputMaxStockProfit();

        int minPrice = Integer.MAX_VALUE;
        int minIndex = 0;
        int maxPrice = 0;
        int maxIndex = Integer.MAX_VALUE;

        for (int i = 0; i < stockPriceArr.length; i++) {
            int currentPrice = stockPriceArr[i];
            validatePrice(currentPrice);

            if (currentPrice < minPrice && i < maxIndex) {
                minPrice = currentPrice;
                minIndex = i;
            }
            if (currentPrice > maxPrice && i > minIndex) {
                maxPrice = currentPrice;
                maxIndex = i;
            }
        }

        maxStockProfit.setIdentifier(inputstockPrices.getIdentifier());
        maxStockProfit.setStartdate(inputstockPrices.getStartdate());
        maxStockProfit.setEnddate(inputstockPrices.getEnddate());
        maxStockProfit.setProcessedDate(OffsetDateTime.now());
        maxStockProfit.setPrices(inputstockPrices.getPrices());
        maxStockProfit.setBuy(minPrice);
        maxStockProfit.setSell(maxPrice);
        maxStockProfit.setProfit(maxPrice - minPrice);

        return maxStockProfit;
    }

    public static int getMaxProfit(int[] stockPrices) {
       int[] buySell = calcBuySell(stockPrices);
       return buySell[1] - buySell[0];

    }

    private static void validatePrice(int currentPrice) throws IllegalArgumentException {
        if (currentPrice < 1) {
            throw new IllegalArgumentException("Only positive prices are supported");
        }
    }

    private static void validateSeries(int[] stockPrices) throws IllegalArgumentException {
        if (stockPrices.length < 2) {
            throw new IllegalArgumentException("Minimum two elements are needed");
        }
    }

    private static int[] calcBuySell(int[] stockPrices){
        validateSeries(stockPrices);

        int minPrice = Integer.MAX_VALUE;
        int minIndex = 0;
        int maxPrice = 0;
        int maxIndex = Integer.MAX_VALUE;

        for (int i = 0; i < stockPrices.length; i++) {
            int currentPrice = stockPrices[i];
            validatePrice(currentPrice);

            if (currentPrice < minPrice && i < maxIndex) {
                minPrice = currentPrice;
                minIndex = i;
            }
            if (currentPrice > maxPrice && i > minIndex) {
                maxPrice = currentPrice;
                maxIndex = i;
            }
        }
        return new int[]{minPrice, maxPrice};
    }

}