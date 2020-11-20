package com.app.naveen.PDFexport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.naveen.PDFexport.Repositories.ActorRepo;
import com.app.naveen.PDFexport.models.Actor;

@Service
public class ActorService {

	@Autowired
	ActorRepo actorRepo;
	
	public List<Actor> findAllActorsInfo() {
		
		return actorRepo.findAll();
	}
	
}
