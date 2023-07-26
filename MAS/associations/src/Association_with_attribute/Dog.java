package Association_with_attribute;

import java.util.ArrayList;
import java.util.List;

public class Dog {
    int idDog;
    String name;
    private List<Adoption> adoptions = new ArrayList<>();
    private List<Owner> owners = new ArrayList<>();

    public Dog(int idDog, String name) {
        this.idDog = idDog;
        this.name = name;
    }

    public void addAdoption(Adoption adoption) throws Exception {
        if(!adoptions.contains(adoption) && !owners.contains(adoption.owner)) {
            adoptions.add(adoption);
            owners.add(adoption.owner);
        }
    }

}
