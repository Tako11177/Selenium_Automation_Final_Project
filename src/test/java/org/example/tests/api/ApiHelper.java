package org.example.tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiHelper {

    public static Response sendEvent() {

        return RestAssured.given()
                .queryParam("v", "2")
                .queryParam("tid", "G-882L632JE5")
                .queryParam("cid", "12345")
                .queryParam("en", "test_event")
                .when()
                .get("https://gtm.gorgia.ge/g/collect")
                .then()
                .extract().response();
    }


    public static String getMockResponse() {
        return "{ \"მესიჯი\": \"ივენთი გაიგზავნა წარმატებულად\" }";
    }
}
