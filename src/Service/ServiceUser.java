package Service;


import Connection.Database;
import Darko.Model.ModelLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Darko.Model.ModelUser;
import java.sql.SQLException;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;


/**
 *
 * @author jjose
 */

public class ServiceUser {
   private final Connection con; 
   
   public ServiceUser(){
       con = Database.getInstance().getConnection();
   }
   
   public ModelUser login(ModelLogin login) throws SQLException{
       ModelUser data = null;
       PreparedStatement p = con.prepareStatement("SELECT user_id, username, email, password FROM users WHERE email=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       p.setString(1, login.getEmail());
       ResultSet r = p.executeQuery();
       
       if (r.first()) {
       String storedHash = r.getString("password");
       String enteredPassword = login.getPassword();
           if (verifyPassword(enteredPassword, storedHash)) {  
               int user_id = r.getInt("user_id");
               String username = r.getString("username");
               String email = r.getString("email");
               data = new ModelUser(user_id, username, "", email);
        }
       }
       r.close();
       p.close();
       return data;
   }
   
   public void insertUser(ModelUser user) throws SQLException{
        if (isEmpty(user)) {
        return;
    }
       String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
 
       PreparedStatement p = con.prepareStatement("INSERT INTO users (username, password, email) VALUES (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
       p.setString(1, user.getUsername());
       p.setString(2,hashedPassword);
       p.setString(3, user.getEmail());
       p.execute();
       ResultSet r = p.getGeneratedKeys();
       r.first();
       int userID = r.getInt(1);
       r.close();
       p.close();
       user.setUser_id(userID);
   }
   
   public boolean checkDuplicayeUser(String user) throws SQLException{
       boolean duplicate = false;
       PreparedStatement p = con.prepareStatement("SELECT user_id FROM users WHERE username=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       p.setString(1,user);
       ResultSet r = p.executeQuery();
       if (r.first()) {
           duplicate = true;
       }
       r.close();
       p.close();
       return duplicate;
   }
   public boolean checkDuplicayeEmail(String user) throws SQLException{
       boolean duplicate = false;
       PreparedStatement p = con.prepareStatement("SELECT user_id FROM users WHERE email=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       p.setString(1,user);
       ResultSet r = p.executeQuery();
       if (r.first()) {
           duplicate = true;
       }
       r.close();
       p.close();
       return duplicate;
   }
   public boolean isEmpty(ModelUser user) {
           return user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty();
   }

   public boolean verifyPassword(String inputPassword, String hashedPasswordFromDB) {
       return BCrypt.checkpw(inputPassword, hashedPasswordFromDB);
    }
}
