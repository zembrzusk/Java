import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Frames implements Serializable{
    int idFrames;
    String modelCode;
    private ArrayList<String> colors;
    public ArrayList<String> getColors() {return colors;}
    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public Frames(int idFrames, String modelCode) {
        this.idFrames = idFrames;
        this.modelCode = modelCode;
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

    //ASSOCIATION
    public List<Glasses> glasses = new ArrayList<>();
    void addGlasses(Glasses glasses) {
        this.glasses.add(glasses);
    }
}


