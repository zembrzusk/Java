import java.awt.*;
import java.awt.Color;

import static java.lang.Thread.sleep;

public class Main extends Frame {

    static Storage s = new Storage();
    static Factory first = new Factory(s), second = new Factory(s), third = new Factory(s);

    Main () {
        setBackground(new Color(0,0,120));
        setTitle("Balloon Project");
        setSize(960, 720);
        setVisible(true);

        while(true) {

            while (s.isPlace()) {
                repaint();
                try {
                    sleep(100);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }

            while (!s.isPlace()) {
                repaint();
                boolean go = true;
                for(int i = s.size(); go;) {
                    if (i > 0) { i--; }
                    repaint();
                    for (int j = 0; j < s.size(); ++j) {
                        Balloon balloon = s.get(j);
                        if (j >= i) { balloon.up(); }
                        try {
                            sleep(2);
                        } catch (InterruptedException e) { e.printStackTrace(); }
                    }

                    if (Storage.checkIfPopped(s)) {
                        s.startAgain();
                        go = false;
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        first.start(); second.start(); third.start();

        new Main();
    }

    public void paint(Graphics g) {
        super.paint(g);
        for(Balloon balloon :s)
            balloon.draw(g);
    }
}
