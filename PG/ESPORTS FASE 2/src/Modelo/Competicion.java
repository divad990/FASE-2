package Modelo;

import java.util.ArrayList;

public class Competicion {
    private int idCompeticion;
    private boolean inscripcion;
    private ArrayList<Jornada> listaJornadas ;

    public Competicion() {

    }

    public Competicion(int idCompeticion, boolean inscripcion, ArrayList listaJornadas) {
        this.idCompeticion = idCompeticion;
        this.inscripcion = inscripcion;
        this.listaJornadas = listaJornadas;
    }

    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public ArrayList<Jornada> getListaJornadas() {
        return listaJornadas;
    }

    public void setListaJornadas(ArrayList<Jornada> listaJornadas) {
        this.listaJornadas = listaJornadas;
    }

    public boolean isInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(boolean inscripcion) {
        this.inscripcion = inscripcion;
    }
}
