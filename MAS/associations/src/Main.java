/*
Comments in capslock are to make project more readable where is what. I was not sure if I should include
getters and setters, because they are not really relevant to associations. Some things are public for simplicity,
so I can put classes in packages so there is no need to wonder which classes are about what. I totally
understand that most if not all attributes should be private with getters, setters, etc.

1. Binary association
Glasses and Lenses. Just a typical normal one to one. I assume that lenses are cut to one particular glasses,
so they can not really be reused to it is kind of one-to-one relationship I think.

2. Association with attribute
Dog can have many owners, and a person can have many dogs. I could not think of anything that was connected to my
(hope to be) final project, unfortunately. So I have added a middle class DogOwner and called this class Adoption.

3. Qualified association
Glasses can have one frames, but same frames model can be used in many glasses. In order to find frames with particular
manufacture number I have created a map.

4. Composition
Customer and order - order can not exist without a customer.

*/

import Association_with_attribute.*;
import Composition.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //1. Binary association
        Lenses lenses = new Lenses(1001);
        Glasses glasses = new Glasses(1, new Frames(1, "NYC1"), lenses);

        //2. Association with attribute
        Dog dog = new Dog(1, "Mały");
        Owner owner = new Owner(1, "Mickiewicz");
        Adoption adoption = new Adoption(1, "2022-11-01", dog, owner);
        System.out.println(adoption);

        //3. Qualified association
        Frames frames = new Frames(1, "WAW01");
        Glasses glasses1 = new Glasses(1, frames, new Lenses(101));
        Frames framesWeLookFor = glasses1.findFramesQualif("WAW01");

        //4. Composition
        Customer customer = new Customer(1, "Kowalski", "9876543210");
        Order order = Order.createOrder(customer, 1);

    }
}