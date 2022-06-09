package Store;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ReturnPetInv {
	@Test
	public void ReturnInventories() {
		RestAssured.baseURI="https://petstore.swagger.io/v2/store/inventory";
		RequestSpecification httpReq=RestAssured.given();
		
		Response res=httpReq.put("/v2/store/inventory");
		ResponseBody body=res.getBody();
		//System.out.println("The status recieved: "+res.getStatusLine());
		System.out.println("Status Code is : "+res.getStatusCode());
		
	}
}
