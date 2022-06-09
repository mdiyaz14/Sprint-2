package Store;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FindOrder {

	@Test

	public void OrderDelete() {
		RestAssured.baseURI="https://petstore.swagger.io";
		RequestSpecification httpReq=RestAssured.given();
		
		Response res=httpReq.get("/v2/store/order/5");
		System.out.println("Response code is : "+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200); 
		JsonPath eval=res.jsonPath();
		System.out.println("ID : "+eval.get("id"));
		System.out.println("Pet ID : "+eval.get("petId"));
		System.out.println("Quantity : "+eval.get("quantity"));
		System.out.println("Ship Date : "+eval.get("shipDate"));
		System.out.println("Status : "+eval.get("status"));
		
		String server=res.header("Server");
		System.out.println("Server : "+server);
		Assert.assertEquals("Jetty(9.2.9.v20150224)", server);
		
		String contentType=res.header("Content-Type");
		System.out.println("Content-Type : "+contentType);
		Assert.assertEquals("application/json", contentType);
}
}
