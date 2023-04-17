package com.nhnacademy.edu.springframework.repository;

import com.nhnacademy.edu.springframework.annotation.Timer;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BasicRatetableStorage implements RatetableStorage {

    File waterfile = new File("/Users/yoonmin/Desktop/java_backend/backend-study/SpringCore/과제2/finalproject_${김윤민}/src/main/resources/Tariff_20220331.csv");
    List<WaterBill> waterBills = new ArrayList<>();

    @Timer
    @Override
    public void csvLoad(DataParser parseData) {

        List<String[]> list = parseData.parser(waterfile);

        for (String[] values : list) {
            String city = values[1];
            String sector = values[2];
            long unitPrice = Integer.parseInt(values[6]);

            //중복제거
            boolean isDuplicate = false;
            for (WaterBill waterBill : waterBills) {
                if (waterBill.getCity().equals(city) && waterBill.getSector().equals(sector)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                waterBills.add(new WaterBill(city, sector, unitPrice));


            }
        }
    }

    @Timer
    @Override
    public List<WaterBill> findPayout(long usage) {

        for(int i=0; i<waterBills.size(); i++){
            long unit =  waterBills.get(i).getUnitPrice();
            waterBills.get(i).setBill(usage * unit);
        }

        return waterBills.stream()
                .sorted((s1,s2) -> Long.compare(s1.getUnitPrice(), s2.getUnitPrice()))
                .limit(5)
                .collect(Collectors.toList());

    }


}
