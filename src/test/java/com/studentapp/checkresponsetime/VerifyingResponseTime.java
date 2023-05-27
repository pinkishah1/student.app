package com.studentapp.checkresponsetime;

import com.studentapp.testbase.TestBase;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

/**
 * Created by Jay
 */
public class VerifyingResponseTime extends TestBase {

    @Test
    public void test001() {
        long responseTime = given()  //because time return type is long so it will store in long
                .when()
                .get("/list")
                .time();
        System.out.println("The response time is :" + responseTime);


        given()
                .when()
                .get("/list")
                .then()
                .time(lessThan(60L), TimeUnit.MILLISECONDS);


    }

}
