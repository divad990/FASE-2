package Modelo;

import java.util.ArrayList;


public class JornadaDAO {

    private static ArrayList<Jornada> listaJornadas =new ArrayList<>();

    public static boolean crearJornada(Jornada j){
        boolean comprobante = false;
        if (listaJornadas.isEmpty()) {
            listaJornadas.add(j);
        } else {
            for (int i = 0; i < listaJornadas.size(); i++) {
                if (j.getNumero()==listaJornadas.get(i).getNumero()) {
                    System.out.println("Ya existe una jornada con ese nombre");
                    comprobante = true;
                }
            }
            if (!comprobante) {
                listaJornadas.add(j);
            }
        }
        return comprobante;
    }

}