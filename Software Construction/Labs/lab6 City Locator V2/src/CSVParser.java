
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

    ArrayList<Country> record;
    Connection con;
    PreparedStatement Ps;
    int count;

    public CSVParser() throws ClassNotFoundException, SQLException {
        record = new ArrayList<>();
        count = 0;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/citylocator", "root", "root");
        //here sonoo is database name, root is username and password  
        Ps = con.prepareStatement("insert into CityRecord(location_id,country,region,city,postalcode,areacode,metrocode,longitude,latitude)values(?,?,?,?,?,?,?,?,?)");

    }

    public ArrayList<Country> getRecord() {
        return record;
    }

    public void setRecord(ArrayList<Country> record) {
        this.record = record;
    }

    public ResultSet getCityData(String s) throws SQLException {

        String query = "select longitude,latitude from cityrecord where city=?";
        PreparedStatement myPS = con.prepareStatement(query);
        myPS.setString(1, s);
        ResultSet rs = myPS.executeQuery();
        return rs;

    }

    public void insertData() throws FileNotFoundException, SQLException, IOException {
        // Opening the File
        String filePath = "src/GeoLiteCity-Location_1.csv";
        String fileToParse;

        BufferedReader buffer = new BufferedReader(new FileReader(filePath));
        File file = new File(filePath);

        Country cr;

        String txt;
        buffer.readLine();
        buffer.readLine();
        while ((txt = buffer.readLine()) != null) {

            //System.out.println(txt);
            String[] fulldata = txt.split(",");

            // Only Country
            if (fulldata[2].equals("\"\"") && fulldata[3].equals("\"\"")) {
                Country ctry = new Country();

                ctry.setId(Integer.parseInt(fulldata[0]));

                //Ps.setString(2, fulldata[1]);
                ctry.setCountry(fulldata[1]);

                ctry.setPostalCode(fulldata[4]);

                // Ps.setFloat(8, Float.parseFloat(fulldata[5]));
                ctry.setLongitude(Float.parseFloat(fulldata[5]));

                try {
                    //Ps.setFloat(9, Float.parseFloat(fulldata[6]));
                    ctry.setLatitude(Float.parseFloat(fulldata[6]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    //  Ps.setFloat(9, 0);
                    ctry.setLatitude(0);
                }
                
                
                cr=ctry;

            }
            
            else if(fulldata[2].equals("\"\"") && (fulldata[3].equals("\"\"")==false)){
                City city=new City();
            
                
                city.setId(Integer.parseInt(fulldata[0]));

                //Ps.setString(2, fulldata[1]);
                city.setCountry(fulldata[1]);

                city.setPostalCode(fulldata[4]);

                // Ps.setFloat(8, Float.parseFloat(fulldata[5]));
                city.setLongitude(Float.parseFloat(fulldata[5]));

                try {
                    //Ps.setFloat(9, Float.parseFloat(fulldata[6]));
                    city.setLatitude(Float.parseFloat(fulldata[6]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    //  Ps.setFloat(9, 0);
                    city.setLatitude(0);
                }
                
                 city.setCityName(fulldata[3]);
            
                
                cr=city;
                
            
        }
            
            else{

                Region rg=new Region();
            // Ps.setInt(1, Integer.parseInt(fulldata[0]));
            rg.setId(Integer.parseInt(fulldata[0]));

            //Ps.setString(2, fulldata[1]);
            rg.setCountry(fulldata[1]);

            //Ps.setString(3, fulldata[2]);
            rg.setRegion(fulldata[2]);

            //Ps.setString(4, fulldata[3]);
            rg.setCityName(fulldata[3]);

            // Ps.setString(5, fulldata[4]);
            rg.setPostalCode(fulldata[4]);

            // Ps.setFloat(8, Float.parseFloat(fulldata[5]));
            rg.setLongitude(Float.parseFloat(fulldata[5]));

            try {
                //Ps.setFloat(9, Float.parseFloat(fulldata[6]));
                rg.setLatitude(Float.parseFloat(fulldata[6]));
            } catch (ArrayIndexOutOfBoundsException e) {
                //  Ps.setFloat(9, 0);
                rg.setLatitude(0);
            }

            try {
                //Ps.setString(7, fulldata[7]);
                rg.setMetroCode(fulldata[7]);
            } catch (ArrayIndexOutOfBoundsException e) {
                //  Ps.setString(7,"");
                rg.setMetroCode("");
            }

            try {
                //Ps.setString (6, fulldata[8]);
                rg.setAreaCode(fulldata[8]);
            } catch (ArrayIndexOutOfBoundsException e) {
                // Ps.setString(6,"");
                rg.setAreaCode("");
            }

            cr=rg;
            
            }
            
            record.add(cr);
            cr = new Region();
            count++;

        }

    }

}
