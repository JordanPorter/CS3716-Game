import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	int x;
	int y;
	private Image image;
	Happiness hap;
	String playerName;

	/**
	 * Constructor for Unit
	 * @param row location of Unit
	 * @param col location of Unit
	 * @param unitPicUrl, url for image of Unit
	 * @param playerName, name player has set for Unit
	 */
	public Unit(int row, int col, String unitPicUrl, String playerName){
		this.row = row;
		this.col = col;
		this.playerName = playerName;
		ImageIcon ii = new ImageIcon(this.getClass().getResource(unitPicUrl));
		image = ii.getImage();
		setHappiness();
	}
	
	/**
	 * 
	 */
	public Unit()	{
	}
	
	/**
	 * @return row location of Unit
	 */
	public int getRow()	{
		return this.row;
	}
	
	/**
	 * @return col location of Unit
	 */
	public int getCol()	{
		return this.col;
	}
	
	/**
	 * @return
	 */
	public int getX()	{
		return col*60;
	}
	
	/**
	 * @return
	 */
	public int getY()	{
		return row*60;
	}
	
	/**
	 * move changes the location of the Unit on the board
	 * @param row
	 * @param col
	 */
	public void move(int row,int col)	{
		this.row = row; 
		this.col = col;
	}
	
	/**
	 * @return image of the Unit
	 */
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
		// create JPanel for choices
		JPanel choices = new JPanel(new GridLayout(6,2));
		// initiate variables for values
		double gValue = 0, mValue = 0, lValue = 0, bValue = 0, kValue = 0;
		NumberFormat percentFormat = NumberFormat.getNumberInstance();
		percentFormat.setMinimumFractionDigits(2);
		// create labels and fields for values
		JLabel governLabel = new JLabel("Govern(%):");
		JFormattedTextField gNum = new JFormattedTextField(percentFormat);
		JLabel moneyLabel = new JLabel("Money(%):");
		JFormattedTextField mNum = new JFormattedTextField(percentFormat);
		JLabel left_aLabel = new JLabel("Left Alone(%):");
		JFormattedTextField lNum = new JFormattedTextField(percentFormat);
		JLabel buildLabel = new JLabel("Building(%):");
		JFormattedTextField bNum = new JFormattedTextField(percentFormat);
		JLabel killLabel = new JLabel("Killing(%):");
		JFormattedTextField kNum = new JFormattedTextField(percentFormat);
		
		// total field to display to the user amount they've placed so far.
		//JLabel totalLabel = new JLabel("Total:");
		//JFormattedTextField total = new JFormattedTextField(percentFormat);
		//total.setEditable(false);
		//total.setForeground(Color.red);
		
		// add fields and values to choices JPanel
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
		
		//choices.add(totalLabel);
		//choices.add(total);
		
		// continue until the user enters the values correctly
		while(true){
			try{
				// pop up to prompt user to enter ratios for happiness values
				JOptionPane.showConfirmDialog(null, choices, "Choose % happiness for each(Adding up to 100%):", JOptionPane.DEFAULT_OPTION);
				gValue = Double.parseDouble(gNum.getText());
				mValue = Double.parseDouble(mNum.getText());
				lValue = Double.parseDouble(lNum.getText());
				bValue = Double.parseDouble(bNum.getText());
				kValue = Double.parseDouble(kNum.getText());
				// if all values equal up to 100% then it was entered correctly
				if((gValue + mValue + lValue + bValue + kValue) == 100) break;
				else{
					System.out.println("Values user entered do not equal 100");
					JOptionPane.showMessageDialog(null,  "Values must add up to 100.", "ALERT", JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(NumberFormatException e){
				System.out.println("Number Format error when setting Happiness ratios");
				JOptionPane.showMessageDialog(null, "Invalid number entered.", "ALERT", JOptionPane.ERROR_MESSAGE);
			}
		}
		// create happiness with the entered ratios
		hap = new Happiness(gValue,mValue,lValue,bValue,kValue);
	}
}
