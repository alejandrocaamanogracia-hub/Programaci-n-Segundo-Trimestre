package Clases;

import Clases.equipos.Equipo;
import Clases.personas.Arbitro;

import java.util.Random;

import static Clases.creacionObjetos.CreacionPersonas.arbitros;

public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesLocal;
    private int golesVisitante;
    private boolean jugado;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante){
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public boolean isJugado() {
        return jugado;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public void jugarPartido(){
        Random rand = new Random();
        int numGoles = rand.nextInt(7);

        if(!jugado){
            System.out.println("\n");
            System.out.println("PARTIDO "+equipoLocal.getNombre()+" VS "+equipoVisitante.getNombre());
            System.out.println("UBICACIÓN: "+equipoLocal.getEstadio().getNombre());
            Arbitro arbitro = asignarArbitro();
            arbitro.saludar();
            System.out.println("----------------------");
            //sleep();
            if(numGoles!=0) {
                for (int i = 0; i < numGoles; i++) {
                    int equipo = rand.nextInt(1, 3);
                    int eleccion = rand.nextInt(1, 4);

                    if (equipo == 1) {
                        if (eleccion == 1) {
                            if (equipoLocal.getPuntosAtaque() > equipoVisitante.getPuntosDefensa()) {
                                golesLocal++;
                                this.equipoLocal.marcarGoles(1);
                                this.equipoVisitante.recibirGoles();
                                this.equipoVisitante.hacerFalta();
                            } else {
                                System.out.println(this.equipoVisitante.getPortero() + " ha hecho una parada.");
                            }
                        }
                        else {
                            golesLocal++;
                            this.equipoLocal.marcarGoles(1);
                            this.equipoVisitante.recibirGoles();
                            this.equipoVisitante.hacerFalta();
                        }
                    }
                    else {
                        if (eleccion == 1) {
                            if (equipoLocal.getPuntosDefensa() < equipoVisitante.getPuntosAtaque()) {
                                golesVisitante++;
                                this.equipoVisitante.marcarGoles(1);
                                this.equipoLocal.recibirGoles();
                                this.equipoLocal.hacerFalta();
                            } else {
                                System.out.println(this.equipoLocal.getPortero() + " ha hecho una parada.");
                            }
                        }
                        else {
                            golesVisitante++;
                            this.equipoVisitante.marcarGoles(1);
                            this.equipoLocal.recibirGoles();
                            this.equipoLocal.hacerFalta();
                        }
                    }
                    //sleep();
                }
            }
            getResultado();
            jugado = true;
            System.out.println("----------------------");
        }
    }

    public void getResultado(){
        if(golesLocal>golesVisitante){
            equipoLocal.setPuntos(equipoLocal.getPuntos() + 3);
        }
        else if(golesVisitante>golesLocal){
            equipoVisitante.setPuntos(equipoVisitante.getPuntos() + 3);
        }
        else {
            equipoLocal.setPuntos(equipoLocal.getPuntos() + 1);
            equipoVisitante.setPuntos(equipoVisitante.getPuntos() + 1);
        }
    }

    public Arbitro asignarArbitro(){

        Random r = new Random();

        int random =  r.nextInt(arbitros.size());

        return arbitros.get(random);

    }

    @Override
    public String toString() {

        String resultado;

        if (golesLocal > golesVisitante) {

            resultado = "Ganador: " + equipoLocal.getNombre() + "\n";

        } else if (golesVisitante > golesLocal) {

            resultado = "Ganador: " + equipoVisitante.getNombre() + "\n";

        } else {

            resultado = "Empate\n";
        }

        return resultado +
                equipoLocal.getNombre() + " " + golesLocal
                + " - " +
                golesVisitante + " " + equipoVisitante.getNombre();
    }
}
