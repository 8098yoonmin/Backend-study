package com.nhnacademy.edu.springframework.repository;

import java.util.List;

public interface RatetableStorage {

    //반환형 수정요망
    void csvLoad(DataParser parser);

    List<WaterBill> findPayout(long usage);

}
