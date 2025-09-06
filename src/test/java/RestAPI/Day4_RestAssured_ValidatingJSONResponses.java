package RestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.*;
import io.restassured.path.json.JsonPath;
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
public class Day4_RestAssured_ValidatingJSONResponses {
int ide;
	
	
	@Test
	public void ValidingjsonResponse()
	{
	//InputStream IS=getClass().getClassLoader().getResourceAsStream("body.json");
	
	//JSONTokener JT=new JSONTokener(IS);
	//JSONObject job=new JSONObject(JT);
		//url: https://dummyjson.com/users?page=2&id=2
				Response res=given()
						.contentType("ContentType.JSON")
					
				.when()
					.get("https://dummyjson.com/products/category/smartphones")
					
					.then()
					.statusCode(200)
					.extract().response();

				
					//.header(null, isEmptyOrNullString())
					//.body("products[2].sku", equalTo("SMA-APP-IPH-123"));
				JSONObject JSP=new JSONObject(res.asString());
				System.out.println("value from website is" + JSP.getString("products[2].sku"));
				Assert.assertEquals( JSP.getString("products[2].sku"), "SMA-APP-IPH-123");

					
			
		
}
	@Test
	public void ValidingjsonResponse1()
	{
	//InputStream IS=getClass().getClassLoader().getResourceAsStream("body.json");
	
	//JSONTokener JT=new JSONTokener(IS);
	//JSONObject job=new JSONObject(JT);
		//url: https://dummyjson.com/users?page=2&id=2
				Response res=given()
						.contentType("ContentType.JSON")
					
				.when()
					.get("https://dummyjson.com/products/category/smartphones")
					
					.then()
					.statusCode(200)
					.extract().response();

				
					//.header(null, isEmptyOrNullString())
					//.body("products[2].sku", equalTo("SMA-APP-IPH-123"));
				
				//Goal is to find the total price of all smartphones in the above get url
				
				//step1://stores completes response in jsonobject
				JSONObject JSP=new JSONObject(res.asString());
				
				//step 2: use for loop to loop through all the rows in the json response
				String price;
				double Totalprice=0;
				for(int i=0;i<JSP.getJSONArray("products").length();i++)
				{
					//step 3 Now in each of the json response row we need to get the price of product
					price=JSP.getJSONArray("products").getJSONObject(i).get("price").toString();
					Totalprice=Totalprice+ Double.parseDouble(price);
					
				}
				System.out.println("Total price is "+Totalprice);

					
			
		
}
}
