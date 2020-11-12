

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Graphics;
import javax.sound.sampled.Clip;


public class playgame extends JFrame implements ActionListener{
    
    home home1 = new home();
    play_s1 s1 = new play_s1();
    play_s2 s2 = new play_s2();
    play_s3 s3 = new play_s3();
    gameover gameover = new gameover();
    
    public playgame() {
        this.setSize(1500,900);
        this.add(home1);
        home1.start.addActionListener(this);
        s1.next.addActionListener(this);
        s2.next.addActionListener(this);
        s3.next .addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==home1.start){
            this.remove(home1);
             s1.starup=false;           
            this.add(s1);

            s1.requestFocusInWindow();
        }
        else if(e.getSource()==s1.next){
            this.remove(s1);
            s1.actor.stop();
            s1.ap1.stop();
            s1.scope1.stop();
             s2.starup=false;           
            this.add(s2);
            s2.requestFocusInWindow();
        }
        else if(e.getSource()==s2.next){
            this.remove(s2);
            s2.actor.stop();
            s2.ap1.stop();
            s2.scope1.stop();
            s3.starup=false;           
            this.add(s3);
            s3.requestFocusInWindow();
            s3.timestart=false;
        }
        else if(e.getSource()==s3.next){
            System.exit(0);
        }
        validate();
        repaint();
        
    }
    
    
}


