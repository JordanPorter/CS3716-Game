===========
CS3716-Game
===========

===========
Details
===========

CS3716 -Game Project

CS3716-Game is a java game project that creates a GUI based strategy game.

- Iteration 1:
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

- Iteration 2:

For the second iteration of the game we decided to focus on adding multiple players to the board first most before we decide to create
or manage any countries or regions, as well as when the game begins we have the player choose their happiness values which are defined by
the player giving a certain value for all 5 happiness types and have those values add up to 100. 

From there we had up sized the maps and added the choice to choose their map type.

When going to start regions and stuff we were instructed by our customer to concentrate on regions and country management for our next 
iteration, so we ended our current plan of action and started defining our regions and everything from a thought process instead of coding.

- Iteration 3:
===========
Run
===========

To run the game:

Unzip the CS3716-Game.zip to a folder.

From command prompt, navigate to the "GAME" folder in the folder you just
created

use the following commands:

javac *.java
java Game

===========
How to Play
===========

- New Game:
When the game is loaded you'll have the option to create a new game, when this is clicked you'll be prompt to choose a map type.

- Add Player:
When the map is selected the board will load the map and display the tiles, from here the user may add players to the game and 
create the players name and happiness values. The user may add any number of players and place them on the map.

- Movement:
To move the player, the user must click and drag the player to the area the user wants the player to be. 

The selected player will be displayed with a red marker on the players name.

- Creating Country
To create a country, you'll have to enter a region that is not already defined as a country. 
From here you'll need to go to the 'Action' menu and select 'Create a Country', this will prompt you that you are 
creating a country 
---
then after all prompts are finished the country will be created.

- Voting Government

- Winning
This feature isn't active as of yet,however when happiness are finalized and a timer implemented to determine how long the game
will last, after the timer ends the player with the highest happiness valued player will win the game.

- Exit Game
To exit the game, select "Exit Game" and the game will close.