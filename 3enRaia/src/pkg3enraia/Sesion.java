/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3enraia;

/**
 *
 * @author dam1a26
 */
public class Sesion {

    private Marcador marcador; //se crean los objetos marcador, partida, jugador y jugadorIA.
    private Partida partida;
    private Jugador jugador;
    private JugadorIA jugadorIA;
    private UI_Juego ui;

    public Sesion() {
        ui = new GUI(marcador, jugador);
        iniciarSesion();
        iniciarMenu();
    }

    private void iniciarSesion() {
        ui.warning("|| ES UN 3 EN RAYA CONTRA LA IA ||");
        marcador = new Marcador(ui);
        ui.setMarcador(marcador);
        ui.warning("Introduce el nombre del jugador: ");
        jugador = new Jugador("|X|", ui.pedirNombre(), ui); // se pasan los parametros que hay en el constructor de jugador
        ui.setJugador(jugador);
        ui.warning("-----------");
    }

    private void iniciarMenu() {
        boolean salir = false;
        int select;
        ui.warning("Introduce la opción deseada                           \n-----------\n1. Nivel ultrafácil\n2. Nivel menos fácil\n3. Nivel menos fácil que el anterior\n4. Nivel 'A ver si puedes ganar XD'\n5. Nivel '0 probabilidad'\n6. Salir");
        select = ui.usarMenuUI();
        switch (select) {
            case 1:
                ui.warning("****Las filas y columnas van desde la (0,0) hasta la (2,2)****");
                jugadorIA = new JugadorIA("|O|", "IA", ui); // se pasan los parametros que hay en el constructor de jugador, nombre IA siempre igual
                partida = new Partida(marcador, jugador, jugadorIA, ui);
                partida.iniciar();
                iniciarMenu();            
                break;
            case 2:
                ui.warning("****Las filas y columnas van desde la (0,0) hasta la (2,2)****");
                jugadorIA = new IA1("|O|", "IA", ui); // se pasan los parametros que hay en el constructor de jugador, nombre IA siempre igual
                partida = new Partida(marcador, jugador, jugadorIA, ui);
                partida.iniciar();
                iniciarMenu();
                break;
            case 3:
                ui.warning("****Las filas y columnas van desde la (0,0) hasta la (2,2)****");
                jugadorIA = new IA2("|O|", "IA", ui); // se pasan los parametros que hay en el constructor de jugador, nombre IA siempre igual
                partida = new Partida(marcador, jugador, jugadorIA, ui);
                partida.iniciar();
                iniciarMenu();
                break;
            case 4:
                ui.warning("****Las filas y columnas van desde la (0,0) hasta la (2,2)****");
                jugadorIA = new IA3("|O|", "IA", ui); // se pasan los parametros que hay en el constructor de jugador, nombre IA siempre igual
                partida = new Partida(marcador, jugador, jugadorIA, ui);
                partida.iniciar();
                iniciarMenu();
                break;
            case 5:
                ui.warning("****Las filas y columnas van desde la (0,0) hasta la (2,2)****");
                jugadorIA = new IA4("|O|", "IA", ui); // se pasan los parametros que hay en el constructor de jugador, nombre IA siempre igual
                partida = new Partida(marcador, jugador, jugadorIA, ui);
                partida.iniciar();
                iniciarMenu();
                break;
            case 6:
                salir = true;
                break;
            default:
                ui.warning("Mira bien lo que escribes");
                iniciarMenu();
                break;
        }
    }
}
