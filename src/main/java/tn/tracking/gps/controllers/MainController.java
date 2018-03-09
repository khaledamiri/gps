package tn.tracking.gps.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.tracking.gps.models.Voiture;
import tn.tracking.gps.repositories.ClientRepositories;
import tn.tracking.gps.repositories.VoitureRepositories;

@RestController
@RequestMapping(name = "/api")
public class MainController {

	@Autowired
	private VoitureRepositories voitureRepositories;

	@Autowired
	private ClientRepositories clientRepositories;

	@GetMapping(value = "/frame")
	public ResponseEntity<Voiture> getTodoById(@PathVariable("id") Long id) {
		Voiture voiture = voitureRepositories.findById(id).get();
		if (voiture == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(voiture, HttpStatus.OK);
		}
	}

}
