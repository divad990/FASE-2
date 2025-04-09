package Model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Entity
@Table(name = "ENFRENTAMIENTO")
public class Enfrentamiento {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_JORNADA", nullable = false)
    private Model.Jornada idJornada;

    @Column(name = "HORA", nullable = false)
    private Instant hora;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Model.Jornada getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(Model.Jornada idJornada) {
        this.idJornada = idJornada;
    }

    public Instant getHora() {
        return hora;
    }

    public void setHora(Instant hora) {
        this.hora = hora;
    }

}