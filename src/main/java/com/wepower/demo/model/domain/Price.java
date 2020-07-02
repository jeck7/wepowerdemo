package com.wepower.demo.model.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "quarter")
    private String quarter;

    @Column(name = "energyprice")
    private String energyPrice;

    @Column(name = "lgsprice")
    private String LGSPrice;

    @JsonManagedReference
    @OneToMany(mappedBy = "price")
    private Set<CustomerType> customerTypes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getEnergyPrice() {
        return energyPrice;
    }

    public void setEnergyPrice(String energyPrice) {
        this.energyPrice = energyPrice;
    }

    public String getLGSPrice() {
        return LGSPrice;
    }

    public void setLGSPrice(String LGSPrice) {
        this.LGSPrice = LGSPrice;
    }

    public Set<CustomerType> getCustomerTypes() {
        return customerTypes;
    }

    public void setCustomerTypes(Set<CustomerType> customerTypes) {
        this.customerTypes = customerTypes;
    }
}
