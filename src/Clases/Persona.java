package Clases;

import java.util.Objects;

public class Persona {
    private String nombre;
    private int edad;
    private String personalidad;
    private String dni;

    public Persona(String nombre, int edad, String personalidad, String dni) {
        this.dni = dni;
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

    @Override
    public String toString() {
        return  nombre.toUpperCase() +" => "+
                " Edad= " + edad +
                ",  Personalidad= " + personalidad + '\''
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }
}
