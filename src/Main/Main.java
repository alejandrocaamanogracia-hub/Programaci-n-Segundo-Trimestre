package Main;

import Clases.*;
import Clases.competiciones.Torneo;
import Clases.creacionObjetos.CreacionEquipos;
import Clases.creacionObjetos.CreacionPersonas;
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

        // Asignar 8 jugadores iniciales al player
        List<Clases.personas.Jugador> todosJugadores = CreacionPersonas.getJugadores();
        int jugadoresIniciales = Math.min(8, todosJugadores.size());
        for (int i = 0; i < jugadoresIniciales; i++) {
            player.añadirJugador(todosJugadores.get(i));
        }
        System.out.println("¡Bienvenido! Tu equipo inicial:");
        System.out.println(player);

        torneo.setEquipos(CreacionEquipos.getEquipos());

        menu.iniciar(torneo, player, tienda);
    }
}
