package Client;


import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class SendClientScreen extends Thread//this class is resposibe for sending the client screen to the server
{

    private Socket s;
    private Rectangle rectangle = null;
    private String passString = null;
    private Robot robot = null;
    private ImageIcon previous = new ImageIcon();//Holds the Client Screen's screenshots
    private DataOutputStream passOut = null;//This stream sends out the automatically generated random password
    private DataOutputStream concentOut = null;//This stream sends out the concent of the Client regarding the controlling of the Server's controling the Cllient Screen
    private BufferedImage bImage;//Holds the screenshot as Buffered Image
    private ImageIcon image;//hold the image as ImageIcon
    private ObjectOutputStream ous;//This stream sends out the Client screen's Screenshots
    private String concent;
    public SendClientScreen(Socket s, Robot robot, Rectangle rectangle, String passString, String concent) {

        this.s = s;
        this.rectangle = rectangle;
        this.robot = robot;
        this.passString = passString;
        this.concent = concent;
        start();
    }

    public void run() {

        try {
            //Sending the automatically generated password
            sendPassword();
            //Sending the concent of the Client
            sendConcent();
            //Initialising stream
            ous = new ObjectOutputStream(s.getOutputStream());
            //Sending client's screen dimension
             sendScreenSize();
             //if the client wants the server to control his PC, then we move to the class responsible for the controlling
             if(concent.equalsIgnoreCase("yes"))
            new ServerDelegate(s,robot);
            //new Client(s);
            while (true) {
                //taking screenshots
                takeScreenshots();
                //sending screenshots
                sendScreenshots();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Server has closed the connection");
            System.exit(0);
            Logger.getLogger(SendClientScreen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                passOut.close();
            } catch (IOException ex) {
                Logger.getLogger(SendClientScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //sends the autoamatically generated password to the clinet to verify 
    private void sendPassword() throws IOException 
    {//Initialising stream
        passOut = new DataOutputStream(s.getOutputStream());
        //writing the password to the stream
        passOut.writeUTF(passString);
        passOut.flush();
    }
    //This method sends the concent regarding the controlling of their screen to the server
    private void sendConcent() throws IOException
    {
        //initialising the stream
        concentOut = new DataOutputStream(s.getOutputStream());
        //writing the concent to the stream
        concentOut.writeUTF(concent);
        passOut.flush();
    }
    //Sends the screen of the screen to the server
    private void sendScreenSize() throws IOException
    {
        ous.writeObject(rectangle);
        ous.reset();
        System.out.println("screen size has been sent");
    }
    //takes screenshots of the client screen
    private void takeScreenshots()
    {
        //takes the screenshot
        bImage = robot.createScreenCapture(rectangle);
        //converts it to Image
        image = new ImageIcon(bImage);

    }
    //sends the screenshots to the server
    private void sendScreenshots() throws IOException
    {
        //sending the screenshot via the stream
        System.out.println("before sending image");
        ous.writeObject(image);
        System.out.println(" image sent");
        ous.reset();
        System.out.println(" stream reset");
    }

}
