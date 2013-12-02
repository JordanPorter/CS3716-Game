import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * @author 
 *
 */
public class Region	{
	//upper left and lower right points for a region we are assuming that regions are rectangular or square for now.
	int x;
	int y;
	int length;
	int width;
	
	Color color;
	
	enum govt{DEMOCRACY,DICTATORSHIP,NONE}
	govt gov;
	
	boolean isCountry = false;
	
	String name; 
	
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
	public Region(String name, int x, int y, int length, int width, Color color){
		this.name = name;
		this.x = x;
		this.y = y;
		this.length = length;
		this.width = width;
		this.color = color;
		this.gov = govt.NONE;
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
	 */
	public void trackCitizens(LinkedList<Unit> units)	{
		for(Unit u : units)	{
			if(u.getX() >= this.x*60 && u.getX() <= (this.x+length-1)*60)	{
				if(u.getY() >= this.y*60 && u.getY() <= (this.y+length-2)*60)	{
					if(!citizens.contains(u))	
						citizens.add(u);
				}
				else
					citizens.remove(u);
			}
			else
				citizens.remove(u);
		}
	}	
}
