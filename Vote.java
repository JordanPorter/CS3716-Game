import java.util.LinkedList;



/**
 * @author Jordan Porter
 * 
 * The vote interface has methods for
 * taking a vote and for creating a voting window
 *
 */
public interface Vote {
	
	public Candidate electionVote(LinkedList<Unit> candidates);
	public boolean yay_nayVote();
}
