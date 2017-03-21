/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3enraia;

import java.util.Scanner;

/**
 *
 * @author dam1a30
 */
public class UI_Juego {

    private Sesion sesion;
    private Marcador marcador;
    private Jugador jugador;
    private JugadorIA jugadorIA;
    private Partida partida;
    
    public UI_Juego() {

    }
    //----------------------------Sesión------------------------------
    private String pedirNombre() { //pide el nombre del jugador normal
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del jugador: ");
        return sc.nextLine(); //lee string
    }

    public void iniciarUISesion() {

        System.out.println("|| ES UN 3 EN RAYA CONTRA LA IA ||");
        System.out.println("-----------");
        marcador = new Marcador();
        jugador = new Jugador("|X|", pedirNombre()); // se pasan los parametros que hay en el constructor de jugador
        System.out.println("-----------");

    }

    private static void menu() {
        System.out.println("Introduce la opción deseada");
        System.out.println("-----------");
        System.out.println("1. Nivel ultrafácil");
        System.out.println("2. Nivel menos fácil");
        System.out.println("3. Nivel menos fácil que el anterior");
        System.out.println("4. Nivel 'A ver si puedes ganar XD'");
        System.out.println("5. Nivel '0 probabilidad'");
        System.out.println("6. Salir");
    }

    public void iniciarUIMenu() {
        Scanner sc = new Scanner(System.in);
        boolean salir = true;
        int select;

        menu();
        select = sc.nextInt();
        switch (select) {
            case 1:
                System.out.println("-----------");
                System.out.println("****Las filas y columnas van desde la (0,0) hasta la (2,2)****");
                System.out.println("-----------");
                jugadorIA = new JugadorIA("|O|", "IA"); // se pasan los parametros que hay en el constructor de jugador, nombre IA siempre igual
                partida = new Partida(marcador, jugador, jugadorIA);
                partida.iniciar();
                sesion.iniciarMenu();
                break;
            case 2:
                System.out.println("-----------");
                System.out.println("****Las filas y columnas van desde la (0,0) hasta la (2,2)****");
                System.out.println("-----------");
                jugadorIA = new IA1("|O|", "IA"); // se pasan los parametros que hay en el constructor de jugador, nombre IA siempre igual
                partida = new Partida(marcador, jugador, jugadorIA);
                partida.iniciar();
                sesion.iniciarMenu();
                break;
            case 3:
                System.out.println("-----------");
                System.out.println("****Las filas y columnas van desde la (0,0) hasta la (2,2)****");
                System.out.println("-----------");
                jugadorIA = new IA2("|O|", "IA"); // se pasan los parametros que hay en el constructor de jugador, nombre IA siempre igual
                partida = new Partida(marcador, jugador, jugadorIA);
                partida.iniciar();
                sesion.iniciarMenu();
                break;
            case 4:
                System.out.println("-----------");
                System.out.println("****Las filas y columnas van desde la (0,0) hasta la (2,2)****");
                System.out.println("-----------");
                jugadorIA = new IA3("|O|", "IA"); // se pasan los parametros que hay en el constructor de jugador, nombre IA siempre igual
                partida = new Partida(marcador, jugador, jugadorIA);
                partida.iniciar();
                sesion.iniciarMenu();
                break;
            case 5:
                System.out.println("-----------");
                System.out.println("****Las filas y columnas van desde la (0,0) hasta la (2,2)****");
                System.out.println("-----------");
                jugadorIA = new IA4("|O|", "IA"); // se pasan los parametros que hay en el constructor de jugador, nombre IA siempre igual
                partida = new Partida(marcador, jugador, jugadorIA);
                partida.iniciar();
                sesion.iniciarMenu();
                break;
            case 6:
                salir = false;
                break;
            default:
                System.out.println("-----------");
                System.out.println("Mira bien lo que escribes");
                System.out.println("-----------");
                sesion.iniciarMenu();
                break;
        }
    }
    //----------------------------Marcador------------------------------   
    public void actualizarUIMarcador(Jugador j){
        System.out.println("Victorias "+j.getNombre()+": "+marcador.victoriasA);
        System.out.println("Victorias IA: "+marcador.victoriasB);
        System.out.println("Empates: "+marcador.empate);
        System.out.println("-----------");
    }
    
}

