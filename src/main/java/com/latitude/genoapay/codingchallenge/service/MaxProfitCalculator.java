package com.latitude.genoapay.codingchallenge.service;

import com.latitude.genoapay.codingchallenge.dto.InputStockPrices;
import com.latitude.genoapay.codingchallenge.dto.OutputMaxStockProfit;

import java.time.OffsetDateTime;
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

        int [] buySell = calcBuySell(stockPriceArr);
        Integer buyPrice = buySell[0];
        Integer sellPrice = buySell[1];

        maxStockProfit.setIdentifier(inputstockPrices.getIdentifier());
        maxStockProfit.setStartdate(inputstockPrices.getStartdate());
        maxStockProfit.setEnddate(inputstockPrices.getEnddate());
        maxStockProfit.setProcessedDate(OffsetDateTime.now());
        maxStockProfit.setPrices(inputstockPrices.getPrices());
        maxStockProfit.setBuy(buyPrice);
        maxStockProfit.setSell(sellPrice);
        maxStockProfit.setProfit(sellPrice - buyPrice);

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

        int buyPrice = Integer.MAX_VALUE;
        int minIndex = 0;
        int sellPrice = 0;
        int maxIndex = Integer.MAX_VALUE;

        for (int i = 0; i < stockPrices.length; i++) {
            int currentPrice = stockPrices[i];
            validatePrice(currentPrice);

            if (currentPrice < buyPrice && i < maxIndex) {
                buyPrice = currentPrice;
                minIndex = i;
            }
            if (currentPrice > sellPrice && i > minIndex) {
                sellPrice = currentPrice;
                maxIndex = i;
            }
        }
        return new int[]{buyPrice, sellPrice};
    }

}