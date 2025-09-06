package RestAPI;
import org.testng.annotations.Test;
import io.restassured.http.*;
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
import java.util.Map;
public class Day3_RestAssured_cOOKIES_HEADERS {
int ide;
	
	
	@Test
	public void CookiesAndHeaders()
	{
	//InputStream IS=getClass().getClassLoader().getResourceAsStream("body.json");
	
	//JSONTokener JT=new JSONTokener(IS);
	//JSONObject job=new JSONObject(JT);
		//url: https://dummyjson.com/users?page=2&id=2
				Response res=given()
						
					
				.when()
					.get("https://google.com");
					
				//Get all cookies from the response
				Map<String,String> cookielist=res.getCookies();
				
				for(String key:cookielist.keySet())
					System.out.println(res.getCookie(key));
		
}
	@Test
	public void Headers()
	{
	//InputStream IS=getClass().getClassLoader().getResourceAsStream("body.json");
	
	//JSONTokener JT=new JSONTokener(IS);
	//JSONObject job=new JSONObject(JT);
		//url: https://dummyjson.com/users?page=2&id=2
				Response res=given()
						
					
				.when()
					.get("https://google.com");
					
				//Get all cookies from the response
				Headers headerlist= res.getHeaders();
				for(Header hdr:headerlist)
				{
					System.out.println("header key is"+hdr.getName());
					System.out.println("headervalue is"+ hdr.getValue());
				}
				
		
		
}
}
