package testAPI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.ReUsablemethod;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class A3_Learning_Step3 {
	
	@Test(priority =1)
	public void complexJsonExample(){
		JsonPath js = new JsonPath(payload.addComplexJson());
		System.out.println(js.get("dashboard.purchaseAmount"));
		System.out.println(js.get("courses[0].title"));
		for(int i=0; i<js.getInt("courses.size()"); i++){
			System.out.println(js.get("courses["+i+"].title"));
		}
		System.out.println("=======================================================================");
	}
	
	@Test(priority =1)
	public void complexJsonReadFromJsonFile() throws Exception{
		//JsonPath js = new JsonPath(payload.addComplexJson());
		String jjj = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"\\data\\sampleJson.json"))).toString();
		JsonPath js = new JsonPath(jjj);
		System.out.println(js.get("dashboard.purchaseAmount"));
		System.out.println(js.get("courses[0].title"));
		for(int i=0; i<js.getInt("courses.size()"); i++){
			System.out.println(js.get("courses["+i+"].title"));
		}
		System.out.println("//=======================================================================//");
	}
	
	@Test
	public void addBookWithJSONFileUse() throws Exception{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String getresponse = given().log().all().header("Content-Type", "application/json").queryParam("key", "qaclick123")
		.body(new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"\\data\\fileJson.json"))))
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js = ReUsablemethod.rawToJson(getresponse);
		String id = js.get("place_id");
		System.out.println("ID == "+id);
	}
	
	@Test(priority =2, dataProvider="books")
	public void addBook(String isbn, String aisle){
		RestAssured.baseURI="http://216.10.245.166";
		String getresponse = given().header("Content-Type", "application/json").body(payload.AddBook(isbn, aisle))
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js = ReUsablemethod.rawToJson(getresponse);
		String id = js.get("ID");
		System.out.println("ID == "+id);
	}
	
	@DataProvider(name="books")
	public Object[][] getdata(){
		return new Object[][]{ {"a1", "a2"}, {"a3", "a4"}, {"a5", "a6"}};
	}

}
