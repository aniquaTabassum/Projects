package Server;


import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;


/**
 *
 * @author Aniqua Tabassum
 */
//this class is responsible for drawing the screenshots on the screen
public class GenerateClientScreen extends Thread 
{
//Variable declaration
    private ImageIcon iIcon = null;//This variable holds the screenshots of the client screen
    private Image image = null;
    private JDesktopPane desktop = null;
    private JFrame frame = null;
    private JPanel panel = null;
    private JInternalFrame inter = null;
    private Icon icon;//This variable holds the Client's screen's screenshots as Icons
    private  Graphics g;//This variable helps draw the client screen on the server's panel
    int i;

    public GenerateClientScreen(ImageIcon iIcon, JFrame frame, JDesktopPane desktop, JInternalFrame inter, JPanel panel) {
        this.iIcon = iIcon;
        this.frame = frame;
        this.desktop = desktop;
        this.inter = inter;
        this.panel = panel;
        this.i = i;

        start();
    }

    public void run() {
        //Scales the image of the Client's screen according to the dimension of the Server's Screen
       scaleImage();
       //Draws the scaled image in the Server's screen
       drawImage();
       
    }
    //This method scales the image of client screen according to the server panel
    private void scaleImage()
    {   
        //Gets the image in "Image" form
        //This is done because there is no method for scaling the images when they are in ImageIcon form
        image = iIcon.getImage();
        //Scales the image according to the Server's screen and the scaling is done smoothly so that the image stays clear
        image = image.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
    }
    //This method draws the scaled image in the server panel
    private void drawImage()
    {
        g = panel.getGraphics();
        g.drawImage(image, 0, 0, panel.getWidth(), panel.getHeight(), panel);
        g.dispose();
    }
}
