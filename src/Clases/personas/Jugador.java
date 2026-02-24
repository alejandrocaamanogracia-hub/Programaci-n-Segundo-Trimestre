package Clases.personas;

import Clases.enumeradores.Posiciones;
import Clases.equipos.Equipo;

public class Jugador extends Persona{
    private Posiciones posicion;
    private int golesAnotados;
    private int precio;
    private Equipo equipo;
    private int amarilla;
    private int roja;

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

    public int getAmarilla() { return amarilla; }

    public void setAmarilla(int amarilla) { this.amarilla = amarilla; }

    public int getRoja() { return roja; }

    public void setRoja(int roja) { this.roja = roja; }

    public void anotarGol(){
        this.golesAnotados++;
        System.out.println(this.getNombre()+" ha marcado un gol");
    }

    public void tarjetaAmarilla(){
        this.amarilla++;
        System.out.println(this.getNombre()+" ha hecho una falta dura y el arbitro le ha sacado una tarjeta amarilla.");
    }

    public void tarjetaRoja(){
        this.roja++;
        System.out.println(this.getNombre() + " ha recibido una tarjeta roja y se perderá en proximo partido.");
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
