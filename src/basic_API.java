import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class basic_API {

	
	
@Test(priority=1,enabled=false)
	
public void API_GET()
{
	
RestAssured.baseURI="http://maps.googleapis.com";

given().
param("location","-33.8670522,151.1957362").
param("radius","1500").
param("key","AIzaSyAHDYSBcbWurnyk4yBfUpvr15AkNnSUELA").

when().
get("/maps/api/place/nearbysearch/json").
then().assertThat().statusCode(200);
System.out.println("API get code passsed successfully");

}	
@Test(priority=2,enabled=true)
public void api_POSTand_DELETE()
{
RestAssured.baseURI="http://216.10.245.166";


Response res=given().
queryParam("key","qaclick123").
body("{"+
"\"location\":{"+"\"lat\":-33.8669711,"+

"\"lng\":151.1958750"+

"},"+

"\"accuracy\":51,"+

"\"name\": \"Google Shoes!\","+

"\"phone_number\": \"(02)9374 4000\","+

"\"address\": \"48 Pirrama Road, Pyrmont,NSW 2009,Australia\","+

"\"type\":[\"shoe_store\"],"+

"\"website\":\"http://www.google.com.au/\","+

"\"language\":\"en-AU\""+

"}").
when().
post("/maps/api/place/add/json").
then().assertThat().statusCode(200).log().all().and().contentType(ContentType.JSON).and().body("status",equalTo("OK")).
extract().response();

String responseString=res.asString();
System.out.println(responseString);
JsonPath js=new JsonPath(responseString);
String placeid=js.get("place_id");
System.out.println(placeid);


given().
queryParam("key", "qaclick123").
body("{"+"\"place_id\":\""+placeid+"\""+"}").
when().
post("/maps/api/place/delete/json").
then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("status",equalTo("OK"));







}	
	
	
	
}
