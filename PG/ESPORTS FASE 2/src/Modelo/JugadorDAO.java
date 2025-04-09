package Modelo;

import java.util.HashMap;
import java.util.Map;

public class JugadorDAO {

    public static final Map<String, Jugador> jugadores = new HashMap<>();

    public static void crearJugador(Jugador j){
        jugadores.put(j.getNickname(),j);
    }
    public static void eliminarJugador(String nickname){
        jugadores.remove(nickname);
    }
    public static void mostrarJugadores(StringBuilder vista){
        vista.delete(0, vista.length());
        for (Map.Entry<String, Jugador> entry : jugadores.entrySet()) {
            vista.append("Nombre: ").append(entry.getValue().getNombre())
                    .append("\t Apellidos: ").append(entry.getValue().getApellido())
                    .append("\t Nacionalidad: ").append(entry.getValue().getNacionalidad())
                    .append("\t Fecha de Nacimiento: ").append(entry.getValue().getFechaNacimiento())
                    .append("\t Nickname: ").append(entry.getValue().getNickname())
                    .append("\t Rol: ").append(entry.getValue().getRol())
                    .append("\t Sueldo: ").append(entry.getValue().getSueldo())
                    .append("\n");
        }
    }
    public static void mostrarJugadorActual(StringBuilder vista2){
        mostrarJugadores(vista2);
    }
    public static Jugador recibirJugador(String nickname){
        return jugadores.get(nickname);

    }
}
