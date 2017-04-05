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
public class IA2 extends IA1 {
    
    public IA2(String tipoFicha, String nombre, UI_Juego ui) {      
        super(tipoFicha, nombre, ui);
    }

    public IA2() {
    }
    
    @Override
    public Posicion movimiento(){
        if(movimientoGanar() !=null){
            return this.movimientoGanar();
        }
        return super.movimientoEstrategico();
    }
    
    public Posicion movimientoGanar() {
                             
        if (tablero.consultar(new Posicion(0, 0)).equals("|O|") && tablero.consultar(new Posicion(0, 1)).equals("|O|") && tablero.consultar(new Posicion(0, 2)).equals("|-|")) {
           
            return new Posicion(0, 2); 
        }
        if (tablero.consultar(new Posicion(0, 0)).equals("|O|") && tablero.consultar(new Posicion(0, 2)).equals("|O|") && tablero.consultar(new Posicion(0, 1)).equals("|-|")) {
           
            return new Posicion(0, 1);
        }
        if (tablero.consultar(new Posicion(0, 1)).equals("|O|") && tablero.consultar(new Posicion(0, 2)).equals("|O|") && tablero.consultar(new Posicion(0, 0)).equals("|-|")) {
            
            return new Posicion(0, 0);
        }
        //--------------fila 1
        if (tablero.consultar(new Posicion(1, 0)).equals("|O|") && tablero.consultar(new Posicion(1, 1)).equals("|O|") && tablero.consultar(new Posicion(1, 2)).equals("|-|")) {
            
            return new Posicion(1, 2);
        }
        if (tablero.consultar(new Posicion(1, 0)).equals("|O|") && tablero.consultar(new Posicion(1, 2)).equals("|O|") && tablero.consultar(new Posicion(1, 1)).equals("|-|")) {
            
            return new Posicion(1, 1);
        }
        if (tablero.consultar(new Posicion(1, 1)).equals("|O|") && tablero.consultar(new Posicion(1, 2)).equals("|O|") && tablero.consultar(new Posicion(1, 0)).equals("|-|")) {
            
            return new Posicion(1, 0);
        }
        //--------------fila 2
        if (tablero.consultar(new Posicion(2, 0)).equals("|O|") && tablero.consultar(new Posicion(2, 1)).equals("|O|") && tablero.consultar(new Posicion(2, 2)).equals("|-|")) {
            
            return new Posicion(2, 2);
        }
        if (tablero.consultar(new Posicion(2, 0)).equals("|O|") && tablero.consultar(new Posicion(2, 2)).equals("|O|") && tablero.consultar(new Posicion(2, 1)).equals("|-|")) {
            
            return new Posicion(2, 1);
        }
        if (tablero.consultar(new Posicion(2, 1)).equals("|O|") && tablero.consultar(new Posicion(2, 2)).equals("|O|") && tablero.consultar(new Posicion(2, 0)).equals("|-|")) {
            
            return new Posicion(2, 0);
        }
        //--------------columna
        if (tablero.consultar(new Posicion(0, 0)).equals("|O|") && tablero.consultar(new Posicion(2, 0)).equals("|O|") && tablero.consultar(new Posicion(1, 0)).equals("|-|")) {
            
            return new Posicion(1, 0);
        }
        if (tablero.consultar(new Posicion(0, 0)).equals("|O|") && tablero.consultar(new Posicion(1, 0)).equals("|O|") && tablero.consultar(new Posicion(2, 0)).equals("|-|")) {
           
            return new Posicion(2, 0);
        }
        if (tablero.consultar(new Posicion(2, 0)).equals("|O|") && tablero.consultar(new Posicion(1, 0)).equals("|O|") && tablero.consultar(new Posicion(0, 0)).equals("|-|")) {
            
            return new Posicion(0, 0);
        }
        //--------------columna 1
        if (tablero.consultar(new Posicion(0, 1)).equals("|O|") && tablero.consultar(new Posicion(2, 1)).equals("|O|") && tablero.consultar(new Posicion(1, 1)).equals("|-|")) {
            
            return new Posicion(1, 1);
        }
        if (tablero.consultar(new Posicion(0, 1)).equals("|O|") && tablero.consultar(new Posicion(1, 1)).equals("|O|") && tablero.consultar(new Posicion(2, 1)).equals("|-|")) {
            
            return new Posicion(2, 1);
        }
        if (tablero.consultar(new Posicion(1, 1)).equals("|O|") && tablero.consultar(new Posicion(2, 1)).equals("|O|") && tablero.consultar(new Posicion(0, 1)).equals("|-|")) {
            
            return new Posicion(0, 1);
        }
        //--------------columna 2
        if (tablero.consultar(new Posicion(0, 2)).equals("|O|") && tablero.consultar(new Posicion(2, 2)).equals("|O|") && tablero.consultar(new Posicion(1, 2)).equals("|-|")) {
           
            return new Posicion(1, 2);
        }
        if (tablero.consultar(new Posicion(0, 2)).equals("|O|") && tablero.consultar(new Posicion(1, 2)).equals("|O|") && tablero.consultar(new Posicion(2, 2)).equals("|-|")) {
            
            return new Posicion(2, 2);
        }
        if (tablero.consultar(new Posicion(1, 2)).equals("|O|") && tablero.consultar(new Posicion(2, 2)).equals("|O|") && tablero.consultar(new Posicion(0, 2)).equals("|-|")) {
            
            return new Posicion(0, 2);
        }
        //--------------diagonal 1
        if (tablero.consultar(new Posicion(0, 0)).equals("|O|") && tablero.consultar(new Posicion(1, 1)).equals("|O|") && tablero.consultar(new Posicion(2, 2)).equals("|-|")) {
            
            return new Posicion(2, 2);
        }
        if (tablero.consultar(new Posicion(1, 1)).equals("|O|") && tablero.consultar(new Posicion(2, 2)).equals("|O|") && tablero.consultar(new Posicion(0, 0)).equals("|-|")) {
            
            return new Posicion(0, 0);
        }
        if (tablero.consultar(new Posicion(0, 0)).equals("|O|") && tablero.consultar(new Posicion(2, 2)).equals("|O|") && tablero.consultar(new Posicion(1, 1)).equals("|-|")) {
            
            return new Posicion(1, 1);
        }
        //--------------diagonal 2
        if (tablero.consultar(new Posicion(0, 2)).equals("|O|") && tablero.consultar(new Posicion(1, 1)).equals("|O|") && tablero.consultar(new Posicion(2, 0)).equals("|-|")) {
            
            return new Posicion(2, 0);
        }
        if (tablero.consultar(new Posicion(1, 1)).equals("|O|") && tablero.consultar(new Posicion(2, 0)).equals("|O|") && tablero.consultar(new Posicion(0, 2)).equals("|-|")) {
            
            return new Posicion(0, 2);
        }
        if (tablero.consultar(new Posicion(0, 2)).equals("|O|") && tablero.consultar(new Posicion(2, 0)).equals("|O|") && tablero.consultar(new Posicion(1, 1)).equals("|-|")) {
            
            return new Posicion(1, 1);
        } 
        return null;       
    }
}
/*
HACER MOVIMIENTO GANADOR SI SE PUEDE
SI NO MOVER A CASILLA SEGUN VALOR ESTRATEGICO
*/

/* System.out.println("IA Fila --> " + 0);
   System.out.println("IA Columna --> " + 2);
   System.out.println("-----------"); */