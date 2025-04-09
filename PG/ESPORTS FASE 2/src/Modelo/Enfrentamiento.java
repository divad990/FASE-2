package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Enfrentamiento {
    private LocalDate fecha;
    private int numeroJornada;
    private LocalTime hora;
    private String resultado;
    private ArrayList<Jornada> listaJornadas;

    public Enfrentamiento() {

    }

    public Enfrentamiento(LocalDate fecha, ArrayList<Jornada> listaJornadas, String resultado, LocalTime hora, int numeroJornada) {
        this.fecha = fecha;
        this.listaJornadas = listaJornadas;
        this.resultado = resultado;
        this.hora = hora;
        this.numeroJornada = numeroJornada;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public ArrayList<Jornada> getListaJornadas() {
        return listaJornadas;
    }

    public void setListaJornadas(ArrayList<Jornada> listaJornadas) {
        this.listaJornadas = listaJornadas;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getNumeroJornada() {
        return numeroJornada;
    }

    public void setNumeroJornada(int numeroJornada) {
        this.numeroJornada = numeroJornada;
    }
}
