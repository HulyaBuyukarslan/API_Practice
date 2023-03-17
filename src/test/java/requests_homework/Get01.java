package requests_homework;

import base_urls.RegresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 extends RegresBaseUrl {
     /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK

  */

@Test
    public void get01(){

String url = "https://reqres.in/api/users/3";

Response response = given().when().get(url);

//response.prettyPrint();
//System.out.println(response.statusCode());
//System.out.println(response.contentType());
//System.out.println(response.statusLine());

    response.
            then().
            statusCode(200).
            contentType(ContentType.JSON).
            statusLine("HTTP/1.1 200 OK");

// 2. yol

    spec.pathParams("first","users","second",3);

    Response response1 =  given().spec(spec).when().get("/{first},/{second}");
    response1.prettyPrint();


    response1.
            then().
            statusCode(200).
            contentType(ContentType.JSON).
            statusLine("HTTP/1.1 200 OK");

        }

}
