package io.rest.test;

import io.jasonfiles.Payload;
import io.restassured.RestAssured;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;

import static io.restassured.path.json.JsonPath.given;
import static org.hamcrest.Matchers.equalTo;

public class BasicDemo {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com/";
            String response=RestAssured.given().log().all()
            .queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(Payload.addPlace()).when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope",equalTo("APP")).extract().asString();
        System.out.println(response);
    }

}
