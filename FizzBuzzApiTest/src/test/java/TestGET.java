import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class TestGET {

	String baseUrl = "http://localhost:8080/FizzBuzz/api/fizzbuzz/";
	
	@Test
	void test1() {
		Response response = RestAssured.get(baseUrl + "createSeq?lastElement=16");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		
		int statuscode = response.getStatusCode();
		
		Assert.assertEquals(200, statuscode);
		
		RestAssured.get(baseUrl + "createSeq?lastElement=16").then()
			.statusCode(200)
			.body("sequence[0]", equalTo("1"))
			.body("sequence[2]", equalTo("Fizz"))
			.body("sequence[4]", equalTo("Buzz"))
			.body("sequence[14]", equalTo("Fizz Buzz"));
	}
	
	
	/*testing API with negative number*/
	@Test
	void test2() {
		Response response = RestAssured.get(baseUrl + "createSeq?lastElement=-2");
		
		int statuscode = response.getStatusCode();
		String body = response.getBody().asString();
		
		Assert.assertEquals(409, statuscode);
		Assert.assertEquals("Given number is less then 0", body);
		
	}
	
	/*testing API with invalid parameter value*/
	@Test
	void test3() {
		Response response = RestAssured.get(baseUrl + "createSeq?lastElement=text");
		
		int statuscode = response.getStatusCode();
		String body = response.getBody().asString();
		
		Assert.assertEquals(409, statuscode);
		Assert.assertEquals("Unable to parse invalid parameter", body);
		
	}
}
