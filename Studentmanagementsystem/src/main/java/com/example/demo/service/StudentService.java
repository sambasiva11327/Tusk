package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
  List<Student> getallstudents();
  Student saveStudent(Student student);
  Student getStudentbyId( Long id);
  Student updatestudent(Student student );
  void deletestudentbyId(Long id);
}
