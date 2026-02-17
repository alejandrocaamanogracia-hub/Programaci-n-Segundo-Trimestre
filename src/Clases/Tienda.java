package Clases;

import Clases.personas.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void añadir(Jugador jugador){
        this.jugadores.add(jugador);
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void comprarJugador(Player player){
        //? ¿HACER QUE SOLO SALGAN 8?
        while(true) {
            System.out.println();
            System.out.println("======TIENDA=====");
            System.out.println("Tu dinero:" + player.getDinero());

            System.out.println("0. Salir");

            List numeros = new ArrayList();
            Random random = new Random();
            int aleatorio = 0;

            for (int i = 0; i< 7; i++) {

                do{
                    aleatorio = random.nextInt(this.jugadores.size());
                }while(numeros.contains(aleatorio));

                numeros.add(aleatorio);

            }

            for (int i = 0; i < numeros.size(); i++) {
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

//            if(opcion == -1){
//                break;
//            }
//            if(opcion<0 || opcion >= jugadores.size()){
//                continue;
//            }
//            else if(jugadores.get(opcion).getPrecio() > player.getDinero()){
//                System.out.println("No tienes tanto dinero");
//            }
//            else{
//                player.setDinero(player.getDinero() - jugadores.get(opcion).getPrecio());
//                System.out.println("Has comprado a " + jugadores.get(opcion).getNombre());
//                player.añadirJugador(jugadores.get(opcion));
//                jugadores.remove(opcion);
//                System.out.println(player);
//                break;
//            }
        }
//        this.jugadores.clear();
    }
}
