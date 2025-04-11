package Model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UsuarioDAO {

    private EntityManager em;
    private EntityTransaction t;

    public UsuarioDAO(EntityManager em, EntityTransaction t) {
        this.em = em;
        this.t = t;
    }

    public Usuario buscar (Usuario usuario) throws Exception{
        try
        {
            t.begin();
            usuario = em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username", Usuario.class)
                    .setParameter("username", "tigreuno")
                    .getSingleResult();
            // Si no encuentra el usuario. p es null
            if (usuario == null)
                throw new Exception();
            t.commit();
            return usuario;
        }
        catch (Exception e) {
            t.rollback();
            throw new Exception(e.getClass() + "\n" + "Error al buscar el usuario ");
        }
    }
}
