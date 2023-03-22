package pojos;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDatesPojo {

/*
                    "bookingdates" : {
                        "checkin" : "2023-03-21",
                        "checkout" : "2023-03-28"
                    },
 */

   private String checkin;
    private String checkout;



    public BookingDatesPojo() {
    }



    public BookingDatesPojo(String checkin, String checout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getChecout() {
        return checkout;
    }

    public void setChecout(String checout) {
        this.checkout = checout;
    }

    @Override
    public String toString() {
        return "{" +
                "checkin='" + checkin + '\'' +
                ", checout='" + checkout + '\'' +
                '}';
    }
}

