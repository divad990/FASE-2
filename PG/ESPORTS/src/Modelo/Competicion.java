package Modelo;

public class Competicion {
    private int idCompeticion;
    private boolean inscripcion;
    private Jornada jornada;

    public Competicion() {

    }

    public Competicion(int idCompeticion, boolean inscripcion, Jornada jornada) {
        this.idCompeticion = idCompeticion;
        this.inscripcion = inscripcion;
        this.jornada = jornada;
    }

    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public boolean isInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(boolean inscripcion) {
        this.inscripcion = inscripcion;
    }
}
