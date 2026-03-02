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
        Tienda tienda = new Tienda();
        Torneo torneo = new Torneo();

        CreacionPersonas.CrearEntrenador();
        CreacionEquipos.CreacionEstadios();
        CreacionEquipos.CreacionEquipos();
        CreacionPersonas.CrearJugadores(tienda);
        CreacionEquipos.RellenarEquipos();
        CreacionPersonas.CrearArbitros();

        Player player = new Player();

        System.out.println(Colores.VERDE_BRILLANTE + Colores.NEGRITA +"¡Bienvenido! Tu equipo inicial:" + Colores.RESET);
        System.out.println(player);

        torneo.setEquipos(CreacionEquipos.getEquipos());

        menu.iniciar(torneo, player, tienda);
    }

}