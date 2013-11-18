CS3716-Game
===========

CS3716 -Game Project

CS3716-Game is a java game project that creates a GUI based strategy game.

In the first iteration of the Game, four classes were created 

1) Board.java
2) Tile.java
3) Unit.java
4) Game.java

Board class creates the panel where the whole game is to be played.

Tile class creates the terrain for the board and we have used 7 different tiles. 
//GTile - grass, HTile - hills, MTile - mountains, FTile - forest, WTile - water, ITile - Ice, etc.
This image files will be used at the time of running the code. 

Unit.java creates the unit/player who is the main actor of the game. A player can be viewed as an icon on the game. We have used guy.png as the source icon for the player for this iteration.

Game.java creates the frame of the game and adds the Board panel to itself. 

The 8 image files that are attached with the code will be used as a data file so the code wouldn't run without them.

The code can be compiled by:

$ javac Board.java Tile.java Unit.java Game.java

And run command: 

$java Game

