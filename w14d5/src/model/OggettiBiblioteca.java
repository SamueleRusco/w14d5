package model;
import java.time.LocalDate;
import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Table (name="oggettibiblioteca")


@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "oggetti_biblioteca", discriminatorType = DiscriminatorType.STRING)
//@NamedQuery(name="OggettiBiblioteca.findAll", query = "SELECT e FROM OggettiBiblioteca e")
public class OggettiBiblioteca implements Serializable {

	

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY) //genera in automatico id nel database incrementale (i++)
	@Column(name = "id")
	private Long isbn;
	
	@Column (nullable = false)
	private String titolo;
	
	@Column (nullable = false)
	private int AnnoPubblicazione;
	
		
	@Column (nullable = false)
	private Integer numeroPagine;
	
	@OneToOne(mappedBy ="oggettiBiblioteca")
	private Prestito prestito;
	
	public OggettiBiblioteca() {};
	
	public OggettiBiblioteca(Long isbn, String titolo, int annoPubblicazione, Integer numeroPagine){
		this.isbn = isbn;
		this.titolo = titolo;
		this.AnnoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoPubblicazione() {
		return AnnoPubblicazione;
	}

	public void setAnnoPubblicazione(int annoPubblicazione) {
		AnnoPubblicazione = annoPubblicazione;
	}

	public Integer getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(Integer numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	public Prestito getPrestito() {
		return prestito;
	}

	public void setPrestito(Prestito prestito) {
		this.prestito = prestito;
	}

	@Override
	public String toString() {
		return "OggettiBiblioteca [getIsbn()=" + getIsbn() + ", getTitolo()=" + getTitolo()
				+ ", getAnnoPubblicazione()=" + getAnnoPubblicazione() + ", getNumeroPagine()=" + getNumeroPagine()
				+ "]";
	}	
	
}