package requests_homework;

import base_urls.RegresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get05 extends RegresBaseUrl {
 /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json; charset=utf-8”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */

@Test
    public void get05(){
    spec.pathParams("first","unkonown","second",3);

    Response response = given().spec(spec).when().get("/{first}/{second}");
    response.prettyPrint();



//// 1.yol :
//    response.
//            then().
//            statusCode(200).
//            contentType(ContentType.JSON).
//            body("data.id",equalTo(3),
//                    "data.name",equalTo("true red"),
//                    "data.year",equalTo(2002),
//                    "data.color",equalTo("#BF1932"),
//                    "data.pantone_value",equalTo("19-1664"),
//                    "support.url",equalTo("https://reqres.in/#support-heading"),
//                    "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

// 2.yol :

    JsonPath jsonPath = response.jsonPath();

    response.
            then().
            statusCode(200).
            contentType(ContentType.JSON);


    assertEquals(3,jsonPath.getInt("data.id"));
    assertEquals("true red",jsonPath.getString("data.name"));
    assertEquals(2002,jsonPath.getInt("data.year"));
    assertEquals("#BF1932",jsonPath.getString("data.color"));
    assertEquals("19-1664",jsonPath.getString("data.pantone_value"));
    assertEquals("https://reqres.in/#support-heading",jsonPath.getString("support.url"));
    assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!",jsonPath.getString("support.text"));


//3. yol (Soft Assert)








}



}
