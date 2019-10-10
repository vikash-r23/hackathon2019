package com.db.hackathon.model;

public class MonthBreakDownData {
    private String month;
    private String year;
    private Double amount;

    public MonthBreakDownData() {
    }

    public MonthBreakDownData(String month, String year, Double amount) {
        this.month = month;
        this.year = year;
        this.amount = amount;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
