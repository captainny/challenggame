import java.util.Random;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class apple2 {
    Image img;
            public int x =0,mx=20;
	public int y=500;//ทำให้ภาพอยู่ตรงกลาง
	public int count = 0;
	apple2(){
                String imageLocation = "apple.png";
                URL imageURL = this.getClass().getResource(imageLocation);
		img = Toolkit.getDefaultToolkit().getImage(imageURL);
		//runner.start();
	}
	
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