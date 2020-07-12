package com.example.personaldata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.personaldata.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
