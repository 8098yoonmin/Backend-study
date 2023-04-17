package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.repository.BasicRatetableStorage;
import com.nhnacademy.edu.springframework.repository.RatetableStorage;
import com.nhnacademy.edu.springframework.service.BasicResultReport;
import com.nhnacademy.edu.springframework.service.BasicWatersupplyFeeService;
import com.nhnacademy.edu.springframework.service.ResultReport;
import com.nhnacademy.edu.springframework.service.WatersupplyFeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BootStrap {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework.config");

        RatetableStorage table = context.getBean("basicRatetableStorage", BasicRatetableStorage.class);
        ResultReport result = context.getBean("basicResultReport", BasicResultReport.class);

        WatersupplyFeeService service = context.getBean("basicWatersupplyFeeService", BasicWatersupplyFeeService.class);
        result.report(service.getTotalBill(table, 2000));

    }
}
