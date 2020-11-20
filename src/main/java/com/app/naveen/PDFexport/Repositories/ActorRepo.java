package com.app.naveen.PDFexport.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.naveen.PDFexport.models.Actor;

@Repository
public interface ActorRepo extends JpaRepository<Actor, Integer> {

}
