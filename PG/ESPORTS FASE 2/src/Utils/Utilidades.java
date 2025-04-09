package Utils;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {

    public static String solicitarDato(String dato, String mensaje, String expresionRegular) {
        String variable = "";
        boolean error = true;
        do {
            try {
                variable = JOptionPane.showInputDialog(mensaje);
                if (variable.isEmpty())
                    JOptionPane.showMessageDialog(null, dato + " es un campo obligatorio");
                Pattern pat = Pattern.compile(expresionRegular);
                Matcher mat = pat.matcher(variable);
                if (!mat.matches()) {
                    JOptionPane.showMessageDialog(null, dato + " no tiene un formato adecuado");
                } else {
                    error = false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (error);
        return variable;
    }
}