import java.awt.Image;

import javax.swing.ImageIcon;


public class Tile {
	String type; //G - grass, H - hills, M - mountains, F - forest, W - water, I - Ice, etc.
	String imageUrl = "Tile.png";
	Image image;
	
	public Tile(String type){
		this.type = type;
		imageUrl = "/img/" + type + imageUrl; //concatenates ie. GTile.png, WTile.png, etc.
		ImageIcon ii = new ImageIcon(this.getClass().getResource(imageUrl)); 
		this.image = ii.getImage();
	}
	public Image getImage(){return this.image;}

}
