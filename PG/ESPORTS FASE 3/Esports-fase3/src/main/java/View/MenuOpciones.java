package View;

import Controller.VistaController;

import javax.swing.*;

public class MenuOpciones extends JFrame {
    private JPanel contentPane;
    private JButton generarCalendarioDeCompeticiónButton;
    private JButton cerrarEtapaDeInscripciónButton;
    private JButton gestiónDeJugadoresButton;
    private JButton gestiónDeEquiposButton;
    private JButton introducirResultadosButton;
    private JButton verInformesButton;

    private VistaController vistaController;

    public MenuOpciones(VistaController vistaController) {
        this.vistaController = vistaController;

        setContentPane(contentPane);
        setTitle("Menú de Opciones");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // ActionListeners para cada botón (excepto OK y Cancel)
        generarCalendarioDeCompeticiónButton.addActionListener(e -> {
            
        });

        cerrarEtapaDeInscripciónButton.addActionListener(e -> {

        });

        gestiónDeJugadoresButton.addActionListener(e -> {
            dispose();
            vistaController.iniciarGestionJugadores();
        });

        gestiónDeEquiposButton.addActionListener(e -> {

        });

        introducirResultadosButton.addActionListener(e -> {

        });

        verInformesButton.addActionListener(e -> {

        });
    }
}
