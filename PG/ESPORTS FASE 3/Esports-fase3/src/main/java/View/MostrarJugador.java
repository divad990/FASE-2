package View;

import Controller.VistaController;
import Model.Jugador;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MostrarJugador extends JFrame {
    private JPanel pPrincipal;
    private JLabel fnNombre;
    private JLabel fnApellido;
    private JLabel fnDni;
    private JLabel fnRol;
    private JLabel fnNickname;
    private JLabel fnNacionalidad;
    private JLabel fnFechaNacimienito;
    private JLabel fnSueldo;
    private JLabel fnEquipo;

    private VistaController vistaController;
    private String nif;

    public MostrarJugador(VistaController vistaController, String nif) {
        this.vistaController = vistaController;
        this.nif = nif;

        setContentPane(pPrincipal);
        setSize(600, 600);
        setTitle("Gestión de Jugadores");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        Jugador j = vistaController.obtenerJugador(nif);
        fnNombre.setText(j.getNombre());
        fnApellido.setText(j.getApellido());
        fnDni.setText(j.getDni());
        fnRol.setText(j.getRol());
        fnNickname.setText(j.getNickname());
        fnNacionalidad.setText(j.getNacionalidad());
        fnFechaNacimienito.setText(j.getFechaNacimiento().toString());
        fnSueldo.setText(String.valueOf(j.getSueldo()));
        String equipo = j.getIdEquipo().getNombre();
        fnEquipo.setText(equipo);
    }

    public void onCancel() {
        dispose();
    }

}
