package Store;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteOrder {
	@Test
	public void OrderDelete() {
		RestAssured.baseURI="https://a83f1936-30a1-4a15-93b7-090c6a59104b.mock.pstmn.io";
		RequestSpecification httpReq=RestAssured.given();
		
		Response res=httpReq.delete("/v2/store/order/4");
		
		System.out.println("Response code is : "+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);                                           
		
		String server=res.header("Server");
		System.out.println("Server : "+server);
		Assert.assertEquals("nginx", server);
		
		String contentType=res.header("Content-Type");
		System.out.println("Content-Type : "+contentType);
		Assert.assertEquals("text/html; charset=utf-8", contentType);
	}
}
