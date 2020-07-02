package com.wepower.demo.model.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class SerachHistroy {

    @Id
    @GeneratedValue
    private Long id;

    private String startDate;

    private String endDate;

    private String productBasePrice;

    private String summaryPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getProductBasePrice() {
        return productBasePrice;
    }

    public void setProductBasePrice(String productBasePrice) {
        this.productBasePrice = productBasePrice;
    }

    public String getSummaryPrice() {
        return summaryPrice;
    }

    public void setSummaryPrice(String summaryPrice) {
        this.summaryPrice = summaryPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
