package requests_homework;

import base_urls.AutomationExerciseBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.awt.geom.RectangularShape;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08 extends AutomationExerciseBaseUrl {

/*2)
	Given
		https://automationexercise.com/api/productsList
	When
		User sends Get request
	Then
		Assert that number of "Women" usertype is 12
		(Kadın usertype sayısının 12 olduğunu doğrulayın)

*/

    @Test

    public void Get08() {
        spec.pathParam("pp1", "productsList");

        Response response = given().spec(spec).get("/{pp1}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        List<String> listWomenType = jsonPath.getList("products.findAll{it.category.usertype.usertype=='Women'}");
        System.out.println(listWomenType.size());
        int kadinTypeSayisi=listWomenType.size();
        assertEquals(12,kadinTypeSayisi);
    }

}





