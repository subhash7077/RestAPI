package io.parser;

import io.jasonfiles.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
    public static void main(String[] args) {
        JsonPath jp = new JsonPath(Payload.coursePrice());

       // Print No of courses returned by API
        int courseCount=jp.getInt("courses.size()");
        System.out.println("Total number of courses: " + courseCount);

        //Print Purchase Amount
       int totalAmount= jp.getInt("dashboard.purchaseAmount");
       System.out.println("Total Amount: " + totalAmount);

        //Print Title of the first course
        String courseTitle=jp.getString("courses[0].title");
        System.out.println("Title of the first course: " + courseTitle);

        //Print All course titles and their respective Prices
        for(int i=0;i<courseCount;i++){
          String title= jp.getString("courses["+i+"].title");
          int price=jp.getInt("courses["+i+"].price");
            System.out.println("Course No:"+ (i+1) + ", Course Title: " + title + ", Price: " + price);
        }

        // Print no of copies sold by RPA Course
        //int rpaCopies=jp.getInt("courses.find { it.title == 'RPA' }.copies");
        //System.out.println("No of copies sold by RPA Course: " + rpaCopies);
        for (int i=0;i<courseCount;i++){
            String title=jp.getString("courses["+i+"].title");
            if (title.equalsIgnoreCase("rpa")){
              int rpaCopies= jp.getInt("courses["+i+"].copies");
                System.out.println("No of copies sold by "+title+" Course: " + rpaCopies);
                break;
            }
        }

        //Verify if Sum of all Course prices matches with Purchase Amount
        VerifySum.sumOfcourse();
        System.out.println("Sum of all course prices matches with Purchase Amount");
    }
}
