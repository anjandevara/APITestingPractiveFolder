package APITesting.com.org.api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonServerRequests {

	@Test
	public void Post_1() {
		Response response = RestAssured.given()
				.body("{\"id\":\"2\"," + "\"title\":\"Dummy Title\"," + "\"author\":\"Anjan\"}").when()
				.contentType(ContentType.JSON).post("http://localhost:3000/posts");

		System.out.println(response.asString());
	}

}
