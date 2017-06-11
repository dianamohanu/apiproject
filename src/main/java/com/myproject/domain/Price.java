package com.myproject.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Price {

    @Column
    private Double priceInLei;

    @Column
    private Double priceInEuro;

    @Column
    private Double priceInDollars;

    @Column
    private Double priceInPounds;

    public Double getPriceInLei() {
        return priceInLei;
    }

    public void setPriceInLei(Double priceInLei) {
        this.priceInLei = priceInLei;
    }

    public Double getPriceInEuro() {
        return priceInEuro;
    }

    public void setPriceInEuro(Double priceInEuro) {
        this.priceInEuro = priceInEuro;
    }

    public Double getPriceInDollars() {
        return priceInDollars;
    }

    public void setPriceInDollars(Double priceInDollars) {
        this.priceInDollars = priceInDollars;
    }

    public Double getPriceInPounds() {
        return priceInPounds;
    }

    public void setPriceInPounds(Double priceInPounds) {
        this.priceInPounds = priceInPounds;
    }
}
