/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3enraia;

/**
 *
 * @author dam1a30
 */
public class UI_Juego {
    
    protected int victoriasA;
    protected int victoriasB;
    protected int empate;
    
    private Jugador jugador;
    
    public UI_Juego() {
        victoriasA=0;
        victoriasB=0;
        empate=0;
    }
    
    public void actualizarMarcador(Jugador j){
        System.out.println("Victorias "+j.getNombre()+": "+victoriasA);
        System.out.println("Victorias IA: "+victoriasB);
        System.out.println("Empates: "+empate);
        System.out.println("-----------");
    }
        
}
