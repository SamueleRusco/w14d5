package controller;
import java.time.LocalDate;

import java.util.Date;
import java.util.List;

import model.Prestito;
import model.Libro;
import model.Rivista;
import model.Utente;
import model.periodicita;
import modelDaos.OggettiBibliotecaDao;
import modelDaos.PrestitoDao;
import modelDaos.UtenteDao;
import utils.JpaUtil;


public class MainEs {

	public static void main(String[] args) {
		
	Libro l1 = new Libro();
		l1.setAnnoPubblicazione(2018);
		l1.setNumeroPagine(205);
		l1.setTitolo("Il Silmarillion");
		l1.setAutore("Tolkien");
		l1.setGenere("fantasy");
		
		
	Rivista r1 = new Rivista();
		r1.setPeriodicita(periodicita.SETTIMANALE);
		r1.setAnnoPubblicazione(2022);
		r1.setNumeroPagine(205);
		r1.setTitolo("la settimana enigmistica");
		
	Utente u1 = new Utente();
		u1.setNome("franco");
		u1.setCognome("porci");	
		u1.setDataNascita(LocalDate.of(1997, 3, 10));
		
	Prestito p1 = new Prestito();
		p1.setDataInizioPrestito(LocalDate.of(2022, 1, 1));
		p1.setOggettiBiblioteca(OggettiBibliotecaDao.findOggetto(1l));
		p1.setUtente(UtenteDao.findUtente(1l));
		
		
		/*OggettiBibliotecaDao.save(r1);
		OggettiBibliotecaDao.save(l1);
		UtenteDao.save(u1);
		PrestitoDao.save(p1);
		PrestitoDao.removePrestito(p1);
		*/
		System.out.println("ciaoo");
		JpaUtil.closeConnection();
	}

}
