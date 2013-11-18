import java.util.ArrayList;


/**
 * @author Jordan Porter
 * 
 * The vote class creates a new vote and queries
 * players for a 'yay' or 'nay' vote. 
 *
 */
public class Vote {

	private ArrayList<Unit> players;
	
	private ArrayList<Unit> yay;
	private ArrayList<Unit> nay;
	
	/**
	 * Constructs a new vote with a list of
	 * relevant players
	 * 
	 * @param players
	 */
	public Vote(ArrayList<Unit> players)	{
		this.players = players;
	}
	
	/**
	 * Takes a vote of all the players
	 * calling a vote method in each Unit's
	 * class which generates a pop up window
	 * to cast their vote. Then calculates whether
	 * the vote is successful or not.
	 * 
	 * @return true/false
	 */
	public boolean takeVote()	{
		yay = new ArrayList<Unit>();
		nay = new ArrayList<Unit>();
		
		for(Unit u : players)	{
			if(u.vote() == true)
				yay.add(u);
			else
				nay.add(u);
		}
		
		if(yay.size() > nay.size())	
			return true;
		else
			return false;
	}
	
}
