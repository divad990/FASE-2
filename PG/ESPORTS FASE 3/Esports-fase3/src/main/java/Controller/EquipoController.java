package Controller;

import Model.DAO.EquipoDAO;
import Model.Equipo;
import Utils.BaseDatos;

import java.util.List;

public class EquipoController {

    private final EquipoDAO equipoDAO;

    public EquipoController() {
        this.equipoDAO = new EquipoDAO(BaseDatos.getEm(), BaseDatos.getT());
    }

    public List<String> obtenerEquipos() {
        return equipoDAO.obtenerEquipos();
    }
    public Equipo obtenerEquipo(String equipo) {
        return equipoDAO.obtenerEquipo(equipo);
    }

}
