package com.example.demo;

import com.example.demo.mongodb.MongoUtils;
import com.mongodb.BasicDBObject;
/**
 * Hello world!
 *
 */
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

import static com.mongodb.client.model.Filters.eq;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestMongodb {

    public static void main(String args[]) throws ParseException {
    	String dbUrl = "mongodb+srv://cRERQ6ZQmVZ7B0T4:cRERQ6ZQmVZ7B0T4@cluster0.rikfx.mongodb.net/covid19?retryWrites=true&w=majority";
    	Time time = new Time();
    	List<String> a = time.getDays("1/1/2021", "1/1/2021");
//    	System.out.println(a);
    	MongoUtils mongoUtils = new MongoUtils();
    	ArrayList<String> province = new ArrayList();
    	province.add("Province_State");
    	ArrayList<String> data = new ArrayList();
    	data.add("Alabama");
    	ArrayList<JSONObject> jsonObject = mongoUtils.query2json("covid19", "dailyreport", province, data, a, "Confirmed");
    	Json2CsvUtils b = new Json2CsvUtils();
    	String json = jsonObject.toString();
    	String csv = b.Json2Csv(json);
    	System.out.println(csv);
//        try {
//
//            // To connect to mongodb server
//            MongoClient mongoClient = MongoClients.create(dbUrl);
//
//            // Now connect to your databases
//            MongoDatabase mgdb = mongoClient.getDatabase("covid19");
//            MongoCollection<Document> dailycollection = mgdb.getCollection("dailyreport");
//
//            System.out.println("Connect to database successfully!");
//            System.out.println("MongoDatabase inof is : "+mgdb.getName());
//            // If MongoDB in secure mode, authentication is required.
//            // boolean auth = db.authenticate(myUserName, myPassword);
//            // System.out.println("Authentication: "+auth);
//            BasicDBObject query = new BasicDBObject();
//            query.put("Province_State","Alabama");
//            MongoCursor<Document> cursor = dailycollection.find(query).skip(0).iterator();
//            
//            List<String> resultList = new LinkedList<>();
//            List<String> tableList = new ArrayList<>();
//            String result = "[";
//            while (cursor.hasNext()) {
//                String jsonString = cursor.next().toJson();
//                result += jsonString;
//                result += ",";
//
////                JSONArray jsonArray = new JSONArray(jsonString);
////                JSONObject jsonObject = jsonArray.getJSONObject(0);
////                try {
////                    if(tableList.size() == 0) {
////                        StringBuilder stringKey = new StringBuilder();
////                        Iterator iterator = jsonObject.keys();
////                        while (iterator.hasNext()) {
////                            String key = (String) iterator.next();
////                            tableList.add(key);
////                        stringKey.append(key).append(',');
////                        }
////                        resultList.add(stringKey.deleteCharAt(stringKey.length()-1).toString());
////                    }
////                    StringBuilder stringValue = new StringBuilder();
////                    for(String entry: tableList){
////                        String value = new String();
////                        if(!jsonObject.has(entry)){
////                            value = "null";
////                        }
////                        else {
////                            value = jsonObject.get(entry).toString();
////                        }
////                        stringValue.append(value).append(',');
////                    }
////                    resultList.add(stringValue.deleteCharAt(stringValue.length()-1).toString());
////                }
////                catch (JSONException e){
////                    e.printStackTrace();
////                }
//            }
//            result = result.substring(0, result.length() - 1);
//            result += "]";
//            System.out.println(result);
//            
//
//        } catch (Exception e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//        }
    }
}