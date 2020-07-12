package com.example.personaldata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.personaldata.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
