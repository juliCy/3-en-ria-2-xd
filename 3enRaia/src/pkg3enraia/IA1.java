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
public class IA1 extends JugadorIA {
    
    public IA1(String tipoFicha, String nombre) {      
        super(tipoFicha, nombre);
    }

    public IA1() {
    }
    
    @Override
    public Posicion movimiento(){
        return this.movimientoEstrategico();
    }
    
    public Posicion movimientoEstrategico() {
        Posicion posActual = new Posicion();
        int prioridad[][] = {{8, 4, 7}, {3, 9, 2}, {6, 1, 5}};
        int f, c;
        int guardar = 0;

        //Busca una casilla según la prioridad y se la asigna a guardar.
        for (f = 0; f < 3; f++) {
            for (c = 0; c < 3; c++) {
                if ((tablero.consultar(new Posicion(f,c)).equals("|-|")) && (prioridad[f][c] > guardar)) {
                    guardar = prioridad[f][c];
                    posActual.setFila(f);
                    posActual.setColumna(c);
                }
            }
        }       
        return posActual;
    }
}
/*
PRIMEA CASILLA VACIA SEGUN POSICION ESTRATEGICA
PRIMERO CENTRO, LUEGO ESQUINAS Y POR ULTIMA LATERALES.
*/

/*
        if(("|-|").equals(tablero.consultar(new Posicion(1,1)))){
            System.out.println("IA Fila --> " + 1);
            System.out.println("IA Columna --> " + 1);
            System.out.println("-----------");
            return new Posicion(1,1);
        }
        if(("|-|").equals(tablero.consultar(new Posicion(0,0)))){
            System.out.println("IA Fila --> " + 0);
            System.out.println("IA Columna --> " + 0);
            System.out.println("-----------");
            return new Posicion(0,0);
        }
        if(("|-|").equals(tablero.consultar(new Posicion (0,2)))){
            System.out.println("IA Fila --> " + 0);
            System.out.println("IA Columna --> " + 2);
            System.out.println("-----------");
            return new Posicion(0,2);
        }
        if(("|-|").equals(tablero.consultar(new Posicion(2,0)))){
            System.out.println("IA Fila --> " + 2);
            System.out.println("IA Columna --> " + 0);
            System.out.println("-----------");
            return new Posicion(2,0);
        }
        if(("|-|").equals(tablero.consultar(new Posicion(2,2)))){
            System.out.println("IA Fila --> " + 2);
            System.out.println("IA Columna --> " + 2);
            System.out.println("-----------");
            return new Posicion(2,2);
        }
        if(("|-|").equals(tablero.consultar(new Posicion(0,1)))){
            System.out.println("IA Fila --> " + 0);
            System.out.println("IA Columna --> " + 1);
            System.out.println("-----------");
            return new Posicion(0,1);
        }
        if(("|-|").equals(tablero.consultar(new Posicion(1,0)))){
            System.out.println("IA Fila --> " + 1);
            System.out.println("IA Columna --> " + 0);
            System.out.println("-----------");
            return new Posicion(1,0);
        }
        if(("|-|").equals(tablero.consultar(new Posicion(1,2)))){
            System.out.println("IA Fila --> " + 1);
            System.out.println("IA Columna --> " + 2);
            System.out.println("-----------");
            return new Posicion(1,2);
        }
        if(("|-|").equals(tablero.consultar(new Posicion(2,1)))){
            System.out.println("IA Fila --> " + 2);
            System.out.println("IA Columna --> " + 1);
            System.out.println("-----------");
            return new Posicion(2,1);
        }
        return null;
        */