package Clases;

import Clases.equipos.Equipo;
import Clases.personas.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tienda {
    private List<Jugador> jugadores = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public Tienda(){}

    public void addJugadores(List<Jugador> jugadores){
        this.jugadores.addAll(jugadores);
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void add(Jugador jugador){
        this.jugadores.add(jugador);
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /** CAMBIAR PLANTILLA */
    public void cambiarPlantilla(Player player, List<Equipo> equipos) {
        this.jugadores.clear();

        java.util.Random rand = new java.util.Random();
        for (Equipo equipo : equipos) {
            List<Jugador> plantilla = equipo.getJugadores();
            if (plantilla.size() > 2) {
                int numLiberar = 1 + rand.nextInt(2);
                for (int i = 0; i < numLiberar; i++) {
                    int idx = rand.nextInt(plantilla.size());
                    Jugador liberado = plantilla.get(idx);
                    this.jugadores.add(liberado);
                    plantilla.remove(idx);
                }
            }
        }

        while (true) {
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║                                  ║");
            System.out.println("║       MERCADO DE FICHAJES        ║");
            System.out.println("║                                  ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.println("Dinero disponible: " + player.getDinero() + "€");
            System.out.println("0. Salir del mercado");
            System.out.println("1. Ver plantilla actual y liberar jugadores");
            System.out.println("2. Fichar jugadores del mercado (" + this.jugadores.size() + " disponibles)");

            int opcion;
            while (true) {
                try {
                    opcion = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Opción inválida, introduce un número");
                }
            }

            if (opcion == 0) {
                System.out.println("Saliendo del mercado...");
                break;
            } else if (opcion == 1) {
                List<Jugador> plantillaPlayer = player.getJugadores();
                if (plantillaPlayer.isEmpty()) {
                    System.out.println("Tu equipo no tiene jugadores.");
                } else {
                    System.out.println("--- TU PLANTILLA ---");
                    for (int i = 0; i < plantillaPlayer.size(); i++) {
                        System.out.println((i + 1) + ". " + plantillaPlayer.get(i));
                    }
                    System.out.println("0. Volver");
                    System.out.println("Elige un jugador para liberarlo (50% de su valor):");

                    int opLiberar;
                    while (true) {
                        try {
                            opLiberar = Integer.parseInt(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Opción inválida");
                        }
                    }

                    if (opLiberar == 0) continue;
                    if (opLiberar < 1 || opLiberar > plantillaPlayer.size()) {
                        System.out.println("Opción fuera de rango");
                        continue;
                    }

                    Jugador liberado = plantillaPlayer.get(opLiberar - 1);
                    int reembolso = liberado.getPrecio() / 2;
                    player.setDinero(player.getDinero() + reembolso);
                    this.jugadores.add(liberado);
                    plantillaPlayer.remove(opLiberar - 1);
                    System.out.println("Has liberado a " + liberado.getNombre() + ". Recibes " + reembolso + "€.");
                }
            } else if (opcion == 2) {
                if (this.jugadores.isEmpty()) {
                    System.out.println("No hay jugadores disponibles en el mercado.");
                    continue;
                }

                System.out.println("--- MERCADO DE JUGADORES ---");
                System.out.println("0. Volver");
                for (int i = 0; i < this.jugadores.size(); i++) {
                    System.out.println((i + 1) + ". " + this.jugadores.get(i));
                }

                int opFichar;
                while (true) {
                    try {
                        opFichar = Integer.parseInt(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Opción inválida");
                    }
                }

                if (opFichar == 0) continue;
                if (opFichar < 1 || opFichar > this.jugadores.size()) {
                    System.out.println("Opción fuera de rango");
                    continue;
                }

                Jugador elegido = this.jugadores.get(opFichar - 1);
                if (elegido.getPrecio() > player.getDinero()) {
                    System.out.println("No tienes suficiente dinero. Necesitas " + elegido.getPrecio() + "€.");
                } else {
                    player.setDinero(player.getDinero() - elegido.getPrecio());
                    player.addJugador(elegido);
                    this.jugadores.remove(opFichar - 1);
                    System.out.println("¡Has fichado a " + elegido.getNombre() + " por " + elegido.getPrecio() + "€!");
                    System.out.println("Dinero restante: " + player.getDinero() + "€");
                }
            } else {
                System.out.println("Opción inválida");
            }
        }
    }

    public void comprarJugador(Player player){
        while(true) {
            System.out.println("\n======TIENDA=====");
            System.out.println("Tu dinero: " + player.getDinero() + "€");
            System.out.println("0. Salir");
            for (int i = 0; i < this.jugadores.size(); i++) {
                System.out.println((i+1) + ". " + jugadores.get(i));
            }

            int opcion;
            while(true) {
                try {
                    opcion = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Opción inválida, introduce un nº");
                }
            }
            opcion -= 1;

            if(opcion == -1) break;
            if(opcion < 0 || opcion >= jugadores.size()) continue;

            Jugador seleccionado = jugadores.get(opcion);
            if(seleccionado.getPrecio() > player.getDinero()){
                System.out.println("No tienes dinero suficiente");
            } else {
                player.setDinero(player.getDinero() - seleccionado.getPrecio());
                System.out.println("Has comprado a " + seleccionado.getNombre());
                player.addJugador(seleccionado);
                jugadores.remove(opcion);
                System.out.println(player);
                break;
            }
        }
        this.jugadores.clear();
    }
}
