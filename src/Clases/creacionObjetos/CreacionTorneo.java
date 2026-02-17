package Clases.creacionObjetos;

import Clases.Partido;
import Clases.competiciones.Jornada;
import Clases.competiciones.Torneo;
import Clases.equipos.Equipo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreacionTorneo {

    static List<Jornada> jornadasTorneo = new ArrayList<>();

    public static void CrearTorneo(){

        // region IDA

        int numeroJornada = 1;

        LocalDate fechaJornada = LocalDate.of(2025,2,21);

        Jornada jornada = new Jornada(fechaJornada, 1, CreacionJornadas.hacerJornadaPrimeraVez());

        jornadasTorneo.add(jornada);

        fechaJornada = fechaJornada.plusDays(7);

        numeroJornada = numeroJornada + 1;

        int jornadas = CreacionJornadas.equipos.size() - 1;

        for (int i = 1; i < jornadas; i++) {

            jornada = new Jornada(fechaJornada, numeroJornada, CreacionJornadas.hacerJornada());

            jornadasTorneo.add(jornada);

            fechaJornada = fechaJornada.plusDays(7);

            numeroJornada = numeroJornada + 1;

        }

        // HACER LA VUELTA

        int jornadasIda = jornadasTorneo.size();

        for (int i = 0; i < jornadasIda; i++) {

            List<Partido> partidosvuelta = new ArrayList<>();

            numeroJornada = numeroJornada + 1;

            fechaJornada = fechaJornada.plusDays(7);

            Jornada j = jornadasTorneo.get(i);

            for (Partido p : j.getPartidos()) {

                Partido vuelta = new Partido(p.getEquipoVisitante(), p.getEquipoLocal());

                partidosvuelta.add(vuelta);

            }

            jornada = new Jornada(fechaJornada, numeroJornada, partidosvuelta);

            jornadasTorneo.add(jornada);

        }

        Torneo liga = new Torneo(jornadasTorneo, "Premier League");

        for (Jornada j : liga.getJornadas()) {

            for (Partido p : j.getPartidos()) {
                System.out.println(p.getEquipoLocal().getNombre() + " vs " + p.getEquipoVisitante().getNombre());
            }

            System.out.println(); // línea en blanco entre jornadas
        }

    }

}
