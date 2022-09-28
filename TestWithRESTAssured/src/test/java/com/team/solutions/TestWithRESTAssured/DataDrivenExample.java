package com.team.solutions.TestWithRESTAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExample extends DataForTest{

    //@Test(dataProvider = "DataForPost")
    public void test_post(String firstName, String lastName, int subjectId) {

        JSONObject request = new JSONObject();

        request.put("firstName",firstName);
        request.put("lastName",lastName);
        request.put("subjectId", subjectId);

        baseURI = "http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                when().
                post("/profile").
                then().
                statusCode(201).
                log().all();
    }



    //@Test(dataProvider = "dataForDelete")
    public void delete(int userId) {

        baseURI = "http://localhost:3000/";

        when().delete("/users/"+userId).then().statusCode(200);

    }



}
