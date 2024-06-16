package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class StudentmanagementsystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentmanagementsystemApplication.class, args);
	}
@Autowired
private StudentRepository studentrepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Student student1=new Student("samba","mooraboina","ssmb027@gmail.com");
		studentrepo.save(student1);
		Student student2=new Student("rajesh","palepogu","rajesh@gmail.com");
		studentrepo.save(student2);
		Student student3=new Student("suresh","pagidipalli","suresh027@gmail.com");
		studentrepo.save(student3);*/
		
	}

}
