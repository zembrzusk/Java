import java.io.Serializable;

public class Customer extends ObjectPlus implements Serializable {
    //mandatory
    private int customerId;
    public int getCustomerId() {return customerId;}
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    Customer(int customerId) {
        if (customerId == 0) {throw new IllegalArgumentException("Customer id can not be 0.");}
        setCustomerId(customerId);
    }

    //optional
    private String surname;
    public String getSurname() {return surname;}
    public void setSurname(String surname) {
        this.surname = surname;
    }
    //optional
    private String firstname;
    public String getFirstname() {return firstname;}
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    //optional attribute
    private String nip;
    public String getNip() {return nip;}
    public void setNip(String nip) {
        if(nip==null) {
            this.nip = null;
        } else {
            if (nip.length() != 10 && !nip.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException("Nip should be 10 digits.");
            }
            this.nip = nip;
        }
    }
    //optional, complex
    private Address address;
    public Address getAddress() {return address;}
    public void setAddress(Address address) {
        this.address = address;
    }
    Customer(int customerId, String surname, String firstname, String nip, Address address) {
        setCustomerId(customerId);
        setFirstname(firstname);
        setSurname(surname);
        setNip(nip);
        setAddress(address);
    }

}
