import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class MongoFunctions {
	
	MongoCollection<Document> collection;
	
	public void connectToDatabase() throws Exception{
		MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("employees");        
        System.out.println("Connected to Database " + db.toString());
        
        collection = db.getCollection("employees");
        System.out.println("Collection created successfully" + collection.toString());
	}
	
	public void addPatient() throws Exception{
		int randomNum = ThreadLocalRandom.current().nextInt(1000, 2000);
        Document doc = new Document("name", randomNum);
        collection.insertOne(doc);
        System.out.println("Inserted value " + randomNum);
	}
	
	public void searchPatient(String patientId){
		FindIterable<Document> cursor = collection.find();
        Iterator iter = cursor.iterator();
        while(iter.hasNext()){
            if(iter.next() == patientId){
            	//return value code here
            }
        }
	}
	
	public void updatePatient(){
		//update code here
	}
	
	public void removePatient(){
		//remove code here
	}
}
