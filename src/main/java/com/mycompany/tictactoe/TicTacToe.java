/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tictactoe;


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class TicTacToe implements ActionListener {
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];//9 Button
	boolean player12_turn;
	

//TicTacToe game's frame structure
    
        
	TicTacToe(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Exit Application
		frame.setSize(800,800);//Frame Size
		frame.getContentPane().setBackground(new Color(50,50,50));//Background Color
		frame.setLayout(new BorderLayout());//Layout border with no gaps between components
		frame.setVisible(true);// Visible ; false - No Visible
		
		textfield.setBackground(new Color(25,25,25));//Background Color
		textfield.setForeground(new Color(25,150,200));//foreground Color gray 25,255,0
		textfield.setFont(new Font("Cooper",Font.BOLD,75));//Font Style
		textfield.setHorizontalAlignment(JLabel.CENTER);//Textfield Location
                textfield.setText("Tic-Tac-Toe");//Name of Game
		textfield.setOpaque(true);//turn on Opaquing
                
                    
		title_panel.setLayout(new BorderLayout());//Title panel Layout
		title_panel.setBounds(1,1,800,100);//Bounds x,y,hight,length
		
		button_panel.setLayout(new GridLayout(3,3));// button_layout
                button_panel.setBackground(new Color(150,150,150));//button color
                
                //for statement  buttons setting
                for(int i=0; i<9; i++) {
                    buttons[i] = new JButton();
                    button_panel.add(buttons[i]);
                    buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
                    buttons[i].setFocusable(false);// select whole buttons of contain
                    buttons[i].addActionListener(this);
                    
                }
                // add frame functions
                title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
                frame.add(button_panel);
                
                first_turn();
                
	}

	@Override
	public void actionPerformed(ActionEvent e) {
            // for statement. It is input and output on frame <for loop>
            for(int i=0;i<9;i++) {
                if(e.getSource()== buttons[i]){
                    if(player12_turn) {
                        if(buttons[i].getText()==""){
                            buttons[i].setForeground(new Color(255,0,0));
                            buttons[i].setText("X");
                            player12_turn=false;
                            textfield.setText("O turn");
                            check();
                        }                            
                    }
                    else{
                        if(buttons[i].getText()==""){
                            buttons[i].setForeground(new Color(0,0,255));
                            buttons[i].setText("O");
                            player12_turn=true;
                            textfield.setText("X turn");
                            check();
                        
                    }
                }
            }
		
		
	}
        }
        //on top panel of indicator,and show next player,<try catch>
        public void first_turn() {
            //used try catch - Make delay on text fild after 1.5 seconds. 
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, e);
            }
	    //It will be random choose player.	
            if(random.nextInt(2)==0){
                player12_turn = true;
                textfield.setText("X turn");
            }
            else{
                player12_turn = false;
                textfield.setText("O turn");
            }
	}
	//output on buttons.
	public void check( ) {
            if(
                    
               (buttons[0].getText()=="X") &&
               (buttons[1].getText()=="X") &&
               (buttons[2].getText()=="X")
                    
               ){
                xWins(0,1,2);
            }
            if(
               (buttons[3].getText()=="X") &&
               (buttons[4].getText()=="X") &&
               (buttons[5].getText()=="X")
                    
               ){
                xWins(3,4,5);
        }
            if(
               (buttons[6].getText()=="X") &&
               (buttons[7].getText()=="X") &&
               (buttons[8].getText()=="X")
                    
               ){
                xWins(6,7,8);
        }
            if(
               (buttons[0].getText()=="X") &&
               (buttons[3].getText()=="X") &&
               (buttons[6].getText()=="X")
                    
               ){
                xWins(0,3,6);
        }
            if(
               (buttons[1].getText()=="X") &&
               (buttons[4].getText()=="X") &&
               (buttons[7].getText()=="X")
                    
               ){
                xWins(1,4,7);
        }
            if(
               (buttons[2].getText()=="X") &&
               (buttons[5].getText()=="X") &&
               (buttons[8].getText()=="X")
                    
               ){
                xWins(2,5,8);

	}
            if(
               (buttons[0].getText()=="X") &&
               (buttons[4].getText()=="X") &&
               (buttons[8].getText()=="X")
                    
               ){
                xWins(0,4,8);
        }
            if(
               (buttons[2].getText()=="X") &&
               (buttons[4].getText()=="X") &&
               (buttons[6].getText()=="X")
                    
               ){
                xWins(2,4,6);
            }
            //Check O wins conditons
            if(
                    
               (buttons[0].getText()=="O") &&
               (buttons[1].getText()=="O") &&
               (buttons[2].getText()=="O")
                    
               ){
                oWins(0,1,2);
            }
            if(
               (buttons[3].getText()=="O") &&
               (buttons[4].getText()=="O") &&
               (buttons[5].getText()=="O")
                    
               ){
                oWins(3,4,5);
        }
            if(
               (buttons[0].getText()=="O") &&
               (buttons[3].getText()=="O") &&
               (buttons[6].getText()=="O")
                    
               ){
                oWins(0,3,6);
        }
            if(
               (buttons[6].getText()=="O") &&
               (buttons[7].getText()=="O") &&
               (buttons[8].getText()=="O")
                    
               ){
                oWins(6,7,8);
        }
            if(
               (buttons[1].getText()=="O") &&
               (buttons[4].getText()=="O") &&
               (buttons[7].getText()=="O")
                    
               ){
                oWins(1,4,7);
        }
            if(
               (buttons[2].getText()=="O") &&
               (buttons[5].getText()=="O") &&
               (buttons[8].getText()=="O")
                    
               ){
                oWins(2,5,8);

	}
            if(
               (buttons[0].getText()=="O") &&
               (buttons[4].getText()=="O") &&
               (buttons[8].getText()=="O")
                    
               ){
                oWins(0,4,8);
        }
            if(
               (buttons[2].getText()=="O") &&
               (buttons[4].getText()=="O") &&
               (buttons[6].getText()=="O")
                    
               ){
                oWins(2,4,6);
            }
        }
	
//    //countDown recursion
//    public void countDown(int n){
//        if (n ==0){
//            System.out.print(n);
//        }else
//            System.out.print(n);
//        countDown(n-1);
//    }
    
    // x or y winning indicator <for loop>
    public void xWins(int a, int b, int c) {
		        buttons[a].setBackground(Color.GREEN);
                buttons[b].setBackground(Color.GREEN);
                buttons[c].setBackground(Color.GREEN);
                
                for(int i=0;i<9;i++){
                    buttons[i].setEnabled(false);
                }
                textfield.setText("X wins");
                        
	}
	
    public void oWins(int a, int b, int c) {
                buttons[a].setBackground(Color.GREEN);
                buttons[b].setBackground(Color.GREEN);
                buttons[c].setBackground(Color.GREEN);
                
                for(int i=0;i<9;i++){
                    buttons[i].setEnabled(false);
                }
                textfield.setText("O wins");
    }

//    public void draw(int a, int b, int c){
//                if
//        })
//    }

    private void printlind(String done) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
		
}



