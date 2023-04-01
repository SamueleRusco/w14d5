package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("Riviste")
public class Rivista extends OggettiBiblioteca implements Serializable {
	
	
	
	

	@Column
	@Enumerated(EnumType.STRING)
	private periodicita periodicita;

	public Rivista() {
		super();
	
	}

	public Rivista(Long isbn, String titolo,int AnnoPubblicazione, Integer numeroPagine, periodicita periodicita) {
		super(isbn, titolo, AnnoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

	public periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(periodicita periodicita) {
		this.periodicita = periodicita;
	}
	@Override
	public String toString() {
		return "Rivista [getPeriodicita()=" + getPeriodicita() + "]";
	}
		
	}
	
