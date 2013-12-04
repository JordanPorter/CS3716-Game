import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;


/**
 * @author 
 *
 */
public class Election {

	//<Unit> citizens;
	ArrayList<Unit> candidates;
	String[] votes;
	
	/**
	 * @param candidates
	 */
	public Election()	{
	}
	
	/**
	 * @return
	 */
	public Unit electionVote(ArrayList<Candidate> candidates, ArrayList<Unit> citizens) {
		Candidate winner = null;
		String[] options = new String[candidates.size()];
		for(int i=0; i<options.length; i++)	{
			options[i] = candidates.get(i).u.playerName;
		}
		for(int i=0; i<citizens.size(); i++)	{
			String thisVote = (String) JOptionPane.showInputDialog(null, "Select the name of your vote:", citizens.get(i).playerName + " Vote Now", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			for(Candidate c : candidates)	{
				if(c.u.playerName.equalsIgnoreCase(thisVote))
					c.votedFor();
			}
		}
		for(Candidate c : candidates)	{
			if(winner == null)
				winner = c;
			else if(c.getVotesFor() > winner.getVotesFor())
				winner = c;
		}
		return winner.u;
	}
	
	/**
	 * @return
	 */
	public boolean yay_nayVote(Region r, ArrayList<Unit> citizens, Unit initiator) {
		LinkedList<Unit> yayVotes = new LinkedList<Unit>();
		LinkedList<Unit> nayVotes = new LinkedList<Unit>();
		System.out.println("Beginning YAY NAY Vote.");
		for(Unit u : citizens)	{
			System.out.println("Taking Vote From: " + u.playerName);
			String thisVote = (String) JOptionPane.showInputDialog(null, u.playerName + " enter your vote (yay/nay/don't care):", JOptionPane.PLAIN_MESSAGE);
			if(thisVote.equalsIgnoreCase("yay"))
				yayVotes.add(u);
			else if(thisVote.equalsIgnoreCase("nay"))
				nayVotes.add(u);
			else
				System.out.println("Don't Care Vote");
		}
		if(yayVotes.size() > nayVotes.size())	{
			r.founderRow = initiator.row;
			r.founderCol = initiator.col;
			return true;
		}
		else 
			return false;
	}
	
}
