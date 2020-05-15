package com.db.hackathon.model;

import java.util.List;
import java.util.Map;

public class PitcherPortfolio {
    private List<MonthBreakDownData> monthBreakDownData;
    private Map<String, Double> investorBreakDownData;

    public PitcherPortfolio() {
    }

    public List<MonthBreakDownData> getMonthBreakDownData() {
        return monthBreakDownData;
    }

    public void setMonthBreakDownData(List<MonthBreakDownData> monthBreakDownData) {
        this.monthBreakDownData = monthBreakDownData;
    }

    public Map<String, Double> getInvestorBreakDownData() {
        return investorBreakDownData;
    }

    public void setInvestorBreakDownData(Map<String, Double> investorBreakDownData) {
        this.investorBreakDownData = investorBreakDownData;
    }
}
