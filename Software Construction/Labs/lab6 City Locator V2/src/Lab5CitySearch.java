
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
import java.util.Set;
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
        // cv.insertData();
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
        //creating seession factory object  
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
        //creating session object  
        Session session = factory.openSession();

        // Getting the Currently Stored Values inside the Database
        Query quer = session.createQuery("select count(*) from Region");
        Long count = (Long) quer.uniqueResult();
        // If there is no data inserted right now
        if (count == 0) {

            for (Country r : cv.record) {

                Transaction t = session.beginTransaction();
                session.persist(r);//persisting the object  
                t.commit();//transaction is commited  

            }

        }
        System.out.println("Select An Option");
        System.out.println("1: Find Longitude and Latitude of City");
        System.out.println("2: Find Neigbhour cities based on Longtitude and Latitude");
        System.out.println("3: Distance between Cities using Longitudes and Latitudes");
        System.out.println("4: Exit The Program");
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();

        switch (val) {

            case 4:
                System.exit(0);
                break;

            case 3:
                float longi1,
                 longi2,
                 lati1,
                 lati2;

                System.out.println("Enter Longitude of First City");
                longi1 = sc.nextFloat();
                while (Math.abs(longi1) > 180) {
                    System.out.println("Enter the Value Again [-180,180]");
                    longi1 = sc.nextFloat();

                }

                System.out.println("Enter Latitude of First City");
                lati1 = sc.nextFloat();
                while (Math.abs(lati1) > 90) {
                    System.out.println("Enter the Value Again [-90,90]");
                    lati1 = sc.nextFloat();

                }

                System.out.println("Enter Longitude of Second City");
                longi2 = sc.nextFloat();
                while (Math.abs(longi2) > 180) {
                    System.out.println("Enter the Value Again [-180,180]");
                    longi2 = sc.nextFloat();

                }

                System.out.println("Enter Latitude of Second City");
                lati2 = sc.nextFloat();
                while (Math.abs(lati2) > 90) {
                    System.out.println("Enter the Value Again [-90,90]");
                    lati2 = sc.nextFloat();

                }

                System.out.println("Distance is:");
                System.out.println(GreatDistance(longi1, longi2, lati1, lati2) * 6371000);

                break;

            case 1:
                String s;
                System.out.println("Enter the City Name");
                s = sc.nextLine();             // To avoid the empty line, caused by earlier use of Scanner
                String st = sc.nextLine();
                Query query = session.createQuery("From Region where city=?");
                query.setParameter(0, st);
                List<Region> re = query.list();
                System.out.println("Result Of Longitude and Latitude");

                if (re.size() == 0) {
                    System.out.println("No Result Found ");
                } else {
                    for (Region cr : re) {
                        System.out.println("City " + cr.getCityName());
                        System.out.println("Longitude " + cr.getLongitude());
                        System.out.println("Latitude " + cr.getLatitude());
                        System.out.println("Region:" + cr.getRegion());
                        System.out.println("-------------------");
                    }
                }
                break;

            case 2:
                System.out.println("Enter Longitude:");
                float f = sc.nextFloat();
                System.out.println("Enter Latitude:");
                float f2 = sc.nextFloat();

                Query query1 = session.createQuery("from Region");

                List<Region> result = query1.list();

                int id = 0;

                for (Region rv : result) {
//                    System.out.println(rv.getLatitude());
//                    System.out.println(rv.getLongitude());
                    if (rv.getLatitude() == f2 && rv.getLongitude() == f) {
                        id = rv.getId();
                        break;
                    }
                }

                System.out.println(id);
                if (id > 1) {

                    Map<Integer, Double> list = new HashMap<Integer, Double>();
                    Map<Integer, Integer> list_key = new HashMap<Integer, Integer>();
                    double dist = 0;
                    int amount = 0;
                    for (int k = id + 1; k < id + 50; k++) {

                        query1 = session.createQuery("From Region where Id=?");
                        query1.setParameter(0, k);
                        List<Region> results = query1.list();
                        //System.out.println(results);
                        for (Region rv : results) {
                            dist = GreatDistance(f, rv.getLongitude(), f2, rv.getLatitude()) * 6371000;
                        }
                        //System.out.println(dist);
                        if (dist <= 10000000) {
                            list.put(k, dist);
                            list_key.put(k, k);
                            amount++;
                        }

                    }

                    System.out.println("How Many Nearby Cities Should be Printed? Available : " + amount);

                    int userVal = sc.nextInt();
                    while (userVal < 0 || userVal > amount) {
                        System.out.println("Enter Again:");
                        userVal = sc.nextInt();

                    }

                    List<Integer> l = new ArrayList<Integer>(list.keySet());
                    int temp;
                    for (int k = 0; k < userVal; k++) {
                        temp = l.get(k);
                        System.out.println(temp);
                        query1 = session.createQuery("From Region where Id=?");
                        query1.setParameter(0, temp);
                        List<Region> result1 = query1.list();
                        for (Region rv : result1) {
                            System.out.println(rv.getCityName());
                            System.out.println(rv.getLongitude());
                            System.out.println(rv.getLatitude());
                            System.out.println("Distance : " + list.get(temp));
                        }
                        count++;

                    }
                } else {
                    System.out.println("Result Not Found");
                }
                break;
        }
        System.out.println("Done");
        System.exit(0);
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
