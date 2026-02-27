package Clases.personas;

import Clases.equipos.Equipo;

public final class Jugador extends Persona{
    private String posicion;
    private int golesAnotados;
    private int precio;
    private Equipo equipo;

    public Jugador(String nombre, int edad, String personalidad ,String posicion, int precio,  Equipo equipo) {
        super(nombre, edad, personalidad);
        this.posicion = posicion;
        this.precio = precio;
        this.equipo = equipo;
    }


    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void anotarGol(){
        this.golesAnotados++;
        System.out.println(this.getNombre()+" ha marcado un gol");
    }

    public void getInfo(){
        System.out.println("--------------------");
        System.out.println(this.getNombre());
        System.out.println(this.getEdad()+" años");
        System.out.println("Posición: "+this.getPosicion());
        System.out.println(this.getGolesAnotados()+" goles");
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "posicion='" + posicion + '\'' +
                ", golesAnotados=" + golesAnotados +
                ", precio=" + precio +
                ", equipo=" + equipo +
                "} " + super.toString();
    }
}
