package modelDaos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.OggettiBiblioteca;
import model.Prestito;
import model.Utente;
import utils.JpaUtil;

public class PrestitoDao {
	
	//stesso nome della persistent unit
	static EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	
	public static void save(Prestito p) {
		em.getTransaction().begin();//getTransaction: "creo" uno snapshot (copia temporanea) del db
		em.persist(p);//, provo a fare le operazioni, vedo se vanno a buon fine
		em.getTransaction().commit();//se tutto è andato a buon fine, lo faccio sul db vero, 
		System.out.println("libro salvato");
		
	}
	
	//funzione gatById()
	public static void multipleSave(List<Prestito> el) {
		em.getTransaction().begin();
		el.forEach(e -> em.persist(e));
		em.getTransaction().commit();
		}
	
	
	
	public static Prestito findUtente(Long id) {
		em.getTransaction().begin();
		Prestito e = em.find(Prestito.class, id);
		em.getTransaction().commit();
		return e;
	}
	
	//funzione delete
	
	public static void removePrestito(Prestito p) {
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("prestito eliminato!");
	};
	
	//fidnAllUser()
	@SuppressWarnings("unchecked")
	public static List<Prestito> PrestitoFindAll(){
		Query q = em.createNamedQuery("Prestito.findAll");
		return (List<Prestito> ) q.getResultList();
	}

}