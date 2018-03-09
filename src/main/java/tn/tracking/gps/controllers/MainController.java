package tn.tracking.gps.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.tracking.gps.dto.VoitureDTO;
import tn.tracking.gps.dto.transform.ClientTransform;
import tn.tracking.gps.dto.transform.VoitureTransform;
import tn.tracking.gps.models.Voiture;
import tn.tracking.gps.repositories.ClientRepositories;
import tn.tracking.gps.repositories.VoitureRepositories;

@RestController
@RequestMapping(name = "/api")
@CrossOrigin("*")
public class MainController {

	@Autowired
	private VoitureRepositories voitureRepositories;

	@Autowired
	private ClientRepositories clientRepositories;

	@GetMapping(value = "/voiture/{id}")
	public ResponseEntity<VoitureDTO> getVoitureById(@PathVariable("id") Long id) {
		Voiture voiture = voitureRepositories.findById(id).get();
		VoitureDTO voitureDTO = VoitureTransform.voiture2VoitureDTO(voiture);

		if (voiture == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(voitureDTO, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/voitures")
	public ResponseEntity<Page<VoitureDTO>> getAllVoituresByClient(Long idClient, int page, int size) {

		Pageable pageable = new PageRequest(page, size);

		Page<Voiture> voituresPage = voitureRepositories.findAll(pageable);

		Page<VoitureDTO> voituresPages = VoitureTransform.voiturePage2voiturePageDTO(pageable, voituresPage);

		if (null != voituresPages) {
			return new ResponseEntity<>(voituresPages, HttpStatus.OK);

		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@DeleteMapping(value = "/voiture/{id}")
	public void deleteVoiture(Long idVoiture) {

		voitureRepositories.deleteById(idVoiture);

	}

	@PutMapping(value = "/voiture/{id}")
	public ResponseEntity<Voiture> updateVoiture(@PathVariable("id") String id, @Valid @RequestBody VoitureDTO voitureDTO) {
		Voiture voiture=voitureRepositories.findById(id);
		
	        if(voiture == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        voiture.setClient(ClientTransform.clientDTO2Client(voitureDTO.getClient()));
	        voiture.setMatricule(voitureDTO.getMatricule());
	        Voiture updatedTodo = voitureRepositories.save(voiture);
	        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
		

	}
}
