package Server;


import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//This class creates the User Interface of the first page when the user decides to continue as "Server"
public class ServerFirstPage extends javax.swing.JFrame {

    public ServerFirstPage() throws IOException {
        initComponents();
        this.setLocationRelativeTo(null);
         try {
                    showIp();
                   
                } catch (UnknownHostException ex) {
                    Logger.getLogger(ServerFirstPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                     
      
    }
    //Variable declaration
    private static ServerSocket ss = null;
    private static Socket server = null;
    private static int passwordFromClient;//this variable holds the pasword that comes from the client,for authentication purposes, in Integer format
    private static int passwordFromServer;//this variable holds the pasword that th Server types, for authentication purposes, in Integer format
    private static DataInputStream passwordStream = null;//The password is sent from the Client to the Server, for authentication purposees, using this stream
    private static String passwordFromServerS;//this variable holds the pasword that th Server types, for authentication purposes, in String format
    private static String passwordFromClientS;//this variable holds the pasword that comes from the client,for authentication purposes, in String format
    private static String concent;//This variable holds the information rgarding whether or not the client has decided to let the server control their computerd
    private static DataInputStream concentStream = null;//The concent passes through this stream
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameOfApp = new javax.swing.JPanel();
        exitButton = new javax.swing.JLabel();
        minimizeButton = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        passwordPanel = new javax.swing.JPanel();
        passwordLabel = new javax.swing.JLabel();
        passwordBox = new javax.swing.JPasswordField();
        enterButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        IPtextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        nameOfApp.setBackground(new java.awt.Color(0, 102, 255));
        nameOfApp.setForeground(new java.awt.Color(255, 255, 255));

        exitButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        exitButton.setText("  X");
        exitButton.setToolTipText("Close window");
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });

        minimizeButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        minimizeButton.setText("   -");
        minimizeButton.setToolTipText("Minimize window");
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("CONNECTIFY");
        jLabel1.setToolTipText("Welcome to TEAMVIEWER");

        javax.swing.GroupLayout nameOfAppLayout = new javax.swing.GroupLayout(nameOfApp);
        nameOfApp.setLayout(nameOfAppLayout);
        nameOfAppLayout.setHorizontalGroup(
            nameOfAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nameOfAppLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(minimizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        nameOfAppLayout.setVerticalGroup(
            nameOfAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nameOfAppLayout.createSequentialGroup()
                .addGroup(nameOfAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nameOfAppLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(nameOfAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minimizeButton)))
                    .addGroup(nameOfAppLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        passwordPanel.setBackground(new java.awt.Color(255, 255, 255));

        passwordLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        passwordLabel.setText("Password");

        passwordBox.setToolTipText("Enter the password that has been automatically generated on the client's window");

        enterButton.setText("Enter");
        enterButton.setToolTipText("Press the button to proceed");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Your IP:");

        IPtextField.setEditable(false);
        IPtextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout passwordPanelLayout = new javax.swing.GroupLayout(passwordPanel);
        passwordPanel.setLayout(passwordPanelLayout);
        passwordPanelLayout.setHorizontalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(passwordPanelLayout.createSequentialGroup()
                        .addComponent(passwordBox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enterButton)
                        .addGap(18, 18, 18))
                    .addGroup(passwordPanelLayout.createSequentialGroup()
                        .addComponent(IPtextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        passwordPanelLayout.setVerticalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IPtextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterButton))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(nameOfApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(passwordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nameOfApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(passwordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  //This method sets the localhost of the server in a non editable textfield 
    private void showIp() throws UnknownHostException
    {
         InetAddress ipAddress = InetAddress.getLocalHost();
                    IPtextField.setText(ipAddress.getHostAddress());
    }
    //This method receives the password from the client 
    protected static void receivePassword(Socket server) throws IOException {
        System.out.println("receiving password");
        //Initialising the stream
        passwordStream = new DataInputStream(server.getInputStream());
        //reads the password from the client
        passwordFromClientS = passwordStream.readUTF();
        //Converts it in Integer form
        passwordFromClient = Integer.parseInt(passwordFromClientS);
        System.out.println("entered the receive password. password received is "+passwordFromClient);
    }
    //This method receives the concent of the client regarding the controling their screen
   protected static void receiveConcent(Socket server) throws IOException
   {
       //Initialising the stream
        concentStream = new DataInputStream(server.getInputStream());
        //reading the concent regarding the controlling of the Client's PC
        concent = passwordStream.readUTF();
       
   }
   //Exits the software when "Exit Button"" is pressed
    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitButtonMouseClicked
    //Minimizes the software when "Minimize Button"" is pressed
    private void minimizeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonMouseClicked
    //This method matches the password of the Client and the Server. 
    //If it is a match, then the software moves to the next feature
    //If not then it notifies the server that the password he entered is incorrect and that no connection is established
    
    private void matchPassword()
    {
        //gets the password that the Server has typed from the JPasswordField
        passwordFromServerS = passwordBox.getText();
        passwordFromServer = Integer.parseInt(passwordFromServerS);
        //Checking if the both passwords match or not
        if (passwordFromClient != passwordFromServer) {
            JOptionPane.showMessageDialog(null, "Connection was not established as passwords did not match");
            //Clears the password box and gives the Server another chance to type the correct password
            passwordBox.setText("");
        } else {
            server = StartServer.getServer();
            new ReceiveScreenshots(server,concent);
           
        }
    }
    //this method starts the Pasword matching process when the "Enter button" is clicked
    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButtonActionPerformed
        
        matchPassword();


    }//GEN-LAST:event_enterButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerFirstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerFirstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerFirstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerFirstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    new ServerFirstPage().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ServerFirstPage.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IPtextField;
    private javax.swing.JButton enterButton;
    private javax.swing.JLabel exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel minimizeButton;
    private javax.swing.JPanel nameOfApp;
    private javax.swing.JPasswordField passwordBox;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel passwordPanel;
    // End of variables declaration//GEN-END:variables
}
