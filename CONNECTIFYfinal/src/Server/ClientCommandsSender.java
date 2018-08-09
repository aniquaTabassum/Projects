package Server;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JPanel;

/**
 * @author Aniqua Tabassum
 */
//This class sends the command fro the server to the client and controls the Client's PC
//Some methods are left unused here as the class implements KeyListener interface and all of the interface's methods needs to be present in this class
class ClientCommandsSender implements KeyListener,
        MouseMotionListener,MouseListener {
//Variable declaration
    private Socket cSocket = null;
    private JPanel cPanel = null;
    private PrintWriter writer = null;
    private Rectangle clientScreenDim = null;
    private double xScale;//xAxis after scaling
    private double yScale;//yAxis after scaling
    ClientCommandsSender(Socket s, JPanel p, Rectangle r) {
        cSocket = s;
        cPanel = p;
        clientScreenDim = r;
        //Associating the event listeners to the panel
        AssociateEvent();
        try {
             //Prepare PrintWriter which will be used to send commands to
             //the client
            writer = new PrintWriter(cSocket.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    //This method associate event listners to the panel     
    private void AssociateEvent()
    {
         cPanel.addKeyListener(this);
        cPanel.addMouseListener(this);
        cPanel.addMouseMotionListener(this);
    }
    //Not implemeted yet
    public void mouseDragged(MouseEvent e) {
    }
    //Gets the dimension after scaling
    private void Scale()
    {
       
         xScale = clientScreenDim.getWidth()/cPanel.getWidth();
        System.out.println("xScale: " + xScale);
         yScale = clientScreenDim.getHeight()/cPanel.getHeight();
        System.out.println("yScale: " + yScale);
    }
    //THE METHOD IS "PUBLIC" AND NOT "PRIVATE" AS THESE ARE BUILT-IN METHODS AND CHANGING IT TO "PRIVATE" WILL SHOW AN ERROR MESSAGE
    //handles the event when the mouse is moved
    public void mouseMoved(MouseEvent e) {
        Scale();
        System.out.println("Mouse Moved");
        writer.println(EnumCommands.MOVE_MOUSE.getAbbrev());
        writer.println((int)(e.getX() * xScale));
        writer.println((int)(e.getY() * yScale));
        writer.flush();
    }

    //this is not implemented
    public void mouseClicked(MouseEvent e) {
    }
    //THE METHOD IS "PUBLIC" AND NOT "PRIVATE" AS THESE ARE BUILT-IN METHODS AND CHANGING IT TO "PRIVATE" WILL SHOW AN ERROR MESSAGE
    //handles the events when mouse is clicked
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Pressed");
        writer.println(EnumCommands.PRESS_MOUSE.getAbbrev());
        int button = e.getButton();
       
        writer.println(button);
        writer.flush();
    }
    //THE METHOD IS "PUBLIC" AND NOT "PRIVATE" AS THESE ARE BUILT-IN METHODS AND CHANGING IT TO "PRIVATE" WILL SHOW AN ERROR MESSAGE
    //handles the event when mouse is released
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Released");
        writer.println(EnumCommands.RELEASE_MOUSE.getAbbrev());
        int button = e.getButton();
       
        writer.println(button);
        writer.flush();
    }

    //not implemented
    public void mouseEntered(MouseEvent e) {
    }

    //not implemented
    public void mouseExited(MouseEvent e) {

    }

    //not implemented
    public void keyTyped(KeyEvent e) {
    }
    //THE METHOD IS "PUBLIC" AND NOT "PRIVATE" AS THESE ARE BUILT-IN METHODS AND CHANGING IT TO "PRIVATE" WILL SHOW AN ERROR MESSAGE
    //handles events when a key is pressed
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed");
        writer.println(EnumCommands.PRESS_KEY.getAbbrev());
        writer.println(e.getKeyCode());
        writer.flush();
    }
    //THE METHOD IS "PUBLIC" AND NOT "PRIVATE" AS THESE ARE BUILT-IN METHODS AND CHANGING IT TO "PRIVATE" WILL SHOW AN ERROR MESSAGE
    //handles events when a key is released
    public void keyReleased(KeyEvent e) {
        System.out.println("Mouse Released");
        writer.println(EnumCommands.RELEASE_KEY.getAbbrev());
        writer.println(e.getKeyCode());
        writer.flush();
    }

}
