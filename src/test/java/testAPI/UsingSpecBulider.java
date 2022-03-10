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
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class UsingSpecBulider {

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

		RequestSpecification inputRequest = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();

		ResponseSpecification outputRequest = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();

		RequestSpecification res = given().spec(inputRequest).body(pl);
		Response response = res.when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.extract().response();

		System.out.println("--------------" + response.asString());
	}
}
