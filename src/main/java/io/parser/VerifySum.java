package io.parser;
import io.jasonfiles.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifySum {
    @Test
    public static void sumOfcourse(){
        JsonPath jp= new JsonPath(Payload.coursePrice());
        int count= jp.getInt("courses.size()");
        int totalAmount=0;
        System.out.println("Total number of courses: " + count);
        for (int i=0;i<count;i++){
            int price=jp.getInt("courses["+i+"].price");
            int copies=jp.getInt("courses["+i+"].copies");
            int sum=price*copies;
            totalAmount= totalAmount + sum;
        }
        int purchaseAmount= jp.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(totalAmount, purchaseAmount, "Total amount does not match with Purchase Amount");
    }
}
