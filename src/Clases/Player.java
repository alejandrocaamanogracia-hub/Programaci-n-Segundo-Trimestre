package Clases;

public class Player {
    private int dinero=100;
    private Equipo equipoPlayer = new Equipo();

    public Player() {

    }

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
