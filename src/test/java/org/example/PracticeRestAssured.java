package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Test;

public class PracticeRestAssured{


    @Test
    public void getData(){
        RequestSpecification request = RestAssured.given();
        Response response = request.get("https://reqres.in/api/users?page=2");
        String res = response.body().asString();
        System.out.println(res);
    }

    @Test
    public void postData(){
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = RestAssured.given();
        JSONObject requestJson = new JSONObject();
        requestJson.put("name","Naveen");
        requestJson.put("job","Tester");
        request.header("Contact-Type","applicaion/json");
        request.body(requestJson.toJSONString());

        Response response = request.post("/api/users");
        System.out.println(response.body().asString()+"Status"+response.statusLine());
    }


}
