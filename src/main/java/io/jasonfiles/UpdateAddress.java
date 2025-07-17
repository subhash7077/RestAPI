package io.jasonfiles;

public class UpdateAddress {
    public static String addressUpdate(String place_id){
        return "{\n" +
                "\"place_id\":\"" + place_id + "\",\n" +
                "\"address\":\"70 Summer walk, USA\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";
    }
}
