

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

public class play_s3 extends JPanel implements ActionListener,Runnable{
	ImageIcon bg = new ImageIcon(this.getClass().getResource("bg.png"));
        ImageIcon s_3 = new ImageIcon(this.getClass().getResource("s_3.png"));
        ImageIcon cm = new ImageIcon(this.getClass().getResource("complete.png"));
	public ArrayList<scopeee> scopeee = new ArrayList<>();
	public ArrayList<apple2> ap = new ArrayList<>();
        apple2 a=new apple2();
        aunt  un = new aunt();
        
        Thread thread=new Thread(this);
        ImageIcon ex = new ImageIcon(this.getClass().getResource("exitttt.png"));
        JButton next = new JButton(ex);
	public int times ;
	public int HP = 3;
	public int rs1 = 1;
	public int rs2 = 2;
        boolean starup = true;
	boolean timestart = false;
	boolean startball = false;
	
	
	public int scor = 0;
	boolean delapp = false;
	int time_paralyze=5;
	public int appx=0;
        
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
                            scopeee.add(new scopeee());
			}
		}
            }
	});
	 Thread ap1=new Thread(new Runnable() {
             public int mx=30;
        @Override
        public void run() {
            while(true){
                if(timestart == false){
                    a.x+=mx ; 
                    if(a.x==1500){
                        mx=-5;
                    }
                    else if(a.x<=0){
                        mx=5;
                    }
                }
                try{
                    Thread.sleep(1);
                }catch(InterruptedException e){}
            }
        }
    }); 
	play_s3(){
            next.setBounds(675,600,283,145);
            setLayout(null);
            actor.start();
            ap1.start();                
            scope1.start();
            this.addKeyListener(new KeyAdapter(){
                @Override
                public void keyPressed(KeyEvent e){

                    if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    for(int i=0 ; i<scopeee.size();i++){
                            if(Intersect(a.getbound(),scopeee.get(i).getbound())){
                                
                                System.out.println(".keyPressed() complete");
                                delapp=true;
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
            for(int i=0 ; i<scopeee.size();i++){
                g.drawImage(scopeee.get(i).getImage(),scopeee.get(i).getX(),scopeee.get(i).getY(),100,100,this);
            }
            g.drawImage(a.getImage(),a.getX(),a.getY(),100,100, this);
            for(int i=0 ; i<scopeee.size();i++){
                g.drawImage( scopeee.get(i).getImage() ,scopeee.get(i).getX(),scopeee.get(i).getY(),100,100,this);
                g.drawImage(un.getImage(),a.getX()-150, a.getY()+20, this);
                if(delapp){
                    super.paintComponent(g);
                    super.setBackground(Color.white);
                     g.drawImage(bg.getImage(),0,0,1500,900, this);
                      g.drawImage(cm.getImage(),0,0,1500,900, this);
                    add(next); 
                    this.add(next);
                    next.setBorderPainted(false);
                    next.setFocusPainted(false);
                    next.setContentAreaFilled(false);
                }
            }
                 g.drawImage(s_3.getImage(),675,100,200,200, this);
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
                ap1.start();  
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

