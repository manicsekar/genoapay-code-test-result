package com.latitude.genoapay.codingchallenge.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class OutputMaxStockProfit {
    private String identifier;
    private OffsetDateTime startdate;
    private OffsetDateTime enddate;
    private List<Integer> prices;
    private OffsetDateTime processedDate;
    private Integer buy;
    private Integer sell;
    private Integer profit;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public OffsetDateTime getStartdate() {
        return startdate;
    }

    public void setStartdate(OffsetDateTime startdate) {
        this.startdate = startdate;
    }

    public OffsetDateTime getEnddate() {
        return enddate;
    }

    public void setEnddate(OffsetDateTime enddate) {
        this.enddate = enddate;
    }

    public List<Integer> getPrices() {
        return prices;
    }

    public void setPrices(List<Integer> prices) {
        this.prices = prices;
    }

    public OffsetDateTime getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(OffsetDateTime processedDate) {
        this.processedDate = processedDate;
    }

    public Integer getBuy() {
        return buy;
    }

    public void setBuy(Integer buy) {
        this.buy = buy;
    }

    public Integer getSell() {
        return sell;
    }

    public void setSell(Integer sell) {
        this.sell = sell;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }
}
