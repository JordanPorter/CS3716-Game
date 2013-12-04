
public class Candidate { 

	public int votesFor = 0;
	
	Unit u;
	
	public Candidate(Unit u)	{
		votesFor = 0;	
		this.u = u;
	}
	
	public void votedFor()	{
		votesFor++;
	}
	
	public int getVotesFor()	{
		return votesFor;
	}
}
