import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class jframegame {

    public static void main(String[] args) {
        JFrame jf =new playgame();
        jf.setSize(1500,900);
        jf.setTitle("mygame");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setFocusableWindowState(true);
        jf.setLocationRelativeTo(jf);
    }
    
}
