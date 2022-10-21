import java.awt.*;
import java.util.Random;

public class Balloon {
    java.awt.Color color;
    Color colorName;
    int x, y;
    Random random = new Random();
    boolean popped;

    public Balloon(Color color) {
        colorName = color;
        this.color = color.col;
        this.x = new Random().nextInt(920);
        this.y = 665;
        popped = false;
    }

    public void draw(Graphics g){
        if(!popped) {
            g.setColor(this.color);
            g.fillOval(this.x, this.y, 40, 50);
            g.drawLine(this.x+20, y+50, x+20, y+70);
        }
    }

    public void up() {
        y -=2;
        if((y<=480) &&
                !(colorName == Color.INDIAN_RED || colorName == Color.LIGHT_CORAL)) {
        popped = true;
        } else if(y<=240) {
            popped = true;
        }
    }
}
