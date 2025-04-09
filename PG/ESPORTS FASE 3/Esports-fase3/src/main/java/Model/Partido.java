package Model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "PARTIDO")
public class Partido {
    @EmbeddedId
    private PartidoId id;

    @MapsId("idEquipo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_EQUIPO", nullable = false)
    private Equipo idEquipo;

    @MapsId("idEnfrentamiento")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_ENFRENTAMIENTO", nullable = false)
    private Enfrentamiento idEnfrentamiento;

    @Column(name = "RESULTADO", nullable = false, length = 5)
    private String resultado;

    public PartidoId getId() {
        return id;
    }

    public void setId(PartidoId id) {
        this.id = id;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Enfrentamiento getIdEnfrentamiento() {
        return idEnfrentamiento;
    }

    public void setIdEnfrentamiento(Enfrentamiento idEnfrentamiento) {
        this.idEnfrentamiento = idEnfrentamiento;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

}