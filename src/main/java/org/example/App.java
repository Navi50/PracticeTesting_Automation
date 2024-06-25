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
        System.out.println(getLocators("Loginpage").get("login"));


    }

    public static Map<String, String> getLocators(String page){

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            File jsonFile = new File("src/test/resources/Locators.json");
            Map<String, Object> dataMap = objectMapper.readValue(jsonFile, Map.class);
            Map<String, Object> data = (Map<String, Object>) dataMap.get(page);

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
