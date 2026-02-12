package Clases;

public class Jugador extends Persona{
    private String posicion;
    private int golesAnotados;
    private int precio;

    public Jugador(String nombre, int edad, String personalidad,  String posicion, int precio) {
        super(nombre, edad, personalidad);
        this.posicion = posicion;
        this.precio = precio;
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
