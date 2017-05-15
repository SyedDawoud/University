
import Dao.dao;
import com.mongodb.client.FindIterable;
import csvParser.CSVParser;
import java.io.IOException;
import java.sql.SQLException;
import mongoConnector.Connection;
import org.bson.Document;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Dawoud Ali
 */
public class randomTest {

    @Test
    public void checkDataSize() throws ClassNotFoundException, SQLException, IOException {

        int result = 123833;

        CSVParser myparser = new CSVParser();
        myparser.insertData();
        assertEquals(myparser.getCount(), result);

    }

    @Test
    public void checkSearchByCords() {

        String result = "\"AP\"";
        dao testDao = new dao();

        FindIterable<Document> docList = testDao.findCityByCoordinates(35, 105, Connection.getMongoClient().getDatabase("citySearchV3").getCollection("locations"));
        Document temp = docList.first();

        assertEquals(temp.getString("Country"), result);

    }
}
