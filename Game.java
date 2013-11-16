
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;

/**
 * Game is the main class for our game. 
 *
 **/
public class Game extends JPanel{
    private Player curPlayer;
    private Board board;
    // starting window width and height
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    // width and height to determine a change in the window 
    private int width = -1;
    private int height = -1;
    
    public Game(){
        // PreferredSize of the frame
        setPreferredSize( new Dimension( WINDOW_WIDTH, WINDOW_HEIGHT ));
    }
    
    public Player getCurPlayer(){
        return curPlayer;
    }

    // runApplication method to create a frame for the Game
    public static void runApplication( JPanel app ){
        // Create frame
        JFrame frame = new JFrame();

        frame.setSize(app.getPreferredSize());
        frame.setTitle( app.getClass().getName() );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add(app);
        frame.setVisible( true );
    }
    // Create a new game then add the game to RunApplication
    public static void main( String[] args){
        Game application = new Game();
        runApplication( application );
    }
}
