package databases;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConnectToMongoDB {

    public static MongoDatabase mongoDatabase = null;

    public MongoDatabase connectToMongoDB() {
        MongoClient mongoClient = MongoClients.create("mongodb+srv://jamallaique:rootpasswordmongodb@cluster0.iv0dd4c.mongodb.net/?retryWrites=true&w=majority");
        mongoDatabase = mongoClient.getDatabase("students");
        System.out.println("Database Connected");
        return mongoDatabase;
    }

    public String insertIntoToMongoDB(User user) {
        String profile = user.getStName();
        MongoDatabase mongoDatabase = connectToMongoDB();
        MongoCollection<Document> collection = mongoDatabase.getCollection("profile");
        Document document = new Document().append("stName", user.getStName()).append("stID", user.getStID()).
                append("stDOB", user.getStDOB());
        collection.insertOne(document);
        return profile + " has been registered";
    }

    public List<User> readUserProfileFromMongoDB() {
        List<User> list = new ArrayList<User>();
        User user = new User();
        MongoDatabase mongoDatabase = connectToMongoDB();
        MongoCollection<Document> collection = mongoDatabase.getCollection("profile");
        BasicDBObject basicDBObject = new BasicDBObject();
        FindIterable<Document> iterable = collection.find(basicDBObject);
//        FindIterable<Document> iterable = collection.find();
        for (Document doc : iterable) {
            String stName = (String) doc.get("stName");
            user.setStName(stName);
            String stID = (String) doc.get("stID");
            user.setStID(stID);
            String stDOB = (String) doc.get("stDOB");
            user.setStDOB(stDOB);
            user = new User(stName, stID, stDOB);
            list.add(user);
        }
        return list;
    }

    public List<String> readFromMongoDB() {
        List<String> list = new ArrayList<String>();
        MongoDatabase mongoDatabase = connectToMongoDB();
        MongoCollection<Document> collection = mongoDatabase.getCollection("profile");
        FindIterable<Document> iterDoc = collection.find();
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            list.add(it.next().toString());
        }
        return list;
    }

    public static void main(String[] args) {
        ConnectToMongoDB mongo = new ConnectToMongoDB();
        mongo.insertIntoToMongoDB(new User("Naomi Chan", "4493", "07-1996"));
        mongo.insertIntoToMongoDB(new User("john smith", "4494", "07-1997"));
        mongo.insertIntoToMongoDB(new User("will smith", "4495", "07-1998"));
        List<User> user = mongo.readUserProfileFromMongoDB();
        for (User person : user) {
            System.out.println(person.getStName() + " " + person.getStID());
        }
    }
}
