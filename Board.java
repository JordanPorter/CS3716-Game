import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Board extends JPanel implements MouseListener{
	int numPixels =60; //number of pixels in tile image - must be a square. (not the map just the tile)
	String[][] tilePos = {{"I","I","I","I","I","F","F","F"},
					    {"M","I","I","I","I","I","G", "M"},
					    {"M","M","H","H","H","G","G","G"},
					    {"M","M","G","G","G","G","G","G"},
					    {"G","G","G","G","G","G","G","G"},
					    {"D","D","W","W","W","W","G","G"},
					    {"D","D","D","W","W","W","W","W"},
					    {"D","D","D","D","W","W","W","W"},
					    };
	//ArrayList<Unit> units; will do this later
	Unit unit;
	
	//Tile[][] tiles = new Tile[8][8]; Not required, We should create a map where key{I,F,G,M,D,W) and value{attributes of I, ...} near array efficiency at a fraction of memory cost.
	
	public Board(){
		setSize(480,480);
		unit = new Unit(3,4,"Guy.png");
		addMouseListener(this);
		//initTiles();
	}
	//public void initTiles(){
	//	for(int i=0; i<tilePos.length;i++){
	//		for(int j=0; j<tilePos[i].length; j++){
	//			tiles[i][j] = new Tile(tilePos[i][j]);
	//		}
	//	}
	//}
	
	public void paintComponent(Graphics g){
		//super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		for(int i=0; i<tilePos.length; i++){
			for(int j=0; j<tilePos[i].length; j++){
				g2d.drawImage(new Tile(tilePos[i][j]).getImage(), j*this.numPixels,i*this.numPixels,this);
			}
		}
		g2d.drawImage(unit.getImage(), unit.getCol()*this.numPixels, unit.getRow()*this.numPixels, this);
		g.dispose();
	}
	
	public void mouseClicked(MouseEvent event){
		int y = event.getX();
		int x = event.getY();
		x = x/this.numPixels; //using truncation of integers to get rowNum
		y = y/this.numPixels; //likewise here.
		if(Math.abs(x-unit.row) <= 1 && Math.abs(y-unit.col) <= 1){
			unit.move(x, y);
			repaint();
		}
	}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {	}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	
	public static void main (String[] args){
    	JFrame frame = new JFrame();
    	frame.setSize(480,490);
    	frame.setTitle("Stuff");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setResizable(false);
    	frame.add(new Board());
    	frame.setVisible(true);
    }
}
