package com.ss.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.springboot.Entity.Person;
import com.ss.springboot.Exception.ResourceNotFoundException;
import com.ss.springboot.Repository.PersonRepository;
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
	private PersonRepository personrepo;
	
	@Override
	public Person saveperson(Person person) {
		// TODO Auto-generated method stub
		return personrepo.save(person);
	}

	@Override
	public List findall(Person person) {
		// TODO Auto-generated method stub
		return personrepo.findAll();
	}

	@Override
	public   Person getpersonById(Long Id) {
		
		// TODO Auto-generated method stub
		     
		return personrepo.findById(Id).orElseThrow(()-> 
		new ResourceNotFoundException("Person", "Id", Id));
	
		  
	}

	@Override
	public Person updatePerson(Person person, long id) {
		// TODO Auto-generated method stub
		//we need to check whether employee id with given id is exist i DB or not
		Person existingperson= personrepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Person", "Id", id));
		existingperson.setEname(person.getEname());
		existingperson.setsurname(person.getsurname());
		existingperson.setemail(person.getemail());
		 return existingperson;
	}

	@Override
	public void deletebyperson( long id) {
		// TODO Auto-generated method stub
	personrepo.findById(id).orElseThrow(()-> 
	new ResourceNotFoundException("Person", "Id", id));
	personrepo.deleteById(id);

}}
