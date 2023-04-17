package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.repository.RatetableStorage;
import com.nhnacademy.edu.springframework.repository.WaterBill;

import java.util.List;

public interface WatersupplyFeeService {
    List<WaterBill> getTotalBill(RatetableStorage storage, long usage) ;
}
