package com.nhnacademy.edu.springframework.repository;

import java.io.File;
import java.util.List;

public interface DataParser {

    List<String[]> parser(File file);
}
