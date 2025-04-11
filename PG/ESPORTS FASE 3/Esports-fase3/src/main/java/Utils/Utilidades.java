package Utils;

import Exceptions.CampoVacioException;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {

    public static boolean validarDato(String dato, String expresionRegular) throws CampoVacioException {
        if (dato == null || dato.trim().isEmpty()) {
            throw new CampoVacioException("");
        }
        if (dato.isEmpty())
            throw new CampoVacioException("");
        Pattern pat = Pattern.compile(expresionRegular);
        Matcher mat = pat.matcher(dato);
        return mat.matches();
    }
}