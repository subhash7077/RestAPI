package io.jasonfiles;

public class UpdateAddress {
    public static String addressUpdate(String place_id, String newAddress) {
        return "{\n" +
                "\"place_id\":\"" + place_id + "\",\n" +
                "\"address\":\""+newAddress+"\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";
    }
}
