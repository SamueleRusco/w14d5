package modelDaos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.OggettiBiblioteca;
import model.Utente;
import utils.JpaUtil;

public class UtenteDao {
	
	//stesso nome della persistent unit
	static EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	
	public static void save(Utente u) {
		em.getTransaction().begin();//getTransaction: "creo" uno snapshot (copia temporanea) del db
		em.persist(u);//, provo a fare le operazioni, vedo se vanno a buon fine
		em.getTransaction().commit();//se tutto è andato a buon fine, lo faccio sul db vero, 
		System.out.println("Utente salvato");
		
	}
	
	//funzione gatById()
	public static void multipleSave(List<Utente> el) {
		em.getTransaction().begin();
		el.forEach(e -> em.persist(e));
		em.getTransaction().commit();
		}
	
	
	
	public static Utente findUtente(Long numeroTessera) {
		em.getTransaction().begin();
		Utente e = em.find(Utente.class, numeroTessera);
		em.getTransaction().commit();
		return e;
	}
	
	//funzione delete
	
	public static void removeUtente(Utente u) {
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		System.out.println("utente eliminato!");
	};
	
	//fidnAllUser()
	@SuppressWarnings("unchecked")
	public static List<OggettiBiblioteca> OggettiBibliotecaFindAll(){
		Query q = em.createNamedQuery("Utente.findAll");
		return (List<OggettiBiblioteca> ) q.getResultList();
	}

}