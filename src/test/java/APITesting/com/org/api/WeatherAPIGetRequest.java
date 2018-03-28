package APITesting.com.org.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class WeatherAPIGetRequest {

	// Get weather by City Name - GET REQUEST
//	@Test
	public void make_GET_REQUEST() {
		Response respose = RestAssured.given().get(
				"http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=f289f6d705516581d777ccc17389a646");
		System.out.println(respose.getStatusCode());
		Assert.assertEquals(respose.statusCode(), "200");
	}

	// Using parameters and Authorization
	@Test
	public void Using_parameters_and_Authorization() {
		RestAssured.given().param("q", "London,uk").param("appid", "f289f6d705516581d777ccc17389a646").when()
				.get("http://samples.openweathermap.org/data/2.5/weather").then().assertThat().statusCode(200);
	}

	// How to handle GET request
	@Test
	public void How_to_handle_GET_request() {
		Response response = RestAssured.given().param("q", "London,uk")
				.param("appid", "f289f6d705516581d777ccc17389a646").when()
				.get("http://samples.openweathermap.org/data/2.5/weather");

		System.out.println(response.asString());
	}

	@Test
	public void find_City_By_ID() {
		Response response = RestAssured.given().param("id", "2172797")
				.param("appid", "b6907d289e10d714a6e88b30761fae22").when()
				.get("http://samples.openweathermap.org/data/2.5/weather");
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.asString());
	}

	// Extracting Actual Results form API's and finding the JSON PATH for an object
	@Test
	public void Extracting_Actual_Results_form_API() {
		String weatherReport = RestAssured.given().param("id", "2172797")
				.param("appid", "b6907d289e10d714a6e88b30761fae22").when()
				.get("http://samples.openweathermap.org/data/2.5/weather").then().contentType(ContentType.JSON)
				.extract().path("weather[0].description");
		System.out.println("Weather Report is :: " + weatherReport);
	}
}
