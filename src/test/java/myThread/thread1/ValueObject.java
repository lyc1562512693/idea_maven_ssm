package myThread.thread1;

import java.util.ArrayList;
import java.util.List;

public class ValueObject {
    public List<String> lst= new ArrayList<>();

    public List<String> getLst() {
        return lst;
    }

    public void setLst(List<String> lst) {
        this.lst = lst;
    }
}
