
package lab3restaurantreservation;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dawoud Ali
 */
public class Lab3RestaurantReservation {

    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        DatabaseConnector db=new DatabaseConnector();
        ResultSet rs;
        
        try {
            String user="Drake";
            int k = db.updateData("insert into Users(username,password,userType)Values('Drane','13','Customer')" );
            System.out.println(k);
//             while(rs.next()){
//            
//            System.out.println("Name : "  + rs.getString(1));
//            System.out.println("Guest Type : "  + rs.getString(3));
//            
//        }
        } catch (SQLException ex) {
            Logger.getLogger(Lab3RestaurantReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        
        
    }
    
}
