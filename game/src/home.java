

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class home extends JPanel implements ActionListener,MouseListener{
    ImageIcon st = new ImageIcon(this.getClass().getResource("Cap_start.png"));
    ImageIcon sto = new ImageIcon(this.getClass().getResource("Cap_Exito.png"));
    JButton start = new JButton(st);
    ImageIcon bg = new ImageIcon(this.getClass().getResource("bg.png"));
    ImageIcon ch = new ImageIcon(this.getClass().getResource("challeng.png"));
     ImageIcon s_1 = new ImageIcon(this.getClass().getResource("s_1.png"));
    
    
    public home() {
        setLayout(null);
        this.add(start);
        start.setBorderPainted(false);
        start.setFocusPainted(false);
        start.setContentAreaFilled(false);
        start.setBounds(600,600,350,140);
        start.addMouseListener(this);
       
        
       
    }
    
    @Override
 protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bg.getImage(),0,0,1500,900, this);
        g.drawImage(ch.getImage(),400,300,700,600, this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if(me.getSource()==start){
            start.setIcon(sto);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if(me.getSource()==start){
            start.setIcon(st);
        }
    }
    
}
