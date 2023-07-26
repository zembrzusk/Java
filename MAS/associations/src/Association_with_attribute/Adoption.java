package Association_with_attribute;

public class Adoption {
    int idAdoption;
    String date;
    Dog dog;
    Owner owner;

    public Adoption(int idAdoption, String date, Dog dog, Owner owner) throws Exception {
        if(dog == null || owner == null) {
            throw new Exception("Wrong data.");
        }
        this.idAdoption = idAdoption;
        this.date = date;
        this.dog = dog;
        dog.addAdoption(this);
        this.owner = owner;
        owner.addAdoption(this);
    }

    @Override
    public String toString() {
        return dog.name + " was adopted by " + owner.surname + " on " + date + ".";
    }
}
