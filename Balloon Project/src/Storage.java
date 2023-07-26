import java.util.ArrayList;

public class Storage extends ArrayList<Balloon> {
    int current, capacity = 99;

    boolean isPlace() {
        if(capacity>current) {
            return true;
        }else {
            System.out.print("");
            return false;
        }
    }

    @Override
    public boolean add(Balloon balloon) {
        if(isPlace()) {
        super.add(balloon);
        current++;
        }
        return true;
    }

    void startAgain() {
        removeAll(this);
        current = 0;
    }

    static boolean checkIfPopped(Storage s) {
        boolean check = true;
        for(int i = 0; i < 99; ++i) {
            if(!s.get(i).popped)
                check = false;
        }
        return check;
    }
}
