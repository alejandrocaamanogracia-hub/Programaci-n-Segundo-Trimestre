package Main;

import Clases.*;
import Clases.competiciones.Torneo;
import Clases.creacionObjetos.CreacionEquipos;
import Clases.creacionObjetos.CreacionPersonas;
import Clases.equipos.Equipo;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        Player player = new Player();
        Tienda tienda = new Tienda();
        Torneo torneo = new Torneo();

        CreacionPersonas.CrearEntrenador();
        CreacionEquipos.CreacionEstadios();
        CreacionEquipos.CreacionEquipos();
        CreacionPersonas.CrearJugadores(tienda);
        CreacionEquipos.RellenarEquipos();

        // Asignar jugadores iniciales del equipo Xtart al player
        List<Clases.personas.Jugador> todosJugadores = CreacionPersonas.getJugadores();
        for (Clases.personas.Jugador jugador : todosJugadores) {
            if (jugador.getEquipo() != null && jugador.getEquipo().getNombre().equalsIgnoreCase("Xtart")) {
                jugador.setEquipo(player.getEquipoPlayer());
                player.addJugador(jugador);
            }
        }

        System.out.println("¡Bienvenido! Tu equipo inicial:");
        System.out.println(player);

        torneo.setEquipos(CreacionEquipos.getEquipos());

        menu.iniciar(torneo, player, tienda);
    }

}