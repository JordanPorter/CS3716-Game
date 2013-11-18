import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Game extends JFrame implements ActionListener{
        private ImageIcon title = new ImageIcon("Title.png");
    private JPanel main;
    private Board board;
    private JLabel titlescreen;

    private JMenuBar menu;
    private JMenu file;
    private JMenuItem newGame;
    private JMenuItem joinGame;
    
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
                add(board, BorderLayout.CENTER);
                repaint();
                 }
                });
                joinGame = new JMenuItem("Join Game");
                menu.add(file);
                file.add(newGame);
                file.add(joinGame);
                this.add(menu, BorderLayout.NORTH);
                
                titlescreen = new JLabel(title);
                main = new JPanel();
        main.add(titlescreen, BorderLayout.CENTER);
        this.add(main);
        board = new Board();
        this.add(board, BorderLayout.CENTER);
                //gamePanel.add(new JButton("JoinGame"));
                //this.add(gamePanel, BorderLayout.EAST);
                this.setVisible(true);
        }

        public void actionPerformed( ActionEvent evt ){
        Object o = evt.getSource();
        }
        public static void main(String[] args){
                new Game();
                
        }
}
