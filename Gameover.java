package f2.spw;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gameover extends JFrame{
    private int game = 0;
    public Gameover(){
        super("SPACE WAR!!");
        
            setSize(400, 250);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            getContentPane().setLayout(new BorderLayout());
            
            JPanel j = new JPanel();
            j.setLayout(null);
            
            JLabel jb = new JLabel("!!!GAME OVER!!!");
            jb.setBounds(140,30,140,100); 
            j.add(jb);
            getContentPane().add(j);
                  
            setVisible(true);
        
    }
}