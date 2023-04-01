package model;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;
import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;

import lombok.Setter;



@Table (name="prestiti")
@Entity

@NamedQuery(name="Prestito.findAll", query = "SELECT e FROM Prestito e")
//@NamedQuery(name="OggettiBiblioteca.findAll", query = "SELECT e FROM OggettiBiblioteca e")
public class Prestito implements Serializable {

   

	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "prestito_utente")
    private Utente utente;

    @OneToOne
    @JoinColumn(name = "prestito_oggettiBiblioteca")
    private OggettiBiblioteca oggettiBiblioteca;

    @Column
    private LocalDate dataInizioPrestito;

    @Column
    private LocalDate dataFinePrestito = dataInizioPrestito.plusDays(30);

    @Column
    private LocalDate dataRestituzione;

    public Prestito() {
    }

    public Prestito(Utente utente, OggettiBiblioteca oggettiBiblioteca, LocalDate dataInizioPrestito,
            LocalDate dataRestituzione) {
        super();
        this.utente = utente;
        this.oggettiBiblioteca = oggettiBiblioteca;
        this.dataInizioPrestito = dataInizioPrestito;
       
        this.dataRestituzione = dataRestituzione;
    }
   



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public OggettiBiblioteca getOggettiBiblioteca() {
		return oggettiBiblioteca;
	}

	public void setOggettiBiblioteca(OggettiBiblioteca oggettiBiblioteca) {
		this.oggettiBiblioteca = oggettiBiblioteca;
	}

	public LocalDate getDataInizioPrestito() {
		return dataInizioPrestito;
	}

	public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}

	public LocalDate getDataFinePrestito() {
		return dataFinePrestito;
	}

	

	public LocalDate getDataRestituzione() {
		return dataRestituzione;
	}

	public void setDataRestituzione(LocalDate dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}

	@Override
	public String toString() {
		return "Prestito [tempoPrestito=" +  ", id=" + this.getId() + ", utente=" + this.getUtente() + ", oggettiBiblioteca="
				+ this.getOggettiBiblioteca() + ", dataInizioPrestito=" + this.getDataInizioPrestito() + ", dataFinePrestito="
				+ this.getDataFinePrestito() + ", dataRestituzione=" + this.getDataRestituzione() + "]";
	}
	

	
	
}