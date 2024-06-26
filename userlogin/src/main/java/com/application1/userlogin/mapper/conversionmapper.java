package com.application1.userlogin.mapper;

import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.application1.userlogin.dto.userclientdto;
import com.application1.userlogin.dto.userdto;
import com.application1.userlogin.entity.userdetails;

public class conversionmapper {
	
	


	public static userdto maptouserdto(userdetails users)
	{
		userdto dto =new userdto();
		dto.setId(users.getId());
		dto.setName(users.getName());
		dto.setEmail(users.getEmail());
		
		
		return dto;
		
		
	}
	

	public static userclientdto maptouserdtocli(userdetails users)
	{
		userclientdto dtocli =new userclientdto();
		dtocli.setId(users.getId());
		dtocli.setName(users.getName());
		dtocli.setEmail(users.getEmail());
		
		
		return dtocli;
		
		
	}
	

	public static userdetails maptouserentity(userdto usrdto)
	{
		userdetails usrdet =new userdetails();
		usrdet.setId(usrdto.getId());
		usrdet.setName(usrdto.getName());
		usrdet.setEmail(usrdto.getEmail());
		usrdet.setPassword(usrdto.getPassword());
		
		
		
		return usrdet;
		
		
	}
	
}
