package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Jornada {
    private int numero;
    private LocalDate fecha;
    private ArrayList<Jornada> listaJornadas;

    public Jornada() {

    }

    public Jornada(int numero, LocalDate fecha) {
        this.numero = numero;
        this.fecha = fecha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Jornada> getListaJornadas() {
        return listaJornadas;
    }

    public void setListaJornadas(ArrayList<Jornada> listaJornadas) {
        this.listaJornadas = listaJornadas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
