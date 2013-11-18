import javax.swing.JOptionPane;


/**
 * @author Jordan Porter
 * 
 * The vote interface has methods for
 * taking a vote and for creating a voting window
 *
 */
public interface Vote {

	public boolean vote();
	public JOptionPane voteWindow();
	
}
