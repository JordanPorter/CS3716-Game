
public class Candidate extends Unit	{

	int votesFor = 0;
	String name = "";
	Unit unit;
	
	/**
	 * Constructs a new Candidate from a
	 * Unit.
	 * 
	 * @param unit
	 * @param name
	 */
	
	public Candidate(Unit unit, String name) {
		super();
		this.name = name;
		this.unit = unit;
	}
	
	/**
	 * If voted for in an election this method 
	 * will be called to increase the count of
	 * the votes for this Candidate
	 */
	
	public void votedFor()	{
		votesFor++;
	}
	
	public int getVotesFor()	{
		return votesFor;
	}
	
	/**
	 * Resets the votes count to zero for this
	 * Candidate
	 */
	
	public void resetVotes()	{
		votesFor = 0;
	}
	
}
