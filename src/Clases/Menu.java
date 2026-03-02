package Clases;

import Clases.competiciones.Torneo;
import Clases.creacionObjetos.CreacionEquipos;
import Clases.creacionObjetos.CreacionPersonas;
import Clases.equipos.Equipo;
import Clases.personas.Jugador;

import javax.swing.plaf.synth.ColorType;
import java.util.*;

public class Menu {

    public void iniciar(Torneo torneo, Player player, Tienda tienda) {
        Scanner sc = new Scanner(System.in);
        int temporada = 1;
        while(true){
            System.out.println();
            System.out.println(Colores.AZUL + Colores.NEGRITA + "╔══════════════════════════════════╗");
            System.out.printf( "║           TEMPORADA %-3d          ║%n", temporada);
            System.out.println("╚══════════════════════════════════╝" + Colores.RESET);
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
                torneo.jugarPartidos(player, tienda, torneo);
                System.out.println();
                System.out.println("¡Temporada " + temporada + " finalizada!");
                System.out.println();

                // Clasificación final de la temporada
                List<Equipo> clasificacion = new ArrayList<>(torneo.getEquipos());
                clasificacion.sort((e1, e2) -> Integer.compare(e2.getPuntos(), e1.getPuntos()));
                System.out.println(Colores.NEGRITA+"--- CLASIFICACIÓN FINAL TEMPORADA " + temporada + " ---" + Colores.RESET);
                int pos = 1;
                for (Equipo e : clasificacion) {
                    System.out.println(pos + ". " + e.getNombre() + ": " + e.getPuntos() + " ptos");
                    pos++;
                }
                System.out.println();

                Jugador pichichi = CreacionPersonas.jugadores.get(0);

                int maxGoles = 0;

                for (Jugador j : CreacionPersonas.jugadores) {
                    if (j.getGolesAnotados() > maxGoles) {
                        maxGoles = j.getGolesAnotados();
                    }
                }

                System.out.println(Colores.AMARILLO_BRILLANTE+"Pichichi(s) con " + maxGoles + " goles:" + Colores.RESET);

                for (Jugador j : CreacionPersonas.jugadores) {
                    if (j.getGolesAnotados() == maxGoles) {
                        System.out.println("- " + j.getNombre()
                                + " (" + j.getEquipo().getNombre() + ")");
                    }
                }

                System.out.println();

                for (int i = 0; i < clasificacion.size(); i++) {
                    if (clasificacion.get(i).getNombre().equalsIgnoreCase("Xtart")) {
                        if (i == 0){
                            player.setDinero(player.getDinero() + 10000);
                            System.out.println(Colores.AMARILLO_BRILLANTE+"Has ganada la liga por lo que se te premia con 10000 €");
                        }else if (i<0 && i>10){
                            player.setDinero(player.getDinero() + 5000);
                            System.out.println(Colores.AZUL+"Has quedado en el top 10 por lo que se te premia con 5000 €");
                        }else {
                            System.out.println("No has logrado entrar en el top 10");
                        }
                    }
                }

                System.out.println();

                while(true) {
                    System.out.println("1. IR A TIENDA (compra rápida)");
                    System.out.println("2. MERCADO DE FICHAJES (cambiar plantilla - fin de temporada)");
                    String opcion1 = sc.nextLine();
                    if (opcion1.equals("1")) {
                        for(Equipo equipo : torneo.getEquipos()){
                            tienda.addJugadores(equipo.getJugadores());
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
