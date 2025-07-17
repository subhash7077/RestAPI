package io.parser;

import io.restassured.path.json.JsonPath;

public class JsonParser {
    public static JsonPath parserJson(String response) {
        JsonPath jp= new JsonPath(response);
        return jp;
    }
}
