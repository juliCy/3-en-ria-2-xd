/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3enraia;

import java.util.Scanner;

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
        ui = new UI_Juego();
        iniciarSesion();
        iniciarMenu();
        marcador = new Marcador();
        partida = new Partida(marcador, jugador, jugadorIA);        
    }
    
    private void iniciarSesion(){
        ui.iniciarUISesion();         
    }
    
    public void iniciarMenu() {
        ui.iniciarUIMenu();                    
    }
    
}