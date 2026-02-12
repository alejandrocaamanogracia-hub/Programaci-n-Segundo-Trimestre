package Clases;

import java.util.Scanner;

public class Menu {

    public void iniciar(Torneo torneo, Player player, Tienda tienda) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("""
                    =====================
                        JUGAR TORNEO
                    =====================
                        1. Continuar
                    """);
            String opcion = sc.nextLine();
            if(opcion.equals("1")){
                torneo.generarPartidos();
                torneo.jugarPartidos();
                tienda.getJugadores().clear();
                for(Equipo equipo : torneo.getEquipos()){
                    tienda.añadirJugadores(equipo.getJugadores());
                }

                tienda.comprarJugador(player);

            }
            else{
                continue;
            }
        }
    }
}
