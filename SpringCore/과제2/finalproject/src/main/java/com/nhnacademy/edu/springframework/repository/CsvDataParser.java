package com.nhnacademy.edu.springframework.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvDataParser implements DataParser {

    //파일위치
//    File waterfile = new File("/Users/yoonmin/Desktop/java_backend/backend-study/SpringCore/과제2/finalproject/src/main/resources/Tariff_20220331.csv");

    List<String[]> list = new ArrayList<>();

    //일단 데이터 파싱 역할만...
    @Override
    public List<String[]> parser(File file) {
//        String[] values;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                list.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
