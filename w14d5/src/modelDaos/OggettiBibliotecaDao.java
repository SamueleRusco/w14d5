package modelDaos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.OggettiBiblioteca;
import utils.JpaUtil;

public class OggettiBibliotecaDao {
	
	//stesso nome della persistent unit
	static EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	
	public static void save(OggettiBiblioteca e) {
		em.getTransaction().begin();//getTransaction: "creo" uno snapshot (copia temporanea) del db
		em.persist(e);//, provo a fare le operazioni, vedo se vanno a buon fine
		em.getTransaction().commit();//se tutto è andato a buon fine, lo faccio sul db vero, 
		System.out.println("libro salvato");
		
	}
	
	//funzione gatById()
	public static void multipleSave(List<OggettiBiblioteca> el) {
		em.getTransaction().begin();
		el.forEach(e -> em.persist(e));
		em.getTransaction().commit();
		}
	
	
	
	public static OggettiBiblioteca findOggetto(Long id) {
		em.getTransaction().begin();
		OggettiBiblioteca e = em.find(OggettiBiblioteca.class, id);
		em.getTransaction().commit();
		return e;
	}
	
	//funzione delete
	
	public static void removeOggetto(OggettiBiblioteca e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("libro eliminato eliminato!");
	};
	
	public static void searchByAutore(String autore) {
		em.getTransaction().begin();
		
		TypedQuery<OggettiBiblioteca> query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.autore = :autore", OggettiBiblioteca.class);
	    query.setParameter("autore", autore);
	    List<OggettiBiblioteca> resultList = query.getResultList();/*getSingleResult() per cercare solo il primo elemento*/
	    
		em.getTransaction().commit();
		if (resultList != null && !resultList.isEmpty()) {
	        for (OggettiBiblioteca p : resultList) {
	            System.out.println(p.toString());
	        }
	    } else {
	        System.out.println("Nessuna pubblicazione trovata per l'anno " + autore);
	    }
	}
	
	public static void searchByTitolo(String titolo) {
		em.getTransaction().begin();
		
		TypedQuery<OggettiBiblioteca> query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.titolo like :titolo", OggettiBiblioteca.class);
	    query.setParameter("titolo", '%' + titolo + '%');
	    List<OggettiBiblioteca> resultList = query.getResultList();
	    
		em.getTransaction().commit();
		if (resultList != null && !resultList.isEmpty()) {
	        for (OggettiBiblioteca p : resultList) {
	            System.out.println(p.toString());
	        }
	    } else {
	        System.out.println("Nessuna pubblicazione trovata con titolo: " + titolo);
	    }
	}
	    
	
	//fidnAllUser()
	@SuppressWarnings("unchecked")
	public static List<OggettiBiblioteca> OggettiBibliotecaFindAll(){
		Query q = em.createNamedQuery("OggettiBiblioteca.findAll");
		return (List<OggettiBiblioteca> ) q.getResultList();
	}

}