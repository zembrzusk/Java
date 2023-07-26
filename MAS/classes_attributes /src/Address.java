import java.io.Serializable;

public class Address extends ObjectPlus implements Serializable {
    //mandatory
    private String city;
    public String getCity() {return city;}
    public void setCity(String city) {
        if (city == null) {throw new IllegalArgumentException("City name can not be empty.");}
        this.city = city;
    }
    Address(String city) {
        setCity(city);
    }
    //optional
    private String street;
    public String getStreet() {return street;}
    public void setStreet(String street) {
        //street name can be null in case someone lives in a small village without street
        this.street = street;
    }
    Address(String city, String street) {
        setCity(city);
        setStreet(street);
    }
}
