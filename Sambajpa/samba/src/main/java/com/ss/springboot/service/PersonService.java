package com.ss.springboot.service;

import java.util.List;
import java.util.Optional;

import com.ss.springboot.Entity.Person;

public interface PersonService {
   public Person saveperson(Person person) ;
   public List findall(Person person);
   public   Person getpersonById(Long Id);
   public Person updatePerson(Person person,long id);
   void deletebyperson(long id);
	   
   
}
