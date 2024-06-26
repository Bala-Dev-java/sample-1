package com.application1.userlogin.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import com.application1.userlogin.security.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.application1.userlogin.dto.userclientdto;
import com.application1.userlogin.dto.userdto;
import com.application1.userlogin.entity.userdetails;
import com.application1.userlogin.exception.Resourcenotfound;
import com.application1.userlogin.mapper.conversionmapper;
import com.application1.userlogin.repository.loginrepo;
import com.application1.userlogin.response.LoginMessage;
import com.application1.userlogin.service.loginservice;
import com.application1.userlogin.security.Securityconfig;



@Service
public class loginimplementation implements loginservice {
	
	@Autowired
	private loginrepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public userclientdto createuser(userdto user) {
		
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		userdetails users = conversionmapper.maptouserentity(user);
		
		userdetails saveduser = repo.save(users);
		return conversionmapper.maptouserdtocli(saveduser);
		
		
	}


	@Override
	public userclientdto getuserbyid(int userid) {
		// TODO Auto-generated method stub
		
		userdetails founduser = repo.findById(userid).
				orElseThrow(() -> new Resourcenotfound("User not found in the database"+ userid));
		
		
		return conversionmapper.maptouserdtocli(founduser);
	}


	@Override
	public List<userclientdto> getalluser() {
		
		List<userdetails> alluserdetails = repo.findAll();
		return alluserdetails.stream().map((userdetails)-> conversionmapper.maptouserdtocli(userdetails)).collect(Collectors.toList());
		
		
	}


	@Override
	public userclientdto updateuser(int userid, userdto updatedetails) {
		
		userdetails updateduser = repo.findById(userid).orElseThrow(() -> new Resourcenotfound("user not found"));
		updateduser.setName(updatedetails.getName());
		updateduser.setEmail(updatedetails.getEmail());
		updateduser.setPassword(updatedetails.getPassword());
		
		userdetails updateddb = repo.save(updateduser);
		
		return conversionmapper.maptouserdtocli(updateddb);
	}


	@Override
	public void deleteuser(int id) {
		userdetails deleteduser = repo.findById(id).orElseThrow(() -> new Resourcenotfound("user not found"));
		repo.deleteById(id);
		
		
	}

//	public boolean validateuser(userdto user)
//	{
//		
//		userdetails user1= conversionmapper.maptouserentity(user);
//		user1.setPassword(user.getPassword());
//		user1.setEmail(user.getEmail());
//		
//		String user2 = repo.findByEmail(user1.getEmail());
//		
//		
//		
//		
//		if(user1.getPassword().equals(user2))
//				{
//						return true;
//				}
//		else
//		{
//			return false;
//		}
//	}


	@Override
	public LoginMessage loginuser(userdto user) {
		// TODO Auto-generated method stub
		userdetails user1 = repo.findByEmail(user.getEmail());
				if(user1 != null)
				{
					String Password = user.getPassword();
					String encodedpassword = user1.getPassword();
					boolean ispwdright = passwordEncoder.matches(Password, encodedpassword);
					if(ispwdright)
					{
						Optional<userdetails> loggeduser = repo.findOneByEmailAndPassword(user.getEmail(), user1.getPassword());
						if(loggeduser.isPresent())
						{
							return new LoginMessage("Login Success", true);
						}
						else
						{
							return new LoginMessage("Login Failed", false);
						}
						
						
					}
					else
					{
						return new LoginMessage("password doesnot Match", false);
						
					}
				}
				else
				{
					return new LoginMessage("Email not Found", false);
				}
		
		
	
	}
	
	

	
	
}



