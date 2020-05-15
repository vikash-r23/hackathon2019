package com.db.hackathon.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Investments {
    public Investments() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long ideaId;
    private Long investorId;
    private int day;
    private String month;
    private int year;
    private Double amount;

    @Override
    public String toString() {
        return "Investments{" +
                "id=" + id +
                ", ideaId=" + ideaId +
                ", investorId=" + investorId +
                ", day=" + day +
                ", month='" + month + '\'' +
                ", year=" + year +
                ", amount=" + amount +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(Long ideaId) {
        this.ideaId = ideaId;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
