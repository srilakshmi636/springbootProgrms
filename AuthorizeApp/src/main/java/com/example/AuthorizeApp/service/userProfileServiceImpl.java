package com.example.AuthorizeApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AuthorizeApp.model.Userprofile;
import com.example.AuthorizeApp.repository.Userprofilerepo;
@Service
public class userProfileServiceImpl implements userprofileservice {
	
	@Autowired
	Userprofilerepo userrepo;


	@Override
	public Userprofile adduserprofile(Userprofile userprofile) {
		userrepo.save(userprofile);
		return userprofile;
	}

	@Override
	public boolean validateUserprofile(String userid, String pssword) {
		Userprofile userprofile=userrepo.findByUseridAndPassword(userid, pssword);
		if(userprofile!=null) {
			return true;
		}else {
		
		return false;
		}
	}

}
