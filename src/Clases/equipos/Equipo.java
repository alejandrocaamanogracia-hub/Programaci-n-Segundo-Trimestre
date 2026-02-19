package Clases.equipos;

import Clases.personas.Entrenador;
import Clases.personas.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    public Equipo(String nombre){
        this.nombre = nombre;
    }
    public Equipo(String nombre, Estadio estadio) {
        this.nombre = nombre;
        this.estadio = estadio;
    }

    public Equipo(String nombre, Estadio estadio, Entrenador entrenador) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.entrenador = entrenador;
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
        jugadores.add(jugador);
    }

    public void marcarGoles(int goles){
        Random rand = new Random();
        for (int i = 0; i < goles; i++) {
            golesFavor++;
            if(jugadores.size()>0) {
                int index = rand.nextInt(jugadores.size());
                jugadores.get(index).anotarGol();
            }
            else{
                System.out.println("NO FUNCIONA");
                System.out.println(this);
            }
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return Objects.equals(nombre, equipo.nombre) && Objects.equals(jugadores, equipo.jugadores) && Objects.equals(estadio, equipo.estadio) && Objects.equals(entrenador, equipo.entrenador);
    }
}
