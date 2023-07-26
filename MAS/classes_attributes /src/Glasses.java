import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Glasses extends ObjectPlus implements Serializable {
    //obligatory
    private int glassesId;
    public int getGlassesId() {return glassesId;}
    public void setGlassesId(int glassesId) {
        if (glassesId == 0) {throw new IllegalArgumentException("Glasses id can not be empty.");}
        this.glassesId = glassesId;
    }
    //obligatory
    private Frames frames;
    public Frames getFrames() {return frames;}
    public void setFrames(Frames frames) {
        if (frames == null) {throw new IllegalArgumentException("Frames can not be null.");}
        this.frames = frames;
    }
    //obligatory
    private Lenses lenses;
    public Lenses getLenses() {return lenses;}
    public void setLenses(Lenses lenses) {
        if (lenses == null) {throw new IllegalArgumentException("Lenses can not be null.");}
        this.lenses = lenses;
    }

    public Glasses(int glassesId, Frames frames, Lenses lenses) {
        setGlassesId(glassesId);
        setFrames(frames);
        setLenses(lenses);
        // Add to the extent
        addGlasses(this);
    }

    //overriding
    @Override
    public String toString() {
        return "Glasses id: " + glassesId;
    }

    //extent
    private static List<Glasses> extent = new ArrayList<>();
    private static void addGlasses(Glasses glasses) {
        extent.add(glasses);
    }
    private static void removeGlasses(Glasses glasses) {
        extent.remove(glasses);
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + Glasses.class.getName());
        for (Glasses glasses : extent) {
            System.out.println(glasses);
        }
    }

    //derived attribute
    public double getPrice() {
        return frames.getPrice() + lenses.getPrice();
    }
    //overload
    public double getPrice(double work) { return frames.getPrice() + lenses.getPrice() + work;}

}
