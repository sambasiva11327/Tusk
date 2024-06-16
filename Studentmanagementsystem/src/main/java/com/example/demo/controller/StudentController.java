package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
    @Autowired
	private StudentService studentservice;
	@GetMapping("/students")
    public String ListStudents(Model model) {
    	
    	model.addAttribute("Students",studentservice.getallstudents());
		return "Students";
	}
	@GetMapping("/students/new")
	public String createstudentform(Model model)
	{
		//create student object to hold student form data
		Student student=new Student();
		model.addAttribute("student", student);
		return "create_student";
		
	}
	@PostMapping("/students")
	public String savestudent(@ModelAttribute("student") Student student) {
		studentservice.saveStudent(student);
		return "redirect:/students";
		
	}
	@GetMapping("/student/edit{id}")
	public String editstudent(@PathVariable Long id, Model model) {
		
		model.addAttribute("student", studentservice.getStudentbyId(id));
		return "edit_student";
		
	}
	@PostMapping("/student/{id}")
	public String updatestudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,Model model) {
		Student existingstudent=new Student();
	
		//get student from database by id
		existingstudent.setId(id);
		existingstudent.setFirstname(student.getFirstname());
		existingstudent.setLastname(student.getLastname());
		existingstudent.setEmail(student.getEmail());
		//save update student object
		studentservice.updatestudent(existingstudent);
				return "redirect:/students";
		
	}
	@GetMapping("/student/delete{id}")
	public String deletestudent(@PathVariable Long id) {
		studentservice.deletestudentbyId(id);
		return "redirect:/students";
		
	}
   
}
