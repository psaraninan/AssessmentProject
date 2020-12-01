package com.assessment.api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ApiTest {
	String responseString;
	Response response;
	JsonPath jsonResponse;

	@BeforeTest
	public void getApiResponse() throws ParseException {

		RestAssured.baseURI = "https://api.github.com";
		response = given().header("Content-Type", "application/json").when().get("/events");
		responseString = response.then().extract().asString();
	}

	@Test
	public void validateStatus200() {
		response.then().log().status().assertThat().statusCode(200);
	}

	@Test
	public void printEventCounts() {
		int pushEventCount = 0;
		int createEventCount = 0;

		jsonResponse = new JsonPath(responseString);
		List<Object> jsonResponseList = jsonResponse.getList("type");

		// counts the number of pushEvent and createEvent
		for (Object o : jsonResponseList) {

			if (o.equals("PushEvent")) {
				pushEventCount++;
			} else if (o.equals("CreateEvent")) {
				createEventCount++;
			}
		}
		System.out.println("Occurence of PushEvent: " + pushEventCount);
		System.out.println("Occurence of CreateEvent: " + createEventCount);
	}

	@Test
	public void verifyJsonResponseIsArray() throws ParseException {
		SoftAssert assertion = new SoftAssert();
		// checks for JSON response type - asserts that it is an array

		Object obj = new JSONParser().parse(responseString);
		assertion.assertTrue(obj instanceof JSONArray);
		assertion.assertAll();
	}
}
