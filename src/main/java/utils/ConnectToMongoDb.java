package utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class ConnectToMongoDb {
    public static void main(String[] args) {
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://<username>:<password>@cluster0.afqwg.mongodb.net/<dbname>?retryWrites=true&w=majority");

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("test");

    }
}
