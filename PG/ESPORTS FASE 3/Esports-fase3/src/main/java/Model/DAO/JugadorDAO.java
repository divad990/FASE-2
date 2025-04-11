package Model.DAO;

import Model.Jugador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class JugadorDAO {

    EntityManager em;
    EntityTransaction t;

    public JugadorDAO(EntityManager em, EntityTransaction t) {
        this.em = em;
        this.t = t;
    }

    public boolean validarDni(String dni) {
        t.begin();
        Jugador j = em.find(Jugador.class, dni);
        if (j != null) {
            t.commit();
            return true;
        } else {
            t.rollback();
            return false;
        }
    }
    public boolean validarNickname(String nickname) {
        t.begin();
        Jugador j = em.find(Jugador.class, nickname);
        if (j != null) {
            t.commit();
            return true;
        } else {
            t.rollback();
            return false;
        }
    }

}
