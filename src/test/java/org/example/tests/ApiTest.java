package org.example.tests;

import org.example.tests.api.ApiHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest extends BaseTest {

    @Test
    public void testRestAssuredAPI() {
        test.info("GET მოთხოვნის გაგზავნა შპს გორგიას საიტის API-ზე");

        Response response = ApiHelper.sendEvent();

        // Log status code
        test.info("სტატუს კოდი: " + response.getStatusCode());

        // Log response body
        String body = response.asString();
        if (body.isEmpty()) {
            test.info("მიღებული პასუხის body ცარიელია.");
            body = ApiHelper.getMockResponse();
        }
        test.info("პასუხი: " + body);

        // Assert status code is 200
        try {
            Assert.assertEquals(response.getStatusCode(), 200, "სტატუს კოდი არ არის 200!");
            test.pass("API დაბრუნებული სტატუს კოდია: 200");
        } catch (AssertionError e) {
            test.fail("API ტესტი წარუმატებელია: " + e.getMessage());
            throw e;
        }
    }
}



