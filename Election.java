import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Election implements Vote{

	ArrayList<Candidate> candidates;
	ArrayList<Unit> voters;
	String message = "Enter the name of your vote ";
	
	public Election(ArrayList<Candidate> candidates, ArrayList<Unit> voters)	{
		this.candidates = candidates;
		this.voters = voters;
	}
	
	/**
	 * @see Vote#vote()
	 **/
	
	public Candidate electionVote() {
		Candidate winner = null;
		String[] options = new String[candidates.size()];
		for(int i=0; i<options.length; i++)	{
			options[i] = candidates.get(i).name;
		}
		
		
		for(Unit u : voters)	{
			String thisVote = (String) JOptionPane.showInputDialog(null, "Enter the name of your vote:", u.playerName + " Vote Now", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			for(Candidate c : candidates)	{
				if(c.name.equalsIgnoreCase(thisVote))
					c.votedFor();
				if(winner == null)
					winner = c;
				if(c.getVotesFor() > winner.getVotesFor() && winner != null)
					winner = c;
			}
		}
		
		return winner;
	}

	public boolean yay_nayVote() {
		/* NOT APPLICABLE */
		return false;
	}
}
