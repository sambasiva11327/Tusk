package com.ss.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.springboot.Entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
