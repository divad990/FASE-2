package Modelo;

import java.util.ArrayList;

public class EquipoDAO {

    public static final ArrayList<Equipo> equipos = new ArrayList<>();

    public static boolean crearEquipo(Equipo e){
        boolean comprobante = false;
        if (equipos.isEmpty()) {
            equipos.add(e);
        } else {
            for (Equipo torombolo : equipos) {
                if (torombolo.getNombre().contentEquals(e.getNombre())) {
                    System.out.println("Ya existe un equipo con ese nombre");
                    comprobante = true;
                }
            }
            if (!comprobante) {
                equipos.add(e);
            }
        }
        return comprobante;
    }
    public static void eliminarEquipo(String nombre){
        equipos.removeIf(equipo -> equipo.getNombre().contentEquals(nombre));
    }
    public static void mostrarEquipos(StringBuilder vista) {
        vista.delete(0, vista.length());
        for (Equipo equipo : equipos) {
            vista.append("Nombre: ").append(equipo.getNombre())
                    .append("\t Fecha de Fundación: ").append(equipo.getFechaFundacion())
                    .append("\t Jugadores: ").append(mostrarJugadoresEquipo(equipo.getListaJugadores()))
                    .append("\n");
        }
    }
    public static void mostrarEquipoActual(StringBuilder vista2){
        mostrarEquipos(vista2);
    }

    public static StringBuilder mostrarJugadoresEquipo(ArrayList<Jugador> listaJugadores){
        StringBuilder vistaJugadores = new StringBuilder();
        for (Jugador jugador : listaJugadores) {
            vistaJugadores.append("Nombre: ").append(jugador.getNombre()).append(", Apellido: ").append(jugador.getApellido()).append(", Nacionalidad: ").append(jugador.getNacionalidad()).append(" ,Fecha nacimiento: ").append(jugador.getFechaNacimiento()).append(" ,Nickname: ").append(jugador.getNickname()).append(" ,Rol: ").append(jugador.getRol()).append(" ,Sueldo: ").append(jugador.getSueldo()+"\n");
        }
        return vistaJugadores;
    }
}
