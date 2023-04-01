package utils;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


//variabile statica, entityMan serve per creare le entità (classi che diventeranno tabelle)
	//CRUD = CREATE READ UPDATE DELETE!!
	//questa classe serve per istanziare una variabile che ci permette di comunicare col database (creare/salvare/modificare/recuperare entità)
	
public class JpaUtil {

	private static final EntityManagerFactory entityManagerFactory;

	static {
		try {
			entityManagerFactory = Persistence
					.createEntityManagerFactory("w14d5");
		} catch (Throwable ex) {
			System.err.println("Initial EntityManagerFactory creation failed."
					+ ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	public static void closeConnection() {
		entityManagerFactory.close();
	}

}
