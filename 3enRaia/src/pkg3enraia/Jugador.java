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
public class Jugador {

    private String nombre,tipoFicha;
    private UI_Juego ui;

    public Jugador(String tipoFicha, String nombre, UI_Juego ui) { //parametros de jugador
        this.tipoFicha = tipoFicha;
        this.nombre = nombre;
        this.ui = ui;
    }

    public Jugador() {
    }

    public String getTipoFicha() {
        return tipoFicha;
    }
                                          // no necesitamos setters porque la ficha y el nombre se indican antes de empezar la partida
    public String getNombre() {
        return nombre;
    }

    public Posicion movimiento(){ //Jugador dice donde quiere mover
        return ui.movimientoUI();
    }     
    
}
