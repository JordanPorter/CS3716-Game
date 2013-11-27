import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;


public class Election {

	ArrayList<Unit> citizens;
	ArrayList<Unit> candidates;
	String[] votes;
	
	public Election(ArrayList<Unit> candidates, ArrayList<Unit> citizens)	{
		this.candidates = candidates;
		this.citizens = citizens;
	}
	
	public Election(ArrayList<Unit> candidates)	{
		this.candidates = candidates;
	}
	
	public Unit electionVote() {
		Unit winner = null;
		String[] options = new String[candidates.size()];
		for(int i=0; i<options.length; i++)	{
			options[i] = candidates.get(i).playerName;
		}
		votes = new String[citizens.size()];
		for(int i=0; i<citizens.size(); i++)	{
			String thisVote = (String) JOptionPane.showInputDialog(null, "Select the name of your vote:", citizens.get(i).playerName + " Vote Now", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
			for(Unit c : candidates)	{
				if(c.playerName.equalsIgnoreCase(thisVote))
					votes[i] = c.playerName;
			}
		}
		
		return winner;
	}
	
	public boolean yay_nayVote() {
		LinkedList<Unit> yayVotes = new LinkedList<Unit>();
		LinkedList<Unit> nayVotes = new LinkedList<Unit>();
		for(Unit u : citizens)	{
			System.out.println(u.playerName);
			String thisVote = (String) JOptionPane.showInputDialog(null, u.playerName + " enter your vote (yay/nay/don't care):", JOptionPane.PLAIN_MESSAGE);
			if(thisVote.equalsIgnoreCase("yay"))
				yayVotes.add(u);
			else if(thisVote.equalsIgnoreCase("nay"))
				nayVotes.add(u);
			else
				System.out.println("Don't Care Vote");
		}
		if(yayVotes.size() > nayVotes.size())
			return true;
		else 
			return false;
	}
	
}
