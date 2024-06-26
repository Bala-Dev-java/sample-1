package com.application1.userlogin.service;

import java.util.List;

import com.application1.userlogin.dto.userclientdto;
import com.application1.userlogin.dto.userdto;
import com.application1.userlogin.response.LoginMessage;

public interface loginservice 
{
	userclientdto createuser(userdto user);
	
	userclientdto getuserbyid(int userid);
	
	List<userclientdto> getalluser();
	
	userclientdto updateuser(int empid , userdto updatedetails);
	
	public void deleteuser(int id);
	
	LoginMessage loginuser(userdto user);
	
	
	
	

}