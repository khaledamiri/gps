package tn.tracking.gps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.tracking.gps.models.Client;

@Repository
public interface ClientRepositories extends JpaRepository<Client, Long> {

}
