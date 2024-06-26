package com.application1.userlogin.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application1.userlogin.entity.userdetails;



@Repository
public interface loginrepo extends JpaRepository<userdetails, Integer> {
	
//	@Query("select password from userdetails where email = :peru")
//	String findByEmail(@Param("peru") String email);
	
	Optional<userdetails> findOneByEmailAndPassword(String email, String password);
	
	userdetails findByEmail(String email);
	
	

}
