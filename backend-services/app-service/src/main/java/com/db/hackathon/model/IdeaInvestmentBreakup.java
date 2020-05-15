package com.db.hackathon.model;

import javax.persistence.*;

@Entity
public class IdeaInvestmentBreakup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long ideaId;
    private Long marketingFund;
    private Long manufacturingFund;
    private Long suppliesFund;
    private Long payoutFund;

    public IdeaInvestmentBreakup() {
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

    public Long getMarketingFund() {
        return marketingFund;
    }

    public void setMarketingFund(Long marketingFund) {
        this.marketingFund = marketingFund;
    }

    public Long getManufacturingFund() {
        return manufacturingFund;
    }

    public void setManufacturingFund(Long manufacturingFund) {
        this.manufacturingFund = manufacturingFund;
    }

    public Long getSuppliesFund() {
        return suppliesFund;
    }

    public void setSuppliesFund(Long suppliesFund) {
        this.suppliesFund = suppliesFund;
    }

    public Long getPayoutFund() {
        return payoutFund;
    }

    public void setPayoutFund(Long payoutFund) {
        this.payoutFund = payoutFund;
    }




}
