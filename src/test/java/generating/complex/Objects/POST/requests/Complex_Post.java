package generating.complex.Objects.POST.requests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Complex_Post {

	@Test
	public void com_post() {
		Info info1 = new Info();
		info1.setEmail("test1@innominds.com");
		info1.setNumber("0192938347xx");
		info1.setAddress("WR2.1");

		_Post _post = new _Post();
		_post.setInfo(info1);
		_post.setId("947903247");
		_post.setTitle("New Title1");
		_post.setAuthor("Author 1");

		Response response = RestAssured.given().when().body(_post).when().contentType(ContentType.JSON)
				.post("http://localhost:3000/posts");
		System.out.println(response.asString());
	}
}
