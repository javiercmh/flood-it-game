import processing.core.*; 
import processing.data.*; 
import processing.opengl.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class version6 extends PApplet {

// Based on http://www.lemoda.net/javascript/flood-it/index.html

Tablero t = new Tablero();
FloodIt f = new FloodIt();

public void setup(){
  size(600,420);
  noStroke();
  f.startingColours();
}

public void draw() {
  background(175);
  
  // New Game Button
  rectMode(CENTER);
  int y=265;
  fill(250,0,0);
  rect(513,y,125,28);
  y+=50;

  rectMode(0); // to leave it as it was  
  fill(242);
  textSize(20); 
  textAlign(CENTER);
  text("New Game", 512, 272);

  f.newGame();
  f.buttons();
  f.paint();
}


class FloodIt{  
  int x=0;
  int y=0;
  int c=6; // colour chosen
  int counter = 0;
  int turns = 0;
  int maxTurns = 28;
  int c0= color(0) ; // last colour
  boolean win = false; // winner?

  // constructor
  FloodIt(){}

  public void newGame() {
    if(mousePressed){
      if(450 < mouseX && mouseX < 575 && 250 < mouseY && mouseY < 278){
        startingColours();
        f = new FloodIt();
      }
    }
  }
  
  public void buttons() {
    int distance = 450; 
    int c = -1;
    int ypos = 40;
    
    // Text
    fill(0);
    textSize(14); 
    textAlign(0);
    text("Choose a colour:",distance,30);
    
    // Colours to choose
    for(int j=0; j < 2; j++){
      distance = 400;
      for(int i=0; i < 3; i++){
        c++;
        distance += 50;
        stroke(1);
        fill(t.colour[c]);
        rect(distance,ypos,30,30);
        noStroke();
      }  
      ypos += 50;
    }
  }
  
  public void startingColours(){
    // Paint 2D array
    for (int i = 0; i < t.rows; i++) {
      for (int j = 0; j < t.cols; j++) {
        t.squares[i][j] = t.colour[PApplet.parseInt(random(0,6))];
      }
    }
  }
  
  // choose a colour
  public void select() {
    int ypos = 40;
    if(mousePressed){
      for(int i=0; i<2; i++){
      int xpos = 450;
      if(ypos < mouseY && mouseY < ypos+30) {
        for(int j=0; j<3; j++){
          if(xpos<mouseX && mouseX<xpos+30) {
            c = i*3 + j;
          }
          xpos += 50;  
        }
      }
      ypos += 50;
      }
    }
  }
    
  public void paint(){
    if(win) {
      fill(255);
      textSize(32); 
      textAlign(CENTER);
      text("You Win!",210,210);
      println("You Win");      
    } else if(turns < maxTurns){
      // turns counter
      fill(0);
      textSize(32); 
      textAlign(0);
      text(turns,450,200);
      text("/"+maxTurns, 490, 200);
      println(mouseX + " " + mouseY);
      
      // save the last colour stored on that square
      c0 = t.squares[0][0]; 
      select(); // gives 'c' a value
      if(c0 != t.colour[c] && c <6 && c > -1){     
        t.squares[0][0] = t.colour[c];
        changeAround();
        turns++;
      } 
      t.update(); // draw the squares again
    } else {
      // You lose
      fill(255);
      textSize(32); 
      textAlign(CENTER);
      text("You Lose!",210,210);
      println("You Lose");    
    }   
    
    // check if you win
    for (int i = 0; i < t.rows; i++) {
      for (int j = 0; j < t.cols; j++) {
        // Count squares of the same colour
        if(t.squares[i][j] == t.colour[c]){
          counter++;
         }
      }
    }
    if(counter<196){
      counter = 0;
    } else win = true;
    x=0; y=0; // leave x and y untouched
    //end of win check
    
  } // end of paint
  
    // change colours around
  public void changeAround(){
    // remember that x = 0, y = 0
    x++;
    replaceSquare();
    x--;
    y++;
    replaceSquare();
    y-=2;
    replaceSquare();
    y++;
    x--;
    replaceSquare();
    x++;
    
  } // end of changeAround
  
  // it replaces a square only if its colour is c0 and it's not out of bounds
  public void replaceSquare(){
    if(x >-1 && x<14 && y >-1 && y<14){
      if(t.squares[x][y] == c0){
        t.squares[x][y] = t.colour[c];
        changeAround();
      }
    }
  }
  
} // end of FloodIt
class Tablero {
  // Some attributes
  int rows = 14;
  int cols = 14;

  // Available colours
  int red = color(255,0,0);
  int green = color(0,255,0);
  int blue = color(0,0,255);
  int brown = color(200,100,0);
  int yellow = color(255,255,0);
  int purple = color(80,40,70);

  int[][] squares = new int[rows][cols];
  int[] colour = {red,green,blue,brown,purple,yellow,0};
    
  Tablero(){}
  
  public void update(){
    int x=0;
    int y=0;
    // Draw squares, from the array of colours
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        fill(squares[i][j]);
        rect(x,y,30,30);
        y+=30;
      }
      y=0;
      x+=30;
    }
  } // end of update
  
} // end of class Tablero
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "version6" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
