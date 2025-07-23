package io.parser;

import io.jasonfiles.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;

import static io.restassured.RestAssured.given;

public class DynamicJson {
    @Test(dataProvider = "bookData")
    public void addBook(String isbn, String aisle) {
        RestAssured.baseURI = "http://216.10.245.166";
        String response=given().log().all().header("content-type","application/json")
                .body(Payload.addBook(isbn, aisle))
                .when()
                .post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js=JsonParser.parserJson(response);
        String id=js.get("ID");
        System.out.println(id);
    }
    @DataProvider(name = "bookData")
    public Object[][] getData(){
        return new Object[][]{{"ABC", "12345"},{"XYZ", "67890"},{"PQR", "54321"}};

    }
}
