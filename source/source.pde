// Based on http://www.lemoda.net/javascript/flood-it/index.html

Board t = new Board();
FloodIt f = new FloodIt();

void setup(){
  size(600,420);
  noStroke();
  f.startingColours();
}

void draw() {
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
