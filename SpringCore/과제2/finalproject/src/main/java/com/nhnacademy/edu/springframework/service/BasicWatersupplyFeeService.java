package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.repository.CsvDataParser;
import com.nhnacademy.edu.springframework.repository.DataParser;
import com.nhnacademy.edu.springframework.repository.RatetableStorage;
import com.nhnacademy.edu.springframework.repository.WaterBill;

import javax.xml.crypto.Data;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BasicWatersupplyFeeService implements WatersupplyFeeService{
    DataParser parser = new CsvDataParser();

    @Override
    public List<WaterBill> getTotalBill(RatetableStorage storage, long usage) {
        storage.csvLoad(parser);
        return storage.findPayout(usage);
    }

}
