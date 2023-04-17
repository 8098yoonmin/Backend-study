package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.annotation.Timer;
import com.nhnacademy.edu.springframework.repository.CsvDataParser;
import com.nhnacademy.edu.springframework.repository.DataParser;
import com.nhnacademy.edu.springframework.repository.RatetableStorage;
import com.nhnacademy.edu.springframework.repository.WaterBill;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BasicWatersupplyFeeService implements WatersupplyFeeService{
    DataParser parser = new CsvDataParser();

    @Timer
    @Override
    public List<WaterBill> getTotalBill(RatetableStorage storage, long usage) {
        storage.csvLoad(parser);
        return storage.findPayout(usage);
    }

}
