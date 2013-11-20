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
	Happiness hap;
	String playerName;
	//private String unitPicUrl; //= "unit.png"

	public Unit(int row, int col, String unitPicUrl, String playerName){
		this.row = row;
		this.col = col;
		this.playerName = playerName;
		ImageIcon ii = new ImageIcon(this.getClass().getResource(unitPicUrl));
		image = ii.getImage();
		setHappiness();
	}
	
	public Unit()	{
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
	
	public void setHappiness(){
		Object[] selection = {"GOVERN", "MONEY", "LEFT_ALONE", "BUILDING", "KILLING"};
		String initial = "GOVERN";
		String type = (String) JOptionPane.showInputDialog(null, "Choose your happiness type:", "Happiness Type", JOptionPane.QUESTION_MESSAGE, null, selection, initial);
		switch(type){
			case "GOVERN":
				hap = new Happiness(Happiness.HapType.GOVERN);
				break;
			case "MONEY":
				hap = new Happiness(Happiness.HapType.MONEY);
				break;
			case "LEFT_ALONE":
				hap = new Happiness(Happiness.HapType.LEFT_ALONE);
				break;
			case "BUILDING":
				hap = new Happiness(Happiness.HapType.BUILDING);
				break;
			case "KILLING":
				hap = new Happiness(Happiness.HapType.KILLING);
				break;
		}
	}
}
