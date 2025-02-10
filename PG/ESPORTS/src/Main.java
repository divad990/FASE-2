import Controladores.*;

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
        boolean fallo = true;
        while (fallo) {
            //Menu con botones
            int opcion1 = JOptionPane.showOptionDialog(null, "Selecciona una opción", "Menú principal", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Gestionar jugadores", "Gestionar equipos", "Generar calendario", "Salir"}, 0);
            if (opcion1 != -1) {
                opcion1++;
                System.out.println(" seleccionada opcion " + opcion1);
            }
            if (opcion1 == 1) {
                fallo = false;
                boolean fallo2 = true;
                do {
                    int opcion2 = Integer.parseInt(JOptionPane.showInputDialog("""
                            Selecciona una opción: \

                            1. Crear jugador\

                            2. Modificar jugador\

                            3. Eliminar jugador\

                            4. Listar jugadores\

                            5. Salir"""));
                    switch (opcion2) {
                        case 1:
                            fallo2 = false;
                            JugadorController.crearJugador();
                            break;
                        case 2:
                            fallo2 = false;
                            //JugadorController.modificarJugador();
                            break;
                        case 3:
                            //JugadorController.eliminarJugador();
                            fallo2 = false;
                            break;
                        case 4:
                            //JugadorController.listarJugadores();
                            fallo2 = false;
                            break;
                        case 5:
                            fallo2 = false;
                            menuf1();
                            break;
                        default:
                            System.out.println("Opción no válida");
                    }
                } while (fallo2);
                menuf1();
            } else if (opcion1 == 2) {
                fallo = false;
                boolean fallo2 = true;
                do {
                    int opcion2 = Integer.parseInt(JOptionPane.showInputDialog("""
                            Selecciona una opción: \

                            1. Crear equipo\

                            2. Modificar equipo\

                            3. Eliminar equipo\

                            4. Listar equipos\

                            5. Salir"""));
                    switch (opcion2) {
                        case 1:
                            //EquipoController.crearEquipo();
                            fallo2 = false;
                            break;
                        case 2:
                            //EquipoController.modificarEquipo();
                            fallo2 = false;
                            break;
                        case 3:
                            //EquipoController.eliminarEquipo();
                            fallo2 = false;
                            break;
                        case 4:
                            //EquipoController.listarEquipos();
                            fallo2 = false;
                            break;
                        case 5:
                            fallo2 = false;
                            menuf1();
                            break;
                        default:
                            System.out.println("Opción no válida");
                    }
                } while (fallo2);
                menuf1();
            } else if (opcion1 == 3) {
                fallo = false;
                boolean fallo2 = true;
                do {
                    int opcion2 = Integer.parseInt(JOptionPane.showInputDialog("""
                            Selecciona una opción: \

                            1. Generar calendario\

                            2. Salir"""));
                    switch (opcion2) {
                        case 1:

                            fallo2 = false;
                            break;
                        case 2:
                            fallo2 = false;
                            menuf1();
                            break;
                        default:
                            System.out.println("Opción no válida");
                    }
                } while (fallo2);
                menuf1();
            } else if (opcion1 == 4) {
                fallo = false;
                System.exit(0);
            } else {
                System.out.println("Opción no válida");
            }
        }
    }

}