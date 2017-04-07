/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3enraia;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author dam1a30
 */
public class GUI extends UI_Juego implements ActionListener {
    
    
    private JFrame frame;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JButton[][] botones = new JButton [3][3];
    private JLabel vic;
    private JLabel derr;
    private JLabel emp;
    private JLabel warning;
    private JRadioButton d1;
    private JRadioButton d2;
    private JRadioButton d3;
    private JRadioButton d4;
    private JRadioButton d5;
    private JButton empezar;
    private ButtonGroup group;
    private Posicion buz;

    public GUI(Marcador marcador, Jugador jugador) {
        super(marcador,jugador);
        //Frame------------------------
        frame = new JFrame("Tres en Raya");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);  
        frame.setLayout(null);
        //Panel Tablero----------------
        panel1 = new JPanel(new GridLayout(3, 3));
        frame.add(panel1);
        panel1.setBounds(50, 20, 400, 400);
        //Panel Wrning-----------------
        panel3 = new JPanel();
        panel3.setLayout(null);
        frame.add(panel3);
        panel3.setBounds(50, 440, 400, 110);
        //Panel Radio------------------
        panel4 = new JPanel();
        panel4.setLayout(null);
        frame.add(panel4);
        panel4.setBounds(570, 350, 280, 200);
        //Panel Marcador---------------
        panel2 = new JPanel();
        panel2.setLayout(null);
        frame.add(panel2);
        panel2.setBounds(550, 100, 300, 120);
        panel2.setBackground(Color.red);
        //Label vic--------------------
        vic = new JLabel("Victorias jugador");
        panel2.add(vic);
        vic.setBounds(20, 20, 150, 20);
        //Label derr-------------------
        derr = new JLabel("Victorias IA");
        panel2.add(derr);
        derr.setBounds(20, 50, 150, 20);
        //Label emp--------------------
        emp = new JLabel("Empates");
        panel2.add(emp);
        emp.setBounds(20, 80, 70, 20);
        //Label warning----------------
        warning = new JLabel();
        panel3.add(warning);
        warning.setBounds(100, 15, 200, 100);
        //Radio1-----------------------
        d1 = new JRadioButton(Integer.toString(1));
        d1.setText("Muy Fácil");
        panel4.add(d1);
        d1.setBounds(30, 10, 100, 15);
        d1.addActionListener(this);
        //Radio2-----------------------
        d2 = new JRadioButton(Integer.toString(2));
        d2.setText("Fácil");
        panel4.add(d2);
        d2.setBounds(30, 50, 100, 15);
        d2.addActionListener(this);
        //Radio3-----------------------
        d3 = new JRadioButton(Integer.toString(3));
        panel4.add(d3);
        d3.setBounds(30, 90, 100, 15);
        d3.setText("Menos Fácil");
        d3.addActionListener(this);
        //Radio4-----------------------
        d4 = new JRadioButton(Integer.toString(4));
        d4.setText("Medio");
        panel4.add(d4);
        d4.setBounds(30, 130, 100, 15);
        d4.addActionListener(this);
        //Radio5-----------------------
        d5 = new JRadioButton(Integer.toString(5));
        d5.setText("Difícil");
        panel4.add(d5);
        d5.setBounds(30, 170, 100, 15);
        d5.addActionListener(this);      
        //Group the radio buttons.
        group = new ButtonGroup();
        group.add(d1);
        group.add(d2);
        group.add(d3);
        group.add(d4);
        group.add(d5);
        //Botones------------------------
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botones[i][j] = new JButton();                            
                botones[i][j].setVisible(true);              
                panel1.add(botones[i][j]);
                botones[i][j].addActionListener(this);
            }
        } 
        //Boton empezar-------------------
        empezar = new JButton("Empezar");
        panel4.add(empezar);
        empezar.setBounds(140, 80, 100, 50);
        empezar.addActionListener(this);
        
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int f, c;
        JButton selectedBtn = (JButton) e.getSource();
        for (f = 0; f < 3; f++) {
            for (c = 0; c < 3; c++) {
                if (botones[f][c] == selectedBtn) {
                    this.buz = new Posicion();
                    this.buz.setFila(f);
                    this.buz.setColumna(c);
                }
            }
        }
        
    }
    
    /*private void resetTablero() {
        int f, c;
        for (f = 0; f < 3; f++) {
            for (c = 0; c < 3; c++) {
                botones[f][c].setText("");
            }
        }
    }*/
    
    @Override
    public void warning(String msg) {
        warning.setText(msg);
    }
    
    @Override
    public String pedirNombre() { //pide el nombre del jugador normal
        String nombre = JOptionPane.showInputDialog("Escribe tu nombre:");
        return nombre;
    }
    
    @Override
    public int usarMenuUI() {
        
        //resetTablero();
        return group.nextInt();
    }
    
    @Override
    public void estadoPartida(boolean fin){
        if(!fin){
            warning.setText("En curso");
        }else{
            warning.setText("Finalizada");
        }
    }
    
    @Override
    public void ponerFichaUI(String f, Posicion p, String c[][]) {
        c[p.getFila()][p.getColumna()] = f;
        botones[p.getFila()][p.getColumna()].setText(f);

    }
    
    @Override
    public void actualizarMarcadorUI(Jugador j) {
        vic.setText("Victorias " + j.getNombre() + ": " + marcador.getVictoriasA());
        derr.setText("Victorias IA: " + marcador.getVictoriasB());
        emp.setText("Empates: " + marcador.getEmpate());
    }
    
    @Override
    public Posicion movimientoUI(){
        Posicion p = new Posicion();
        this.buz = null;
        while (this.buz == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
        p.setFila(this.buz.getFila());
        p.setColumna(this.buz.getColumna());
        return p;
    }
}
