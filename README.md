# flood-it-game

A fun game I made using Processing. You start with a random colorful board and your goal is to end up with a 1-color board. Give it a try!

# Requirements

Processing 3 will work although it was made with Processing 2.

# Installation

You have 2 possibilities:
 
1. Download PC or Linux versions I made
2. Clone repository and run from source code

## Option 2 only

You can easily change the number of moves you get (instead of the default 25 or 28). Just edit line 7 of `FloodIt.pde`:

```java
class FloodIt{  
  int x=0;
  int y=0;
  int c=6; // colour chosen
  int counter = 0;
  int turns = 0;
  int maxTurns = 25;   // HERE YOU CAN CHANGE THE MAX NUMBER OF MOVES
  color c0= color(0) ; // last colour
  boolean win = false; // winner?
```

# Screenshots

![Gameplay](/screenshots/gameplay.png?raw=true "Gameplay")

This is me playing.

![You Lose!](/screenshots/lose.png?raw=true "You Lose!")

Well, it's not all fun and games ;)