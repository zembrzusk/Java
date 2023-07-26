package Composition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable {
//CUSTOMER DATA - ID, SURNAME, NIP & getters and setters
    private int customerId;
    public int getCustomerId() {return customerId;}
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    Customer(int customerId) {
        if (customerId == 0) {throw new IllegalArgumentException("Customer id can not be 0.");}
        setCustomerId(customerId);
    }
    private String surname, nip;
    public String getSurname() {return surname;}
    public void setSurname(String surname) {
        this.surname = surname;
    }
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
    public Customer(int customerId, String surname, String nip) {
        setCustomerId(customerId);
        setSurname(surname);
        setNip(nip);
    }

    //ASSOCIATION PART
    private List<Order> orders = new ArrayList<>();
    public void addOrder(Order order) throws Exception {
        if(!orders.contains(order)) {
            orders.add(order);
        }
    }
}
