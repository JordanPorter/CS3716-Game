import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * @author 
 *
 */
public class Region	{
	//upper left and lower right points for a region we are assuming that regions are rectangular or square for now.
	
	
	
	Color color ;
	
	enum govt{DEMOCRACY,DICTATORSHIP,NONE}
	govt gov;
	
	boolean isCountry = false;
	
	String name; 
	
	int founderRow;
	int founderCol;
	
	int id;
	
	ArrayList<Unit> citizens; 
	LinkedList<Unit> candidates; 
	
	Unit ruler; 
	
	/**
	 * @param name
	 * @param x
	 * @param y
	 * @param length
	 * @param width
	 * @param color
	 */
	public Region(String name, Color color, int id){
		this.name = name;
		this.color = color;
		this.gov = govt.NONE;
		this.id = id;
		citizens = new ArrayList<Unit>();
	}
	
	/**
	 * @param unit
	 */
	public void setRuler(Unit unit){
		this.ruler = unit;	
	}
	
	/**
	 * @return
	 */
	public Unit getRuler(){
		return this.ruler;
	}
	
	/**
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * @return
	 */
	public String getName(){
		return this.name;
	}
	
	public void drawName(Graphics2D g, int numPixels)	{
		if(this.isCountry)	{
			g.drawString("District " + this.name, (founderCol*numPixels)+numPixels/2+numPixels/4, (founderRow*numPixels)+numPixels/2+numPixels/2);
		}
	}
	
	/**
	 * @param unit
	 */
	public void addCitizen(Unit unit){
		this.citizens.add(unit);
	}
	
	/**
	 * @return
	 */
	public ArrayList<Unit> getCitizens(){
		return this.citizens;
	}

	/**
	 * @param units
	 * @param regions 
	 */
	public void trackCitizens(ArrayList<Unit> units, String[][] regionPos, ArrayList<Region> regions)	{
		for(Unit u : units)	{
			int row = u.row;
			int col = u.col;
			if(regions.get(Integer.parseInt(regionPos[row][col])-1).id == this.id)	{
				if(!citizens.contains(u))	{
					System.out.println("Citizen " + u.playerName + " entered " + this.name);
					citizens.add(u);
				}
			}
			else	{
				if(citizens.contains(u))	{
					citizens.remove(u);
					System.out.println("Citizen " + u.playerName + " left " + this.name);
				}
			}
		}
	}	
}
