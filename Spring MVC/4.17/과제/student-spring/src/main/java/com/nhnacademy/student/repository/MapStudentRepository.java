package com.nhnacademy.student.repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MapStudentRepository implements StudentRepository{
    private Map<String, Student> studentsMap = new ConcurrentHashMap<>();
    List<Object> list = new ArrayList<>();
    @Override
    public void save(Student student) {
        studentsMap.put(student.getId(),student);
    }

    @Override
    public void update(Student student) {
        studentsMap.put(student.getId(),student);
    }

    @Override
    public void deleteById(String id) {
        studentsMap.remove(id);
    }

    @Override
    public Student getStudentById(String id) {
        return studentsMap.get(id);
    }

    @Override
    public List<Object> getStudents() {
//        for (Entry<String, Student> entrySet : studentsMap.entrySet()) {
//            list.add(entrySet.getValue());
//        }
//        return list;
        return studentsMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean existById(String id) {
        if(Objects.isNull(studentsMap.get(id))){
            return false;
        }
        else return true;
    }
}
