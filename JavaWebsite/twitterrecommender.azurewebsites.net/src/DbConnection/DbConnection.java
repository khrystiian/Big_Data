package DbConnection;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.util.ArrayList;

import recommender.*;
import movie.*;


public class DbConnection {

	public static final String host = "ds060649.mlab.com";
	public static final int port = 60649;
	public static final String database = "imdb";
	public static final String collectionName = "Recommender";

	public static final String USERNAME = "ACiobanu";
	public static final String password = "Christtian2";
	public static final char[] PASSWORD = password.toCharArray();


	
	public ArrayList<RObject> getrecommenderRObjects() {
		ArrayList<RObject> recRObjects = new ArrayList<RObject>();

		ServerAddress serverAddress = new ServerAddress(host, port);
		MongoCredential credentials = MongoCredential.createCredential(USERNAME, database, PASSWORD);
		ArrayList<MongoCredential> auths = new ArrayList<MongoCredential>();
		auths.add(credentials);

		MongoClient mongoClient = new MongoClient(serverAddress, auths);

		DB db = mongoClient.getDB("imdb");
		DBCollection coll = db.getCollection("Recommender");
		BuildRObject rob = new BuildRObject();
		DBCursor  cursor = coll.find();
		while (cursor.hasNext()) {
			DBObject obj = cursor.next();		
			recRObjects.add(rob.buildRObject(obj.toString()));
		}
		return recRObjects;

	}
	
	public Movie getMovie(String movieId){
		Movie movie = new Movie();
		BuildMovie build = new BuildMovie();
		ServerAddress serverAddress = new ServerAddress(host, port);
		MongoCredential credentials = MongoCredential.createCredential(USERNAME, database, PASSWORD);
		ArrayList<MongoCredential> auths = new ArrayList<MongoCredential>();
		auths.add(credentials);

		MongoClient mongoClient = new MongoClient(serverAddress, auths);

		DB db = mongoClient.getDB("imdb");
		DBCollection coll = db.getCollection("Movies");
		DBCursor cursor = coll.find(new BasicDBObject("_id", movieId));
		while (cursor.hasNext()) {
			DBObject obj = cursor.next();		
			movie = build.buildMovie(obj.toString());
		}		
				
		return movie;
		
	}
	
	
	
	
	
	
	
}