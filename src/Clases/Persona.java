package Clases;

public class Persona {
    private String nombre;
    private int edad;
    private String personalidad;

    public Persona(String nombre, int edad, String personalidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.personalidad = personalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPersonalidad() {
        return personalidad;
    }

    public void setPersonalidad(String personalidad) {
        this.personalidad = personalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
