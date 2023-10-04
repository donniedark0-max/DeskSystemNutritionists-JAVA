package Darko.Component;

import Darko.Model.ModelLogin;
import Darko.Model.ModelUser;
import Darko.Swing.Button;
import Darko.Swing.MyPasswordField;
import Darko.Swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    private ModelUser user;
    private ModelLogin dataLogin;

    public ModelLogin getDataLogin(){
        return dataLogin;
    }
    
    public ModelUser getUser() {
        return user;
    }
    
    public PanelLoginAndRegister(ActionListener eventRegister, ActionListener eventLogin) throws FontFormatException, FontFormatException, IOException, IOException {
        initComponents();
        initRegister(eventRegister);
        initLogin(eventLogin);
        login.setVisible(false);
        register.setVisible(true);
    }

    private void initRegister(ActionListener eventRegister) throws FontFormatException, FontFormatException, IOException, IOException, IOException, IOException, IOException {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
         Font customFont1 = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jjose\\OneDrive\\Escritorio\\fonts\\PPEiko-Medium.otf"));
        customFont1 = customFont1.deriveFont(Font.BOLD, 30);
        Font customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jjose\\OneDrive\\Escritorio\\fonts\\Amphora-Regular.otf"));
        customFont2 = customFont2.deriveFont(Font.ITALIC,15);
         Font customFont3 = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jjose\\OneDrive\\Escritorio\\fonts\\Amphora-Regular.otf"));
        customFont3 = customFont3.deriveFont(Font.PLAIN,15);
        JLabel label = new JLabel("Crear Cuenta");
        label.setFont(customFont1);
        label.setForeground(new Color(7, 164, 121));
        register.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        txtUser.setHint("Nombre");
        txtUser.setFont(customFont2);
        register.add(txtUser, "w 60%");
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/mail.png")));
        txtEmail.setHint("Correo");

        register.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPass.setHint("Contraseña");
      
        register.add(txtPass, "w 60%");
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("Regístrate");
        cmd.setFont(customFont3);
        cmd.addActionListener(eventRegister);
        register.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUser.getText().trim();
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                user = new ModelUser(0, username, password, email);
            }
            
        });
    }

    private void initLogin(ActionListener eventLogin) throws FontFormatException, FontFormatException, IOException {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        Font customFont1 = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jjose\\OneDrive\\Escritorio\\fonts\\PPEiko-Medium.otf"));
        customFont1 = customFont1.deriveFont(Font.BOLD, 30);
        Font customFont3 = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\jjose\\OneDrive\\Escritorio\\fonts\\Amphora-Regular.otf"));
        customFont3 = customFont3.deriveFont(Font.PLAIN,15);
        JLabel label = new JLabel("Iniciar sesión");
         label.setFont(customFont1);
        label.setForeground(new Color(7, 164, 121));
        login.add(label);
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/mail.png")));
        txtEmail.setHint("Correo");
        login.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPass.setHint("Contraseña");
        login.add(txtPass, "w 60%");
        JButton cmdForget = new JButton("¿Olvidó su contraseña?"
                + "\nComuníquese con el administrador");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 10));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventLogin);
        cmd.setText("Iniciar sesión");
         cmd.setFont(customFont3);
        login.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                dataLogin = new ModelLogin(email, password);
            }
            
        });
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
