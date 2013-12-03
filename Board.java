import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
/**
* @author Allan Collins, Jordan Porter
*
* The Board class draws the board for the game
* It implements a movement system that uses the Unit move method to change
* the unit's position and then redraws it on the board.
*/
public class Board extends JPanel implements MouseListener{
    int numPixels = 30; //number of pixels in tile image - must be a square. (not the map just the tile)
    
    BufferedReader file;
    Unit activeUnit = null;
    Unit newUnit = null;
    String[][] tilePos;
    String[][] regionPos;
    ArrayList<Unit> units;
    LinkedList<Region> regions;
    
    JMenu actions;
    
    JMenuItem createCountry;
    JMenuItem addPlayer;
    
    File map;
    
    public Board(Game g, File map) throws IOException{
    	
    	this.map = map;
    	
    	setLayout(new BorderLayout());
    	loadMap();
    	createRegions();
    	g.setSize(numPixels*tilePos[0].length,numPixels*tilePos.length+45);
        regions = new LinkedList<Region>();
        units = new ArrayList<Unit>();
        addMouseListener(this);   
        
        addPlayer = new JMenuItem("Add Player");
        addPlayer.setMnemonic(KeyEvent.VK_A);
        addPlayer.addActionListener(new ActionListener()	{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = null;
				name = JOptionPane.showInputDialog("Enter Your Name");
				while(name == null)	{
					name = JOptionPane.showInputDialog("YOU MUST ENTER A NAME");
				}
				
				newUnit = new Unit(0,0,"./img/Guy.png", name);
				JOptionPane.showMessageDialog(null, "Click To Place Character");
			}
        	
        });
        
        actions = new JMenu("Actions");
        actions.setMnemonic(KeyEvent.VK_A);
                
