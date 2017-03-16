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

    public Jugador(String tipoFicha, String nombre) { //parametros de jugador
        this.tipoFicha = tipoFicha;
        this.nombre = nombre;
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
        int fila, columna;
        
        Scanner sc = new Scanner(System.in);
        System.out.println(getNombre()+" Fila -->");
        fila = sc.nextInt(); //lee la consola
        System.out.println(getNombre()+" Columna -->");       
        columna = sc.nextInt();
        System.out.println("-----------");        
        return new Posicion(fila, columna);        
    }
    
}
