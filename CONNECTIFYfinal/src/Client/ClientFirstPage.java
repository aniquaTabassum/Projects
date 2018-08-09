package Client;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;

import java.io.IOException;

import java.net.Socket;
import java.util.Random;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;


public class ClientFirstPage extends javax.swing.JFrame {
 //variable declaration
    private int pass;//Stores the automatically generated password visible on the client screen
    private Socket s;//The streams are created based on this socket
    private Robot robot = null;//This robot takes the Client's screen's screenshots, controls the Client's PC according to the server
   //The next two variables are necessary to initiate the Robot
    private GraphicsEnvironment gen;//Stores the Graphics Environment of the Client Screen
    private GraphicsDevice gdev;//Stores the Graphics Device of the client Screen
    private Dimension dim;//Stores the dimension of the client screen
    private Rectangle rectangle;//helps storing the dimension
    private String concent;//Stores whether ornot the client wants the server to control their screen
    public ClientFirstPage() throws IOException, AWTException {
        initComponents();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //generates the automatic password
                    generatePassword();
                  
                } catch (IOException ex) {
                    Logger.getLogger(ClientFirstPage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (AWTException ex) {
                    Logger.getLogger(ClientFirstPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
       
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        teamviewerName = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exitLabel = new javax.swing.JLabel();
        minimizeLabel = new javax.swing.JLabel();
        passwordGeneratePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        generatedPassTextfield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        agreeToControl = new javax.swing.JRadioButton();
        disagreeControl = new javax.swing.JRadioButton();
        GObutton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ipArea = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        teamviewerName.setBackground(new java.awt.Color(51, 102, 255));
        teamviewerName.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("CONNECTIFY");
        jLabel1.setToolTipText("Welcome to TEAMVIEWER");

        exitLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        exitLabel.setForeground(new java.awt.Color(0, 0, 0));
        exitLabel.setText("  X");
        exitLabel.setToolTipText("Close window");
        exitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabelMouseClicked(evt);
            }
        });

        minimizeLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        minimizeLabel.setForeground(new java.awt.Color(0, 0, 0));
        minimizeLabel.setText("  -");
        minimizeLabel.setToolTipText("Minimize window");
        minimizeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout teamviewerNameLayout = new javax.swing.GroupLayout(teamviewerName);
        teamviewerName.setLayout(teamviewerNameLayout);
        teamviewerNameLayout.setHorizontalGroup(
            teamviewerNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teamviewerNameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(minimizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        teamviewerNameLayout.setVerticalGroup(
            teamviewerNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teamviewerNameLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(teamviewerNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(exitLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minimizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        passwordGeneratePanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Password");
        jLabel2.setToolTipText("Automatically generated password for authentication");

        generatedPassTextfield.setForeground(new java.awt.Color(0, 0, 0));
        generatedPassTextfield.setToolTipText("Provide your Server with this automatically generated password to establish a connection");
        generatedPassTextfield.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        generatedPassTextfield.setEnabled(false);
        generatedPassTextfield.setFocusable(false);
        generatedPassTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatedPassTextfieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Do you want your server to control your PC?");

        agreeToControl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        agreeToControl.setForeground(new java.awt.Color(0, 0, 0));
        agreeToControl.setText("Yes");
        agreeToControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agreeToControlActionPerformed(evt);
            }
        });

        disagreeControl.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        disagreeControl.setForeground(new java.awt.Color(0, 0, 0));
        disagreeControl.setText("No");
        disagreeControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disagreeControlActionPerformed(evt);
            }
        });

        GObutton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        GObutton.setForeground(new java.awt.Color(51, 51, 51));
        GObutton.setText("GO");
        GObutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GObuttonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("  IP");

        ipArea.setToolTipText("Enter the IP of the PC you are trying to connect with");

