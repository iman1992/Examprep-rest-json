package dataGenerator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Random;


public class DataGenerator {

    String[] testFirstNames = {"ed", "knui", "kunni", "pardalanat"};
    String[] testLastNames = {"mike", "hansen", "Henriksen", "Hanssen"};
    String[] testStreets = {"BoVej 39", "AndreasVej 90", "HenrikVej 90", "Hansvej 90"};
    String[] testCity = {"Lyngyb", "Roskilde", "Hedested", "København"};
    JsonArray hehe;
    Random rnd = new Random();

    public String getRandomFirstName() {
        String fname = testFirstNames[rnd.nextInt(testFirstNames.length)];
        return fname;
    }

    public String getRandomLastName() {
        String lname = testLastNames[rnd.nextInt(testLastNames.length)];
        return lname;
    }

    public String getRandomStreet() {
        String street = testStreets[rnd.nextInt(testStreets.length)];
        return street;
    }

    public String getRandomCity() {
        String city = testCity[rnd.nextInt(testCity.length)];
        return city;
    }

    public String getData(int count, boolean fname, boolean lname, boolean street, boolean city) {
        JsonArray names = new JsonArray();
        for (int i = 0; i < count; i++) {
            JsonObject person = new JsonObject();
            if (fname) {
                person.addProperty("fName", getRandomFirstName());
            }
            if (lname) {
                person.addProperty("lName", getRandomLastName());
            }
            if (street) {
                person.addProperty("street", getRandomStreet());
            }
            if (city) {
                person.addProperty("city", getRandomCity());
            }
            names.add(person);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonStr = gson.toJson(names); //The JSON string is ready
        System.out.println(jsonStr);
        return jsonStr;
    }

    public String getOnePersonJsonAsString() {
        JsonArray names = new JsonArray();
        JsonObject person = new JsonObject();
        person.addProperty("fName", getRandomFirstName());
        person.addProperty("lName", getRandomLastName());
        person.addProperty("street", getRandomStreet());
        person.addProperty("city", getRandomCity());
        names.add(person);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonStr = gson.toJson(names); //The JSON string is ready
        System.out.println(jsonStr);
        return jsonStr;
    }
}
