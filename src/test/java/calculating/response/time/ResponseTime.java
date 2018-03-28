package calculating.response.time;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseTime {

	@Test
	public void response_Time() {
		Response response = RestAssured.given().when().get("http://localhost:3000/posts");

		Long time = response.then().extract().time();

		System.out.println("Response is :: " + response.asString());
		System.out.println("Response time is :: " + time);
	}

}
