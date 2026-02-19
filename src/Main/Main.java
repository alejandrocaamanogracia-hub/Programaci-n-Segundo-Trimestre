package Main;

import Clases.*;
import Clases.competiciones.Torneo;
import Clases.creacionObjetos.CreacionEquipos;
import Clases.creacionObjetos.CreacionPersonas;

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


        torneo.setEquipos(CreacionEquipos.getEquipos());

        menu.iniciar(torneo, player, tienda);

    }

}
