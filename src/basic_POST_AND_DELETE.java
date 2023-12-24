import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class basic_POST_AND_DELETE {
	Properties prop =new Properties();
	
	@BeforeTest 
	public void getData() throws IOException
	{
	 FileInputStream fis = new FileInputStream("C:\\Users\\User\\workspace\\Demo_API\\src\\files\\env.properties");
	prop.load(fis);
	prop.getProperty("HOST");
	
	}
		
	
	@Test(priority=1,enabled=true)
	public void api_POSTand_DELETE()
	{
	RestAssured.baseURI=prop.getProperty("HOST");


	Response res=given().
	queryParam("key","qaclick123").
	body("{"+
	"\"location\":{"+"\"lat\":-33.8669710,"+

	"\"lng\":151.1958750"+

	"},"+

	"\"accuracy\":50,"+

	"\"name\": \"Google Shoes!\","+

	"\"phone_number\": \"(02)9374 4000\","+

	"\"address\": \"48 Pirrama Road, Pyrmont,NSW 2009,Australia\","+

	"\"type\":[\"shoe_store\"],"+

	"\"website\":\"http://www.google.com.au/\","+

	"\"language\":\"en-AU\""+

	"}").
	when().
	post("/maps/api/place/add/json").
	then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("status",equalTo("OK")).
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
