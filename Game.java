import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JFrame implements ActionListener{
    private ImageIcon title = new ImageIcon("./img/TITLE.png");
    public JPanel mainPanel;
    private Board board;
    private JLabel titlescreen;
    private JPanel tScreen;

    static Game g;
    
    public JMenuBar menu;
    public JMenu file;
    public JMenuItem newGame;
    public JMenuItem joinGame;
    
    public Game(){
        this.setLayout(new BorderLayout());
        setSize(610,510);
        this.setTitle("CS3716 Project G5");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        menu = new JMenuBar();
        file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        
        newGame = new JMenuItem("New Game");
        newGame.addActionListener( new ActionListener (){
            public void actionPerformed(ActionEvent e){
            	try {
            		ArrayList<String> maps = new ArrayList<String>();
            		File dir = new File("./img");
            		for(File f : dir.listFiles())	{
            			if(f.getName().endsWith(".map"))
            				maps.add(f.getName());
            		}
            		int selectedMap = JOptionPane.showOptionDialog(null, "Select a Map", "Map Selection", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, maps.toArray(), null);
					System.out.println(selectedMap);
					System.out.println(maps.get(selectedMap));
            		board = new Board(g, new File(maps.get(selectedMap)));
	            	g.remove(mainPanel);
	            	g.add(board, BorderLayout.CENTER);
	            	repaint();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        joinGame = new JMenuItem("Join Game");
        menu.add(file);
        file.add(newGame);
        file.add(joinGame);
        this.add(menu, BorderLayout.NORTH);
                
        titlescreen = new JLabel(title);
        tScreen = new JPanel();
        tScreen.add(titlescreen);


        mainPanel = new JPanel();
        mainPanel.add(tScreen);

        this.add(mainPanel, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed( ActionEvent evt ){
    }
    public static void main(String[] args){
        g = new Game();         
    }
}
