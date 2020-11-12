import java.util.Random;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class aunt {
    Image img;
            public int x = 750;
	public int y=500;//ทำให้ภาพอยู่ตรงกลาง
	public int count = 0;
	aunt(){
                String imageLocation = "aunt.png";
                URL imageURL = this.getClass().getResource(imageLocation);
		img = Toolkit.getDefaultToolkit().getImage(imageURL);
		//runner.start();
	}
	Thread runner = new Thread(new Runnable() {
            public void run() {
		while(true){
                    x=750;
                    y=300;
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
	
}
    

