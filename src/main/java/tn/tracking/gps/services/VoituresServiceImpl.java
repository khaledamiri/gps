package tn.tracking.gps.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.tracking.gps.models.Voiture;
import tn.tracking.gps.repositories.ClientRepositories;
import tn.tracking.gps.repositories.VoitureRepositories;

@Service
public class VoituresServiceImpl implements VoitureService {

	@Autowired
	private VoitureRepositories voitureRepositories;

	@Autowired
	private ClientRepositories clientRepositories;

	public List<Voiture> getAll() {
		return this.voitureRepositories.findAll();

	}

	@Override
	public Voiture updateVoiture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voiture> getAllVoitureByIdClient(Long idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Voiture getVoitureByDateDebAndDateFinAndVitesse(String matricule, Date deb, Date fin, long vitesse) {
		// TODO Auto-generated method stub
		return null;
	}

}
