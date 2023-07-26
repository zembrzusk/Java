/*
Three main classes that I put examples of attributes in are Glasses, Customer and Frames.
In class Glasses we have:
1. the extent
7. derived attribute (price)
9. override (toString)
10. overload (getPrice(double work))

in class Customer we have:
3. complex attribute (address)
4. optional attribute (nip)

in class Frames we have:
6. class attribute (minimal Price)
8. class method (findCheaperThan)
5. multi-valued (colors)
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Frames frames = new Frames();
        Lenses lenses = new Lenses(1);
        Glasses glasses = new Glasses(1, frames, lenses);

        Customer customer = new Customer(1, "Smith", "John", "0123456789",
                new Address("Zielona 1A"));

        //1. The extent - List<Glasses> extent
        Glasses.showExtent();
        System.out.println("-- end of showExtent --");

        //3. Complex attribute - address
        //class: Customer, attribute: address
        customer.setAddress(new Address("Warszawa", "aleje Jerozolimskie 1/40"));

        //4. Optional attribute - nip
        //class: Customer, attribute: nip
        customer.setNip(null);
        customer.setNip("1223334444");

        //5. Multi-valued
        //class: Frames, attribute: colors
        ArrayList<String> colors = new ArrayList<>();
        colors.add("white"); colors.add("gold");
        frames.setColors(colors);

        //6. Class attribute
        // class: Frames, attribute: minPrice
        frames.setMinPrice(20);

        //7. Derived attribute
        // class: Glasses, attribute: price
        double glassesPrice = glasses.getPrice();

        //8. Class method
        //this method returns a list of frames that are cheaper than certain price level.
        List<Frames> classMethod = Frames.findFramesCheaperThan(100);

        //9. Override
        //class: Glasses, method: toString
        System.out.println("-- now test of toString() --");
        System.out.println(glasses);

        //10. Overload - getPrice(double work)
        //Overload adds the costs of labour into the final price
        double partPrice = glasses.getPrice();
        double finalPrice = glasses.getPrice(120);

    }
}