

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;  
import org.hibernate.service.ServiceRegistry;


/**
 *
 * @author Dawoud Ali
 */
public class Lab5CitySearch {

   
    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {
        
        CSVParser cv=new CSVParser();
        //cv.insertData();
        
        System.out.println("Select An Option");
        System.out.println("1: Find Longitude and Latitude of City");
        System.out.println("2: Find Neigbhour cities based on Longtitude and Latitude");
        Scanner sc=new Scanner(System.in);
        int val=sc.nextInt();
        
        switch(val){
            case 1:
                String s;
                System.out.println("Enter the City Name");
                s=sc.nextLine();
                s=sc.nextLine();
     
                ResultSet data=cv.getCityData(s);
                System.out.println("Result Of Longitude and Latitude");
               
                System.out.println(data.getDouble("longitude"));
                System.out.println(data.getDouble(2));
               
                break;
            
            case 2:
                System.out.println("Enter Longitude:");
                float f=sc.nextFloat();
                System.out.println("Enter Latitude:");
                float f2=sc.nextFloat();
                
                
                
                break;
                
                
            
            
        }
        
   
        
        
        
                Configuration cfg=new Configuration();  
		cfg.configure("cityRecord.cfg.xml");//populates the data of the configuration file  
		//creating seession factory object  
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()). build();
		SessionFactory factory=cfg.buildSessionFactory(serviceRegistry);
		//creating session object  
		Session session=factory.openSession();  
		
                        for(CityRecord r : cv.record){
                            
                            Transaction t=session.beginTransaction();  
                            session.persist(r);//persisting the object  
                            t.commit();//transaction is commited  
                            
                        }
                        
			
		session.close();  

                System.out.println("Done");
    }
    
}
