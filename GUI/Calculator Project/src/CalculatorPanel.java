import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorPanel extends JPanel{

    CalculatorPanel() {
        setBorder(BorderFactory.createTitledBorder("CalculatorPanel"));

        JLabel label = new JLabel(""), resLabel = new JLabel("");
        JButton doneButton = new JButton("="), clearButton = new JButton("clear");

        JButton bDec = new JButton("Dec"), bOct = new JButton("Oct"),
                bBin = new JButton("Bin"), bHex = new JButton("Hex");

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resLabel.setText(compute(label.getText()));
                bDec.setText("Dec (selected)"); bOct.setText("Oct"); bBin.setText("Bin"); bHex.setText("Hex");
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(""); resLabel.setText("");
                bDec.setText("Dec"); bOct.setText("Oct"); bBin.setText("Bin"); bHex.setText("Hex");
            }
        });

        //buttons here
            JButton bzero = new JButton("0"), bone = new JButton("1"), btwo = new JButton("2"),
                    bthree = new JButton("3"), bfour = new JButton("4"), bfive = new JButton("5"),
                    bsix = new JButton("6"), bseven = new JButton("7"), beight = new JButton("8"),
                    bnine = new JButton("9");

            bzero.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    label.setText(label.getText()+"0");
                }});
            bone.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    label.setText(label.getText()+"1");
                }});
            btwo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    label.setText(label.getText()+"2");
                }});
            bthree.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    label.setText(label.getText()+"3");
                }});
            bfour.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    label.setText(label.getText()+"4");
                }});
            bfive.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    label.setText(label.getText()+"5");
                }});
            bsix.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    label.setText(label.getText()+"6");
                }});
            bseven.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    label.setText(label.getText()+"7");
                }});
            beight.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    label.setText(label.getText()+"8");
                }});
            bnine.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    label.setText(label.getText()+"9");
                }});

            JPanel numerPanel = new JPanel();
            numerPanel.setLayout(new GridLayout(3, 5));
            numerPanel.add(bzero); numerPanel.add(bone); numerPanel.add(btwo); numerPanel.add(bthree);
            numerPanel.add(bfour); numerPanel.add(bfive); numerPanel.add(bsix); numerPanel.add(bseven);
            numerPanel.add(beight); numerPanel.add(bnine);

            JButton badd = new JButton("+"), bsub = new JButton("-"),
                    bdiv = new JButton("/"), bmul = new JButton("*"),
                    bSqu = new JButton("sqrt"), bPer = new JButton("%");

            badd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {label.setText(label.getText()+" + ");}});
            bsub.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {label.setText(label.getText()+" - ");}});
            bdiv.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {label.setText(label.getText()+" / ");}});
            bmul.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {label.setText(label.getText()+" * ");}});

            bSqu.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    resLabel.setText("sqrt(" + Double.parseDouble(result(label.getText())) + ") = "
                            + java.lang.Math.sqrt(Double.parseDouble(result(label.getText()))));
                    label.setText("");}});
            bPer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    resLabel.setText("(" + Double.parseDouble(result(label.getText())) + ") * 100% = " +
                            Double.parseDouble(result(label.getText()))*100 + "%");
                    label.setText("");}});


            numerPanel.add(badd); numerPanel.add(bsub); numerPanel.add(bdiv); numerPanel.add(bmul);
            numerPanel.add(bSqu); numerPanel.add(bPer);

            setLayout(new GridLayout(2,3));
        add(numerPanel); add(doneButton); add(clearButton); add(label); add(resLabel);

        bDec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bDec.setText("Dec (selected)"); bOct.setText("Oct"); bBin.setText("Bin"); bHex.setText("Hex");
                resLabel.setText(compute(label.getText()));
            }});
        bOct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bDec.setText("Dec"); bOct.setText("Oct (selected)"); bBin.setText("Bin"); bHex.setText("Hex");
                resLabel.setText("= " + Integer.toOctalString((int)Double.parseDouble(result(label.getText()))));
            }});
        bBin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bDec.setText("Dec"); bOct.setText("Oct"); bBin.setText("Bin  (selected)"); bHex.setText("Hex");
                resLabel.setText("= " + Integer.toBinaryString((int)Double.parseDouble(result(label.getText()))));
            }});
        bHex.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bDec.setText("Dec"); bOct.setText("Oct"); bBin.setText("Bin"); bHex.setText("Hex  (selected)");
                resLabel.setText("= " + Integer.toHexString((int)Double.parseDouble(result(label.getText()))));
            }});

        JPanel formPanel = new JPanel();
        formPanel.setBorder(BorderFactory.createTitledBorder("FormPanel"));
        formPanel.setLayout(new GridLayout(2,2, 20, 20));
        formPanel.add(bDec); formPanel.add(bOct); formPanel.add(bBin); formPanel.add(bHex);
        add(formPanel);
    }


    String result(String equation) {
        double res = 0;
        String[] array = equation.split(" ");
        try {
            for (int i = 0; i < array.length; ) {
                if (array[i].equals("+")) {res = res + Double.parseDouble(array[i + 1]); i = i + 2;}
                else if (array[i].equals("-")) {res = res - Double.parseDouble(array[i + 1]); i = i + 2; }
                else if (array[i].equals("/")) {res = res / Double.parseDouble(array[i + 1]); i = i + 2; }
                else if (array[i].equals("*")) {res = res * Double.parseDouble(array[i + 1]); i = i + 2; }
                else {res = Double.parseDouble(array[i]); i = i + 1; }
            }
        } catch (Exception e) {return ""+0;}
        return ""+res;
    }

    String compute(String equation) {
        String s = result(equation);
        if(s.equals(""))
        return "That is not correct equation! Clear and try again.";
        else return "= " + s;
    }

}
