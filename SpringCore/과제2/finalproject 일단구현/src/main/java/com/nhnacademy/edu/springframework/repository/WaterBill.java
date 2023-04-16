package com.nhnacademy.edu.springframework.repository;

import java.util.Collection;

public class WaterBill {
    private String city;
    private String sector;
    private long unitPrice;
    private long billTotal;

    public WaterBill(String city, String sector, long unitPrice) {
        this.city = city;
        this.sector = sector;
        this.unitPrice = unitPrice;
    }

    public void setBill(long billTotal) { this.billTotal = billTotal;}

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public long getBillTotal() {
        return billTotal;
    }
    //    public Collection<WaterBill> findAll() {
//        return ;
//    }

    @Override
    public String toString() {
        return "WaterBill{city='"+city+'\''+
                ", sector='"+sector +
                "', unitPrice="+unitPrice +
                ", billTotal="+billTotal +
                "}" +'\n';
    }
}
