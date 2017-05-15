package Dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import entities.Country;
import entities.Region;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Dawoud Ali
 */
// Dao class that will be used to save data, get particular city or list of cities
public class dao {

    public void addData(List<Country> list, MongoCollection collection) {

        List<Document> docList = new ArrayList<>();
        Document tempDoc = new Document();
        for (Country country : list) {
            if (country.getClass().toString().contains("entities.Region")) {
                Region reg = (Region) country;
                tempDoc.append("id", reg.getId());
                tempDoc.append("name", reg.getCityName());
                tempDoc.append("area", reg.getAreaCode());
                tempDoc.append("Country", reg.getCountry());
                tempDoc.append("metroCode", reg.getMetroCode());
                tempDoc.append("region", reg.getRegion());
                tempDoc.append("postal", reg.getPostalCode());

                tempDoc.append("longitude", reg.getLongitude());
                tempDoc.append("latitude", reg.getLatitude());

            } else {
                tempDoc.append("Country", country.getCountry());
                tempDoc.append("id", country.getId());
                tempDoc.append("postal", country.getPostalCode());
                tempDoc.append("longitude", country.getLongitude());
                tempDoc.append("latitude", country.getLatitude());

                tempDoc.append("name", null);
                tempDoc.append("region", null);
                tempDoc.append("metroCode", null);
                tempDoc.append("area", null);

            }

            docList.add(tempDoc);
            tempDoc = new Document();
        }
        System.out.println("List Size");
        System.out.println(docList.size());
//        collection.insertMany(docList);

    }
//Setting the Criteria and Querying the Documents accordingly

    public FindIterable<Document> findCityByCoordinates(float longitude, float latitude, MongoCollection collection) {

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("longitude", longitude);
        searchQuery.put("latitude", latitude);

        return collection.find(searchQuery);

    }

    public FindIterable<Document> findCityByName(String name, MongoCollection collection) {

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", name);

        return collection.find(searchQuery);

    }

}
