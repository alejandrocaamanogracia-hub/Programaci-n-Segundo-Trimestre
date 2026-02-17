package Clases.creacionObjetos;

import Clases.Partido;
import Clases.equipos.Equipo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreacionJornadas {

    static List<Partido> partidos = new ArrayList<>();
    static List<Equipo> equipos = new ArrayList<>();

    public static List<Partido> hacerJornadaPrimeraVez(){

        equipos = new ArrayList<>(CreacionEquipos.equipos);

        Collections.shuffle(equipos);

        for(int i = 0; i < equipos.size()/2; i++){

            partidos.add(new Partido(equipos.get(i), equipos.get(equipos.size()-i-1)));

        }

        Equipo ultimo = equipos.remove(equipos.size() - 1);
        equipos.add(1, ultimo);

        return partidos;

    }

    public static List<Partido> hacerJornada(){

        partidos.clear();

        for(int i = 0; i < equipos.size()/2; i++){

            partidos.add(new Partido(equipos.get(i), equipos.get(equipos.size()-i-1)));

        }

        Equipo ultimo = equipos.remove(equipos.size() - 1);
        equipos.add(1, ultimo);

        return partidos;

    }

}
