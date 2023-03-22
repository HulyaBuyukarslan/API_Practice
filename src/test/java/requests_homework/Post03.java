package requests_homework;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingRequestPojo;
import pojos.BookingResponseBodyPojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03 extends HerOkuAppBaseUrl {
 /*
   "https://restful-booker.herokuapp.com/apidoc/index.html" dökümanını kullanarak;
    Bir booking oluşturan, o booking'i güncelleyen ve sonra silen ve
    bu adımları doğrulayan positif ve negatif testler içeren bir otomasyon testi yazınız.
*/

  /*
  Given
        1)"https://restful-booker.herokuapp.com/booking"
        2)
                  {
                    "firstname" : "Mona",
                    "lastname" : "Roza",
                    "totalprice" : 333,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2023-03-21",
                        "checkout" : "2023-03-28"
                    },
                    "additionalneeds" : "Silence"
                    }

         When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like

                    {
                        "bookingid": 2415,
                        "booking": {
                            "firstname": "Mona",
                            "lastname": "Roza",
                            "totalprice": 333,
                            "depositpaid": true,
                            "bookingdates": {
                                "checkin": "2023-03-21",
                                "checkout": "2023-03-28"
                            },
                         "additionalneeds": "Silence"
                        }
           }
   */




@Test
    public void post03(){
    spec.pathParam("pp1","booking");

    BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2023-03-21","2023-03-28");

    BookingRequestPojo bookingRequestPojo = new BookingRequestPojo("Mona","Roza",333,true,bookingDatesPojo,"Silence");


    BookingRequestPojo expectedData = new BookingRequestPojo("Mona","Roza",333,true,bookingDatesPojo,"Silence");

    Response response= given().spec(spec).contentType(ContentType.JSON).
                       when().body(expectedData).post("/{pp1}");


    BookingResponseBodyPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), BookingResponseBodyPojo.class);
    System.out.println(actualData);

    assertEquals(200,response.statusCode());
    assertEquals(expectedData.getFirstname(),actualData.getBooking().getFirstname());
    assertEquals(expectedData.getLastname(),actualData.getBooking().getLastname());
    assertEquals(expectedData.getTotalprice(),actualData.getBooking().getTotalprice());
    assertEquals(expectedData.getDepositpaid(),actualData.getBooking().getDepositpaid());
    assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
    assertEquals(expectedData.getBookingdates().getChecout(),actualData.getBooking().getBookingdates().getChecout());
    assertEquals(expectedData.getAdditionalneeds(),actualData.getBooking().getAdditionalneeds());


}




}
