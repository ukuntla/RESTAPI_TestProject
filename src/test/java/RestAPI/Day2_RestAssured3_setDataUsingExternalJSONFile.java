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
public class Day2_RestAssured3_setDataUsingExternalJSONFile {
int ide;
	
	
	@Test
	public void createUser()
	{
	InputStream IS=getClass().getClassLoader().getResourceAsStream("body.json");
	
	JSONTokener JT=new JSONTokener(IS);
	JSONObject job=new JSONObject(JT);
				Response res=given()
					
					.header("Content-Type","application/json")
					.body(job.toString())
					
				.when()
					.post("https://dummyjson.com/users/add")
					
				.then()
					.extract()
					.response();
				//Integer statcode=res.getStatusCode();
				System.out.println(res.asPrettyString());
		
}
	
}
