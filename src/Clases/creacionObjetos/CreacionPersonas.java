package Clases.creacionObjetos;

import Clases.equipos.Equipo;
import Clases.equipos.Estadio;
import Clases.personas.Entrenador;
import Clases.personas.Jugador;
import Clases.personas.Persona;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CreacionPersonas {

    protected static List<Entrenador> entrenadores = new ArrayList<Entrenador>();
    protected static List<Jugador>  jugadores = new ArrayList<Jugador>();

    public static List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public static List<Jugador> getJugadores() {
        return jugadores;
    }

    public static void CrearEntrenador(){

        try{

            InputStream lectura = CreacionPersonas.class.getResourceAsStream("/datos/entrenadores.txt");

            BufferedReader br = new BufferedReader(new InputStreamReader(lectura));

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] informacion = linea.split(",");

                String nombre = informacion[0];
                int edad =  Integer.parseInt(informacion[1]);
                String personalidad = informacion[2];


                entrenadores.add(new Entrenador(nombre, edad, personalidad));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void CrearJugadores(){

        try{

            InputStream lectura = CreacionPersonas.class.getResourceAsStream("/datos/jugadores.txt");

            BufferedReader br = new BufferedReader(new InputStreamReader(lectura));

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] informacion = linea.split(",");

                String nombre = informacion[0];
                int edad =  Integer.parseInt(informacion[1]);
                String personalidad = informacion[2];
                String posicion = informacion[3];
                int precio = Integer.parseInt(informacion[4]);
                String equipo = informacion[5];

                List<Equipo> equipos = CreacionEquipos.equipos;

                Equipo equipoJugador = null;

                for (int i  = 0; i < equipos.size(); i++) {
                    if (equipos.get(i).getNombre().equals(equipo)) {
                        equipoJugador = (Equipo) equipos.get(i);
                    }
                }

                jugadores.add(new Jugador(nombre, edad, personalidad,posicion, precio, equipoJugador));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

