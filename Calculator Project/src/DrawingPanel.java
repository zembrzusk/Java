import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingPanel extends JPanel {

    DrawingPanel() {
        setBorder(BorderFactory.createTitledBorder("DrawingPanel"));

        ListaRownan listaRownan = new ListaRownan();
        //zostaw jedno
        listaRownan.add(new Rownanie("1"));

        setLayout(new GridLayout(1,2));
        WykresPanel wykresPanel = new WykresPanel(listaRownan);
        add(wykresPanel);

        JPanel prawyPanel = new JPanel();
        prawyPanel.setLayout(new BoxLayout(prawyPanel, BoxLayout.Y_AXIS));

        JPanel dodajPanel = new JPanel();
        dodajPanel.setLayout(new FlowLayout());
        dodajPanel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        JTextField rownanieText = new JTextField(15);
        JButton addButton = new JButton("add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!rownanieText.getText().equals("")){
                    prawyPanel.add(new LinePanel(listaRownan, new Rownanie(rownanieText.getText()), wykresPanel));
                    rownanieText.setText("");
                    wykresPanel.name();
                }
            }
        });
        dodajPanel.add(rownanieText); dodajPanel.add(addButton);
        prawyPanel.add(dodajPanel);
        add(prawyPanel);
    }

}

class LinePanel extends JPanel{
    LinePanel(ListaRownan listaRownan, Rownanie rownanie, WykresPanel wykresPanel) {
        listaRownan.add(rownanie);
        JCheckBox lCheckBox = new JCheckBox();
        add(lCheckBox);
        JLabel lLabel = new JLabel();
        lLabel.setText(rownanie.rownanie);
        add(lLabel);
        JButton lColorButton = new JButton("color");
        lColorButton.setForeground(rownanie.color);
        String[] options = {"PINK", "RED", "ORANGE", "BLUE"};
        lColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int col = JOptionPane.showOptionDialog(null, "Chose a color",
                        "Colors",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if(col == 0) {rownanie.color = Color.PINK; lColorButton.setForeground(rownanie.color);}
                if(col == 1) {rownanie.color = Color.RED; lColorButton.setForeground(rownanie.color);}
                if(col == 2) {rownanie.color = Color.ORANGE; lColorButton.setForeground(rownanie.color);}
                if(col == 3) {rownanie.color = Color.BLUE; lColorButton.setForeground(rownanie.color);}
                wykresPanel.name();
            }
        });
        add(lColorButton);
        JButton lDeleteButton = new JButton("delete");
        add(lDeleteButton);
    }
}

class Rownanie {
    String rownanie;
    double[] iksy= new double[8];
    Color color = Color.MAGENTA;
    Boolean isVisible = true;

    Rownanie(String s) {
        for(int i = 0; i < iksy.length; i++) {
            iksy[i] = 0;
        }
        rownanie = s;
        usunspacje();
        segreguj();
    }

    double wartosc(double punkt) {
        double res = 0;
        double temp = 1;
        for(int i = 0; i<iksy.length; i++) {
            res += (temp*iksy[i]);
            temp = temp*punkt;
        }
        return res;
    }

    void segreguj() {


        String[] array;

        if(rownanie.contains("+")) {
            array = rownanie.split("\\+");
        } else {
            array = new String[1];
            array[0] = rownanie;
        }
        for(int i = 0; i<array.length;++i) {
            String s = array[i];

            //jesli to x^
            if(s.contains("x^")) {
                String[] sarr = s.split("x\\^");
                if (sarr[0].equals("")) {
                    iksy[Integer.parseInt(sarr[1])] += 1;
                } else {
                    iksy[Integer.parseInt(sarr[1])] += Double.parseDouble(sarr[0]);
                }
            }

            //jesli to x
            else if(s.contains("x")) {
                String[] sarr = s.split("x");
                if (sarr[0].equals("")) {
                    iksy[1] += 1;
                } else {
                    iksy[1] += Double.parseDouble(sarr[0]);
                }
            }

            //jesli to liczba
            else {
                iksy[0] += Double.parseDouble(s);
            }
        }
    }

    void usunspacje() {
        String temp = "";
        rownanie.trim();
        rownanie.toLowerCase();
        char[] arr = rownanie.toCharArray();

        for(int i = 0; i<arr.length; i++) {
            if(arr[i]>='a' && arr[i]<='z') {
                arr[i]='x';
            }
        }

        for(int i = 0; i<arr.length; i++) {
            if(arr[i]!=' ') {
                if(arr[i]=='-') {
                    if(i==0) {
                        temp = temp + "-1";
                    }else
                    temp = temp + "+" + "-";
                }else
                temp = temp + arr[i];
            }
        }
        rownanie = temp;
    }
}

