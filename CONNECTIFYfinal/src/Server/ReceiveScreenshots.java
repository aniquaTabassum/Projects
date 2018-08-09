package Server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class ReceiveScreenshots extends Thread //this class is responsible for receiving the screenshots from client and draws the GUI for displaying them
{//Variable declaration
    private Socket s = null;//The streams are based on this Socket
    private ImageIcon normalImage = null;//This variable receives and stores the screenshots of the client screen
    private JDesktopPane desktop = new JDesktopPane();
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JInternalFrame inter = new JInternalFrame("Client Screen", true, true, true);
    private ObjectInputStream ois = null;//This stream is used for receiving the Client's screenshots
    private Rectangle rectangle;//This variable holds the dimension of the client screen
    private String concent;//this variable holds the concent of the Client regarding the controling of the Client's screen
    public ReceiveScreenshots(Socket s, String concent) {
        this.s = s;
        this.concent = concent;
        drawGUI();
        start();

    }

    public void run() {
        int i = 1;

        try {
            //Initialising the stream
            ois = new ObjectInputStream(s.getInputStream());
            //Receiving the dimension of the Client's screen
            receiveClienScreenDimension();

        } catch (IOException ex) {
            Logger.getLogger(ReceiveScreenshots.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReceiveScreenshots.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {

            try {
                //Receiving the Client's screen's screenshots
                receiveImage();
            } catch (IOException ex) {
                Logger.getLogger(ReceiveScreenshots.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReceiveScreenshots.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Generating the Client's Screen on the Server's screen
            new GenerateClientScreen(normalImage, frame, desktop, inter, panel);

        }
    }
    //this method receives the dimension of the client screen
    private void receiveClienScreenDimension() throws IOException, ClassNotFoundException
    {
     //Receiving the dimension and storing them in Rectangular form
     rectangle =(Rectangle) ois.readObject();  
     //if the Client permits, then the Server is starting to ontrol the Client's screen
     if(concent.equalsIgnoreCase("yes"))
     {
     new ClientCommandsSender(s,panel,rectangle);
        System.out.println("dimension received");
     }
    }
    //receives image from the client
    private void receiveImage() throws IOException, ClassNotFoundException 
    {
       normalImage = (ImageIcon) ois.readObject(); 
    }
    //Draws the GUI of the panel where the Client screen is shown in the Server's screen
    private void drawGUI() {
        //The program is terminated when the exit button closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the background to blue
        frame.getContentPane().setBackground(Color.BLUE);
        //sets the dimension of the panel
        frame.setSize(400, 400);
        //sets the visibility of the page to "true"
        frame.setVisible(true);
        //sets the layout of the internal screen
        inter.setLayout(new BorderLayout());
        //adds the panel to the internl frame
        inter.getContentPane().add(panel);
        //sets the size of the internal panel
        inter.setSize(800, 800);
        //sets the visibility of the panel to "true"
        inter.setVisible(true);
        //makes the panel focusable
        panel.setFocusable(true);
        //adds the internal frame to the JDesktopPane
        desktop.add(inter);
        //sets the visibility of the JDesktopPane to "true"
        desktop.setVisible(true);
        //adds the JDesktopPane to the frame
        frame.add(desktop);
    }
}
