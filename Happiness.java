/**
 * Happiness is the class for the amount of happiness a player will have
 * each type of happiness type is calculated in a different way and will give 
 * a score to the player which the player will try to get the highest to win
 **/
public class Happiness{
	// integer value for the ratio of each type of happiness
    double govern;
    double money;
    double left_alone;
    double building;
    double killing;
    // total amount of happiness
    double happiness;
    // Constructor for happiness
    public Happiness(double govern, double money, double left_alone, double building, double killing){
    	this.govern = govern;
    	this.money = money;
    	this.left_alone = left_alone;
    	this.building = building;
    	this.killing = killing;
    	happiness = 0;
    }
    // Calculates happiness depending on ratios the player choices at the beginning of the game
    public double calculateHappiness(){
    	// takes the ratios of each happiness type and calculates the full value of happiness
        return happiness;
    }
    
}