package com.example.AuthorizeApp.service;

import com.example.AuthorizeApp.model.Userprofile;

public interface userprofileservice {
	
	
	
   Userprofile adduserprofile(Userprofile userprofile);
	
	boolean validateUserprofile(String userid,String pssword);


}
