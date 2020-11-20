package com.app.naveen.PDFexport.controllers;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.naveen.PDFexport.models.Actor;
import com.app.naveen.PDFexport.services.ActorService;
import com.app.naveen.PDFexport.utilities.GeneratePDF;

@RestController
public class ActorController {

	@Autowired
	ActorService actorService;
	
	
	@GetMapping(value="actors/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> getAllActors() {
		
		List<Actor> actors =  actorService.findAllActorsInfo();
		
		ByteArrayInputStream bis = GeneratePDF.getPDF(actors);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=actors.pdf");
		
		return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
	}
}







