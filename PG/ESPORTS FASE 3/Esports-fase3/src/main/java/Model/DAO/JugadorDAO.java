package Model.DAO;

import Model.Equipo;
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
        Jugador j = em.createQuery("SELECT j FROM Jugador j WHERE j.nickname = :nickname", Jugador.class)
                .setParameter("nickname", nickname)
                .getResultStream()
                .findFirst()
                .orElse(null);
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
    public void modificarJugador(String dni, String nombre, String apellido, String nickname, String nacionalidad, String rol, java.sql.Date fechaNacimiento, BigDecimal sueldo, Equipo equipo) {
        t.begin();
        Jugador j = em.find(Jugador.class, dni);
        if (!nombre.isEmpty()) {
            j.setNombre(nombre);
        }
        if (!apellido.isEmpty()) {
            j.setApellido(apellido);
        }
        if (!nickname.isEmpty()) {
            j.setNickname(nickname);
        }
        if (!nacionalidad.isEmpty()) {
            j.setNacionalidad(nacionalidad);
        }
        if (!rol.isEmpty()) {
            j.setRol(rol);
        }
        if (fechaNacimiento != null) {
            j.setFechaNacimiento(fechaNacimiento.toLocalDate());
        }
        if (sueldo != null) {
            j.setSueldo(sueldo);
        }
        if (equipo != null) {
            j.setIdEquipo(equipo);
        }
        em.merge(j);
        t.commit();
    }
    public void eliminarJugador(String dni) {
        t.begin();
        Jugador j = em.find(Jugador.class, dni);
        em.remove(j);
        t.commit();
    }
    public Jugador obtenerJugador(String nif) {
        t.begin();
        Jugador j = em.find(Jugador.class, nif);
        t.commit();
        return j;
    }

}
