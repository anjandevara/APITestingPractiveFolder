package APITesting.com.org.api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post3 {
	Post2 post2 = new Post2();

	// POST the data dynamically to the API
	// @Test
	public void test_Post2() {
		post2.setId("3");
		post2.setTitle("This is 3rd Title");
		post2.setAuthur("This is Anjan");

		Response respose = RestAssured.given().body(post2).when().contentType(ContentType.JSON)
				.post("http://localhost:3000/posts");
		System.out.println(respose.asString());
	}

	// PUT or UPDATE the data dynamically to the API
	// @Test
	public void test_PUT() {
		post2.setId("2");
		post2.setTitle("Updated Title");
		post2.setAuthur("Anjan Kumar Devara");

		Response response = RestAssured.given().body(post2).when().contentType(ContentType.JSON)
				.put("http://localhost:3000/posts/2");
		System.out.println(response.asString());

	}

	// PATCH or Update a particular element in API
	// @Test
	public void test_PATCH() {
		Response respose = RestAssured.given().body("{\"title\":\"Title Patched\"}").when()
				.contentType(ContentType.JSON).patch("http://localhost:3000/posts/3");
		System.out.println(respose.asString());
	}

	// Delete a record from the API
	@Test
	public void test_DELETE() {
		Response respose = RestAssured.given().when().delete("http://localhost:3000/posts/3");
		System.out.println("Deleting response" + respose.asString());

	}
}
