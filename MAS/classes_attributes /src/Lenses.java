import java.io.Serializable;

public class Lenses extends ObjectPlus implements Serializable {
    //obligatory
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

    private float price;
    //class attribute
    private static int minPrice = 1;
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        if (price<minPrice) {throw new IllegalArgumentException("Price can not be smaller than " + minPrice + ".");}
        this.price = price;
    }
    public static void setMinPrice(int minPrice) {
        if (minPrice < 0) {throw new IllegalArgumentException("Price can not be smaller than 0.");}
        Lenses.minPrice = minPrice;
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
}
