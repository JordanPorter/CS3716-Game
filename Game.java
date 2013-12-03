import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Joshua, Jordan
 *
 */
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
    public JMenuItem exitGame;
    public JMenu help;
    public JMenuItem helpitem;
    
    /**
     * 
     */
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
        newGame.setMnemonic(KeyEvent.VK_N);
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
            		board = new Board(g, new File(maps.get(selectedMap)));
	            	g.remove(mainPanel);
	            	g.add(board, BorderLayout.CENTER);
	            	repaint();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            }
        });
        
        exitGame = new JMenuItem("Exit Game");
        exitGame.setMnemonic(KeyEvent.VK_X);
        exitGame.addActionListener(new ActionListener()	{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
        	
        });
        
        help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        helpitem = new JMenuItem("ReadMe");
        helpitem.setMnemonic(KeyEvent.VK_R);
        helpitem.addActionListener( new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		JFrame read = new JFrame();
        		JPanel content = new JPanel();
        		JTextArea readFile = new JTextArea();
        		JScrollPane readme = new JScrollPane(readFile);
        		readme.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        		readme.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        		try{	
        			BufferedReader input = new BufferedReader(new FileReader("README.md"));
        			String line = null;
        			while( (line = input.readLine()) != null){
        				readFile.append(line + "\n");
        			}
        			input.close();
        		}
        		catch(IOException er){
        			System.out.println("File error");
    				JOptionPane.showMessageDialog(null, "Couldn't read file.", "ALERT", JOptionPane.ERROR_MESSAGE);
        		}
        		content.setLayout(new BorderLayout());
        		content.setPreferredSize(new Dimension(500,500));
        		content.add(readme);
        		read.setTitle("CS3716 Project ReadMe");
        		read.setSize(content.getPreferredSize());
        		read.add(content);
        		read.setVisible( true );
        	}
        });
        
        menu.add(file);
        menu.add(help);
        help.add(helpitem);
        file.add(newGame);
        file.add(exitGame);
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

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed( ActionEvent evt ){
    }
    /**
     * @param args
     */
    public static void main(String[] args){
        g = new Game();         
    }
}
