import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author 
 *
 */
public class Unit {
	int row; //current tile row
	int col; //current tile col
	private Image image;
	//private String unitPicUrl; //= "unit.png"

	public Unit(int row, int col, String unitPicUrl){
		this.row = row;
		this.col = col;
		//this.unitPicUrl = unitPicUrl;
		ImageIcon ii = new ImageIcon(this.getClass().getResource(unitPicUrl));
		image = ii.getImage();
	}
	
	public int getRow()	{
		return this.row;
	}
	
	public int getCol()	{
		return this.col;
	}
	
	public void move(int row,int col)	{
		this.row = row; 
		this.col = col;
	}
	
	public Image getImage()	{
		return this.image;
	}
		
	/**
	 * The vote method accepts a "yay" or "nay"
	 * vote and outputs a true for "yay" and 
	 * false for "nay"
	 * 
	 * @return true if "yay", false if "nay"
	 */
	public boolean vote()	{
		String thisVote = JOptionPane.showInputDialog("type 'yay' or 'nay' in the box and press 'vote'", null);
		while(true)	{
			if(thisVote.equalsIgnoreCase("yay"))
				return true;
			else if(thisVote.equalsIgnoreCase("nay"))
				return false;
			else
				thisVote = JOptionPane.showInputDialog("type 'yay' or 'nay' in the box and press 'vote'", null);
		}
	}
}
