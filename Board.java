import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class Board extends JPanel implements MouseListener{
        int numPixels =60; //number of pixels in tile image - must be a square. (not the map just the tile)
        String[][] tilePos = {			{"I","I","I","I","I","F","F","F","F","F"},
                                         {"M","I","I","I","I","I","G", "M","M","M"},
                                         {"M","M","H","H","H","G","G","G","G","G"},
                                         {"M","M","G","G","G","G","G","G","G","G"},
                                         {"G","G","G","G","G","G","G","G","G","F"},
                                         {"D","D","W","W","W","W","G","G","F","F"},
                                         {"D","D","D","W","W","W","W","W","W","F"},
                                         {"D","D","D","D","W","W","W","W","W","W"},
                                         };
       //Unit[] units;
       //int emptySlot = 0;
       //int maxSlots = 4;
      //ArrayList<Unit> units; //will do this later
      LinkedList<Unit> units;
       Unit unit;
       Unit unit1;
       ArrayList<Region> regions;
       Unit unit2;
       Region region1;
       Region region2;
        
        //Tile[][] tiles = new Tile[8][8]; Not required, We should create a map where key{I,F,G,M,D,W) and value{attributes of I, ...} near array efficiency at a fraction of memory cost.
        
        public Board(){
        		setLayout(new BorderLayout());
                setSize(numPixels*tilePos.length,numPixels*tilePos[1].length);
                //units = new Unit[maxSlots];
                //units = new ArrayList<Unit>();
                regions = new ArrayList<Region>();
                units = new LinkedList<Unit>();
                unit1 = new Unit(3,4,"Guy.png");
                region1 = new Region("Canada",0,0,3,9);
                region2 = new Region("US",4,0,7,9);
                regions.add(region1);
                regions.add(region2);
                unit2 = new Unit(7,3, "Guy.png");
                //units[emptySlot] = unit;
                //emptySlot++;
                //units[emptySlot] = unit2;
                //emptySlot++;
                units.add(unit1);
                units.addFirst(unit2);
                unit = unit1;
                addMouseListener(this);
                
                //initTiles();
        }
        //public void initTiles(){
        //        for(int i=0; i<tilePos.length;i++){
        //                for(int j=0; j<tilePos[i].length; j++){
        //                        tiles[i][j] = new Tile(tilePos[i][j]);
        //                }
        //        }
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
                               // g2d.drawLine(arg0, arg1, arg2, arg3)
                        }
                }
                //for(int i =0; i<tilePos[i].length; i++){
                //	g2d.drawLine(0, i*this.numPixels, tilePos[1].length*this.numPixels, i*this.numPixels);
                //}
                for(Unit u : units){
                	  g2d.drawImage(u.getImage(), u.getCol()*this.numPixels + 10, u.getRow()*this.numPixels + 10, this);
                }
                g.dispose();
        }
        
        public void mouseClicked(MouseEvent event){
                int y = event.getX();
                int x = event.getY();
                x = x/this.numPixels; //using truncation of integers to get rowNum
                y = y/this.numPixels; //likewise here.
                
                if(x < tilePos.length && y <tilePos[1].length){
                	if(Math.abs(x-unit.row) <= 1 && Math.abs(y-unit.col) <= 1){
                		if(!tilePos[x][y].equals("W") && !tilePos[x][y].equals("M")){
                			unit.move(x, y);
                			repaint();
                			unit = units.removeFirst();
                			units.addLast(unit);
                		}
                	}
                }
        }
        public void mouseEntered(MouseEvent arg0) {}
        public void mouseExited(MouseEvent arg0) {        }
        public void mousePressed(MouseEvent arg0) {}
        public void mouseReleased(MouseEvent arg0) {}
        
        //JButton joinButton = new JButton("JoinGame");
        //add(new JButton("JoinGame"));
        
       /* public static void main (String[] args){
            JFrame frame = new JFrame();
            frame.setSize(480,550);
            frame.setTitle("Stuff");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.add(new Board());
            //frame.add(new JButton("JoinGame"));
            frame.setVisible(true);
    }*/
}
