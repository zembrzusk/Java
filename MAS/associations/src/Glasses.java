import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Glasses implements Serializable {
    private int glassesId;
    public int getGlassesId() {return glassesId;}
    public void setGlassesId(int glassesId) {
        if (glassesId == 0) {throw new IllegalArgumentException("Glasses id can not be empty.");}
        this.glassesId = glassesId;
    }
    private Frames frames;
    public Frames getFrames() {return frames;}
    public void setFrames(Frames frames) {
        if (frames == null) {throw new IllegalArgumentException("Frames can not be null.");}
        this.frames = frames;
        addFramesQualif(frames);
        frames.addGlasses(this); //this is the reverse connection
    }
    private Lenses lenses;
    public Lenses getLenses() {return lenses;}
//PART OF ASSOCIATION
    public void setLenses(Lenses lenses) {
        if (lenses == null) {throw new IllegalArgumentException("Lenses can not be null.");}
        this.lenses = lenses;
        if(lenses.getGlasses()!=this) {
            lenses.setGlasses(this);
        }
    }
    public Glasses(int glassesId, Frames frames, Lenses lenses) {
        setGlassesId(glassesId);
        setFrames(frames);
        setLenses(lenses);
        addGlasses(this);
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

//ASSOCIATION - Qualified association
    private Map<String, Frames> framesQualif = new TreeMap<>();

    public void addFramesQualif(Frames frames) {
        if(!framesQualif.containsKey(frames.modelCode)) {
            framesQualif.put(frames.modelCode, frames);
        }
    }

    public Frames findFramesQualif(String modelCode) throws Exception {
        if(!framesQualif.containsKey(modelCode)) {
            throw new Exception("Unable to find a frames: " + modelCode);
        }
        return framesQualif.get(modelCode);
    }
}
