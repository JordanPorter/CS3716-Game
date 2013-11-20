import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
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
    String[][] tilePos = {			{"I","I","I","I","I","F","F","F","F","F"},
                                    {"M","I","I","I","I","I","G","M","M","M"},
                                    {"M","M","H","H","H","G","G","G","G","G"},
                                    {"M","M","G","G","G","G","G","G","G","G"},
                                    {"G","G","G","G","G","G","G","G","G","F"},
                                    {"D","D","W","W","W","W","G","G","F","F"},
                                    {"D","D","D","W","W","W","W","W","W","F"},
                                    {"D","D","D","D","W","W","W","W","W","W"},
    };
    
    Unit activeUnit = null;
    
    LinkedList<Unit> units;
    ArrayList<Region> regions;
    Region region1;
    Region region2;
    
    JMenuItem addPlayer;
    
    public Board(Game g){
    	setLayout(new BorderLayout());
        setSize(numPixels*tilePos.length,numPixels*tilePos[1].length);
        regions = new ArrayList<Region>();
        units = new LinkedList<Unit>();
        region1 = new Region("Canada",0,0,3,9);
        region2 = new Region("US",4,0,7,9);
        regions.add(region1);
        regions.add(region2);
        addMouseListener(this);   
        
        addPlayer = new JMenuItem("Add Player");
        addPlayer.addActionListener(new ActionListener()	{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = JOptionPane.showInputDialog("Enter Yout Name");
				units.add(new Unit(0,0,"./img/Guy.png", name));
				repaint();
			}
        	
        });
        g.file.add(addPlayer);
        
    }
        
    //public void initTiles(){
    //	 for(int i=0; i<tilePos.length;i++){
    //		 for(int j=0; j<tilePos[i].length; j++){
    //      	 tiles[i][j] = new Tile(tilePos[i][j]);
    // 		 }
    //   }
    //}
 
    public void paintComponent(Graphics g){
        //super.paint(g);
    	Graphics2D g2d = (Graphics2D) g;
        for(int i=0; i<tilePos.length; i++){  
        	//g2d.drawLine(i*this.numPixels, 0, i*this.numPixels, tilePos[1].length*this.numPixels);
            //g2d.drawLine(0, i*this.numPixels, tilePos[1].length*this.numPixels, i*this.numPixels);
            //g2d.drawLine(i*this.numPixels, 0, tilePos[1].length*this.numPixels, i*this.numPixels);
        	for(int j=0; j<tilePos[i].length; j++){
        		g2d.drawImage(new Tile(tilePos[i][j]).getImage(), j*this.numPixels,i*this.numPixels,this);              
        		//g2d.drawLine(arg0, arg1, arg2, arg3)
        	}
        }
        
        //for(int i =0; i<tilePos[i].length; i++){
        //	 g2d.drawLine(0, i*this.numPixels, tilePos[1].length*this.numPixels, i*this.numPixels);
        //}
                
        for(Unit u : units){
        	g2d.drawImage(u.getImage(), u.getCol()*this.numPixels + 10, u.getRow()*this.numPixels + 10, this);
        }
        g.dispose();
    }
        
    public void mouseClicked(MouseEvent event){}
    
    public void mouseEntered(MouseEvent arg0) {}
    
    public void mouseExited(MouseEvent arg0) {}
    
    public void mousePressed(MouseEvent event) {
    	int y = event.getX();
        int x = event.getY();
        x = x/this.numPixels; 
        y = y/this.numPixels; 
        System.out.println("MousePressed at : " + x + ", " + y);
        for(Unit u : units)	{
        	System.out.println(u.playerName + ": " + u.getRow() + ", " + u.getCol());
        	if(u.getRow() == x && u.getCol() == y){
        		activeUnit = u;
        		System.out.println(u.playerName + " is Active");
        		break;
        	}
        	else	{
        		activeUnit = null;
        	}
        }  
    }
    
    public void mouseReleased(MouseEvent event) {
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

}
