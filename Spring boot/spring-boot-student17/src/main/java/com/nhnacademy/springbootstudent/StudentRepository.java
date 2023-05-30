package com.nhnacademy.springbootstudent;

import java.util.List;

public interface StudentRepository extends JpaRepsoitry {

    List<Student> findAll();
}
