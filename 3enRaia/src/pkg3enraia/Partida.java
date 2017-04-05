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
public class Partida {

    private Tablero tablero; //declaramos el tablero, el marcador y los jugadores
    private Marcador marcador;
    private int turnoActual;
    private Jugador[] jugadores;
    private UI_Juego ui;

    public Partida(Marcador marcador, Jugador jugadorJ, JugadorIA jugadorIA, UI_Juego ui) { // pasamos los parametros necesarios para partida
        this.tablero = new Tablero("|O|", ui);   
        this.marcador = marcador;
        this.jugadores = new Jugador[2]; //jugadores array de 2 posiciones
        this.jugadores[1] = jugadorJ;
        this.jugadores[0] = jugadorIA;
        this.turnoActual = (int)(Math.random() * 2);
        jugadorIA.setTablero(tablero);
        this.ui = ui;
    }

    public int getTurnoActual() {
        return turnoActual;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Marcador getMarcador() {
        return marcador;
    }

    public void incrementarTurno() { // incrementa el turno cada vez que se pone una ficha
        this.turnoActual++;
    }

    public void iniciar() { //Metodo que inicia la partida
        if (turnoActual % 2 == 1) {
            ui.warning("****EMPIEZAS PRIMERO****\n-----------\n****Tus fichas son las X****\n-----------");
        } else if (turnoActual % 2 == 0) {
            ui.warning("****LA IA EMPIEZA PRIMERO****\n-----------\n****Sus fichas son los O****\n-----------");
        }
        if (turnoActual == 0){
            ui.warning("");
        }
        jugar();
    }

    private void salir() { //Método para salir de la partida.       
        marcador.mostrar(jugadores[1]);
    }

    public boolean comprobarGanador(Jugador jugadorJ) { //Comprueba que jugador ha ganado; mirando las diagonales, verticales y horizontales. Despues de cada movimiento.       

        if (validar(new Posicion(0, 0), new Posicion(0, 1), new Posicion(0, 2), jugadorJ.getTipoFicha())) {
            return true;
        }
        if (validar(new Posicion(1, 0), new Posicion(1, 1), new Posicion(1, 2), jugadorJ.getTipoFicha())) {
            return true;
        }
        if (validar(new Posicion(2, 0), new Posicion(2, 1), new Posicion(2, 2), jugadorJ.getTipoFicha())) {
            return true;
        }
        if (validar(new Posicion(0, 0), new Posicion(1, 0), new Posicion(2, 0), jugadorJ.getTipoFicha())) {
            return true;
        }
        if (validar(new Posicion(0, 1), new Posicion(1, 1), new Posicion(2, 1), jugadorJ.getTipoFicha())) {
            return true;
        }
        if (validar(new Posicion(0, 2), new Posicion(1, 2), new Posicion(2, 2), jugadorJ.getTipoFicha())) {
            return true;
        }
        if (validar(new Posicion(0, 0), new Posicion(1, 1), new Posicion(2, 2), jugadorJ.getTipoFicha())) {
            return true;
        }
        if (validar(new Posicion(0, 2), new Posicion(1, 1), new Posicion(2, 0), jugadorJ.getTipoFicha())) {
            return true;
        }
        return false;
    }

    private boolean validar(Posicion pos1, Posicion pos2, Posicion pos3, String tipoFicha) { //metodo que valida si hay una ficha en cada posicion
        if (tablero.consultar(pos1).equals(tipoFicha) && tablero.consultar(pos2).equals(tipoFicha) && tablero.consultar(pos3).equals(tipoFicha)) {
            return true;
        }
        return false;
    }

    private void jugar() { //Bucle que continua hasta que la partida finaliza. Cuando el tablero está completo o alguien ha ganado.
        Posicion p;

        boolean partidaFinalizada = false;

        while (!partidaFinalizada) {            
            if(turnoActual != 0){
            ui.estadoPartida(partidaFinalizada);   
            ui.warning("Turno actual: " + this.getTurnoActual());
            tablero.mostrar();
            ui.warning("-----------");
            }
            p = this.jugadores[turnoActual % 2].movimiento(); //asi sabemos de quien es el turno, si el modulo es 1 le toca al jugador normal, si es 0 a la IA          
            if (tablero.validarMovimiento(p)) { //valida el movimiento
                this.tablero.ponerFicha(p, this.jugadores[turnoActual % 2].getTipoFicha());  //segun de quien sea el turno pone X o O            
                if (comprobarGanador(this.jugadores[turnoActual % 2])) { //Comprueba quien gana
                    if (turnoActual % 2 == 1) { //Si el turno es 1 y gana, se incrementa el marcador del jugador normal
                        marcador.incrementarA();                      
                        tablero.mostrar();
                        ui.warning("-----------\n¡HAS GANADO!\n-----------");
                    } else {                        //Si el turno es 0 y gana, se incrementa el marcador del jugador normal
                        marcador.incrementarB();                       
                        tablero.mostrar();                      
                        ui.warning("-----------\n¡HAS PERDIDO!\n-----------");
                    }
                    partidaFinalizada = true;
/*enifvalidar*/ } else if (tablero.completo()) { //si se llena el tablero y no hay ganador es empate *********** 
                    partidaFinalizada = true;
                    marcador.empatar();                   
                    tablero.mostrar();                  
                    ui.warning("-----------\n¡EMPATE!\n-----------");
                }
                incrementarTurno();        //si el movimiento es valido pasa al siguiente turno      
            } else { // si el movimento no es valido
                if (turnoActual % 2 == 1) { //y es el turno de 1, se incrementa el marcador de la IA
                    marcador.incrementarB();                 
                    ui.warning("Movimiento no válido, ¡HAS PERDIDO!\n-----------");
                } else { //si es el turno de 0, se incrementa el marcador del jugador normal
                    marcador.incrementarA();                
                    ui.warning("La IA ha hecho un movimiento no válido, ¡HAS GANADO!\n-----------");//en el caso de que la ia pueda poner encima de otra ficha          
                }
                partidaFinalizada = true;
            }
        }
        ui.estadoPartida(partidaFinalizada);
        salir();
    }
}