        javax.swing.GroupLayout passwordGeneratePanelLayout = new javax.swing.GroupLayout(passwordGeneratePanel);
        passwordGeneratePanel.setLayout(passwordGeneratePanelLayout);
        passwordGeneratePanelLayout.setHorizontalGroup(
            passwordGeneratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordGeneratePanelLayout.createSequentialGroup()
                .addGroup(passwordGeneratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(passwordGeneratePanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(passwordGeneratePanelLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(GObutton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(passwordGeneratePanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(passwordGeneratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(passwordGeneratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(generatedPassTextfield)
                            .addComponent(ipArea, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(passwordGeneratePanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(agreeToControl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(disagreeControl)
                .addGap(83, 83, 83))
        );
        passwordGeneratePanelLayout.setVerticalGroup(
            passwordGeneratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordGeneratePanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(passwordGeneratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(ipArea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(passwordGeneratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generatedPassTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(passwordGeneratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agreeToControl)
                    .addComponent(disagreeControl))
                .addGap(15, 15, 15)
                .addComponent(GObutton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(teamviewerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(passwordGeneratePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(teamviewerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(passwordGeneratePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//the program terminates when the "exit button" is clicked
    private void exitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseClicked

        System.exit(0);
    }//GEN-LAST:event_exitLabelMouseClicked
//the program minimizes when the "minimize button" is clicked
    private void minimizeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeLabelMouseClicked
       
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeLabelMouseClicked
//Gets the agreement of the user regarding if he wants the client to control his PC or not
    private void agreeToControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agreeToControlActionPerformed
        // TODO add your handling code here:
        disagreeControl.setSelected(false);
        concent = "yes";
    }//GEN-LAST:event_agreeToControlActionPerformed
//Gets the disagreement of the user regarding if he wants the client to control his PC or not
    private void disagreeControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disagreeControlActionPerformed
        // TODO add your handling code here:
        agreeToControl.setSelected(false);
        concent = "no";
    }//GEN-LAST:event_disagreeControlActionPerformed

    private void generatedPassTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatedPassTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_generatedPassTextfieldActionPerformed
//Initiates the client and starts sending screenshots to the Server
    private void GObuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GObuttonActionPerformed
        try {
            // TODO add your handling code here:
            //initiating the client
            initiateClient();
        } catch (IOException ex) {
            Logger.getLogger(ClientFirstPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AWTException ex) {
            Logger.getLogger(ClientFirstPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        //sendinf the screenshots
        new SendClientScreen(s,robot,rectangle,Integer.toString(pass),concent);  
    }//GEN-LAST:event_GObuttonActionPerformed

   private void generatePassword() throws IOException, AWTException //this method generates the password in the client screen automatically 
                                                                    //the client and sever will get connected if and only if the server enters the same 
                                                                    //password that has been generated here
   {
      
       Random r = new Random();
       //generating the random password
       pass = r.nextInt(9000);
       //setting the password to the JTextField
       generatedPassTextfield.setText(Integer.toString(pass));
       
       
   }
 
   private void initiateClient() throws IOException, AWTException //inititates the necessary variables to call the constructor of client class
   {
       //Gets the ip of the Server
       String ip = ipArea.getText();
       //Initialises the socket
         s = new Socket(ip,3389);
         //gets the Graphics Environment of the client
        gen = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //gets the Graphics Device of the client
        gdev = gen.getDefaultScreenDevice();
        //Initiates to Robot
        robot = new Robot(gdev);
        //Gets the dimension of the Client screen
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        //Stores it in rectangular form
        rectangle = new Rectangle(dim);
         
        
   }
    public static void main(String args[]){
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
            java.util.logging.Logger.getLogger(ClientFirstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientFirstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientFirstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientFirstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
    }
   
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GObutton;
    private javax.swing.JRadioButton agreeToControl;
    private javax.swing.JRadioButton disagreeControl;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JTextField generatedPassTextfield;
    private javax.swing.JTextField ipArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel minimizeLabel;
    private javax.swing.JPanel passwordGeneratePanel;
    private javax.swing.JPanel teamviewerName;
    // End of variables declaration//GEN-END:variables
}
