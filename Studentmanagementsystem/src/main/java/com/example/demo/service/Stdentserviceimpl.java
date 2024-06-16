package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
@Service
public class Stdentserviceimpl implements StudentService {
    @Autowired
	private StudentRepository studentrepo;
	
	@Override
	public List<Student> getallstudents() {
		// TODO Auto-generated method stub
		
		return studentrepo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentrepo.save(student);
	}

	@Override
	public Student getStudentbyId(Long id) {
		// TODO Auto-generated method stub
		
		return studentrepo.findById(id).get();
	}

	@Override
	public Student updatestudent(Student student) {
		// TODO Auto-generated method stub
		return studentrepo.save(student);
	}

	@Override
	public void deletestudentbyId(Long id) {
		// TODO Auto-generated method stub
		studentrepo.deleteById(id);
		
	}

}
