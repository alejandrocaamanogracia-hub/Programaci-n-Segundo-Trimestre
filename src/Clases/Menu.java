package Clases;

import Clases.competiciones.Torneo;
import Clases.equipos.Equipo;

import java.util.*;

public class Menu {

    public void iniciar(Torneo torneo, Player player, Tienda tienda) {
        Scanner sc = new Scanner(System.in);
        int temporada = 1;
        while(true){
            System.out.println();
            System.out.println("╔══════════════════════════════════╗");
            System.out.printf( "║        TEMPORADA %-3d             ║%n", temporada);
            System.out.println("╚══════════════════════════════════╝");
            System.out.println("""
                    =====================
                        JUGAR TORNEO
                    =====================
                        1. Continuar
                        2. Ver info de equipos
                        3. Ver clasificación
                    """);
            String opcion = sc.nextLine();
            if(opcion.equals("1")){
                torneo.generarPartidos();
                torneo.jugarPartidos();
                System.out.println();
                System.out.println("¡Temporada " + temporada + " finalizada!");
                System.out.println();

                // Clasificación final de la temporada
                List<Equipo> clasificacion = new ArrayList<>(torneo.getEquipos());
                clasificacion.sort((e1, e2) -> Integer.compare(e2.getPuntos(), e1.getPuntos()));
                System.out.println("--- CLASIFICACIÓN FINAL TEMPORADA " + temporada + " ---");
                int pos = 1;
                for (Equipo e : clasificacion) {
                    System.out.println(pos + ". " + e.getNombre() + ": " + e.getPuntos() + " ptos");
                    pos++;
                }
                System.out.println();

                while(true) {
                    System.out.println("1. IR A TIENDA (compra rápida)");
                    System.out.println("2. MERCADO DE FICHAJES (cambiar plantilla - fin de temporada)");
                    String opcion1 = sc.nextLine();
                    if (opcion1.equals("1")) {
                        for(Equipo equipo : torneo.getEquipos()){
                            tienda.añadirJugadores(equipo.getJugadores());
                        }
                        tienda.comprarJugador(player);
                        break;
                    } else if (opcion1.equals("2")) {
                        tienda.cambiarPlantilla(player, torneo.getEquipos());
                        break;
                    }
                }

                // Reiniciar puntos para la siguiente temporada
                for (Equipo equipo : torneo.getEquipos()) {
                    equipo.setPuntos(0);
                    equipo.setGolesFavor(0);
                    equipo.setGolesContra(0);
                }
                temporada++;
            }
            else if(opcion.equals("2")){
                for(Equipo equipo : torneo.getEquipos()){
                    equipo.getInfo();
                }
            }
            else if(opcion.equals("3")){
                List<Equipo> provisional = new ArrayList<Equipo>();
                provisional.addAll(torneo.getEquipos());

                provisional.sort((e1, e2) -> Integer.compare(e2.getPuntos(), e1.getPuntos()));

                int i = 1;
                for(Equipo equipo : provisional){
                    System.out.println(i+". "+equipo.getNombre()+": "+equipo.getPuntos()+"ptos");
                    i++;
                }

            }
            else{
                continue;
            }
        }
    }
}
