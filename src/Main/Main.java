package Main;

import Darko.Component.PanelCover;
import Darko.Component.PanelLoginAndRegister;
import Darko.Component.PanelVerify;
import Darko.Component.PanelVerifyCredentials;
import Connection.Database;
import Darko.Model.ModelLogin;
import Darko.Model.ModelUser;
import Service.ServiceUser;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private PanelCover cover;
    private PanelLoginAndRegister LoginAndRegister;
    private PanelVerify verifyMessage;
    private PanelVerifyCredentials verifyCredentials;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private ServiceUser service;
    
    public Main() throws FontFormatException, IOException {
        setTitle("Sistema de gestión nutricional");
        initComponents();
        init();
        
    }
    
    private void init() throws FontFormatException, IOException, IOException {
        service = new ServiceUser();
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        verifyMessage = new PanelVerify();
        verifyCredentials = new PanelVerifyCredentials();
        ActionListener eventRegister = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
            
        };
        ActionListener eventLogin = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               
                try {
                    Login();
                } catch (FontFormatException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        };
        LoginAndRegister = new PanelLoginAndRegister(eventRegister, eventLogin);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                if (fraction <= 0.5f) {
                    size += fraction * addSize;
                } else {
                    size += addSize - fraction * addSize;
                }
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if (fraction >= 0.5f) {
                        cover.registerRight(fractionCover * 100);
                    } else {
                        cover.loginRight(fractionLogin * 100);
                    }
                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if (fraction <= 0.5f) {
                        cover.registerLeft(fraction * 100);
                    } else {
                        cover.loginLeft((1f - fraction) * 100);
                    }
                }
                if (fraction >= 0.5f) {
                    LoginAndRegister.showRegister(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(LoginAndRegister, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                bg.revalidate();
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }
        };
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);  //  for smooth animation
        bg.setLayout(layout);
        bg.setLayer(verifyMessage, JLayeredPane.POPUP_LAYER);
        bg.add(verifyMessage, "pos 300 60  60% 30%" );
        bg.setLayer(verifyCredentials, JLayeredPane.POPUP_LAYER);
        bg.add(verifyCredentials, "pos 115 450  43.5% 60%" );
        bg.add(cover, "width " + coverSize + "%, pos " + (isLogin ? "1al" : "0al") + " 0 n 100%");
        bg.add(LoginAndRegister, "width " + loginSize + "%, pos " + (isLogin ? "0al" : "1al") + " 0 n 100%"); 
        LoginAndRegister.showRegister(!isLogin);
        cover.login(isLogin);
        cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });
    }
    
    private void register(){
       ModelUser user = LoginAndRegister.getUser(); 
       validateForm();
       
       try{
           if (service.checkDuplicayeUser(user.getUsername())) {
            JOptionPane.showMessageDialog(this, "Nombre ya registrado.", "Error", JOptionPane.INFORMATION_MESSAGE);
           } else if(service.checkDuplicayeEmail(user.getEmail())){
            JOptionPane.showMessageDialog(this, "Email ya registrado.", "Error", JOptionPane.INFORMATION_MESSAGE);
           } else {
               service.insertUser(user);
           }
       } catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Error Register.", "Error", JOptionPane.ERROR_MESSAGE);
           System.out.println(e.getLocalizedMessage());
       }
    }
    
    private void Login() throws FontFormatException, IOException{
        ModelLogin data = LoginAndRegister.getDataLogin();
        try{
            ModelUser user = service.login(data);
            if (user != null) {
                this.dispose();
                //MainSystem.main(user);
                App.main(user);
              
                
            } else {
                verifyCredentials.setVisible(true);
            }
        } catch (SQLException e){
            System.out.println(e.getLocalizedMessage());
            verifyMessage.setVisible(true);
        }
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Icon/icon.png"));
        return retValue;
    }

     private void validateForm() {
        ModelUser user = LoginAndRegister.getUser();

        if (user.getUsername().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            verifyMessage.setVisible(true);
        } else if (!isValidName(user.getUsername())) {
            verifyMessage.setVisible(true);
        } else if (!isValidEmail(user.getEmail())) {
            verifyMessage.setVisible(true);
        } else {
            // Realizar acciones si la validación es exitosa
            JOptionPane.showMessageDialog(this, "Formulario validado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(emailPattern, email);
    }
    
     private boolean isValidName(String name) {
        String namePattern = "^[A-Za-z]+$";
        return Pattern.matches(namePattern, name);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 933, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
            
        try{
            Database.getInstance().connectToDatabase();
        } catch (SQLException e){
            e.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (FontFormatException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    
   
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
