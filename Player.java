import java.awt.Image;
/**
 * Player class for game where the player has a set coordinates and stats
 * that determine the individule player. 
 **/
public class Player{
    int row;
    int col;
    Object[] inventory;
    int money;
    int hp;
    int defense;
    Happiness hap;
    boolean isTurn;
    Image image;
    String countryName;
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
