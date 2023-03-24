package requests_homework;

import base_urls.SwaggerBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07 extends SwaggerBaseUrl {
/*
//1) https://petstore.swagger.io/ dokumanını kullanarak statüsü "available" olan "pet" sayısını bulup
    100'den fazla olduğunu assert eden bir otomasyon testi yazınız.
 */

//https://petstore.swagger.io/v2/pet/findByStatus?status=available

@Test
    public void get07(){

spec.
        pathParams("pp1","pet","pp2","findByStatus").
        queryParam("status","available");


    Response response = given().spec(spec).get("/{pp1}/{pp2}");
//    response.prettyPrint();

    assertEquals(200,response.statusCode());

    JsonPath jsonPath = response.jsonPath();

    List<Integer> listStatus = jsonPath.getList("findAll{it.id}.status");
    System.out.println(listStatus);
    System.out.println(listStatus.size());
    assertTrue(listStatus.size()>100);

//    int availablePetSayisi = response.jsonPath().getList("id").size();
//    assertTrue(availablePetSayisi>100);


}

}
