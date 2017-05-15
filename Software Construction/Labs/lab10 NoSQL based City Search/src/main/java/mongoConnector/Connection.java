package mongoConnector;

import com.mongodb.MongoClient;

/**
 *
 * @author Dawoud Ali
 * This file is for getting the MongoClient that will be used to query the things
 */
public class Connection {

    private static final MongoClient mongoClient;

    static {
        try {
            mongoClient = new MongoClient();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Mongo creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static MongoClient getMongoClient() {
        return mongoClient;
    }

}
