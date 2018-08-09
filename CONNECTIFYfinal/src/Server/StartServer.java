/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author hp
 */
//This class is responsible for setting up the server and to receive client requests
public class StartServer extends Thread{
   private static ServerSocket ss = null;
   private static Socket server = null;
   
    private DataInputStream passwordStream = null;
   
    private DataInputStream concentStream = null;
   
     public StartServer() throws IOException {
        ss = new ServerSocket(3389);
         System.out.println("entered start server");
         start();
        
    }
     public void run(){ 
        System.out.println("Hi from SS");
	while (true){  
            try{  
		
	        server = ss.accept();
                System.out.println("hi");
                System.out.println("Socket Server Class :" + server);
                ServerFirstPage.receivePassword(server);
                ServerFirstPage.receiveConcent(server);
	    }
	    catch(Exception ioe){ 
              
	    }
        }
    }
     protected static Socket getServer()
     {
      return StartServer.server;   
     }
   
}
