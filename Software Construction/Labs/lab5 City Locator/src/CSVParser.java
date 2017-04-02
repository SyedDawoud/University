
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author Dawoud Ali
 */
public class CSVParser {
    
    ArrayList<CityRecord> record;
    Connection con;
    PreparedStatement Ps;
    int count;
    
    
    public CSVParser() throws ClassNotFoundException, SQLException{
        record=new ArrayList<>();
        count=0;
         Class.forName("com.mysql.jdbc.Driver");  
     con=DriverManager.getConnection(  
    "jdbc:mysql://localhost:3306/citylocator","root","root");  
    //here sonoo is database name, root is username and password  
     Ps=con.prepareStatement("insert into CityRecord(location_id,country,region,city,postalcode,areacode,metrocode,longitude,latitude)values(?,?,?,?,?,?,?,?,?)");
        
    }

    public ArrayList<CityRecord> getRecord() {
        return record;
    }

    public void setRecord(ArrayList<CityRecord> record) {
        this.record = record;
    }
    
    public ResultSet getCityData(String s) throws SQLException{
        
        String query="select longitude,latitude from cityrecord where city=?";
        PreparedStatement myPS=con.prepareStatement(query);
        myPS.setString(1, s);
        ResultSet rs=myPS.executeQuery();
        return rs;
        
          
    }
    
    
    
    public void insertData() throws FileNotFoundException, SQLException, IOException{
        // Opening the File
        String filePath="src/GeoLiteCity-Location_1.csv";
        String fileToParse;
        
        BufferedReader buffer=new BufferedReader(new FileReader(filePath));
        File file=new File(filePath);
        CityRecord cr=new CityRecord();
       
   
        String txt;
        buffer.readLine();
        buffer.readLine();
        while( (txt = buffer.readLine()) != null){
        
        //System.out.println(txt);
       String[] fulldata= txt.split(",");
       
      
       
         // Ps.setInt(1, Integer.parseInt(fulldata[0]));
          cr.setLocation_id(Integer.parseInt(fulldata[0]));
          
          //Ps.setString(2, fulldata[1]);
          cr.setCountry(fulldata[1]);
          
          //Ps.setString(3, fulldata[2]);
          cr.setRegion(fulldata[2]);
          
          //Ps.setString(4, fulldata[3]);
          cr.setCity(fulldata[3]);
          
        // Ps.setString(5, fulldata[4]);
          cr.setPostalCode(fulldata[4]);
          
         
          
       // Ps.setFloat(8, Float.parseFloat(fulldata[5]));
         cr.setLongitude(Float.parseFloat(fulldata[5]));
          
          try{
         //Ps.setFloat(9, Float.parseFloat(fulldata[6]));
          cr.setLatitude(Float.parseFloat(fulldata[6]));
          }
           catch(ArrayIndexOutOfBoundsException e){
           //  Ps.setFloat(9, 0);
          cr.setLatitude(0);
          }
          
          
          
 
          try{
          //Ps.setString(7, fulldata[7]);
          cr.setMetroCode(fulldata[7]);
          }
          catch(ArrayIndexOutOfBoundsException e){
            //  Ps.setString(7,"");
              cr.setMetroCode("");
          }
          
          
          try{
           //Ps.setString (6, fulldata[8]);
           cr.setAreaCode(fulldata[8]);
          }
          catch(ArrayIndexOutOfBoundsException e){
             // Ps.setString(6,"");
              cr.setAreaCode("");
          }
           
          
        
            //int executeUpdate = Ps.executeUpdate();
          
          record.add(cr);
          cr=new CityRecord();
          count++;
          
          
          
        }
        
    }
    
    
    
    
    
    
    
    
}
