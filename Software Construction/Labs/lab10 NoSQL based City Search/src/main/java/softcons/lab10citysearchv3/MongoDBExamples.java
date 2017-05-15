/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softcons.lab10citysearchv3;

/**
 *
 * @author Dawoud Ali
 */
import Dao.dao;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.model.Indexes;

import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.eq;
import csvParser.CSVParser;
import entities.Country;
import entities.Region;
import java.io.IOException;
import java.sql.SQLException;
import static java.util.Arrays.asList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import mongoConnector.Connection;

public class MongoDBExamples {

    public static void main(final String[] args) throws ClassNotFoundException, SQLException, IOException {

//      
        CSVParser csv = new CSVParser();
        dao mydao = new dao();
        csv.insertData();
        List<Country> coun = csv.getRecord();

//            for (Country region:coun){
//                if (region.getClass().toString().contains("entities.Region")){
//                    Region reg=(Region)region;
//                    System.out.println(reg.getCityName());
//                }
//                System.out.println(region.getClass());
//            }
        // 1. Connect to MongoDB instance running on localhost
        MongoClient mongoClient = Connection.getMongoClient();

        // Access database named 'test'
        MongoDatabase database = mongoClient.getDatabase("citySearchV3");

        // Access collection named 'restaurants'
        MongoCollection collection = database.getCollection("locations");

        //mydao.addData(coun, collection);
//        FindIterable<Document> docList = mydao.findCityByName("\"Vail\"", collection);
//        FindIterable<Document> docList = mydao.findCityByCoordinates(0, 0, collection);
        System.out.println("Select An Option");
        System.out.println("1: Find Neigbhour cities based on Name");
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

                FindIterable<Document> docList = mydao.findCityByName(st, collection);

                System.out.println("Result Of Longitude and Latitude");

                Document tempDoc = docList.first();
                Double currentLongitude = tempDoc.getDouble("longitude");
                Double currentLatitude = tempDoc.getDouble("latitude");

                System.out.println("How Many Nearby locations should be checked?");
                int value = sc.nextInt();

                BasicDBObject searchQuery = new BasicDBObject();
                searchQuery.put("longitude", new BasicDBObject("$gt", currentLongitude));
                searchQuery.put("latitude", new BasicDBObject("$lt", currentLongitude));

                docList = collection.find(searchQuery).sort(new BasicDBObject("longitude", 1));

                int tempCount = 1;
                for (Document d : docList) {
                    if (d.getDouble("longitude") < currentLongitude) {
                        continue;
                    }
                    if (tempCount <= value) {
                        System.out.println(d.getString("name"));
                        System.out.println(d.getDouble("longitude"));
                        System.out.println(d.getDouble("latitude"));
                        System.out.print("Distance : ");
                        System.out.println(GreatDistance(currentLongitude, d.getDouble("longitude"), currentLatitude, d.getDouble("latitude")));
                        tempCount++;

                    }

                }

                break;

            case 2:
                System.out.println("Enter Longitude:");
                float f = sc.nextFloat();
                System.out.println("Enter Latitude:");
                float f2 = sc.nextFloat();

                FindIterable<Document> docListv2 = mydao.findCityByCoordinates(f, f2, collection);

                Document doc = docListv2.first();

                Double currentLongitudev2 = doc.getDouble("longitude");
                Double currentLatitudev2 = doc.getDouble("latitude");

                System.out.println("How Many Nearby locations should be checked?");
                int valuev2 = sc.nextInt();

                BasicDBObject searchQueryv2 = new BasicDBObject();
                searchQueryv2.put("longitude", new BasicDBObject("$gt", currentLongitudev2));
                searchQueryv2.put("longitude", new BasicDBObject("$lt", currentLongitudev2));

                docList = collection.find(searchQueryv2).sort(new BasicDBObject("longitude", 1));

                int tempCountv2 = 1;
                for (Document d : docList) {
                    if ((d.getDouble("longitude") - currentLongitudev2) >= -1 && tempCountv2 <= valuev2) {
                        System.out.println(d.getString("name"));
                        System.out.println(d.getDouble("longitude"));
                        System.out.println(d.getDouble("latitude"));
                        System.out.print("Distance : ");
                        System.out.println(GreatDistance(currentLongitudev2, d.getDouble("longitude"), currentLatitudev2, d.getDouble("latitude")));
                        tempCountv2++;

                    }

                }

                break;
        }
        System.out.println("Done");
        System.exit(0);

        mongoClient.close();
        System.out.println("Done ");
    }

//     Great Distance Formula for the Calculation
    public static double GreatDistance(double longi1, double longi2, double lati1, double lati2) {

        float ran = (float) (180 / Math.PI);

        return Math.acos((Math.sin(ran * lati1) * Math.sin(ran * lati2)) + (Math.cos(ran * lati1) * Math.cos(ran * lati2) * Math.cos(ran * Math.abs(longi1 - longi2))));
    }
}
