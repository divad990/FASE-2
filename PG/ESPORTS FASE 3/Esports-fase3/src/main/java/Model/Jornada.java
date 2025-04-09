package Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "JORNADA")
public class Jornada {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NUMERO_JORNADA", nullable = false)
    private Short numeroJornada;

    @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @OneToMany(mappedBy = "idJornada")
    private Set<Enfrentamiento> enfrentamientos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getNumeroJornada() {
        return numeroJornada;
    }

    public void setNumeroJornada(Short numeroJornada) {
        this.numeroJornada = numeroJornada;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Set<Enfrentamiento> getEnfrentamientos() {
        return enfrentamientos;
    }

    public void setEnfrentamientos(Set<Enfrentamiento> enfrentamientos) {
        this.enfrentamientos = enfrentamientos;
    }

}