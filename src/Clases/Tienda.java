package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tienda {
    private List<Jugador> jugadores = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public Tienda(){}

    public void añadirJugadores(List<Jugador> jugadores){
        for(Jugador jugador : jugadores){
            this.jugadores.add(jugador);
        }
    }

d

    public void comprarJugador(Player player){
        //? ¿HACER QUE SOLO SALGAN 8?
        while(true) {
            System.out.println("======TIENDA=====");
            System.out.println("Tu dinero:" + player.getDinero());

            System.out.println("0. Salir");
            for (int i = 0; i < jugadores.size(); i++) {
                System.out.println(i+1 + ". " + jugadores.get(i));
            }

            int opcion;
            while(true) {
                try {
                    opcion = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Opción invalida, introduzca un número");
                }
            }
            opcion -= 1;

            if(opcion == -1){
                System.out.println("Adios");
                break;
            }
            if(opcion<0 || opcion >= jugadores.size()){
                continue;
            }
            else if(jugadores.get(opcion).getPrecio() > player.getDinero()){
                System.out.println("No tienes tanto dinero");
            }
            else{
                player.setDinero(player.getDinero() - jugadores.get(opcion).getPrecio());
                System.out.println("Has comprado a " + jugadores.get(opcion).getNombre());
                player.añadirJugador(jugadores.get(opcion));
                jugadores.remove(opcion);
                System.out.println(player);
            }
        }
    }
}
