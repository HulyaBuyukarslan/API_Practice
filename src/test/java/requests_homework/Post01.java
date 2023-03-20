package requests_homework;

import base_urls.RegresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import test_datas.RegresPostTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Post01 extends RegresBaseUrl {
    /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

@Test
    public void post01(){
    spec.pathParam("pp1","users");


    Map<String,String> requestBody = RegresPostTestData.requestBodyMethod("morpheus","leader");

    Map<String,String > expectedData =RegresPostTestData.expectedDataMethod("morpheus","leader","496","2022-10-04T15:18:56.372Z");

    Response response = given().spec(spec).contentType(ContentType.JSON).
                        when().body(requestBody).
                        post("/{pp1}");
    response.prettyPrint();

    Map<String,String> responseBody = response.as(HashMap.class);
    System.out.println(responseBody);


    assertEquals(201,response.statusCode());
    assertEquals(expectedData.get("name"),responseBody.get("name"));
    assertEquals(expectedData.get("job"),responseBody.get("job"));
    assertNotEquals(expectedData.get("id"),responseBody.get("id"));
    assertNotEquals(expectedData.get("createdAt"),responseBody.get("createdAt"));


    }


//---------- JSONObject Kullanımı-------------

  @Test
  public void post02(){
      spec.pathParam("pp1","users");

     JSONObject requestBody = RegresPostTestData.requestBodyMethodJO("morpheus","leader");

     JSONObject expectedData =RegresPostTestData.expectedDataMethodJO("morpheus","leader","496","2022-10-04T15:18:56.372Z");

      Response response =   given().spec(spec).contentType(ContentType.JSON).
                            when().body(requestBody.toString()).
                            post("/{pp1}");
      response.prettyPrint();


      JsonPath responseBody = response.jsonPath();
      System.out.println(responseBody);

      assertEquals(201,response.statusCode());
      assertEquals(expectedData.getString("name"),responseBody.getString("name"));
      assertEquals(expectedData.getString("job"),responseBody.getString("job"));
      assertNotEquals(expectedData.getString("id"),responseBody.getString("id"));
      assertNotEquals(expectedData.getString("createdAt"),responseBody.getString("createdAt"));


  }



}
