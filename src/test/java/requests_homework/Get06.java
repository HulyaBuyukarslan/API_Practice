package requests_homework;

import base_urls.RegresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get06 extends RegresBaseUrl {

  /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
              (Tüm pantone_value değerlerini yazdırınız)
            3)Print all ids greater than 3 on the console
              (3'ten büyük id'leri yazdırınız)
              Assert that there are 3 ids greater than 3
              (3'ten büyük 3 adet id olduğunu doğrulayınız)
            4)Print all names whose ids are less than 3 on the console
              (id'si 3'ten küçük isimleri yazdırınız)
              Assert that the number of names whose ids are less than 3 is 2
              (id'si 3'ten küçük 2 isim olduğunu doğrulayınız)
    */

@Test
    public void get06(){
    spec.pathParam("pp1","unknown");

    Response response = given().spec(spec).when().get("/{pp1}");
    response.prettyPrint();


// 1)Status code is 200
    assertEquals(200,response.statusCode());

// 2)Print all pantone_values
    JsonPath jsonPath = response.jsonPath();
    List<String> pantoneList = response.jsonPath().getList("data.pantone_value");
    System.out.println(pantoneList);

// 3)Print all ids greater than 3 on the console
    List<Integer> idList = response.jsonPath().getList("data.id");

    List<Integer> idBuyuk3 = new ArrayList<>();

    for(Integer w : idList){
        if (w>3){
            idBuyuk3.add(w);
        }
    }
    System.out.println(idBuyuk3);

        // Groovy ile

    List<Integer> idList1 = response.jsonPath().getList("data.findAll{it.id>3}.id");
    System.out.println(idList1);



// Assert that there are 3 ids greater than 3
    Assert.assertEquals(3,idBuyuk3.size());


// 4)Print all names whose ids are less than 3 on the console
    List<String> allNames = response.jsonPath().getList("data.findAll{it.id<3}.name");
    System.out.println(allNames);


    //  Assert that the number of names whose ids are less than 3 is 2
    assertEquals(2, allNames.size());


















}




}
