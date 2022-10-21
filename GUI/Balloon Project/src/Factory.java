import java.util.Random;

public class Factory extends Thread {
    Storage s;

    public Factory(Storage s) {
        this.s = s;
    }

    @Override
    public void run() {
        while(true) {
            while (s.isPlace()) {
                try {
                    sleep(new Random().nextInt(500)+300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                s.add(new Balloon(Color.randomColor()));
            }
        }
    }
}
