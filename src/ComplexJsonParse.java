import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		JsonPath js = new JsonPath(payload.CoursePrice());
		//1. Print No of courses returned by API
		
		int count=js.getInt("courses.size");
		System.out.println(count);
		
/*		String Title=js.get("courses[0].title");
		System.out.println(Title);
		String Title1=js.get("courses[1].title");
		System.out.println(Title1);
		String Title2=js.get("courses[2].title");
		System.out.println(Title2);*/
		
		int TotalAmount=js.getInt("dashboard.purchaseAmount");
		System.out.println(TotalAmount);
		
		for (int i=0;i<count;i++)
		{
			String courseTitle=js.get("courses["+i+"].title");
			System.out.println(js.get("courses["+i+"].price"));
			
			System.out.println(courseTitle);
		}
		
		
		for (int i=0;i<count;i++)
		{
			String courseTitle=js.get("courses["+i+"].title");
			if (courseTitle.equalsIgnoreCase("RPA"))
			{	int copies=js.get("courses["+i+"].copies");
			System.out.println(copies);}
		}
	

}}
