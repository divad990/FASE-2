package View;

import Controller.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogIn extends JDialog {

    private VistaController vistaController;
    private JPanel panelPricipal;
    private JButton imagenLogIn;
    private JButton logInButton;
    private JPanel panelUsuarioContrasenia;
    private JPanel panerArriba;
    private JPanel panelAbajo;
    private JTextField usuarioField;
    private JTextField contaseniaField;

    public VentanaLogIn(VistaController vistaController) {

        this.vistaController = vistaController;
        setContentPane(panelPricipal);
        setModal(true);
        setSize(400,400);
        setLocationRelativeTo(null);


        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
