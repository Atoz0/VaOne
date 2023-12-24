import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.payload;


public class basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//given-all input details
		//when-Submit the api
		//then-validate the response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.api_Post_Data())
		.when().post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).body("scope",equalTo( "APP"))
		.header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		JsonPath js=new JsonPath(response);
		String PlaceID=js.get("place_id");
		System.out.println(PlaceID);
		
		//Update API Bodys
		String newAddress="70 Summer walk, USA";
		given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		
		.body("{\r\n" + 
				"\"place_id\":\""+PlaceID+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		//Display data Get Place
		String getPlaceResponse=given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", PlaceID)
		
		.when().get("/maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js1=new JsonPath(getPlaceResponse);
		
		String ActualAddress=js1.getString("address");
		System.out.println(ActualAddress);
		Assert.assertEquals(ActualAddress, newAddress);
		
	} 

}
