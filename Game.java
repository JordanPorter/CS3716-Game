import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game extends JFrame {
	
	public Game(){
		this.setLayout(new BorderLayout());
		setSize(750,490);
		this.setTitle("Stuff");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(new Board(), BorderLayout.CENTER);
		JPanel gamePanel = new JPanel();
		gamePanel.add(new JButton("JoinGame"));
		this.add(gamePanel, BorderLayout.EAST);
		this.setVisible(true);
	}
	public static void main(String[] args){
		new Game();
		
	}
}