        createCountry = new JMenuItem("Create Country");
        createCountry.setMnemonic(KeyEvent.VK_C);
        createCountry.addActionListener(new ActionListener()	{
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		for(Region r : regions)	{
        			if(r.citizens.contains(activeUnit))	{
        				System.out.println("Taking Vote for Region: " + r.name + " With " + r.citizens.size() + " citizens");
        				Election e = new Election(r.citizens);
        				r.isCountry = e.yay_nayVote();
        				System.out.println(r.name + " is Country: " + r.isCountry);
        			}
        		}
        	}
        });
        actions.add(createCountry);
        
        g.menu.add(actions);
        
        g.file.add(addPlayer);
        g.file.remove(g.exitGame);
        g.file.remove(g.newGame);
        g.file.add(g.exitGame);
    }
 
    public void createRegions(){
    	for(int i = 0; i < regionPos[0].length; i++){
    		for( int j = 0; j < regionPos.length; j++){
    			
    		}
    	}
    }
    
    
    private void loadMap() throws IOException {	
    	switch(this.map.getName())	{
    		case "Map4.map":
    			numPixels = 10;
    			break;
    		case "Map3.map":
    			numPixels = 20;
    			break;
    		case "Map2.map":
    			numPixels = 25;
    			break;
    		case "Map1.map":
    			numPixels = 30;
    			break;
    	}
    	
    	file = new BufferedReader(new FileReader("./img/" + map));
    	String current;
    	Scanner sc = null;
    	ArrayList<String[]> tile = new ArrayList<String[]>();
    	while((current=file.readLine())!=null){
    		sc = new Scanner(current);
    		sc.useDelimiter(",");
    		ArrayList<String> thisLine = new ArrayList<String>();
    		while(sc.hasNext()){
    			thisLine.add(sc.next());
    		}
    		String[] line = new String[thisLine.size()];
    		tile.add(thisLine.toArray(line));
    	}
    	
    	file = new BufferedReader(new FileReader("./img/" + map.getName().substring(0, map.getName().length() - 4)));
    	ArrayList<String[]> tileRegion = new ArrayList<String[]>();
    	while((current=file.readLine())!=null){
    		sc = new Scanner(current);
    		sc.useDelimiter(",");
    		ArrayList<String> thisLine = new ArrayList<String>();
    		while(sc.hasNext()){
    			thisLine.add(sc.next());
    		}
    		String[] line = new String[thisLine.size()];
    		tileRegion.add(thisLine.toArray(line));
    	}
    	regionPos = new String[tileRegion.size()][tileRegion.get(0).length];
    	regionPos = tileRegion.toArray(regionPos);
    	tilePos = new String[tile.size()][tile.get(0).length];
    	tilePos = tile.toArray(tilePos);
    	sc.close();
    }




	public void paintComponent(Graphics g){
    	Graphics2D g2d = (Graphics2D) g;
        for(int i=0; i<tilePos.length; i++){  
        	for(int j=0; j<tilePos[i].length; j++){
        		g2d.drawImage(new Tile(tilePos[i][j]).getImage(), j*this.numPixels,i*this.numPixels, numPixels, numPixels, this);
        	}
        }
        for(int i=0; i<regionPos.length; i++){  
        	for(int j=0; j<regionPos[i].length; j++){
        		//g2d.setColor();
        		g2d.drawRect(j*this.numPixels,i*this.numPixels, numPixels, numPixels);
        	}
        }
        for(Unit u : units){
        	if(u.equals(activeUnit))	{
        		g.setColor(Color.RED);
        		g2d.fillRect(u.getCol()*this.numPixels, u.getRow()*this.numPixels-18, (int) (u.playerName.length()*7.5), 14);
        	}
        	g.setColor(Color.WHITE);
        	g2d.setFont(Font.getFont("Courier"));
        	g2d.drawString(u.playerName, u.getCol()*this.numPixels, u.getRow()*this.numPixels-6);
        	g2d.drawImage(u.getImage(), u.getCol()*this.numPixels , u.getRow()*this.numPixels, numPixels, numPixels, this);
        }
        g.dispose();
    }
        
    public void mouseClicked(MouseEvent event){
    	if(newUnit != null)	{
    		int y = event.getX();
	        int x = event.getY();
	        x = x/this.numPixels; 
	        y = y/this.numPixels;
    		newUnit.move(x, y);
    		units.add(newUnit);
    		newUnit = null;
    		repaint();
    	}
    }
    
    public void mouseEntered(MouseEvent arg0) {}
    
    public void mouseExited(MouseEvent arg0) {}
    
    public void mousePressed(MouseEvent event) {
	    try {	
    		int y = event.getX();
	        int x = event.getY();
	        x = x/this.numPixels; 
	        y = y/this.numPixels; 
	        for(Unit u : units)	{
	        	if(u.getRow() == x && u.getCol() == y){
	        		activeUnit = u;
	        		repaint();
	        		break;
	        	}
	        	else	{
	        		activeUnit = null;
	        	}
	        }
	    }
	    catch(Exception e)	{
	    	System.out.println("NO PLAYER ON THE BOARD!");
	    }
    }
    
    public void mouseReleased(MouseEvent event) {
    	try	{
	    	int y = event.getX();
	        int x = event.getY();
	        x = x/this.numPixels; //using truncation of integers to get rowNum
	        y = y/this.numPixels; //likewise here.
	        if(x < tilePos.length && y <tilePos[1].length){
	    		if(!tilePos[x][y].equals("W"))	{
	    			activeUnit.move(x, y);
	            	repaint();
	           	}
	    		else if(tilePos[x][y].equals("W"))	{
	    			units.remove(activeUnit);
	    			repaint();
					JOptionPane.showMessageDialog(null, "YOU HAVE DROWNED! Click The Map To Resurrect Yourself");
	    			newUnit = activeUnit;
	    		}
	        }
	        
    	}
    	catch(Exception e)	{
    		System.out.println("No Active Player");
    	}
    }

}
