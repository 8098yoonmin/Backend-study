package com.nhnacademy.edu.springframework.repository;

import com.nhnacademy.edu.springframework.annotation.Timer;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvDataParser implements DataParser {


    List<String[]> list = new ArrayList<>();

    @Timer
    @Override
    public List<String[]> parser(File file) {

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
