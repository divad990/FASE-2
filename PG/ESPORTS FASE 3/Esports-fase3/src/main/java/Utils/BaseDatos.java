package Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BaseDatos {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private static final EntityManager em = emf.createEntityManager();
    private static final EntityTransaction t = em.getTransaction();

    public static EntityManager getEm() {
        return em;
    }

    public static EntityTransaction getT() {
        return t;
    }

}
