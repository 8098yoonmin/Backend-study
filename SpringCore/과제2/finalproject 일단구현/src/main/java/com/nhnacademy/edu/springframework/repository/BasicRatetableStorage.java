package com.nhnacademy.edu.springframework.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasicRatetableStorage implements RatetableStorage {

    File waterfile = new File("/Users/yoonmin/Desktop/java_backend/backend-study/SpringCore/과제2/finalproject/src/main/resources/Tariff_20220331.csv");
    List<WaterBill> waterBills = new ArrayList<>();
    //DataParser 연관관계
    @Override
    public void csvLoad(DataParser parseData) {

        List<String[]> list = parseData.parser(waterfile);

//        순번 , 지자체명 , 업종 , 단계 , 구간시작(세제곱미터)  , 구간끝(세제곱미터)  , 구간금액(원)  , 단계별 기본요금(원)

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

    @Override
    public List<WaterBill> findPayout(long usage) {

        for(int i=0; i<waterBills.size(); i++){
            long unit =  waterBills.get(i).getUnitPrice();
            waterBills.get(i).setBill(usage * unit);
        }

//        가장 저렴한 가격(billTotal)을 가진 항목을 5개만 가격 오름차순으로 표시
        return waterBills.stream()
                .sorted((s1,s2) -> Long.compare(s1.getUnitPrice(), s2.getUnitPrice()))
                .limit(5)
                .collect(Collectors.toList());

    }


}
