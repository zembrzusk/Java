import javax.swing.*;
import java.awt.*;

public class WykresPanel extends JPanel {
        ListaRownan listaRownan;
    WykresPanel(ListaRownan listaRownan) {
        this.listaRownan = listaRownan;
        setBorder(BorderFactory.createLineBorder(Color.white, 3));
        setVisible(true);
        repaint();
        setSize(300,150);
    }

    void name() {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //oś X
        g.drawLine(10, getHeight()/2, getWidth()-10, getHeight()/2);
        //oś Y
        g.drawLine(getWidth()/2,5,getWidth()/2, getHeight()-5);
        //zero
        g.drawString("0", getWidth()/2 + 5, getHeight()/2 + 15);

        //oś X - kreski
        int temp = 10;
        for(int i = 1; i<=13; ++i) {
            if(i!=1 && i!= 13 && i!=7)
                g.drawLine(temp,getHeight()/2,temp,getHeight()/2+3);
            temp = temp + ((getWidth()-10)/12);
        }
        //oś X - liczby
        temp = -2; int tempN = -12;
        for(int i = 1; i<=13; ++i) {
            if(i!=1 && i!= 13 && i!=7)
                g.drawString("" + tempN, temp, (getHeight()/2)+15);
            if(tempN==0)
                temp = temp + 8;
            temp = temp + ((getWidth()-10)/12); tempN = tempN + 2;
        }


        //oś Y - liczby
        int y = 10;
        for(int i = 8; i>=-8; i = i - 2) {
            if(i!=8 && i!=-8 && i!=0) {
                g.drawString("" + i, getWidth() / 2 + 5, y);
            }
            y = y + (getHeight() / 8);
        }

        //oś Y - kreski
        temp = 5;
        for(int i = 1; i<=9; ++i) {
            if(i!=1 && i!= 9 && i!=5)
                g.drawLine(getWidth()/2,temp,getWidth()/2+3,temp);
            temp = temp + ((getHeight()-5)/8);
        }

        //strzalki
        g.drawLine(getWidth()-10, getHeight()/2, getWidth()-10-5, getHeight()/2-5);
        g.drawLine(getWidth()-10, getHeight()/2, getWidth()-10-5, getHeight()/2+5);

        g.drawLine(getWidth()/2, 5, getWidth()/2-5, 5+5);
        g.drawLine(getWidth()/2, 5, getWidth()/2+5, 5+5);


        //rownania
        Node head = listaRownan.getHead();
        while(head.hasNext()) {
            Rownanie r = head.data;
            if(r.isVisible) {
                temp = 0;
                g.setColor(r.color);
                for (double i = -12; i < 12; i = i + 0.1) {
                    g.drawLine(temp, (getHeight() / 2) - (int) (r.wartosc(i) * ((getHeight() - 5) / 16)),
                            temp + (getWidth() - 10) / 180, (getHeight() / 2) - (int) (r.wartosc(i + 0.1) * ((getHeight() - 5) / 16)));
                    temp = temp + (getWidth() - 10) / 180;
                }
            }
            head = head.next;
        }
    }
}
