package View;

import Controller.VistaController;
import Exceptions.CampoVacioException;

import javax.swing.*;
import java.awt.event.*;

public class JugadoresGestion extends JFrame {
    private JPanel pInterno;
    private JComboBox cbOpciones;
    private JTextField tfDni;
    private JTextField tfNombre;
    private JTextField tfNickname;
    private JTextField tfNacionalidad;
    private JTextField tfApellido;
    private JComboBox cmRol;
    private JTextField tfFechaNacimiento;
    private JTextField tfSueldo;
    private JLabel a1;
    private JLabel a2;
    private JLabel a3;
    private JLabel a4;
    private JLabel a5;
    private JLabel a6;
    private JLabel a7;
    private JLabel a8;
    private JLabel e1;
    private JLabel e2;
    private JLabel e3;
    private JLabel e4;
    private JLabel e5;
    private JLabel e6;
    private JLabel e7;
    private JLabel e8;
    private JButton bAceptar;
    private JButton bCancelar;
    private JPanel pPrincipal;

    private VistaController vistaController;

    //private JLabel[] labels = {a1, a2, a3, a4, a5, a6, a7, a8, e1, e2, e3, e4, e5, e6, e7, e8};

    //TODO Funcionalidad botones, restricción y validación de campos, validación de datos.

    public JugadoresGestion(VistaController vistaController) {
        this.vistaController = vistaController;

        /*for (JLabel label : labels) {
            label.setVisible(false);
        }*/

        setContentPane(pPrincipal);
        setSize(600, 600);
        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        bAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        bCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        pPrincipal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        cbOpciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tfDni.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try {
                    if (vistaController.validarDni(tfDni.getText(),"[0-9]{8}[A-Za-z]")==false){
                        //Mostrar formato correcto
                    }
                } catch (CampoVacioException ex) {

                } catch (Exception ex) {
                    // Manejar la excepción de otra manera si es necesario
                }
            }
        });
        tfNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
        tfApellido.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
        tfNickname.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
        tfNacionalidad.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
        tfFechaNacimiento.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
        tfSueldo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}


