import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class Game extends JFrame implements ActionListener{
    private ImageIcon title = new ImageIcon("./img/Title.png");
    private JPanel main;
    private Board board;
    private JLabel titlescreen;
    private JPanel tScreen;

    private JMenuBar menu;
    private JMenu actions;
    private JMenuItem createCountry;
    private JMenu file;
    private JMenuItem newGame;
    private JMenuItem joinGame;
    
    public Game(){
        this.setLayout(new BorderLayout());
        setSize(610,510);
        this.setTitle("CS3716 Project G5");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        final Region region1 = new Region("Region 1", 0, 0, 10, 10);
        
        menu = new JMenuBar();
        file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        actions = new JMenu("Actions");
        actions.setMnemonic(KeyEvent.VK_A);
        
        createCountry = new JMenuItem("Create Country");
        createCountry.addActionListener(new ActionListener()	{
        	public void actionPerformed(ActionEvent e)	{
        		boolean yes = region1.yay_nayVote();
        		System.out.println(yes);
        	}
        });
        actions.add(createCountry);
        
        newGame = new JMenuItem("New Game");
        newGame.addActionListener( new ActionListener (){
            public void actionPerformed(ActionEvent e){
            	board = new Board();
            	region1.citizens.add(board.unit);
            	main.removeAll();
            	main.add(board);
            	repaint();
            }
        });
        joinGame = new JMenuItem("Join Game");
        menu.add(file);
        file.add(newGame);
        file.add(joinGame);
        menu.add(actions);
        
        this.add(menu, BorderLayout.NORTH);
                
        titlescreen = new JLabel(title);
        tScreen = new JPanel();
        tScreen.add(titlescreen);
        
        main = new JPanel();
        main.add(tScreen);
        
        this.add(main, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void actionPerformed( ActionEvent evt ){
        Object o = evt.getSource();
    }
    public static void main(String[] args){
        new Game();
                
    }
}
