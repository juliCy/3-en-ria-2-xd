/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3enraia;

/**
 *
 * @author Juli
 */
public class IA4 extends IA3 {

    public IA4(String tipoFicha, String nombre, UI_Juego ui) {
        super(tipoFicha, nombre, ui);
    }

    @Override
    public Posicion movimiento() {
        if (super.movimientoGanar() != null) {
            return super.movimientoGanar();
        }
        if (super.movimientoTapar() != null) {
            return super.movimientoTapar();
        }
        return this.movimientoPrioridad();
    }

    //Consultar filas
    private int consultarFila(int f) {
        for (int c = 0; c < 3; c++) {
            if (super.getTablero().consultar(new Posicion(f, c)).equals("|X|")) {
                return 0;
            }
        }
        // Si sale del bucle sin retornar 0, sale 1 ya que o son vacias o de la IA.
        return 1;
    }

    //Consultar columnas
    private int consultarColumna(int c) {
        for (int f = 0; f < 3; f++) {
            if (super.getTablero().consultar(new Posicion(f, c)).equals("|X|")) {
                return 0;
            }
        }
        // Si sale del bucle sin retornar 0, sale 1 ya que o son vacias o de la IA.
        return 1;
    }

    //Consultar diagonal derecha
    private int consultarDiag1(int f, int c) {
        //C si la p es valida
        if ((f == 0 && c == 2) || (f == 1 && c == 1) || (f == 2 && c == 0)) {
            for (int fAux = 0, cAux = 2; fAux < 3; fAux++, cAux--) {
                if (super.getTablero().consultar(new Posicion(fAux, cAux)).equals("|X|")) {
                    return 0;
                }
            }
            return 1;
        }
        return 0;
    }

    //Consultar diagonal izquierda
    private int consultarDiag2(int f, int c) {
        //c si la p no es valida
        if ((f == 0 && c == 0) || (f == 1 && c == 1) || (f == 2 && c == 2)) {
            for (int fAux = 0, cAux = 0; fAux < 3; fAux++, cAux++) {
                if (super.getTablero().consultar(new Posicion(fAux, cAux)).equals("|X|")) {
                    return 0;
                }
            }
            return 1;
        }
        return 0;
    }

    //Mejor posicion por Prioridad
    private Posicion buscaPrioridad(int prioridad[][]) {
        int aux;
        Posicion posActual = new Posicion();
        aux = -1;
        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                if ((super.getTablero().consultar(new Posicion(f, c)).equals("|-|")) && (prioridad[f][c] > aux)) {
                    aux = prioridad[f][c];
                    posActual.setFila(f);
                    posActual.setColumna(c);
                }
            }
        }
        return posActual;
    }

    //Comprueba la mejor posición
    //la IA coloca donde tiene mas posibilidades de hacer 3.
    private Posicion movimientoPrioridad() {

        int prioridad[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        Posicion posActual = new Posicion();
        //tabla de prioridades
        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                if (!(this.getTablero().consultar(f, c).equals("|-|"))) {
                    prioridad[f][c] = -1;
                } else {
                    prioridad[f][c] += consultarFila(f);
                    prioridad[f][c] += consultarColumna(c);
                    prioridad[f][c] += consultarDiag1(f, c);
                    prioridad[f][c] += consultarDiag2(f, c);
                }
            }
        }
        posActual = buscaPrioridad(prioridad);
        return posActual;
    }

    //Metodo para imprimir donde ha colocado la IA.
}
