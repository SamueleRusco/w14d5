package model;
import java.time.LocalDate;
import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Table (name="persone")
@Entity


//@NamedQuery(name="OggettiBiblioteca.findAll", query = "SELECT e FROM OggettiBiblioteca e")
public class Utente implements Serializable {
	

	

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY) //genera in automatico id nel database incrementale (i++)
	@Column(name = "numero_tessera")
	private long numeroTessera;
	
	
	@Column (nullable = false)
	private String nome;
	
	@Column (nullable = false)
	private String cognome;
	
	@Column (nullable = false)
	private LocalDate dataNascita;
	
	@OneToOne(mappedBy ="utente")
	private Prestito prestito;
	
		
	

@Override
	public String toString() {
		return "Utente [getNumeroTessera()=" + getNumeroTessera() + ", getNome()=" + getNome() + ", getCognome()="
				+ getCognome() + ", getDataNascita()=" + getDataNascita() + "]";
	}

public long getNumeroTessera() {
		return numeroTessera;
	}

	public void setNumeroTessera(long numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Prestito getPrestito() {
		return prestito;
	}

	public void setPrestito(Prestito prestito) {
		this.prestito = prestito;
	}

public Utente() {}

	public Utente(Long id, String nome, String cognome, LocalDate dataNascita, Integer numeroTessera) {
		super();
		this.numeroTessera = numeroTessera;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		
	}
	
	
	
}