package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity


@DiscriminatorValue("Libro")
public class Libro extends OggettiBiblioteca implements Serializable {
	
	
	
	@Override
	public String toString() {
		return "Libro [getAutore()=" + getAutore() + ", getGenere()=" + getGenere() + "]";
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	@Column
	private String autore;
	@Column 
	private String genere;
	
	
	public Libro() {
		super();
		
	}
	public Libro(Long isbn, String titolo, LocalDate AnnoPubblicazione, Integer numeroPagine) {
		super(isbn, titolo, AnnoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
		
	}
	
	
	
	
	
	
	

}
