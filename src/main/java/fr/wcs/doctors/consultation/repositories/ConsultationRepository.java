package fr.wcs.doctors.consultation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.wcs.doctors.consultation.entities.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
