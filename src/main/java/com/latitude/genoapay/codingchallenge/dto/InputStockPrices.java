package com.latitude.genoapay.codingchallenge.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class InputStockPrices {
    private String identifier;
    private OffsetDateTime startdate;
    private OffsetDateTime enddate;
    private List<Integer> prices;

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

    @Override
    public String toString() {
        return "InputStockPrices{" +
                "identifier='" + identifier + '\'' +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", prices=" + prices +
                '}';
    }
}
