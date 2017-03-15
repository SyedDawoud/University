
package lab3restaurantreservation;
import java.sql.*; 
import java.util.Calendar;

/**
 *
 * @author Dawoud Ali
 */
public class DatabaseConnector {
    
    Connection con;
    Statement statement;
    ResultSet resultSet;
    //PreparedStatement Ps;

    public DatabaseConnector() throws SQLException, ClassNotFoundException {
        
       
     
    Class.forName("com.mysql.jdbc.Driver");  
     con=DriverManager.getConnection(  
    "jdbc:mysql://localhost:3306/Reservations","root","root");  
    //here sonoo is database name, root is username and password  
     statement=con.createStatement();  
     //Ps=null;
    
     
    
    
    }
    
    public ResultSet getData(String query) throws SQLException{
        
        return this.statement.executeQuery(query);
    }
    
    public int updateData(String query) throws SQLException{
        
        
        return this.statement.executeUpdate(query);
    }
    
    public int dataSize(String query,String user, String pass,String type) throws SQLException{
        int size=0;
        PreparedStatement Ps=con.prepareStatement(query);
        Ps.setString(1, user);
        if(pass!="")
        Ps.setString(2, pass);
        if(type!="")
        Ps.setString(3, type);
        
        ResultSet myRs=Ps.executeQuery();
        
        while(myRs.next())
            size++;
        
        return size;
               
        
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    
    public int LogData(String eventHappened,String user) throws SQLException{
        Calendar calendar=Calendar.getInstance();
        String s=calendar.getTime().toString();
        String query="Insert into logs(name,event,time)Values(?,?,?)";
        PreparedStatement ps=con.prepareStatement(query);
        
        ps.setString(1, user);
        ps.setString(2, eventHappened);
        ps.setString(3, s);
        int result=ps.executeUpdate();
        
        return result;
        
        
    }
    
}
