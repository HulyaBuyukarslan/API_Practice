package pojos;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingResponseBodyPojo {
    /*
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


    private Integer bookingid;
    private BookingRequestPojo booking;

    public BookingResponseBodyPojo() {
    }

    public BookingResponseBodyPojo(Integer bookingid, BookingRequestPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }


    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingRequestPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingRequestPojo booking) {
        this.booking = booking;
    }


    @Override
    public String toString() {
        return "{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
