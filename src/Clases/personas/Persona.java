package Clases.personas;

public abstract class Persona {
    private String nombre;
    private int edad;
    private String personalidad;
    private String dni;

    public Persona() {}

    public Persona(String nombre, int edad, String personalidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.personalidad = personalidad;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null) {
            this.nombre = nombre;
        }
    }

    public String getPersonalidad() {
        return personalidad;
    }

    public void setPersonalidad(String personalidad) {
        if (personalidad != null) {
            this.personalidad = personalidad;
        }
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
}
