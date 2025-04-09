package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private LocalDate fechaFundacion;
    private ArrayList <Jugador> listaJugadores;

    public Equipo() {

    }

    public Equipo(String nombre, ArrayList<Jugador> listaJugadores, LocalDate fechaFundacion) {
        this.nombre = nombre;
        this.listaJugadores = (listaJugadores != null) ? listaJugadores : new ArrayList<>();
        this.fechaFundacion = fechaFundacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }


}
