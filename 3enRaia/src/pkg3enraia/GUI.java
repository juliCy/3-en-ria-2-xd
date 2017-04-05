/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3enraia;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


/**
 *
 * @author dam1a30
 */
public class GUI extends UI_Juego {
    
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
    

    public GUI() {
        //Frame------------------------
        frame = new JFrame("Tres en Raya");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);        
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
        panel4.setBounds(550, 350, 280, 200);
        //Panel Marcador---------------
        panel2 = new JPanel();
        panel2.setLayout(null);
        frame.add(panel2);
        panel2.setBounds(600, 50, 200, 120);
        panel2.setBackground(Color.red);
        //Label vic--------------------
        vic = new JLabel("Victorias: ");
        panel2.add(vic);
        vic.setBounds(20, 20, 70, 10);
        //Label derr-------------------
        derr = new JLabel("Derrotas: ");
        panel2.add(derr);
        derr.setBounds(20, 50, 70, 10);
        //Label emp--------------------
        emp = new JLabel("Empates: ");
        panel2.add(emp);
        emp.setBounds(20, 80, 70, 10);
        //Label warning----------------
        warning = new JLabel("Aqui van los warnings");
        panel3.add(warning);
        warning.setBounds(70, 80, 150, 150);
        //Radio1-----------------------
        d1 = new JRadioButton("Dificultad 1");
        panel4.add(d1);
        d1.setBounds(30, 10, 15, 15);
        //Radio2-----------------------
        d2 = new JRadioButton("Dificultad 2");
        panel4.add(d2);
        d2.setBounds(30, 50, 15, 15);
        //Radio3-----------------------
        d3 = new JRadioButton("Dificultad 3");
        panel4.add(d3);
        d3.setBounds(30, 90, 15, 15);
        //Radio4-----------------------
        d4 = new JRadioButton("Dificultad 4");
        panel4.add(d4);
        d4.setBounds(30, 130, 15, 15);
        //Radio5-----------------------
        d5 = new JRadioButton("Dificultad 5");
        panel4.add(d5);
        d5.setBounds(30, 170, 15, 15);
        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(d1);
        group.add(d2);
        group.add(d3);
        group.add(d4);
        group.add(d5);
        //Botones------------------------
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                botones[i][j] = new JButton();                //Instantiating buttons 
                botones[i][j].setText("");
                botones[i][j].setVisible(true);
                botones[i][j].setSize(10, 10);
                panel1.add(botones[i][j]);
            }
        }
    }  
}

//http://codereview.stackexchange.com/questions/57141/tic-tac-toe-game-in-java-oop
