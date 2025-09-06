package RestAPI;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static
io.restassured.RestAssured.given;

import static
io.restassured.matcher.RestAssuredMatchers.*;
import static
org.hamcrest.Matchers.*;

import java.util.HashMap;
public class Day2_RestAssured3_setDataUsingPOJO {
int ide;
	
	
	@Test
	public void createUser()
	{
		
		TestPOJOClass TPC=new TestPOJOClass();
		TPC.setFirstName("Anusha");
		TPC.setLastName("gajam");
				Response res=given()
					
					.header("Content-Type","application/json")
					.body(TPC)
					
				.when()
					.post("https://dummyjson.com/users/add")
					
				.then()
					.extract()
					.response();
				//Integer statcode=res.getStatusCode();
				System.out.println(res.asPrettyString());
		
}
	
}
