import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JOptionPane;


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
