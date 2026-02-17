package Clases;

import Clases.competiciones.Torneo;
import Clases.equipos.Equipo;

import java.util.*;

public class Menu {

//    public void iniciar(Torneo torneo, Player player, Tienda tienda) {
//        Scanner sc = new Scanner(System.in);
//        while(true){
//            System.out.println("""
//                    =====================
//                        JUGAR TORNEO
//                    =====================
//                        1. Continuar
//                        2. Ver info de equipos
//                        3. Ver clasificación
//                    """);
//            String opcion = sc.nextLine();
//            if(opcion.equals("1")){
//                torneo.generarPartidos();
//                torneo.jugarPartidos();
//                System.out.println();
//                while(true) {
//                    System.out.println("1. IR A TIENDA");
//                    String opcion1 = sc.nextLine();
//                    if (opcion1.equals("1")) {
//                        break;
//                    }
//                }
//                for(Equipo equipo : torneo.getEquipos()){
//                    tienda.añadirJugadores(equipo.getJugadores());
//                }
//
//                tienda.comprarJugador(player);
//            }
//            else if(opcion.equals("2")){
//                for(Equipo equipo : torneo.getEquipos()){
//                    equipo.getInfo();
//                }
//            }
//            else if(opcion.equals("3")){
//                List<Equipo> provisional = new ArrayList<Equipo>();
//                provisional.addAll(torneo.getEquipos());
//
//                provisional.sort((e1, e2) -> Integer.compare(e2.getPuntos(), e1.getPuntos()));
//
//                int i = 1;
//                for(Equipo equipo : provisional){
//                    System.out.println(i+". "+equipo.getNombre()+": "+equipo.getPuntos()+"ptos");
//                    i++;
//                }
//
//            }
//            else{
//                continue;
//            }
//        }
//    }
}
