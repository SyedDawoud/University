
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import org.hibernate.Query;
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

    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {

        CSVParser cv = new CSVParser();
        cv.insertData();
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
        //creating seession factory object  
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
        //creating session object  
        Session session = factory.openSession();
        Query quer = session.createQuery("select count(*) from CityRecord");
        // Getting the Size of Database Data
        List res = quer.list();
        int total = cv.count;
        System.out.println(res);
//		
//                        for(CityRecord r : cv.record){
//                            
//                            Transaction t=session.beginTransaction();  
//                            session.persist(r);//persisting the object  
//                            t.commit();//transaction is commited  
//                            
//                        }
//                        
//			
//		session.close(); 

        System.out.println("Select An Option");
        System.out.println("1: Find Longitude and Latitude of City");
        System.out.println("2: Find Neigbhour cities based on Longtitude and Latitude");
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();

        switch (val) {
            case 1:
                String s;
                System.out.println("Enter the City Name");
                s = sc.nextLine();             // To avoid the empty line, caused by earlier use of Scanner
                String st = sc.nextLine();

                Query query = session.createQuery("From CityRecord where city=?");
                query.setParameter(0, st);
                List<CityRecord> re = query.list();
                System.out.println("Result Of Longitude and Latitude");

                if (re.size() == 0) {
                    System.out.println("No Result Found ");
                } else {
                    for (CityRecord cr : re) {
                        System.out.println("City " + cr.getCity());
                        System.out.println("Longitude " + cr.getLongitude());
                        System.out.println("Latitude " + cr.getLatitude());
                    }
                }
                break;

            case 2:
                System.out.println("Enter Longitude:");
                float f = sc.nextFloat();
                System.out.println("Enter Latitude:");
                float f2 = sc.nextFloat();

                Query query1 = session.createQuery("From CityRecord where longitude=? and latitude=?");
                query1.setParameter(0, f);
                query1.setParameter(1, f2);
                List<CityRecord> result = query1.list();
                System.out.println(result);
                int id = result.get(0).getLocation_id();

                Map<Integer, Double> list = new HashMap<Integer, Double>();

                Random iter = new Random();
                // Getting Some Random Value b/w the current city and the end bound
                int randVal = iter.nextInt(total - id - 50 + 1);
                double dist;
                for (int k = randVal; k < randVal + 50; k++) {
                    query1 = session.createQuery("From CityRecord where location_id=?");
                    query1.setParameter(0, k);
                    result = query1.list();
                    dist = GreatDistance(f, result.get(0).getLongitude(), f2, result.get(0).getLatitude());
                    list.put(k, dist);

                }

                System.out.println(list);
                int count = 0;
                for (int k = randVal; k < randVal + 50; k++) {

                    //System.out.println(list.get(k));
                    if (list.get(k) > 0 && list.get(k) < 1) {

                        query1 = session.createQuery("From CityRecord where location_id=?");
                        query1.setParameter(0, k);
                        result = query1.list();

                        System.out.println(result.get(0).getCity());
                        System.out.println(result.get(0).getLongitude());
                        System.out.println(result.get(0).getLatitude());
                        System.out.println("Distance : " + list.get(k));
                        count++;
                        if (count == 5) {
                            break;
                        }

                    }

                }
                break;

        }

        System.out.println("Done");
    }

    class Tupled<A, B> {

        public A first;
        public B second;
    }

    public static double GreatDistance(float longi1, float longi2, float lati1, float lati2) {

        float ran = (float) (180 / Math.PI);

        return Math.acos((Math.sin(ran * lati1) * Math.sin(ran * lati2)) + (Math.cos(ran * lati1) * Math.cos(ran * lati2) * Math.cos(ran * Math.abs(longi1 - longi2))));
    }
}
