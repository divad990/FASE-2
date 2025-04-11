package Model.DAO;

import Model.Jugador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.math.BigDecimal;

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
    public void crearJugador(String dni, String nombre, String apellido, String nickname, String nacionalidad, String rol, java.sql.Date fechaNacimiento, BigDecimal sueldo) {
        t.begin();
        Jugador j = new Jugador();
        j.setDni(dni);
        j.setNombre(nombre);
        j.setRol(rol);
        j.setNickname(nickname);
        j.setApellido(apellido);
        j.setNacionalidad(nacionalidad);
        j.setFechaNacimiento(fechaNacimiento.toLocalDate());
        j.setSueldo(sueldo);
        em.persist(j);
        t.commit();
    }

}
