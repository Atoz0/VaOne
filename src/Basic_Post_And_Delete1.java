import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import files.resources;
import files.payload;
import files.ReusableMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * 
 */

/**
 * @author User
 *
 */
public class Basic_Post_And_Delete1 {

	
Properties prop =new Properties();
	
	@BeforeTest 
	public void getData() throws IOException
	{
	 FileInputStream fis = new FileInputStream("C:\\Users\\User\\workspace\\Demo_API\\src\\files\\env.properties");
	prop.load(fis);
	prop.getProperty("HOST");
	
	}
		
//Post response
	
	@Test(priority=1,enabled=true)
	public void api_POSTand_DELETE()
	{
	RestAssured.baseURI=prop.getProperty("HOST");
    Response res=given().
	queryParam("key",prop.getProperty("KEY")).
	body(payload.api_Post_Data()).
	when().
	post(resources.placePostData()).
	then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("status",equalTo("OK")).
	extract().response();

	JsonPath x=ReusableMethods.rawToJSON(res);
	String placeid=x.get("place_id");
	System.out.println(placeid);
	
//Delete response

	given().
	queryParam("key", "qaclick123").
	body("{"+"\"place_id\":\""+placeid+"\""+"}").
	when().
	post("/maps/api/place/delete/json").
	then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("status",equalTo("OK"));



	
	
	
	
	}	
	
	
}

	
	