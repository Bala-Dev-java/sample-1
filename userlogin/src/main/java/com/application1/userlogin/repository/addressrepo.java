package com.application1.userlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application1.userlogin.entity.address;


@Repository
public interface addressrepo extends JpaRepository<address, Integer> {
	
	

}
