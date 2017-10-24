import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by t00181299 on 20/10/2017.
 */
public class MongoTester {
    public static void main(String args[]){

        try {
            //Connect to MongoDB Server
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase db = mongoClient.getDatabase("employees");
            System.out.println("Connected to Database");

            //Create Collection
            MongoCollection<Document> coll = db.getCollection("employees");
            System.out.println("Collection created successfully");

            //Create
            int randomNum = ThreadLocalRandom.current().nextInt(1000, 2000);
            Document doc = new Document("name", randomNum);
            coll.insertOne(doc);
            System.out.println("Inserted value " + randomNum);

            //Read
            FindIterable<Document> cursor = coll.find();
            Iterator iter = cursor.iterator();
            while(iter.hasNext()){
                System.out.println(iter.next());
            }
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Server is ready");

        }
}