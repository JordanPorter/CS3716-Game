import java.awt.Image;
import java.util.Scanner;
/**
 * Player class for game where the player has a set coordinates and stats
 * that determine the individule player. 
 **/
public class Player{
    int row;
    int col;
    int money;
    int hp;
    int defense;

    boolean isTurn;    
    
    Happiness hap;
    Image image;
    String countryName;
    Object[] inventory;
    
    // Returns the row coordinate of the player
    public int getRow(){
        return row;
    }
    
    // Returns the column coordinate of the player
    public int getCol(){
        return col;
    }
    
    // Sets a new place for the player to move to
    public void move(int row, int col){
        this.row = row;
        this.col = col;
    }
    
    // Returns the happiness amount of the player
    public int getHappiness(){
        return hap.calculateHappiness();
    }
}
