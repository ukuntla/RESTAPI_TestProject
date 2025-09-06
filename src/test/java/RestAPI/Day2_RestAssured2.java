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
public class Day2_RestAssured2 {
int ide;
	@Test
	public void getuser()
	{
		//RestAssured.baseURI="https://reqres.in/api/users";
		Response res=RestAssured
				.given()
			
		.when()
			.get("https://dummyjson.com/users/1")
			
			.then()
			.extract()
			.response();
			
		
			//Integer identi= res.path("data.id")	;	
			//Integer id2=res.jsonPath().get("data.id");
			//System.out.println("ID generated is" + id2);
		//System.out.println("ID generated is" + identi);
		System.out.println(res.asPrettyString());
		/*.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();*/
		
}
	@Test
	public void createUser()
	{
		
		String ss="{\"firstName\":\"umak\", \"lastName\":\"tester\"}"
				;
				Response res=given()
					
					.header("Content-Type","application/json")
					.body(ss)
					
				.when()
					.post("https://dummyjson.com/users/add")
					
				.then()
					.extract()
					.response();
				//Integer statcode=res.getStatusCode();
				System.out.println(res.asPrettyString());
		
}
	
}
