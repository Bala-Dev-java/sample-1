package com.application1.userlogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application1.userlogin.dto.userclientdto;
import com.application1.userlogin.dto.userdto;
import com.application1.userlogin.entity.userdetails;
import com.application1.userlogin.response.LoginMessage;
import com.application1.userlogin.service.loginservice;
import com.application1.userlogin.service.impl.loginimplementation;

@RestController
public class Logincontroller {
	
	
	@Autowired
	private loginimplementation service;
	
	
	
	@RequestMapping("/createuser")
	public ResponseEntity<userclientdto> create(@RequestBody userdto user)
	{
		userclientdto saveduser = service.createuser(user);
		return new ResponseEntity<>(saveduser, HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping("/getuserbyid/{user}")
	public ResponseEntity<userclientdto> create(@PathVariable("user") int user)
	{
		userclientdto founduser = service.getuserbyid(user);
		return ResponseEntity.ok(founduser);
		
		
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/getallusers")
	public ResponseEntity<List<userclientdto>> allusers()
	{
		List<userclientdto> allusers = service.getalluser();
		return ResponseEntity.ok(allusers);
	}
	
	@RequestMapping("/updateuser/{id}")
	public ResponseEntity<userclientdto> update(@PathVariable("id") int id, @RequestBody userdto updateuserdetails)
	{
			userclientdto allusers = service.updateuser(id, updateuserdetails);
		return ResponseEntity.ok(allusers);
	}
	
	
	@RequestMapping("/deleteuser/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id)
	{
			service.deleteuser(id);
		return ResponseEntity.ok("Deleted Successfully");
	}
	
	@RequestMapping("/loginuser")
	public ResponseEntity<?> uservalidation(@RequestBody userdto user)
	{
			LoginMessage loginmessage = service.loginuser(user);
			
			return ResponseEntity.ok(loginmessage);
		
	}
			
	
	
	
	
	
	

}
