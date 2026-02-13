package Clases;

import java.util.ArrayList;
import java.util.List;

public class Torneo {
    private List<Equipo> equipos = new ArrayList<Equipo>();
    private List<Partido> partidos = new  ArrayList<Partido>();

    public Torneo(){}

    public void agregarEquipo(Equipo equipo){
        equipos.add(equipo);
    }

    public void generarPartidos(){
        partidos.clear();
        for(int i=0;i<equipos.size();i++){
            for(int j=0;j<equipos.size();j++){
                if(!equipos.get(i).getNombre().equals(equipos.get(j).getNombre())) {
                    if (i < j) {
                        partidos.add(new Partido(equipos.get(i), equipos.get(j)));
                        partidos.add(new Partido(equipos.get(j), equipos.get(i)));
                    }
                }
            }
        }
    }

    public void jugarPartidos(){
        for (int i = 0; i < partidos.size(); i++) {
            Partido partido = partidos.get(i);
            partido.jugarPartido();
        }
    }
}
