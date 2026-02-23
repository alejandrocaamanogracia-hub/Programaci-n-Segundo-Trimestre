package Clases.personas;

import Clases.enumeradores.Posiciones;
import Clases.equipos.Equipo;

public class Jugador extends Persona{
    private Posiciones posicion;
    private int golesAnotados;
    private int precio;
    private Equipo equipo;

    public Jugador(String nombre, int edad, String personalidad ,Posiciones posicion, int precio,  Equipo equipo) {
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

    public Posiciones getPosicion() {
        return posicion;
    }

    public void setPosicion(Posiciones posicion) {
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
        return  super.toString() +
                ",  Posicion= " + posicion +
                ",  GolesAnotados= " + golesAnotados +
                ",  Precio= " + precio+"€";
    }
}
