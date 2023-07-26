package Association_with_attribute;

import java.util.ArrayList;
import java.util.List;

public class Owner {
    int idOwner;
    String surname;
    private List<Adoption> adoptions = new ArrayList<>();
    private List<Dog> dogs = new ArrayList<>();

    public Owner(int idOwner, String surname) {
        this.idOwner = idOwner;
        this.surname = surname;
    }

    public void addAdoption(Adoption adoption) throws Exception {
        if(!adoptions.contains(adoption) && !dogs.contains(adoption.dog)) {
            adoptions.add(adoption);
            dogs.add(adoption.dog);
        }
    }
}
