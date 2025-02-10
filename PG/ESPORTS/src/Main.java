import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //TODO Fase 1 (inscripcion)

        menuf1();

        //TODO 1. Almacenar jugadores
        //TODO 2. Almacenar equipos
        //TODO 3. Generar jornadas y enfremtanmeintos, almacenar

        //TODO Fase 2 (campeonato)

        //TODO Restricciones
        /*
        1. El numero de equipos tiene que ser par.
        2. Los equipos estan formados por 6 juagadores.
        3. El salario mínimo tiene que ser mayor al SMI.
        4. La competición será de todos contra todos y se tendrá que generar un calendario de enfrentamientos.
        5. Jornada por semana, los enfrentamientos de cada jornada se jugaran en un día.
        6. No se podrán generar jornadas con equipos de menos de 2 jugadores.
        7. Una vez generado el calendario de una copmetición se cerrará la Fase 1
         */
    }

    public static void menuf1() {
        JOptionPane.showMessageDialog(null, "Bienvenido al programa de inscripciones de la competición de eSports");

        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Selecciona una opción:\n1. Inscribir jugadores\n2. Inscribir equipos\n3. Generar jornadas y enfrentamientos\n4. Salir"));

        switch(opcion){
            case 1:
                //TODO Inscribir jugadores
                break;
            case 2:
                //TODO Inscribir equipos
                break;
            case 3:
                //TODO Generar jornadas y enfrentamientos
                break;
            case 4:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
                menuf1();
                break;
        }

    }

}