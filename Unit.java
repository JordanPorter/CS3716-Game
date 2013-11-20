import java.awt.GridLayout;
import java.awt.Image;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
	
	/**
	 * setHappiness will prompt the user to place its percent happiness values for a total of 100
	 * points, if the user enters an invalid format or numbers not adding up to 100 the user will
	 * be notified and prompted to correct their mistakes.
	 * Happiness values will then be set.
	 */
	public void setHappiness(){
		JPanel choices = new JPanel(new GridLayout(5,2));
		double gValue = 0, mValue = 0, lValue = 0, bValue = 0, kValue = 0;
		NumberFormat percentFormat = NumberFormat.getNumberInstance();
		percentFormat.setMinimumFractionDigits(3);
		JLabel governLabel = new JLabel("Govern(%):");
		JFormattedTextField gNum = new JFormattedTextField();
		JLabel moneyLabel = new JLabel("Money(%):");
		JFormattedTextField mNum = new JFormattedTextField();
		JLabel left_aLabel = new JLabel("Left Alone(%):");
		JFormattedTextField lNum = new JFormattedTextField();
		JLabel buildLabel = new JLabel("Building(%):");
		JFormattedTextField bNum = new JFormattedTextField();
		JLabel killLabel = new JLabel("Killing(%):");
		JFormattedTextField kNum = new JFormattedTextField();
		choices.add(governLabel);
		choices.add(gNum);
		choices.add(moneyLabel);
		choices.add(mNum);
		choices.add(left_aLabel);
		choices.add(lNum);
		choices.add(buildLabel);
		choices.add(bNum);
		choices.add(killLabel);
		choices.add(kNum);
		while(true){
			try{
				JOptionPane.showConfirmDialog(null, choices, "Choose % happiness for each:", JOptionPane.OK_CANCEL_OPTION);
				gValue = Double.parseDouble(gNum.getText());
				mValue = Double.parseDouble(mNum.getText());
				lValue = Double.parseDouble(lNum.getText());
				bValue = Double.parseDouble(bNum.getText());
				kValue = Double.parseDouble(kNum.getText());
				if((gValue + mValue + lValue + bValue + kValue) == 100) break;
				else{
					System.out.println("Not 100% assigned for Happiness");
					JOptionPane.showMessageDialog(null, "Values must add up to 100.");
				}
			}
			catch(NumberFormatException e){
				System.out.println("Number Format error");
				JOptionPane.showMessageDialog(null, "Invalid number entered.");
			}
		}
		hap = new Happiness(gValue,mValue,lValue,bValue,kValue);
	}
}
