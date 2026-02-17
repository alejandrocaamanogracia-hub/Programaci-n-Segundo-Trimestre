package Clases;

import Clases.competiciones.Torneo;
import Clases.creacionObjetos.CreacionEquipos;
import Clases.creacionObjetos.CreacionPersonas;
import Clases.creacionObjetos.CreacionTorneo;
import Clases.equipos.Equipo;

import java.util.Scanner;
import java.util.TooManyListenersException;

public class MenuPruebas {

    public static void Inicio(){

        CreacionPersonas.CrearEntrenador();
        CreacionEquipos.CreacionEstadios();
        CreacionEquipos.CreacionEquipos();
        Tienda tienda = new Tienda();
        CreacionPersonas.CrearJugadores(tienda);
        CreacionEquipos.RellenarEquipos();

        Scanner sc = new Scanner(System.in);

        System.out.println("Hola, bienvenido a la Premier League");
        for (int i = 0; i < CreacionEquipos.getEquipos().size(); i++) {
            System.out.println(i + " " + CreacionEquipos.getEquipos().get(i).getNombre());
        }
        System.out.println("Elige con que equipo vas a participar en la liga");
        int opcion = sc.nextInt();

        Equipo equipo =  CreacionEquipos.getEquipos().get(opcion);

        Player jugador = new Player(equipo);

        CreacionTorneo.CrearTorneo();

    }

}
