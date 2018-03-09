package tn.tracking.gps.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.tracking.gps.models.Voiture;

@Repository
public interface VoitureRepositories extends JpaRepository<Voiture, Long> {

	Page<Voiture> findAll(Pageable pageable);

}
