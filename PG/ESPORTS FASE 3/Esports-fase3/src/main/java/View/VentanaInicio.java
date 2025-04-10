package View;

import Controller.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame {

    private JPanel panelInicio;
    private JButton botonAcesso;
    private JButton botonImagen;
    private JPanel panelImagen;
    private JPanel panelAcesso;
    private JButton accesologin;

    private VistaController vistaController;

    public VentanaInicio(VistaController vistaController) {


        this.vistaController = vistaController;
        setContentPane(panelInicio);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        botonAcesso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaController.mostrarAccesoLogIn();
            }
        });
    }

}
