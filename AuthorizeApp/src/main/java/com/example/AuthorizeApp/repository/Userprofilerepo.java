package com.example.AuthorizeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AuthorizeApp.model.Userprofile;
@Repository
public interface Userprofilerepo extends JpaRepository<Userprofile,String>{

	
	Userprofile findByUseridAndPassword(String userid, String password);
}
