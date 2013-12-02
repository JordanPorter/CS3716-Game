===========
CS3716-Game
===========

===========
Details
===========

CS3716 -Game Project

CS3716-Game is a java game project that creates a GUI based strategy game.

-- Iteration 1:
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

-- Iteration 2:

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
When the game is loaded you'll have the option to create a new game, when this is clicked you'll be prompt to choose a map type.

-- Add Player:
When the map is selected the board will load the map and display the tiles, from here the user may add players to the game and 
create the players name and happiness values. The user may add any number of players and place them on the map.

-- Movement:
To move the player, the user must click and drag the player to the area the user wants the player to be. 

The selected player will be displayed with a red marker on the players name.

-- Creating Country

-- Voting Government

-- Winning

- Exit Game
To exit the game, select "Exit Game" and the game will close.