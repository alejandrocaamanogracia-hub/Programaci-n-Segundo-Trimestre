package Clases;

public class Jugador extends Persona{
    private String posicion;
    private int golesAnotados;

    public Jugador(String nombre, int edad, String personalidad,  String posicion) {
        super(nombre, edad, personalidad);
        this.posicion = posicion;
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
}
