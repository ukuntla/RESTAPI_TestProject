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

import java.io.File;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
public class Day3_RestAssured_QueryAndPathParameters {
int ide;
	
	
	@Test
	public void PathandQueryParameters()
	{
	//InputStream IS=getClass().getClassLoader().getResourceAsStream("body.json");
	
	//JSONTokener JT=new JSONTokener(IS);
	//JSONObject job=new JSONObject(JT);
		//url: https://dummyjson.com/users?page=2&id=2
				Response res=given()
						.pathParam("mypath","users")// specifying path parameter
						
						.queryParam("page",2)// specifying path parameter
						//.queryParam("id",2)// specifying path parameter
						
					//.header("Content-Type","application/json")
					//.body(job.toString())
					
				.when()
					.post("https://dummyjson.com/{mypath}")
					
				.then()
					.extract()
					.response();
				//Integer statcode=res.getStatusCode();
				System.out.println(res.asPrettyString());
		
}
	
}
