package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Equipo {
    private String nombre;
    private List<Jugador> jugadores = new ArrayList<Jugador>();
    private int puntos;
    private int golesFavor;
    private int golesContra;
    private Estadio estadio;
    private Entrenador entrenador;

    private int puntosAtaque;
    private int puntosDefensa;

    public Equipo(){}
    public Equipo(String nombre, Estadio estadio) {
        this.nombre = nombre;
        this.estadio = estadio;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    public void setPuntosDefensa(int puntosDefensa) {
        this.puntosDefensa = puntosDefensa;
    }


    public void agregarJugador(Jugador jugador){
        if(jugadores.size()<5){
            int contador = 0;
            for(int i=0; i<jugadores.size(); i++){
                if(jugadores.get(i).getNombre().equalsIgnoreCase(jugador.getNombre())){
                    contador++;
                }
            }
            if(contador==0){
                jugadores.add(jugador);
                actualizarPuntosEstadisticas();
            }
        }
    }

    public void marcarGoles(int goles){
        Random rand = new Random();
        for (int i = 0; i < goles; i++) {
            golesFavor++;
            int index = rand.nextInt(jugadores.size());
            jugadores.get(index).anotarGol();
        }
    }

    public void recibirGoles(){
        golesContra++;
    }

    public String getPortero() {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getPosicion().equalsIgnoreCase("Portero")) {
                return jugadores.get(i).getNombre();
            }
        }
        return null;
    }

    public void actualizarPuntosEstadisticas(){
        puntosAtaque = 0;
        puntosDefensa = 0;
        for(Jugador jugador : jugadores) {
            switch (jugador.getPersonalidad().toLowerCase()) {
                case "irascible" -> puntosAtaque += 2;
                case "normal" -> {
                    puntosAtaque += 1;
                    puntosDefensa += 1;
                }
                case "calmado" -> puntosDefensa += 2;
            }
        }
    }


    public void getInfo(){
        System.out.println();
        System.out.println(this.getNombre().toUpperCase());
        System.out.println("--------------------------------------------------");
        System.out.println(this.getGolesFavor()+" goles a favor.");
        System.out.println(this.getGolesContra()+" goles en contra");
        System.out.println(this.getPuntos()+" puntos");
        for(Jugador jugador : jugadores){
            jugador.getInfo();
        }
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", jugadores=" + jugadores +
                ", puntos=" + puntos +
                ", golesFavor=" + golesFavor +
                ", golesContra=" + golesContra +
                ", estadio=" + estadio +
                ", entrenador=" + entrenador +
                ", puntosAtaque=" + puntosAtaque +
                ", puntosDefensa=" + puntosDefensa +
                '}';
    }
}
