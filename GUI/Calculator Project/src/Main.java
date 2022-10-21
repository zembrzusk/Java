import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        setLayout(new GridLayout(2,1));

        CalculatorPanel calculatorPanel = new CalculatorPanel();
        add(calculatorPanel);

        DrawingPanel drawingPanel = new DrawingPanel();
        add(drawingPanel);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(960,720);
        main.setVisible(true);
    }
}