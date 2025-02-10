package Modelo;

import java.util.HashMap;
import java.util.Map;

public class JugadorDAO {

    public static final Map<String, Jugador> jugadores = new HashMap<>();

    public static void crearJugador(Jugador j){
        jugadores.put(j.getNickname(),j);
    }

}
