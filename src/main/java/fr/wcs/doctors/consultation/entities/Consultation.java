package fr.wcs.doctors.consultation.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "CONSULTATION")
public class Consultation implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dateTime;
	private String reason;
	private int number;
	
	@ManyToOne(optional=false) 
    @JoinColumn(name="DOCTOR_ID", nullable=false, updatable=false)
	private Doctor doctor;
	
	@ManyToOne(optional=false) 
    @JoinColumn(name="PATIENT_ID", nullable=false, updatable=false)
	private Patient patient;
	
	@ManyToMany
    @JoinTable(name="CONSULTATION_has_DRUG")
	private List<Drug> drugs = new ArrayList<Drug>();
	
	
	public Consultation(Long id, LocalDate dateTime, String reason, int number, Doctor doctor, Patient patient) {
		this.id = id;
		this.dateTime = dateTime;
		this.reason = reason;
		this.number = number;
		this.doctor = doctor;
		this.patient = patient;
	}
	
	
	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
}
