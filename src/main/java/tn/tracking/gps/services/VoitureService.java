package tn.tracking.gps.services;

import java.util.Date;
import java.util.List;

import tn.tracking.gps.models.Voiture;

public interface VoitureService {

	public List<Voiture> getAll();

	public Voiture updateVoiture();

	public List<Voiture> getAllVoitureByIdClient(Long idClient);

	public Voiture getVoitureByDateDebAndDateFinAndVitesse(String matricule,Date deb, Date fin,
			long vitesse);

}
