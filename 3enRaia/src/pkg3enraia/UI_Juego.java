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

    protected Marcador marcador;
    protected Jugador jugador;

    public UI_Juego(Marcador marcador, Jugador jugador) {

    }

    public void setMarcador(Marcador m) {
        this.marcador = m;
    }
    
    public void setJugador (Jugador j){
        this.jugador = j;
    }
    //------------------------------------
    
    public void warning(String mensaje) {
        System.out.println(mensaje);
    }

    public String pedirNombre() { //pide el nombre del jugador normal
        Scanner sc = new Scanner(System.in);
        return sc.nextLine(); //lee string
    }

    public int usarMenuUI() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    //------------------------------------
    
    public void estadoPartida(boolean fin){
        if(!fin){
            System.out.println("En curso\n-----------");
        }else{
            System.out.println("Finalizada\n-----------");
        }
    }
     
    public void ponerFichaUI(String f, Posicion p, String c[][]) {
        c[p.getFila()][p.getColumna()] = f;

    }

    public void actualizarMarcadorUI(Jugador j) {
        System.out.println("Victorias " + j.getNombre() + ": " + marcador.getVictoriasA());
        System.out.println("Victorias IA: " + marcador.getVictoriasB());
        System.out.println("Empates: " + marcador.getEmpate());
        System.out.println("-----------");
    }
    //------------------------------------
    
    public Posicion movimientoUI() {
        int fila, columna;

        Scanner sc = new Scanner(System.in);
        System.out.println(jugador.getNombre() + " Fila -->");
        fila = sc.nextInt(); //lee la consola
        System.out.println(jugador.getNombre() + " Columna -->");
        columna = sc.nextInt();
        warning("-----------");
        return new Posicion(fila, columna);
    }

}
