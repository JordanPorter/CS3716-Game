import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

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
    int numPixels = 60; //number of pixels in tile image - must be a square. (not the map just the tile)
    String[][] tilePos = {			{"F","F","F","F","F","F","F","F","F","F","F","F","F","F"},
                                    {"M","F","F","F","F","G","G","F","F","F","F","F","F","F"},
                                    {"M","M","F","F","G","G","G","G","G","F","F","F","F","F"},
                                    {"M","M","M","G","G","G","G","G","G","G","F","F","F","F"},
                                    {"M","M","G","G","G","G","G","G","G","G","G","F","F","F"},
                                    {"M","D","W","W","W","W","G","G","G","G","G","G","F","F"},
                                    {"D","D","D","W","W","W","W","W","W","W","G","G","G","F"},
                                    {"D","D","D","D","W","W","W","W","W","W","W","G","G","G"},
                                    {"D","D","D","W","W","W","G","G","W","W","W","G","G","G"},
                                    {"D","D","W","W","W","W","W","W","W","W","W","G","G","G"},
                                    {"D","D","D","D","W","W","W","W","W","W","G","G","G","G"},
                                    {"D","D","D","D","D","D","D","G","G","G","G","G","G","G"},
    };
    
    Unit activeUnit = null;
    
    LinkedList<Unit> units;
    LinkedList<Region> regions;
    
    JMenuItem addPlayer;
    JMenuItem exitGame;
    
    public Board(Game g){
    	setLayout(new BorderLayout());
    	g.setSize(numPixels*tilePos[0].length,numPixels*tilePos.length+45);
        regions = new LinkedList<Region>();
        units = new LinkedList<Unit>();
        regions.add(new Region("Allanland", 0, 0, tilePos[0].length/2, tilePos.length/2, Color.MAGENTA));
        regions.add(new Region("Jordanland",tilePos[0].length/2, 0, tilePos[0].length/2, tilePos.length/2, Color.BLUE));
        regions.add(new Region("Joshland", 0, tilePos.length/2, tilePos[0].length/2, tilePos.length/2, Color.GREEN));
        regions.add(new Region("Nishantland", tilePos[0].length/2, tilePos.length/2, tilePos[0].length/2, tilePos.length/2, Color.RED));
        addMouseListener(this);   
        
        addPlayer = new JMenuItem("Add Player");
        addPlayer.addActionListener(new ActionListener()	{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = null;
				name = JOptionPane.showInputDialog("Enter Your Name");
				while(name == null)	{
					name = JOptionPane.showInputDialog("YOU MUST ENTER A NAME");
				}
				units.add(new Unit(0,0,"./img/Guy.png", name));
				repaint();
			}
        	
        });
        
        exitGame = new JMenuItem("Exit Game");
        exitGame.addActionListener(new ActionListener()	{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
        	
        });
        
        g.file.add(addPlayer);
        g.file.add(exitGame);
        g.file.remove(g.newGame);
        g.file.remove(g.joinGame);
        
    }
 
    public void paintComponent(Graphics g){
    	Graphics2D g2d = (Graphics2D) g;
        for(int i=0; i<tilePos.length; i++){  
        	for(int j=0; j<tilePos[i].length; j++){
        		g2d.drawImage(new Tile(tilePos[i][j]).getImage(), j*this.numPixels,i*this.numPixels,this);
        		g2d.drawRect(j*numPixels, i*numPixels, numPixels, numPixels);
        	}
        }
        for(Region r : regions)	{
        	g.setColor(r.color);
        	g.drawRect(r.x*60, r.y*60, r.x + r.length*60-1, r.y + r.width*60-1);
        	g.setColor(Color.WHITE);
        	g.drawString(r.name, r.x*60 + r.length/2*60, r.y*60 + r.width/2*60);
        }
                
        for(Unit u : units){
        	g.setColor(Color.WHITE);
        	g2d.drawString(u.playerName, u.getCol()*this.numPixels + 9, u.getRow()*this.numPixels + 10);
        	g2d.drawImage(u.getImage(), u.getCol()*this.numPixels + 10, u.getRow()*this.numPixels + 10, this);
        }
        g.dispose();
    }
        
    public void mouseClicked(MouseEvent event){}
    
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
	    		if(!tilePos[x][y].equals("W") && !tilePos[x][y].equals("M")){
	    			activeUnit.move(x, y);
	            	repaint();
	           	}
	        }
    	}
    	catch(Exception e)	{
    		System.out.println("No Active Player");
    	}
    }

}
