package POSTRequest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class DiffWaysToCreatePostReqBody {
	
	// Post request body using HashMap
	// Post request body using org.json library
	// Difference is when we are using org.json library we should pass data in string format(.body(data.toString))
	@Test
	void testToCreateHashMap() {
		HashMap data = new HashMap();
		data.put("name", "chethan");
		data.put("location", "ongole");
		data.put("phone", "1234567890");
		String skillArr[] = {"Automation","Manual","API"};
		data.put("skills",skillArr);
		
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/employs")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("chethan"))
		.body("phone",equalTo("1234567890"))
		.body("skills[2]",equalTo("API"))
		.extract().as(HashMap.class);
	}

}
