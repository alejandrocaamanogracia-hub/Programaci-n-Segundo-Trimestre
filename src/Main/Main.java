package Main;

import Clases.*;
import Clases.competiciones.Torneo;
import Clases.creacionObjetos.CreacionEquipos;
import Clases.creacionObjetos.CreacionPersonas;
import Clases.equipos.Equipo;
import Clases.equipos.Estadio;
import Clases.personas.Jugador;

public class Main {
    public static void main(String[] args) {

        CreacionPersonas.CrearEntrenador();
        CreacionEquipos.CreacionEstadios();
        CreacionEquipos.CreacionEquipos();
        CreacionPersonas.CrearJugadores();

        CreacionEquipos.RellenarEquipos();

        System.out.println(CreacionEquipos.getEquipos());
        System.out.println(CreacionEquipos.getEstadios());

        System.out.println(CreacionPersonas.getEntrenadores());
        System.out.println(CreacionPersonas.getJugadores());


        Menu menu = new Menu();
        Player player = new Player();
        Tienda tienda = new Tienda();
        Torneo torneo = new Torneo();
        menu.iniciar(torneo, player, tienda);
    }
}
