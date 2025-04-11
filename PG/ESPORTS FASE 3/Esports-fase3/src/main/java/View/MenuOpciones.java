package View;

import Controller.VistaController;

import javax.swing.*;

public class MenuOpciones extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
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
        setModal(true);
        setTitle("Menú de Opciones");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getRootPane().setDefaultButton(buttonOK);

        // ActionListeners para cada botón (excepto OK y Cancel)
        generarCalendarioDeCompeticiónButton.addActionListener(e -> {

        });

        cerrarEtapaDeInscripciónButton.addActionListener(e -> {

        });

        gestiónDeJugadoresButton.addActionListener(e -> {
            vistaController.iniciarGestionJugadores();
        });

        gestiónDeEquiposButton.addActionListener(e -> {

        });

        introducirResultadosButton.addActionListener(e -> {

        });

        verInformesButton.addActionListener(e -> {

        });

        // Botones OK y Cancel solo cierran la ventana
        buttonOK.addActionListener(e -> dispose());
        buttonCancel.addActionListener(e -> dispose());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuOpciones dialog = new MenuOpciones();
            dialog.setVisible(true);
        });
    }
}
