import java.util.LinkedList;


public class Region {
	//upper left and lower right points for a region we are assuming that regions are rectangular or square for now.
	int ULrow; //upper left
	int ULcol;
	int LRrow; //lower right
	int LRcol;
	enum govt{DEMOCRACY,DICTATORSHIP,NONE}
	govt gov;
	String name; //we should set an initial Region name - like hard code it ourselves, but maybe let the governor or dictator be able to change it when they start a country. or win a quo
	LinkedList<Unit> citizens; //people belonging to a country
	Unit ruler; //ruler either dictator or governor. the enum type distinguishes govt type.
	
	public Region(String name, int ULrow,int ULcol, int LRrow, int LRcol){
		this.name = name;
		this.ULrow = ULrow;
		this.ULcol = ULcol;
		this.LRrow = LRrow;
		this.LRcol = LRcol;
		this.gov = gov.NONE;
		citizens = new LinkedList<Unit>();
	}
	
	public void setRuler(Unit unit){this.ruler = unit;	}
	public Unit getRuler(){return this.ruler;}
	public void setName(String name){this.name = name;}
	public String getName(){return this.name;}
	public void addCitizen(Unit unit){this.citizens.add(unit);}
	public LinkedList<Unit> getCitizens(){return this.citizens;}//maybe returning an iterator would be better here.
	
}
