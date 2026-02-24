package Clases;

import Clases.equipos.Equipo;
import Clases.personas.Jugador;

import java.util.List;

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

    public List<Jugador> getJugadores() {
        return equipoPlayer.getJugadores();
    }

    public Equipo getEquipoPlayer() {
        return equipoPlayer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔══════════════════════════════════╗\n");
        sb.append("║         MI EQUIPO                ║\n");
        sb.append("╚══════════════════════════════════╝\n");
        sb.append("Dinero: ").append(dinero).append("€\n");
        sb.append("Jugadores (").append(equipoPlayer.getJugadores().size()).append("):\n");
        sb.append("----------------------------------\n");

        if (equipoPlayer.getJugadores().isEmpty()) {
            sb.append("  Sin jugadores en el equipo.\n");
        } else {
            int i = 1;
            for (Clases.personas.Jugador j : equipoPlayer.getJugadores()) {
                sb.append("  ").append(i).append(". ").append(j.getNombre().toUpperCase())
                  .append(" | ").append(j.getPosicion())
                  .append(" | ").append(j.getEdad()).append(" años")
                  .append(" | ").append(j.getPrecio()).append("€")
                  .append(" | Goles: ").append(j.getGolesAnotados()).append("\n");
                i++;
            }
        }

        sb.append("----------------------------------");
        return sb.toString();
    }
}
