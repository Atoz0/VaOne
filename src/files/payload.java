package files;

public class payload {

	
	public static String api_Post_Data()
	{
	String b=("{"+
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

	"}");	
		return b;
		
	}
	
public static String CoursePrice(){
	
	return "{\r\n" + 
			"\r\n" + 
			"\"dashboard\": {\r\n" + 
			"\r\n" + 
			"\"purchaseAmount\": 910,\r\n" + 
			"\r\n" + 
			"\"website\": \"rahulshettyacademy.com\"\r\n" + 
			"\r\n" + 
			"},\r\n" + 
			"\r\n" + 
			"\"courses\": [\r\n" + 
			"\r\n" + 
			"{\r\n" + 
			"\r\n" + 
			"\"title\": \"Selenium Python\",\r\n" + 
			"\r\n" + 
			"\"price\": 50,\r\n" + 
			"\r\n" + 
			"\"copies\": 6\r\n" + 
			"\r\n" + 
			"},\r\n" + 
			"\r\n" + 
			"{\r\n" + 
			"\r\n" + 
			"\"title\": \"Cypress\",\r\n" + 
			"\r\n" + 
			"\"price\": 40,\r\n" + 
			"\r\n" + 
			"\"copies\": 4\r\n" + 
			"\r\n" + 
			"},\r\n" + 
			"\r\n" + 
			"{\r\n" + 
			"\r\n" + 
			"\"title\": \"RPA\",\r\n" + 
			"\r\n" + 
			"\"price\": 45,\r\n" + 
			"\r\n" + 
			"\"copies\": 10\r\n" + 
			"\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"]\r\n" + 
			"\r\n" + 
			"}";
	
}	
	
	
	
}
