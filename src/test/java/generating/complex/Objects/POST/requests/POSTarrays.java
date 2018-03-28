package generating.complex.Objects.POST.requests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class POSTarrays {

	@Test(priority=1)
	public void postArra() {
		_Info info1 = new _Info();
		info1.setEmail("test2@innominds.com");
		info1.setNumber("923450342075");
		info1.setAddress("KJ");

		_Info info2 = new _Info();
		info2.setEmail("test3@innominds.com");
		info2.setNumber("7493872048");
		info2.setAddress("WR2.3");

		Posts post = new Posts();
		post.setInfo(new _Info[] { info1, info2 });
		post.setId("029347594");
		post.setTitle("New Title2");
		post.setAuthor("Author 2");

		Response response = RestAssured.given().when().body(post).contentType(ContentType.JSON)
				.post("http://localhost:3000/posts");
		System.out.println(response.asString());
	}

}
