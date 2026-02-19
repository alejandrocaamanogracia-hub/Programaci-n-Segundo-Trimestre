package Clases;

import Clases.equipos.Equipo;
import Clases.personas.Jugador;

public class Player {
    private int dinero=10000;

    //! EL PLAYER DEBE COMENCAR CON JUGADORES EN EL EQUIPO
    private Equipo equipoPlayer = new Equipo();

    public Player() {}

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public void añadirJugador(Jugador jugador){
        equipoPlayer.agregarJugador(jugador);
    }

    @Override
    public String toString() {
        return "Player{" +
                "dinero=" + dinero +
                ", equipoPlayer=" + equipoPlayer +
                '}';
    }
}
