import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Game extends JFrame implements ActionListener{
	private ImageIcon title = new ImageIcon("Title.png");
    private JPanel gamePanel;
    private Board board;
    private JLabel titlescreen;
    
	public Game(){
		this.setLayout(new BorderLayout());
		setSize(750,490);
		this.setTitle("CS3716 Project G5");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		titlescreen = new JLabel(title);
        this.add(titlescreen, BorderLayout.CENTER);
        board = new Board();
        gamePanel = new JPanel();
        this.add(board, BorderLayout.CENTER);
		gamePanel.add(new JButton("JoinGame"));
		this.add(gamePanel, BorderLayout.EAST);
		this.setVisible(true);
	}

	public void actionPerformed( ActionEvent evt ){
        Object o = evt.getSource();
	}
	public static void main(String[] args){
		new Game();
		
	}
}
