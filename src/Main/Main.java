package Main;

import Clases.*;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        Tienda tienda = new Tienda();

        Estadio estadio1 = new Estadio("Estadio1");
        Estadio estadio2 = new Estadio("eSTADIO2");
        Estadio estadio3 = new Estadio("Estadio3");
        Estadio estadio4 = new Estadio("Estadio4");



        Jugador jugador1 = new Jugador("Juan", 23, "Normal", "Portero",1000);
        Jugador jugador2 = new Jugador("Pablo", 27, "Normal", "otro",1200);
        Jugador jugador3 = new Jugador("Mario", 21, "Irascible", "otro",1000);

        Jugador jugador4 = new Jugador("Jose", 28, "Irascible", "otro",1100);
        Jugador jugador5 = new Jugador("Rubén", 20, "Normal", "otro",1400);
        Jugador jugador6 = new Jugador("Sebas", 25, "Calmado", "Portero",1000);

        Jugador jugador7 = new Jugador("Alejandro", 23, "Calmado", "otro",900);
        Jugador jugador8 = new Jugador("Raúl", 27,"Calmado", "otro",1100);
        Jugador jugador9 = new Jugador("Adrián", 21, "Normal", "Portero",1000);

        Jugador jugador10 = new Jugador("Alvaro", 23, "Normal", "otro",1300);
        Jugador jugador11 = new Jugador("Sergio", 27, "Calmado", "Portero",1000);
        Jugador jugador12 = new Jugador("Daniel", 21,"Irascible", "otro",1000);

        Equipo equipo1 = new Equipo("Equipo1", estadio1);
        Equipo equipo2 = new Equipo("Equipo2", estadio2);
        Equipo equipo3 = new Equipo("Equipo3", estadio3);
        Equipo equipo4 = new Equipo("Equipo4", estadio4);

        equipo1.agregarJugador(jugador1);
        equipo1.agregarJugador(jugador2);
        equipo1.agregarJugador(jugador3);

        equipo2.agregarJugador(jugador4);
        equipo2.agregarJugador(jugador5);
        equipo2.agregarJugador(jugador6);

        equipo3.agregarJugador(jugador7);
        equipo3.agregarJugador(jugador8);
        equipo3.agregarJugador(jugador9);

        equipo4.agregarJugador(jugador10);
        equipo4.agregarJugador(jugador11);
        equipo4.agregarJugador(jugador12);

        Torneo torneo = new Torneo();

        torneo.agregarEquipo(equipo1);
        torneo.agregarEquipo(equipo2);
        torneo.agregarEquipo(equipo3);
        torneo.agregarEquipo(equipo4);

        torneo.generarPartidos();

        torneo.jugarPartidos();

    }
}
