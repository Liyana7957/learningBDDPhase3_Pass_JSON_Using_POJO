package testAPI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.ReUsablemethod;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Pojo_class {

	public static void main(String[] args) {
		pojoLearning pl = new pojoLearning();
		pojo_location plocation = new pojo_location();
		pl.setAccuracy(7957);
		pl.setName("Liyana12");
		pl.setPhone_number("1234567890");
		pl.setAddress("neeraj nagar");
		pl.setWebsite("www.xxxxyyyy.com");
		plocation.setLat(-33.3333);
		plocation.setLng(-22.22222);
		pl.setLocation(plocation);
		List<String> arr = new ArrayList<String>(); // this i m creation to
													// enter data in type
		arr.add("ghfd");
		arr.add("mmmm");
		pl.setTypes(arr);

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().header("Content-Type", "application/json").queryParam("key", "qaclick123").body(pl).when()
				.post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200);
	}
}
