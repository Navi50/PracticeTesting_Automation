package org.example;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(getLocators("Loginpage","name").get("login"));


    }

    public static Map<String, String> getLocators(String page,String eleType){

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            File jsonFile = new File("src/test/resources/Locator.json");
            Map<String, Object> dataMap = objectMapper.readValue(jsonFile, Map.class);
            System.out.println("Datamap");
            System.out.println(dataMap);
            Map<String, Object> datapage = (Map<String, Object>) dataMap.get(page);
            System.out.println("Datapage");
            System.out.println(datapage);
            Map<String, Object> data = (Map<String, Object>) datapage.get(eleType);
            System.out.println("Data");
            System.out.println(data);



            Map<String, String> locator = new HashMap<>();

            for(Map.Entry<String, Object> entry : data.entrySet()){
                locator.put(entry.getKey(), entry.getValue().toString());
            }

            return locator;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
