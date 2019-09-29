# flood-it-game

A fun game I made using Processing. You start with a board full of colours and your goal is to flood the board with just colour. Give it a try!

# Requirements

Processing 3 will work although it was made with Processing 2.

# Usage

You have 2 possibilities:
 
1. Play online [here](https://www.openprocessing.org/sketch/761031) (I also made an html file with the game embedded)
2. Download PC or Linux versions
3. Clone repository and run from source code

## If you choose option 3

You can easily change the number of moves you get. Just change the `maxTurns` variable in `FloodIt.pde`:

```java
class FloodIt {
  int x=0;
  int y=0;
  int c=6;
  int counter = 0;
  int turns = 0;
  int maxTurns = 25;   // HERE YOU CAN CHANGE THE MAX NUMBER OF MOVES
  color c0= color(0) ;
  boolean win = false;
```

# Screenshots

This is me playing:

![Gameplay](/screenshots/gameplay.png?raw=true "Gameplay")

Well, it's not all fun and games ;)

![You Lose!](/screenshots/lose.png?raw=true "You Lose!")
