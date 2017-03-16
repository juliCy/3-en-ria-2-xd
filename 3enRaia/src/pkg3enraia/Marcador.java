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
public class Marcador {
    
    protected int victoriasA;
    protected int victoriasB;
    protected int empate;
    protected UI_Juego ui;
    
    public Marcador() {
         this.ui = new UI_Juego();
    }

    public int getVictoriasA() {
        return victoriasA;
    }

    public int getVictoriasB() {
        return victoriasB;
    }
    
    public void mostrar(){ //Muestra el marcador actual por consola.
        ui.actualizarMarcador();
    }
    
    public void incrementarA(){ //Incrementa el marcador cada vez que termina una partida.
        victoriasA++;
    }
    
    public void incrementarB(){ //Incrementa el marcador cada vez que termina una partida.
        victoriasB++;
    }
    
    public void empatar(){ //Veriica si se completa el tablero y nadie ha ganado. Incrementa el marcador de empates
        empate++;
    }
}