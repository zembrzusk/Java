import java.io.Serializable;

public class Lenses implements Serializable {
    private int lensesId;
    public int getLensesId() {return lensesId;}
    public void setLensesId(int lensesId) {
        this.lensesId = lensesId;
    }
    Lenses(int lensesId) {
        setLensesId(lensesId);
        setLeftLens(0);
        setRightLens(0);
    }
    private double leftLens, rightLens;
    public double getLeftLens() {return leftLens;}
    public double getRightLens() {return rightLens;}
    public void setLeftLens(double value) {
        setLensValue(value, 0);
    }
    public void setRightLens(double value) {
        setLensValue(value, 1);
    }
    private void setLensValue(double value, int lens) {
        if (value >  10) {throw new IllegalArgumentException("Wrong lens value.");}
        if (value < -10) {throw new IllegalArgumentException("Wrong lens value.");}

        if(lens == 0) {this.leftLens = value;}
        if(lens == 1) {this.rightLens = value;}
    }

    //ASSOCIATION
    private Glasses glasses;
    public Glasses getGlasses() {return glasses;}
    public void setGlasses(Glasses glasses) {
        this.glasses = glasses;
        if(glasses.getLenses()!=this) {
            glasses.setLenses(this);
        }
    }


    Lenses(int lensesId, Glasses glasses) {
        setLensesId(lensesId);
        setLeftLens(0);
        setRightLens(0);
        setGlasses(glasses);
    }
}
