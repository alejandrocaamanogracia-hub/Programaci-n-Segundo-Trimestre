package Clases.personas;

public final class Arbitro extends Persona {

    Arbitro() {}

    public Arbitro(String nombre, int edad, String personalidad) {
        super(nombre, edad, personalidad);
    }

    @Override
    public void saludar(){
        System.out.println("Buenas, soy el arbitro " + getNombre() + " y voy a arbitrar este partido.");
    }

}
