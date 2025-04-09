package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class PartidoId implements java.io.Serializable {
    private static final long serialVersionUID = -9132725333606830312L;
    @Column(name = "ID_EQUIPO", nullable = false)
    private Integer idEquipo;

    @Column(name = "ID_ENFRENTAMIENTO", nullable = false)
    private Integer idEnfrentamiento;

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Integer getIdEnfrentamiento() {
        return idEnfrentamiento;
    }

    public void setIdEnfrentamiento(Integer idEnfrentamiento) {
        this.idEnfrentamiento = idEnfrentamiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PartidoId entity = (PartidoId) o;
        return Objects.equals(this.idEquipo, entity.idEquipo) &&
                Objects.equals(this.idEnfrentamiento, entity.idEnfrentamiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEquipo, idEnfrentamiento);
    }

}