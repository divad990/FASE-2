package Model.DAO;

import Model.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import javax.swing.*;
import java.util.List;

public class EquipoDAO {

    private EntityManager em;
    private EntityTransaction t;

    public EquipoDAO(EntityManager em, EntityTransaction t) {
        this.em = em;
        this.t = t;
    }

    public List<String> obtenerEquipos() {
        try {
            t.begin();
            List<String> equipos = List.of(em.createQuery("SELECT e.nombre FROM Equipo e", String.class).getResultList().toArray(new String[0]));
            t.commit();
            return equipos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener equipos de la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public Equipo obtenerEquipo(String nombre) {
        try {
            t.begin();
            Equipo equipo = em.createQuery("SELECT e FROM Equipo e WHERE e.nombre = :nombre", Equipo.class)
                    .setParameter("nombre", nombre)
                    .getSingleResult();
            t.commit();
            return equipo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el equipo de la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
