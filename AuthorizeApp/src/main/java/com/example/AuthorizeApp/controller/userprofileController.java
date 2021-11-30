package com.example.AuthorizeApp.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AuthorizeApp.model.Userprofile;
import com.example.AuthorizeApp.service.userprofileservice;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class userprofileController {
	



	
	@Autowired
	userprofileservice userservice;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> adduser(@RequestBody Userprofile userprofile)
	
	{  
		System.out.println("adduser");
		
		Userprofile result=userservice.adduserprofile(userprofile);
		return new ResponseEntity<Userprofile>(result,HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("/login")
	
	public ResponseEntity<?> validateuser(@RequestBody Userprofile userprofile)
	{
	boolean result= userservice.validateUserprofile(userprofile.getUserid(), userprofile.getPassword());
	
	if(result)
	{
		String tokresult=generateToken(userprofile);
		
		HashMap map=new HashMap();
		map.put("token",tokresult);
		return new ResponseEntity<HashMap>(map,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Invalid user",HttpStatus.FORBIDDEN);
	}
	
	}
	
	public String generateToken(Userprofile userprofile)
	{
		
		long etime=10_000_00;
		
		return Jwts.builder().setSubject(userprofile.getUserid())
							.setIssuedAt(new Date(System.currentTimeMillis()))
							.setExpiration(new Date(System.currentTimeMillis()+etime))
							.signWith(SignatureAlgorithm.HS256, "natwestkey")
							.compact();
							
						
				
		
	}



}
