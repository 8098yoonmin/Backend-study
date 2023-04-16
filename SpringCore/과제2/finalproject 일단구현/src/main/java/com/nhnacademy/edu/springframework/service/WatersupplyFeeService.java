package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.repository.RatetableStorage;
import com.nhnacademy.edu.springframework.repository.WaterBill;

import java.util.List;

public interface WatersupplyFeeService {
    //반환형 수정요망
    List<WaterBill> getTotalBill(RatetableStorage storage, long usage) ;
}
