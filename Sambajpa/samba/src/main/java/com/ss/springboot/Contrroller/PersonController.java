package com.ss.springboot.Contrroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.springboot.Entity.Person;
import com.ss.springboot.service.PersonService;

@RestController
@RequestMapping("/api/employees")
public class PersonController {
    @Autowired
	private PersonService personservice;
    @PostMapping
    public ResponseEntity<Person> saveperson(@RequestBody Person person)
    {
    	
		return new ResponseEntity<Person>(personservice.saveperson(person),HttpStatus.CREATED);
    	
    }
    @GetMapping
    public List findall(@RequestBody Person person){
		return personservice.findall(person);
   
    }
    @GetMapping("{Id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("Id")Long Id){
    	
		return new ResponseEntity<Person>(personservice.getpersonById(Id),HttpStatus.OK) ;
    	
    }
    @PutMapping("{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") long id
    		                             ,@RequestBody Person person){
		return new ResponseEntity<Person>(personservice.updatePerson(person, id),HttpStatus.OK);

		
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteperson(@PathVariable("id") long id){
    	personservice.deletebyperson(id);
		return new ResponseEntity<String>("Delete person sucessfully",HttpStatus.OK);
    	
    }
}
