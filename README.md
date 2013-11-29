===========
CS3716-Game
===========

===========
Details
===========

CS3716 -Game Project

CS3716-Game is a java game project that creates a GUI based strategy game.

In the first iteration of the Game, four classes were created 

1) Board.java
2) Tile.java
3) Unit.java
4) Game.java

Board class creates the panel where the whole game is to be played.

Tile class creates the terrain for the board and we have used 7 different tiles. The player can only go over some of the tiles. Some tiles such as MTile (mountain) and WTile (water) are not meant to be passed through them. 
//GTile - grass, HTile - hills, MTile - mountains, FTile - forest, WTile - water, ITile - Ice, etc.
This image files will be used at the time of running the code. 

Unit.java creates the unit/player who is the main actor of the game. A player can be viewed as an icon on the game. We have used guy.png as the source icon for the player for this iteration.

Game.java creates the frame of the game and adds the Board panel to itself. 

The 8 image files that are attached with the code will be used as a data file so the code wouldn't run without them.

===========
Run
===========

The code can be compiled by:

$ javac Board.java Tile.java Unit.java Game.java

Please ensure that the .class files are in the same folder as the source files to avoid bugs in executing the next command. 

And run command: 

$java Game

or Alternatively, The jar file can be run directly by the following command:

$java -jar CS3716-Game.jar 

===========
How to Play
===========

-New Game:
When the game is loaded you'll have the option to create a new game
When you start the game you'll be prompt to choose your map type you'd like to play on during your session.

When the game loads you'll have the board with no players or anything just the map.