import java.util.Random;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;


public class scope {
    Image img;
            public int x = 0,mx=5;
	public int y=500;//ทำให้ภาพอยู่ตรงกลาง
	public int count = 0;
	scope(){
                String imageLocation = "scope.png";
                URL imageURL = this.getClass().getResource(imageLocation);
		img = Toolkit.getDefaultToolkit().getImage(imageURL);
		runner.start();
	}
	Thread runner = new Thread(new Runnable() {
            public void run() {
		while(true){
                    if(x>=0){
                        
                        x+=mx;
                        if(x==1500){
                            mx=-5;
                        }
                        if(x<=0){
                            mx=5;
                        }
                    }
                    
                    try{
			runner.sleep(10);
                    }catch(InterruptedException e){}
                }
            }
	});
	
	public Image getImage(){
            return img;
	}
	
	public int getX(){
            return x;
	}
	public int getY(){
            return y;
	}
	public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,45,45));
	}
}