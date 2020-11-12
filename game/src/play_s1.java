

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class play_s1 extends JPanel implements ActionListener,Runnable{
	ImageIcon bg = new ImageIcon(this.getClass().getResource("bg.png"));
        ImageIcon s_1 = new ImageIcon(this.getClass().getResource("s_1.png"));
	public ArrayList<scope> scope = new ArrayList<>();
	public ArrayList<apple> ap = new ArrayList<>();
        aunt  un = new aunt();
        Thread thread=new Thread(this);
        ImageIcon nt = new ImageIcon(this.getClass().getResource("next.png"));
        JButton next=new JButton(nt);
	public int times ;
	public int HP = 3;
	public int rs1 = 1;
	public int rs2 = 2;
        boolean starup = true;
	boolean timestart = true;
	boolean startball = false;
	
	
	public int scor = 0;
	boolean delapp = false;
	int time_paralyze=5;
	
	Thread time = new Thread(new Runnable(){
            @Override
            public void run(){
		while(true){
                    try{
			Thread.sleep(10);
                    }catch(Exception e){ }
                    
                    if(timestart == false){
			repaint();
                    }
		}
            }
	});
	
	Thread actor = new Thread(new Runnable(){
            @Override
            public void run(){
		while(true){
                	try{
                            Thread.sleep(1);
			}catch(Exception e){}
                            repaint();
		}
            }
	});
	Thread scope1 = new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                	try{
                            if(startball == false){
				Thread.sleep(100);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startball == false){
                            startball=true;
                            scope.add(new scope());
			}
		}
            }
	});
	Thread ap1 = new Thread(new Runnable(){
            @Override
            public void run() {
		while(true){
			try{
                            if(startball==false){
				Thread.sleep(10);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startball == false){
                           
                            ap.add(new apple());
			}
		}
            }
	});
	

	
	play_s1(){
            next.setBounds(675,600,283,145);
            setLayout(null);
           
            actor.start();
            ap1.start();                
            scope1.start();
           
           
           
           
           
            this.addKeyListener(new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e){

                    if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    for(int i=0 ; i<ap.size();i++){
                        for(int j=0 ; j<scope.size();j++){
                            if(Intersect(ap.get(i).getbound(),scope.get(j).getbound())){
                                ap.remove(i);
                                System.out.println(".keyPressed() complete");
                                delapp=true;
                            } 
                        }
                    }

                    }
                }
            });
	}
	
	
        @Override
	public void paintComponent(Graphics g){
            super.paintComponent(g);          
            g.drawImage(bg.getImage(),0,0,1500,900, this);
            for(int i=0 ; i<scope.size();i++){
                g.drawImage(scope.get(i).getImage(),scope.get(i).getX(),scope.get(i).getY(),100,100,this);
            }
            for(int i=0 ; i<ap.size();i++){
                g.drawImage( ap.get(i).getImage() ,ap.get(i).getX(),ap.get(i).getY(),100,100,this);
                g.drawImage(un.getImage(),ap.get(i).getX()-150, ap.get(i).getY()+20, this);
                if(delapp){
                    ap.remove(i);
                    super.paintComponent(g);
                    super.setBackground(Color.white);
                    add(next);
                    this.add(next);
                    next.setBorderPainted(false);
                    next.setFocusPainted(false);
                    next.setContentAreaFilled(false);
                    
                }
            }
            g.drawImage(s_1.getImage(),675,100,300,300, this);
            	
            }


	public boolean Intersect(Rectangle2D a, Rectangle2D b){
		return (a.intersects(b));
	}
        @Override
	public void actionPerformed(ActionEvent e) {

	}

    @Override
    public void run() {
        while(true){
            if(!starup){
                System.out.println("startup");
		actor.start();
                //ap1.start();                
		scope1.start();
                starup=true;
            }
            repaint();
            try{
                Thread.sleep(1000);
            }catch(Exception e){}
        }
    }
    
}
