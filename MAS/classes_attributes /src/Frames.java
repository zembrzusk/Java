import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Frames extends ObjectPlus implements Serializable {
    //multi-valued
    private ArrayList<String> colors;
    public ArrayList<String> getColors() {return colors;}
    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }
    private float price;
    //class attribute
    private static int minPrice = 1;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public static void setMinPrice(int minPrice) {
        Frames.minPrice = minPrice;
    }

    public Frames() {
        addFrames(this);
    }
    private static List<Frames> extent = new ArrayList<>();
    private static void addFrames(Frames frames) {extent.add(frames);}
    private static void removeFrames(Frames frames) {extent.remove(frames);}
    public static void showExtent() {
        System.out.println("Extent of the class: " + Frames.class.getName());
        for (Frames frames : extent) {
            System.out.println(frames);
        }
    }
    //class method that return list of frames that are same price or cheaper than given price
    public static List<Frames> findFramesCheaperThan(float price) {
        return extent.stream().filter(frames -> frames.getPrice() <= price)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
