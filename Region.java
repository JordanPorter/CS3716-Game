import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JOptionPane;


public class Region implements Vote{
	//upper left and lower right points for a region we are assuming that regions are rectangular or square for now.
	int x;
	int y;
	int length;
	int width;
	Color color;
	enum govt{DEMOCRACY,DICTATORSHIP,NONE}
	govt gov;
	String name; //we should set an initial Region name - like hard code it ourselves, but maybe let the governor or dictator be able to change it when they start a country. or win a quo
	LinkedList<Unit> citizens; //people belonging to a country
	LinkedList<Unit> candidates; //people running in election
	Unit ruler; //ruler either dictator or governor. the enum type distinguishes govt type.
	
	public Region(String name, int x, int y, int length, int width, Color color){
		this.name = name;
		this.x = x;
		this.y = y;
		this.length = length;
		this.width = width;
		this.color = color;
		this.gov = govt.NONE;
		citizens = new LinkedList<Unit>();
	}
	
	public void setRuler(Unit unit){
		this.ruler = unit;	
	}
	
	public Unit getRuler(){
		return this.ruler;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void addCitizen(Unit unit){
		this.citizens.add(unit);
	}
	
	public LinkedList<Unit> getCitizens(){
		return this.citizens;
	}//maybe returning an iterator would be better here.

	public void trackCitizens(LinkedList<Unit> units)	{
		for(Unit u : units)	{
			if(u.getX() >= this.x*60 && u.getX() < (this.x+length)*60)	{
				if(u.getY() >= this.y*60 && u.getY() < (this.y+length)*60)	{
					citizens.add(u);
					System.out.println(this.name + " ADDED " + u.playerName);
				}
				else
					citizens.remove(u);
			}
			else
				citizens.remove(u);
		}
	}
	
	@Override
	public Candidate electionVote(LinkedList<Unit> electionCandidates) {
		LinkedList<Candidate> candidates = new LinkedList<Candidate>();
		for(int i=0; i<electionCandidates.size(); i++)	{
			candidates.add(new Candidate(electionCandidates.get(i), electionCandidates.get(i).playerName));
		}
		Candidate winner = null;
		String[] options = new String[candidates.size()];
		for(int i=0; i<options.length; i++)	{
			options[i] = candidates.get(i).playerName;
		}
		
		
		for(Unit u : citizens)	{
			String thisVote = (String) JOptionPane.showInputDialog(null, "Select the name of your vote:", u.playerName + " Vote Now", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
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

	@Override
	public boolean yay_nayVote() {
		LinkedList<Unit> yayVotes = new LinkedList<Unit>();
		LinkedList<Unit> nayVotes = new LinkedList<Unit>();
		for(Unit u : citizens)	{
			String thisVote = (String) JOptionPane.showInputDialog(null, "Enter your vote (yay/nay/don't care):", JOptionPane.PLAIN_MESSAGE);
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
