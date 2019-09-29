class Tablero {
  // Some attributes
  int rows = 14;
  int cols = 14;

  // Available colours
  color red = color(255,0,0);
  color green = color(0,255,0);
  color blue = color(0,0,255);
  color brown = color(200,100,0);
  color yellow = color(255,255,0);
  color purple = color(80,40,70);

  color[][] squares = new color[rows][cols];
  color[] colour = {red,green,blue,brown,purple,yellow,0};
    
  Tablero(){}
  
  void update(){
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
