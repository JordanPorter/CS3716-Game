/**
 * Happiness is the class for the amount of happiness a player will have
 * each type of happiness type is calculated in a different way and will give 
 * a score to the player which the player will try to get the highest to win
 **/
public class Happiness{
	// enum type of each the different types of happiness in our game
    enum HapType {GOVERN, MONEY, LEFT_ALONE, BUILDING, KILLING};
    // type of happiness for the player associated
    HapType type;
    // amount of happiness
    int happiness;
    // Constructor for happiness
    public Happiness(HapType type){
    	this.type = type;
    	happiness = 0;
    }
    // Calculates happiness depending on the type the player chose at the beginning of the game
    public int calculateHappiness(){
        // switch case to calculate the happiness of this player based on chosen type
    	switch(type){
    		case GOVERN:
    			break;
    		case MONEY:
    			break;
    		case LEFT_ALONE:
    			break;
    		case BUILDING:
    			break;
    		case KILLING:
    			break;
    	}
        return happiness;
    }
    
}