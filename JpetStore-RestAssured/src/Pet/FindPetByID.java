package Pet;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class FindPetByID {
	@Test
	public void FindPetStatus() {
		RestAssured.baseURI="https://petstore.swagger.io";
		RequestSpecification httpReq=RestAssured.given();
		
		Response res=httpReq.put("/v2/pet/0");
		ResponseBody body=res.getBody();
		//System.out.println("The status recieved: "+res.getStatusLine());
		System.out.println("Status Code is : "+res.getStatusCode());
		JsonPath eval=res.jsonPath();
		System.out.println("ID : "+eval.get("id"));
		System.out.println("Status : "+eval.get("status"));
			
 }
}
