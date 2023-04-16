package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.repository.BasicRatetableStorage;
import com.nhnacademy.edu.springframework.repository.RatetableStorage;
import com.nhnacademy.edu.springframework.service.BasicResultReport;
import com.nhnacademy.edu.springframework.service.BasicWatersupplyFeeService;
import com.nhnacademy.edu.springframework.service.ResultReport;
import com.nhnacademy.edu.springframework.service.WatersupplyFeeService;

public class BootStrap {
    public static void main(String[] args) {
        RatetableStorage table = new BasicRatetableStorage();
        ResultReport result = new BasicResultReport();

        WatersupplyFeeService service = new BasicWatersupplyFeeService();
        result.report(service.getTotalBill(table, 2000));
    }
}
