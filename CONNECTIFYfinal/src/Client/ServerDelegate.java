package Client;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/*Author : ANIQUA TABASSUM
 * Used to recieve server commands then execute them at the client side
 */
class ServerDelegate extends Thread {

    Socket socket = null;
    Robot robot = null;
    boolean continueLoop = true;

    public ServerDelegate(Socket socket, Robot robot) {
        this.socket = socket;
        this.robot = robot;
        start(); //Start the thread and hence calling run method
    }

    public void run(){
        Scanner scanner = null;
        try {
            //prepare Scanner object
            System.out.println("Preparing InputStream");
            scanner = new Scanner(socket.getInputStream());

            while(continueLoop){
                //recieve commands and respond accordingly
                System.out.println("Waiting for command");
                int command = scanner.nextInt();
                System.out.println("New command: " + command);
                switch(command){
                    case -1:
                    //Controls the button clicks
                    {
                        int whichButtonToPress = scanner.nextInt();
                        //if the value is 1, then the left button is clicked
                        //middle button if 2
                        //right button if 3
                        if(whichButtonToPress == 1)
                        robot.mousePress(InputEvent.BUTTON1_MASK);
                        else  if(whichButtonToPress == 2)
                        robot.mousePress(InputEvent.BUTTON2_MASK);
                        else  if(whichButtonToPress == 3)
                        robot.mousePress(InputEvent.BUTTON3_MASK);
                         break;
                    }
                   
                    case -2:
                    //controls the button release
                    {
                        int whichButtonToRelease = scanner.nextInt();
                        //if the value is 1, then the left button is released
                        //middle button if 2
                        //right button if 3
                        if(whichButtonToRelease == 1)
                            
                        robot.mouseRelease(InputEvent.BUTTON1_MASK);
                         if(whichButtonToRelease == 2)
                            
                        robot.mouseRelease(InputEvent.BUTTON2_MASK);
                          if(whichButtonToRelease == 3)
                            
                        robot.mouseRelease(InputEvent.BUTTON3_MASK);
                    }
                    break;
                    case -3:
                    //controls key pressing events    
                        robot.keyPress(scanner.nextInt());
                    break;
                    case -4:
                    //Controls key releasing events    
                        robot.keyRelease(scanner.nextInt());
                    break;
                    case -5:
                    //Controls the movement of the mouse    
                        robot.mouseMove(scanner.nextInt(), scanner.nextInt());
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
